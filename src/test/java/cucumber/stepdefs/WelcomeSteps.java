package cucumber.stepdefs;

import com.gildedrose.DataStore;
import com.gildedrose.Item;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.driver.WebDriverWrapper;
import cucumber.site.GildedRoseSite;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class WelcomeSteps {


    private final GildedRoseSite site = new GildedRoseSite();
    private final WebDriverWrapper driver = site.getDriver();

    @Given("a customer is not logged in")
    public void a_customer_is_not_logged_in() {
        // no need to implement since there is no login
    }

    @When("when they access the welcome page")
    public void when_access_the_welcome_page() {
        site.visit("/");
    }

    @Then("they see welcome message from Kahjeet the owner")
    public void they_see_welcome_message_from_Kahjeet_the_owner() {
        driver.pageShouldContain("Welcome to The Gilded Rose");
    }

}
