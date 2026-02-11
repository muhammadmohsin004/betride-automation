@android @TC-113
Feature: TC-113 City to City - Page UI Validation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-113
  Scenario: Verify City to City page UI elements
    Given User is on City to City page
    Then City to City page should display all required UI elements
