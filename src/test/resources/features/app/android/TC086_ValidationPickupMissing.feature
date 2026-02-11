@android @TC-086
Feature: TC-086 Book Hourly - Validation: Pickup Missing

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-086
  Scenario: Verify error is displayed when pickup is not selected
    Given User is on Book Hourly page without selecting pickup
    When User taps Next button without selecting pickup
    Then Error should be displayed saying Please select pickup location
