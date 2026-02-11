@android @TC-094
Feature: TC-094 Confirm Booking - Verify Map Display

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-094
  Scenario: Verify map loads with pickup flag shown
    Given User is on Confirm Booking screen
    When User views the map on Confirm Booking page
    Then Map should load with pickup flag shown
