Feature: The Gilded Rose has inventory
  Scenario: There's some items in the catalog
    Given there are two items in the catalog
    When  I look at the item summary
    Then  I see the total number of items is two