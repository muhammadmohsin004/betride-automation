@android @TC-099
Feature: TC-099 Confirm Booking - Decrease Fare (-1)

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-099
  Scenario: Verify fare decreases by 1 MAD per tap on -1
    Given User is on Confirm Booking page with fare above minimum
    When User taps the minus one button to decrease fare
    Then Fare should decrease by 1 MAD per tap
