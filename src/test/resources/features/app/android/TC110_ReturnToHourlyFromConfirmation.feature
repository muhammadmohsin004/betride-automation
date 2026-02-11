@android @TC-110
Feature: TC-110 Book Hourly - Return to Hourly Page from Confirmation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-110
  Scenario: Verify app returns to hourly selection page when tapping back arrow
    Given User is on Confirm Booking page
    When User taps back arrow on confirmation page
    Then App should return to hourly selection page
