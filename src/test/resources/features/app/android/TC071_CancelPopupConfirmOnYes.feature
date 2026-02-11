@android @TC-071
Feature: TC-071 Driver Search - Cancel Popup Confirm on YES

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-071
  Scenario: Verify tapping YES on cancel popup stops search and navigates back
    Given User has cancel popup visible for confirmation
    When User taps on YES button on cancel popup
    Then User should navigate back to previous screen and search stops
