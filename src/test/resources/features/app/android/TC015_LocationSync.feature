@android @TC-015
Feature: TC-015 Location Sync - Driver Sees Same Location Rider Selected

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-015
  Scenario: Driver sees exact same pickup and dropoff locations as rider selected
    Given Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    And Driver should see pickup and dropoff locations on ride popup
    Then Verify driver sees same locations that rider selected
