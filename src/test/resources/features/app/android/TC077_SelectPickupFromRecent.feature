@android @TC-077
Feature: TC-077 Ride Booking - Select Pickup from Recent Locations

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-077
  Scenario: Verify selecting pickup from recent locations updates field correctly
    Given User has recent location history
    When User taps on a recent location under pickup field
    Then Pickup field should update correctly with selected location
