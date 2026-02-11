@android @TC-016
Feature: TC-016 Duplicate Ride Prevention - No Duplicate Rides Go To Driver

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-016
  Scenario: Driver receives only one ride request even if multiple same rides created
    Given Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    And Driver should receive only one ride request not duplicates
    Then Verify no duplicate ride requests appear on driver screen
