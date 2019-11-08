package gilded_rose_cucumber;

import cucumber.api.java.After;
import gildedrose.Application;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import steps.driver.WebDriverFactory;
import steps.driver.WebDriverWrapper;

/**
 * Class to use spring application context while running cucumber
 */
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
public class SpringCucumberTest {

    private static final Logger LOG = LoggerFactory.getLogger(SpringCucumberTest.class);

    /**
     * Need this method so the cucumber will recognize this class as glue and load spring context configuration
     */
    @Before
    public void setUp() {
        LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
    @After
    public void tearDown(){

            WebDriverWrapper defaultDriver = WebDriverFactory.getDefaultDriver();
            defaultDriver.takeScreenshot("tmp/oops");
        LOG.info("-------------- Trying to Close all Browsers--------------");
        WebDriverFactory.resetAll();

    }
}
