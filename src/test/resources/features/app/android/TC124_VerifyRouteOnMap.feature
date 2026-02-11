@android @TC-124
Feature: TC-124 Confirm Ride - Verify Route on Map

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-124
  Scenario: Verify map displays route from pickup to drop-off
    Given User is on Confirm Ride page
    Then Map should display route from pickup to drop-off
