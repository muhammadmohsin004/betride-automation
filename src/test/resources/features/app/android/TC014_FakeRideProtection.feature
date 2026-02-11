@android @TC-014
Feature: TC-014 Fake Ride Protection - No Fake Rides Appear

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-014
  Scenario: Driver receives only real ride requests no fake requests
    Given Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    And Driver should only see real ride requests without duplicates
    Then Verify no fake or duplicate ride requests appear
