@android @TC-098
Feature: TC-098 Confirm Booking - Increase Fare (+1)

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-098
  Scenario: Verify fare increases by 1 MAD per tap on +1
    Given User is on Confirm Booking page with fare displayed
    When User taps the plus one button to increase fare
    Then Fare should increase by 1 MAD per tap
