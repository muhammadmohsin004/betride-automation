@android @TC-129
Feature: TC-129 Confirm Ride - Verify Default Fare

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-129
  Scenario: Verify default fare is displayed correctly
    Given User is on Confirm Ride page with fare visible
    Then Confirm Ride default fare should be displayed correctly
