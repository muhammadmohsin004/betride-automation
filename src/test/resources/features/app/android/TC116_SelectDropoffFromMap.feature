@android @TC-116
Feature: TC-116 City to City - Select Drop-off Location from Map

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-116
  Scenario: Verify drop-off location selection from map
    Given User is on City to City page with empty drop-off field
    When User taps Select drop-off location and picks a location
    Then Drop-off location should be updated successfully
