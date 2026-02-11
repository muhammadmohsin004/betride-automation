@android @TC-104
Feature: TC-104 Driver Search - Cancel Request Button

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-104
  Scenario: Verify Cancel Request button shows cancel popup
    Given User is on active ride searching screen
    When User taps Cancel Request button
    Then Cancel popup should appear
