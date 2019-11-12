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

/*



    @Given("There are items in the catalog")
    public void there_are_items_in_the_catalog() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I look at the item summary")
    public void i_look_at_the_item_summary() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I see that all of the items have a sell by date")
    public void i_see_that_all_of_the_items_have_a_sell_by_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I see that all the items have a value assigned to them")
    public void i_see_that_all_the_items_have_a_value_assigned_to_them() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("it's the day <days_passed>")
    public void itSTheDayDays_passed() {
    }

    @Then("then <item> have appropriately decreased <sell_by> and <value>")
    public void thenItemHaveAppropriatelyDecreasedSell_byAndValue() {
    }
*/
}