@android @TC-108
Feature: TC-108 Book Hourly - Error Validation Hours Set to 0

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-108
  Scenario: Verify error message when hours set to 0
    Given User is on Book Hourly page with hour selector
    When User tries to set hours to zero
    Then Error message should display "Minimum booking is 1 hour"
