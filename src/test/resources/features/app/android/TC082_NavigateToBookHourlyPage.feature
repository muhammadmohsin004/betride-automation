@android @TC-082
Feature: TC-082 Home Screen - Navigate to Book Hourly Page

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-082
  Scenario: Verify tapping Book Hourly navigates to Book driver by the hour page
    Given User is on Home screen with Book Hourly visible
    When User taps on Book Hourly option
    Then App should navigate to Book driver by the hour page
