@android @TC-019
Feature: TC-019 Hourly Ride Type Validation - Hourly Ride Should NOT Appear As Normal Ride

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-019
  Scenario: Hourly ride displays correctly as Hourly type not normal ride
    Given Driver goes online to receive rides
    Then Driver waits for hourly ride request from rider
    And Ride type should be displayed as Hourly not normal ride
