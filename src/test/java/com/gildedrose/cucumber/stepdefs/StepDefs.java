package com.gildedrose.cucumber.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.gildedrose.cucumber.driver.WebDriverWrapper;
import com.gildedrose.cucumber.site.GildedRoseSite;


public class StepDefs {
    private final GildedRoseSite site = new GildedRoseSite();
    private final WebDriverWrapper driver = site.getDriver();

    @Given("There is an inventory page")
    public void there_is_an_inventory_page() {
        // don't need anything here because no data yet
    }

    @When("I load the page")
    public void i_load_the_page() throws InterruptedException {
        site.visit("/inventory/list");
    }

    @Then("I can see the welcome message")
    public void i_can_see_the_welcome_message() {
        driver.pageShouldContain("inventory");

    }
}
