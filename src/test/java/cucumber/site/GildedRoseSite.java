package cucumber.site;

import cucumber.driver.WebDriverFactory;
import cucumber.driver.WebDriverWrapper;

public class GildedRoseSite {
    public final WebDriverWrapper driver = WebDriverFactory.getDefaultDriver();

    public String baseUrl() {
        return "http://localhost:8080/";
    }

    public WebDriverWrapper getDriver() {
        return driver;
    }

    public void visit(String path) {
        driver.visit(baseUrl() + path);
    }
}
