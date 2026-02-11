@android @TC-021
Feature: TC-021 Timeout - Ride Request Times Out If Driver Does Not Respond

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-021
  Scenario: Ride request times out when driver does not respond
    Given Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    When Driver does not respond to ride request
    Then Ride request should timeout and disappear
