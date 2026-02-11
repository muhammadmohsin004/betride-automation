@android @TC-114
Feature: TC-114 City to City - Select Pickup Location from Map

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-114
  Scenario: Verify pickup location selection from map
    Given User is on City to City page with empty pickup field
    When User taps Select pickup location and picks a location
    Then Pickup field should be filled with selected location
