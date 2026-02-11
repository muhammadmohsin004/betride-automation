@android @TC-097
Feature: TC-097 Confirm Booking - Fare Calculation Display

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-097
  Scenario: Verify fare is calculated based on selected hours
    Given User is on Confirm Booking page to view fare
    When User views the fare section
    Then Fare should be calculated based on selected hours
