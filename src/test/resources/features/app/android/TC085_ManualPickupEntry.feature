@android @TC-085
Feature: TC-085 Book Hourly - Manual Pickup Entry

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-085
  Scenario: Verify manual pickup entry updates the location
    Given User is on Book Hourly page with empty pickup field
    When User taps pickup field and types location manually and selects from suggestions
    Then Pickup location should be updated via manual entry
