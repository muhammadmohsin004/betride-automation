@android @TC-056
Feature: TC-056 Ride Booking - Open Add Destination Page from Home

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-056
  Scenario: Verify tapping Book Ride navigates to Add Destination page
    Given User is on the Rider Home page
    When User taps on Book Ride button
    Then App should navigate to Add Destination page
