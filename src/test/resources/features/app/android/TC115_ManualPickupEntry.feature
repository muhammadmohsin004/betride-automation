@android @TC-115
Feature: TC-115 City to City - Manual Pickup Entry

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-115
  Scenario: Verify manual pickup entry with address typing
    Given User is on City to City page with pickup field empty
    When User taps pickup field and types address and selects from suggestions
    Then Pickup field should be updated with typed location
