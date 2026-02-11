@android @TC-122
Feature: TC-122 City to City - Clear Drop-off Field

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-122
  Scenario: Verify clearing drop-off field with clear icon
    Given User is on City to City page with drop-off filled
    When User taps clear icon on drop-off field
    Then City to City drop-off field should become empty
