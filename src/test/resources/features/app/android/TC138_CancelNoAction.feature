@android @TC-138
Feature: TC-138 Driver Search - Cancel NO Action

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-138
  Scenario: Verify tapping NO on cancel popup closes popup and search continues
    Given User sees cancel popup on driver searching screen
    When User taps NO on cancel confirmation popup
    Then Popup should close and driver search should continue
