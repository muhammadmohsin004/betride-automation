@android @TC-121
Feature: TC-121 City to City - Clear Pickup Field

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-121
  Scenario: Verify clearing pickup field with clear icon
    Given User is on City to City page with pickup filled
    When User taps clear icon on pickup field
    Then City to City pickup field should become empty
