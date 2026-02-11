@android @TC-061
Feature: TC-061 Confirm Ride - Verify Travel Time Display

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-061
  Scenario: Verify estimated travel time is displayed on Confirm Ride page
    Given User is on the Confirm Ride page
    When User views the travel time section
    Then Estimated travel time should be displayed correctly
