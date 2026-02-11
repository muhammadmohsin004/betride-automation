@android @TC-053
Feature: TC-053 Settings - Verify Successful Log Submission

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-053
  Scenario: Verify successful log submission
    Given User is on Send Device Logs popup with internet ON
    When User taps Yes on the popup
    Then Logs should be sent successfully and success message appears
