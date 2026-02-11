@android @TC-068
Feature: TC-068 Driver Search - Searching Animation Behavior

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-068
  Scenario: Verify searching animation loops until driver accepts or user cancels
    Given User has initiated driver search
    When User observes the searching system
    Then Searching animation should loop until driver accepts or user cancels
