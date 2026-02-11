@android @TC-054
Feature: TC-054 Settings - Verify Cancelling Log Send

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-054
  Scenario: Verify cancelling log send by tapping No
    Given User is on Send Device Logs popup
    When User taps No on the popup
    Then Popup should close and no logs are sent
