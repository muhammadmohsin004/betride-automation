@android @TC-020
Feature: TC-020 Driver Balance Check - Low Balance Warning Appears

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-020
  Scenario: Driver with low balance sees warning popup when accepting ride
    Given Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    When Driver taps Accept button on ride popup
    Then Driver should see low balance warning popup
