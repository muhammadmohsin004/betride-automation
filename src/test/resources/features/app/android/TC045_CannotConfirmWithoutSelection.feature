@android @TC-045
Feature: TC-045 Settings - Cannot Confirm Without Selecting Language

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-045
  Scenario: Verify error when confirming without selecting a language
    Given User is on the Language screen without selecting any language
    When User taps on Confirm Language button without selection
    Then Error message should appear asking to select a language
