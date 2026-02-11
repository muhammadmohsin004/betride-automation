@android @TC-120
Feature: TC-120 City to City - Select Drop-off from Last Visited Places

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-120
  Scenario: Verify drop-off selection from last visited places
    Given User is on City to City page with last visited list visible
    When User taps a location under last visited places
    Then Drop-off field should update with selected visited location
