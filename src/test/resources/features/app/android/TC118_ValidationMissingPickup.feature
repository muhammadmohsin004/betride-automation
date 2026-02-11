@android @TC-118
Feature: TC-118 City to City - Validation Missing Pickup

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-118
  Scenario: Verify error when Next tapped without pickup location
    Given User is on City to City page without pickup selected
    When User taps Next without selecting pickup
    Then Error should display "Please select pickup location"
