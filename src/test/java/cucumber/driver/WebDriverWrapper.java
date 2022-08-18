package cucumber.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.interactions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class WebDriverWrapper {
    private final WebDriver driver;

    public Optional<String> executeJavaScript(String script) {
        return Optional.ofNullable(((JavascriptExecutor) driver).executeScript(script))
                .filter(object -> object instanceof String)
                .map(object -> (String) object);
    }

    public WebDriverWrapper() {
        if ("chrome".equals(System.getProperty("webdriver"))) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--silent");
            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);
        } else {
            DesiredCapabilities dcap = new DesiredCapabilities();
            String[] phantomArgs = new String[]{
                    "--webdriver-loglevel=NONE"
            };
            dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
            driver = new PhantomJSDriver(dcap);
            Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @SuppressWarnings("unused")
    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void closeAll() {
        driver.close();
        driver.quit();
    }

    public void isAtURL(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @SuppressWarnings("WeakerAccess")
    public UiElement findElementByName(String name) {
        return new SeleniumWebElement(driver.findElement(By.name(name)));
    }

    public void setTextField(String field_name, String text) {
        UiElement e = findElementByName(field_name);
        e.sendKeys(text);
    }

    public void clickButton(String button_id) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(button_id))).click();
    }

    public void clickButtonByName(String button_name) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.name(button_name))).click();
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public UiElement findElementById(String id) {
        return new SeleniumWebElement(driver.findElement(By.id(id)));
    }

    public void expectAlert(String msg) {
        getWait().until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        assertEquals(msg, alert.getText());
        alert.accept();
    }

    public void expectRedirect(String url) {
        getWait().until(ExpectedConditions.urlContains(url));
    }

    public void pageShouldContain(String text) {
        String bodyText = getBodyText();

        assertThat(bodyText, containsString(text));
    }

    public String getBodyText() {
        return driver.findElement(By.tagName("body")).getText();
    }

    public void expectElementWithIdToContainText(String id, String text) {
        String actualText = findElementById(id).getText();
        assertTrue("Text not found! actual: " + actualText + ", expected:`" + text + "` But got: `" + getBodyText() + "`", actualText.contains(text));
    }

    public void expectElementWithIdToContainValue(String id, String value) {
        assertEquals(value, findElementById(id).getText());
    }

    public void expectPageToContainExactlyNElements(String text, int count) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        assertEquals(count,elements.size());
    }
    public void expectPageToContainExactlyNElementsWithName(String name, int count) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@name='" + name + "']"));
        assertEquals(count,elements.size());
    }

    public void clickUpload() {
        UiElement uploadBtn = findElementById("batchFile");
        uploadBtn.sendKeys(System.getProperty("java.io.tmpdir") + "/contactsUploadTest.csv");
    }

    public void setDropdownByText(String dropdownName, String text) {
        Select dropdown = new Select(getWait().until(ExpectedConditions.visibilityOfElementLocated(By.name(dropdownName))));
        dropdown.selectByVisibleText(text);
    }

    public String getDropdownTextByName(String dropdownName) {
        Select select = new Select(driver.findElements(By.name(dropdownName)).get(0));
        return select.getFirstSelectedOption().getText();
    }

    public void setDropdownValue(String dropdownName, String text) {
        Select dropdown = new Select(getWait().until(ExpectedConditions.visibilityOfElementLocated(By.name(dropdownName))));
        dropdown.selectByValue(text);
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, 10);
    }

    @SuppressWarnings("unused")
    public void waitForDisplayed(String domId) {
        getWait().until(webDriver -> webDriver.findElement(By.id(domId)).isDisplayed());
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @SuppressWarnings("unused")
    public String getBodyHTML() {
        return findElements(By.tagName("body")).get(0).getAttribute("outerHTML");
    }

    public void clickRadioButton(String text) {
        getInputBySelectorAndText("input", text).click();
    }

    public void clickCheckBox(String text) {
        getInputBySelectorAndText("input", text).click();
    }

    private WebElement getInputBySelectorAndText(String selector, String text) {
        return getWebElementStreamOfParents(selector)
                .filter(e-> e.getText().equals(text))
                .findFirst()
                .orElseThrow(() -> new AssertionError(
                        String.format("Can not find element with selector `%s` and text `%s`, but found %s",
                                selector,
                                text,
                                getWebElementStreamOfParents(selector).map(WebElement::getText).collect(Collectors.joining( "," ) )
                                )))
                .findElement(By.cssSelector(selector));
    }

    private Stream<WebElement> getWebElementStreamOfParents(String selector) {
        return findElements(By.cssSelector(selector)).stream().map(e -> e.findElement(By.xpath("./..")));
    }

    public void expectRadioButtonWithText(String optionText) {
        getInputBySelectorAndText("input[type='radio']", optionText);
    }

    public void expectCheckBoxWithText(String optionText) {
        getInputBySelectorAndText("input[type='checkbox']", optionText);
    }

    public WebDriver.Navigation getNavigate() {
        return this.driver.navigate();
    }

    public void takeScreenshot(String name) {
        ChromeDriver chromeDriver = (ChromeDriver)driver;
        File source = chromeDriver.getScreenshotAs(OutputType.FILE);
        String dest = name + ".png";
        File destination = new File(dest);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

