@android @TC-141
Feature: TC-141 Home Screen - Verify Get Anything Option Visible

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-141
  Scenario: Verify Get Anything section is visible on Home screen
    Given User is on the Rider app Home screen
    Then Get Anything section should be visible on Home screen
