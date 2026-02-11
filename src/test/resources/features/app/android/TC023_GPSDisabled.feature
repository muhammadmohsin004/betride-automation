@android @TC-023
Feature: TC-023 GPS Disabled - Driver Cannot Accept Ride With GPS Off

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-023
  Scenario: Driver cannot accept ride when GPS is disabled
    Given Driver goes online to receive rides
    When Driver disables GPS on device
    Then Driver waits for ride request with shorter timeout
    When Driver taps Accept button on ride popup
    Then Driver should see Enable GPS error message
