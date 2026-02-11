@android @TC-119
Feature: TC-119 City to City - Validation Missing Drop-off

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-119
  Scenario: Verify error when Next tapped without drop-off location
    Given User is on City to City page without drop-off selected
    When User taps Next without selecting drop-off
    Then Drop-off error should display "Please select drop-off location"
