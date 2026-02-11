@android @TC-096
Feature: TC-096 Confirm Booking - Verify Selected Hours Displayed

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-096
  Scenario: Verify selected hours are displayed correctly
    Given User is on Confirm Booking page with hours selected
    When User views the Number of hours selected section
    Then Selected hours should be displayed correctly
