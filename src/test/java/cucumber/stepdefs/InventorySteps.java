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

public class InventorySteps {

    private int verify_item_count;

    @Before
    public void reset_data_store(){
        DataStore.getDataStoreInstance().resetDataStore();
    }
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
    @Given("The following items exist in the catalog")
    public void the_following_items_exist_in_the_catalog(List<Map<String,String>> items) {
        DataStore ds = DataStore.getDataStoreInstance();
        verify_item_count = items.size();
        for (Map<String, String> itemAttributes : items) {
            String sellIn = itemAttributes.get("remaining_days");
            String quality = itemAttributes.get("quality");
            String name = itemAttributes.get("name");
            Item item = new Item(name, parseInt(sellIn), parseInt(quality));
            ds.addObject(item.name,item);
        }
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
        driver.expectPageToContainExactlyNElementsWithName("item_quality",verify_item_count);
    }
    @And("I see that all elements have the remaining number of days in which they should be sold")
    public void iSeeThatAllElementsHaveTheRemainingNumberOfDaysInWhichTheyShouldBeSold() {
        driver.expectPageToContainExactlyNElementsWithName("item_sell_by",verify_item_count);

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

    @When("it's the day {int}")
    public void it_s_the_day(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("I can see the welcome message is {string}")
    public void iCanSeeTheWelcomeMessageIs(String message) {
        driver.pageShouldContain(message);
    }

}
