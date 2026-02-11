@android @TC-070
Feature: TC-070 Driver Search - Cancel Popup Close on NO

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-070
  Scenario: Verify popup closes when tapping NO on cancel popup
    Given User has cancel popup visible
    When User taps on NO button on cancel popup
    Then Popup should close and user stays in searching screen
