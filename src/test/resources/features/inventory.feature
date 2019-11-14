Feature: The Gilded Rose has inventory

  Scenario: I can see the inventory page
    Given There is an inventory page
    When  I load the page
    Then  I can see the welcome message

  @now
  Scenario: All Items have a SellIn date that shows when the item should be sold by
    Given There are items in the catalog
    When  I look at the item summary
    Then  I see the names of two items

#  @development
#  Scenario: All Items have values
#      Given There are items in the catalog
#      When  I look at the item summary
#      Then I see that all the items have a value assigned to them
#
#  @development
#  Scenario Outline: When a day passes items degrade
#      Given There are items in the catalog
#      When it's the day <days_passed>
#      Then then <item> have appropriately decreased <sell_by> and <value>
#    Examples:
#      | item    | days_passed |sell_by  | value |
#      | brie    | 1           |10       | $3.99 |
#      | cheddar | 1           |9        | $2.99 |
#      | brie    | 2           |9        | $2.99 |
#      | cheddar | 2           |8        | $1.99 |
