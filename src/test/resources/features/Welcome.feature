Feature: Welcome scenarios for the top page
  @now
  Scenario: The user is welcomed with warm greeting from the owner
    Given a customer is not logged in
    When when they access the welcome page
    Then they see welcome message from Kahjeet the owner
