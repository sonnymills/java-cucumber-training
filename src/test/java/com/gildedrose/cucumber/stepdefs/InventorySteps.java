package com.gildedrose.cucumber.stepdefs;

import com.gildedrose.DataStore;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.gildedrose.cucumber.driver.WebDriverWrapper;
import com.gildedrose.cucumber.site.GildedRoseSite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    @Then("I see the names of two items")
    public void i_see_the_names_of_two_items() {
        driver.pageShouldContain("thing1");
        driver.pageShouldContain("thing2");
    }

    @Then("I see that all of the items have a sell by date")
    public void i_see_that_all_of_the_items_have_a_sell_by_date() {
        driver.expectPageToContainExactlyNElements("Sell By",2);
    }

    @Then("I see that all the items have a value assigned to them")
    public void iSeeThatAllTheItemsHaveAValueAssignedToThem() {
        driver.expectPageToContainExactlyNElements("Value",2);
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
}
