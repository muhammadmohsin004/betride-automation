@android @TC-073
Feature: TC-073 Ride Booking - App Behavior with GPS Off

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-073
  Scenario: Verify app behavior when GPS is disabled
    Given GPS is disabled on the device
    When User opens Add Destination screen
    Then GPS permission popup should appear or manual entry required
