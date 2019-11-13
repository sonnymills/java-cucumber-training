package com.gildedrose.cucumber.stepdefs;

import com.gildedrose.GildedRose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.gildedrose.cucumber.driver.WebDriverWrapper;
import com.gildedrose.cucumber.site.GildedRoseSite;

public class InventorySteps {
    private final GildedRoseSite site = new GildedRoseSite();
    private final WebDriverWrapper driver = site.getDriver();

    @Given("There are items in the catalog")
    public void there_are_items_in_the_catalog() {
        //GildedRose app = new GildedRose(items);
        // app.updateQuality();
    }

    @When("I look at the item summary")
    public void i_look_at_the_item_summary() {
        site.visit("/inventory/list");
    }

    @Then("I see that all of the items have a sell by date")
    public void i_see_that_all_of_the_items_have_a_sell_by_date() {
        // Write code here that turns the phrase above into concrete actions
    }

}
