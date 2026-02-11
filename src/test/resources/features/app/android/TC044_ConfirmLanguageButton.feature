@android @TC-044
Feature: TC-044 Settings - Verify Confirm Language Button

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-044
  Scenario: Verify Confirm Language button switches app language
    Given User has selected a language on the Language screen
    When User taps on Confirm Language button
    Then App should switch to selected language successfully
