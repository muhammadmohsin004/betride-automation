@android @TC-103
Feature: TC-103 Driver Search - Searching UI Validation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-103
  Scenario: Verify searching UI shows correct message and driver icons
    Given User is on ride searching screen
    When User views the searching screen
    Then Message should display "Your ride request is sent to drivers"
    And Driver icons should be visible
