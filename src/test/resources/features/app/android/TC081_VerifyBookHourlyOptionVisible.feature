@android @TC-081
Feature: TC-081 Home Screen - Verify Book Hourly Option Visible

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-081
  Scenario: Verify Book Hourly option is visible on Home screen
    Given Home screen is loaded
    When User views the Home screen options
    Then Book Hourly option should be visible
