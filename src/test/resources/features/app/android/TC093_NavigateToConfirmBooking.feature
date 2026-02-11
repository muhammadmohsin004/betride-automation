@android @TC-093
Feature: TC-093 Book Hourly - Navigate to Confirm Booking

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-093
  Scenario: Verify tapping Next navigates to Confirm Booking page
    Given User is on Book Hourly page with pickup and hours selected
    When User taps Next button to proceed
    Then App should navigate to Confirm Booking page
