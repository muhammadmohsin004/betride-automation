@android @TC-128
Feature: TC-128 Confirm Ride - Verify Total Distance

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-128
  Scenario: Verify total distance is displayed correctly
    Given User is on Confirm Ride page with distance info
    Then Confirm Ride total distance should be displayed correctly
