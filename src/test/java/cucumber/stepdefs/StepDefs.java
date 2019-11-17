package cucumber.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.driver.WebDriverWrapper;
import cucumber.site.GildedRoseSite;


public class StepDefs {
    private final GildedRoseSite site = new GildedRoseSite();
    private final WebDriverWrapper driver = site.getDriver();

    @When("I load the page")
    public void i_load_the_page() throws InterruptedException {
        site.visit("/inventory/list");
    }

    @Then("I can see the welcome message")
    public void i_can_see_the_welcome_message() {
        driver.pageShouldContain("inventory");

    }
}
