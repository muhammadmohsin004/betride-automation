@android @TC-136
Feature: TC-136 Driver Search - Cancel Request Button

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-136
  Scenario: Verify cancel request shows confirmation popup
    Given User is on active driver searching screen
    When User taps Cancel Request button on searching screen
    Then Cancel confirmation popup should be displayed
