package com.gildedrose.cucumber.site;

import com.gildedrose.cucumber.driver.WebDriverFactory;
import com.gildedrose.cucumber.driver.WebDriverWrapper;

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
