@android @TC-143
Feature: TC-143 Send/Receive - Page UI Elements Verification

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-143
  Scenario: Verify all UI elements are visible on Send or Receive Anything page
    Given User is on the Send or Receive Anything page
    Then All Send Receive page UI elements should be visible
