@android @TC-018
Feature: TC-018 Hourly Ride - Driver Sees Hourly Ride Alert With Message

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-018
  Scenario: Driver sees hourly ride alert with duration and accept reject buttons
    Given Driver goes online to receive rides
    Then Driver waits for hourly ride request from rider
    And Driver should see hourly ride popup with duration and accept reject
