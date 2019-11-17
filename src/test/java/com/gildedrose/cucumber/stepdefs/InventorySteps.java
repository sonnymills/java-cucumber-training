package com.gildedrose.cucumber.stepdefs;

import com.gildedrose.DataStore;
import com.gildedrose.Item;
import com.gildedrose.cucumber.driver.WebDriverWrapper;
import com.gildedrose.cucumber.site.GildedRoseSite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InventorySteps {
    private final GildedRoseSite site = new GildedRoseSite();
    private final WebDriverWrapper driver = site.getDriver();
    @Given("There is an inventory page")
    public void there_is_an_inventory_page() {
        // no automation required here
    }
    @Given("There are items in the catalog")
    public void there_are_items_in_the_catalog() {
        DataStore ds = DataStore.getDataStoreInstance();
        ds.addObject("thing1", new Item("thing1",3,3));
        ds.addObject("thing2", new Item("thing2",3,3));
    }

    @When("I look at the item summary")
    public void i_look_at_the_item_summary() {
        site.visit("/inventory/list");
    }
    @Then("I see the names of two items")
    public void i_see_the_names_of_two_items() {
        driver.pageShouldContain("thing1");
        driver.pageShouldContain("thing2");
    }

    @Then("I see that all the items have a quality value assigned to them")
    public void i_see_that_all_the_items_have_a_quality_value_assigned_to_them() {
        // Write code here that turns the phrase above into concrete actions
        driver.expectPageToContainExactlyNElementsWithName("item_quality",2);
    }
    @And("I see that all elements have the remaining number of days in which they should be sold")
    public void iSeeThatAllElementsHaveTheRemainingNumberOfDaysInWhichTheyShouldBeSold() {
        driver.expectPageToContainExactlyNElementsWithName("item_sell_by",2);

    }


    @Given("I add an item {string}")
    public void i_add_an_item(String itemName) {
        DataStore ds = DataStore.getDataStoreInstance();
        ds.addObject(itemName, new Item(itemName,4,4));
    }

    @Then("I can see the item {string}")
    public void i_can_see_the_item(String itemName) {
        driver.pageShouldContain(itemName);
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("There is an item {string} in the catalog with value {double} and sell by {int}")
    public void there_is_an_item_in_the_catalog_with_value_and_sell_by(String string, Double double1, Integer int1) {

        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
    @When("it's the day {int}")
    public void it_s_the_day(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
    @Then("then {string} has appropriately decreased to {int} days remaining to sell and ${double}")
    public void then_has_appropriately_decreased_to_days_remaining_to_sell_and_$(String string, Integer int1, Double double1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I can see the welcome message is {string}")
    public void iCanSeeTheWelcomeMessageIs(String message) {
        driver.pageShouldContain(message);
    }

}
