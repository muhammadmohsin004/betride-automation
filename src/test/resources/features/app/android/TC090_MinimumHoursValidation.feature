@android @TC-090
Feature: TC-090 Book Hourly - Minimum Hours Validation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-090
  Scenario: Verify hours cannot go below 1 hour
    Given User is on Book Hourly page with hours set to 1
    When User tries to decrease hours below 1
    Then Hours should remain at 1 hour and cannot go lower
