package steps.site;

import org.junit.Assert;
import steps.driver.WebDriverFactory;
import steps.driver.WebDriverWrapper;

import java.util.stream.Collectors;

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
