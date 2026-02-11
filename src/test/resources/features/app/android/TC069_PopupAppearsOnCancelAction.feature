@android @TC-069
Feature: TC-069 Driver Search - Popup Appears on Cancel Action

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-069
  Scenario: Verify cancel popup appears when tapping Cancel Request
    Given User has an active driver search
    When User taps on Cancel Request button
    Then Cancel popup should appear immediately
