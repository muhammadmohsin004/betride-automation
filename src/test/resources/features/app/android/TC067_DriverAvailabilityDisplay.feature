@android @TC-067
Feature: TC-067 Driver Search - Driver Availability Display

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-067
  Scenario: Verify nearby drivers displayed on map when searching
    Given User has initiated a search for driver
    When User taps on Search for Driver button
    Then Nearby drivers should be displayed on the map
