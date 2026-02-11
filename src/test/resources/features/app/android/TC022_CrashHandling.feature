@android @TC-022
Feature: TC-022 Crash Handling - Driver App Reopens Showing Ride Alert After Crash

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-022
  Scenario: Driver app reopens showing ride alert after force close
    Given Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    When Driver force closes the app during ride request
    And Driver reopens the app
    Then Same ride alert should still be visible if not reassigned
