@android @TC-117
Feature: TC-117 City to City - Manual Drop-off Entry

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-117
  Scenario: Verify manual drop-off entry with address typing
    Given User is on City to City page with drop-off field empty
    When User taps drop-off field and types address and selects from suggestions
    Then Drop-off field should be updated with typed location
