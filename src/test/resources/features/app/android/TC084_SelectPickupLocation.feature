@android @TC-084
Feature: TC-084 Book Hourly - Select Pickup Location

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-084
  Scenario: Verify selecting pickup location updates the field
    Given User is on Book Hourly page with pickup not selected
    When User taps Select pickup location and chooses a location
    Then Pickup field should update with selected location
