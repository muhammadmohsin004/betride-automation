@android @TC-058
Feature: TC-058 Ride Booking - Incorrect Location Entry

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-058
  Scenario: Verify incorrect location entry shows no results
    Given User is on the Add Destination page for location test
    When User enters invalid location text
    Then Suggestions should show No results found
