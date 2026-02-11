@android @TC-111
Feature: TC-111 Home Screen - Verify City to City Option Visible

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-111
  Scenario: Verify City to City option is visible on Home screen
    Given User is on the Home screen
    Then City to City option should be visible
