package com.gildedrose.cucumber;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import gildedrose.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import com.gildedrose.cucumber.driver.WebDriverFactory;
import com.gildedrose.cucumber.driver.WebDriverWrapper;

/**
 * Class to use spring application context while running cucumber
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    /**
     * Need this method so the cucumber will recognize this class as glue and load spring context configuration
     */
    @Before
    public void setUp() {
        LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");

    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            WebDriverWrapper defaultDriver = WebDriverFactory.getDefaultDriver();
            defaultDriver.takeScreenshot("tmp/oops" + scenario.getName());
        }
        LOG.info("-------------- Trying to Close all Browsers--------------");
        WebDriverFactory.resetAll();

    }
}