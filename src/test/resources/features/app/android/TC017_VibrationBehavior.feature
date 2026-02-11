@android @TC-017
Feature: TC-017 Vibration Behavior - Driver Receives Vibration And Stops After Close

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-017
  Scenario: Driver receives vibration alert and it stops after closing
    Given Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    When Driver taps Accept button on ride popup
    Then Ride should be accepted successfully
    And Driver waits for rider to accept on Rider app
    Then Driver should receive vibration alert
    When Driver closes the vibration alert
    Then Vibration should stop immediately
