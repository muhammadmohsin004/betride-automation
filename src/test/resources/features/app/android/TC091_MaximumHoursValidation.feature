@android @TC-091
Feature: TC-091 Book Hourly - Maximum Hours Validation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-091
  Scenario: Verify hours stop at maximum 12 hours
    Given User is on Book Hourly page with hours less than 12
    When User increases hours to maximum
    Then Hours should stop at 12 hours and cannot go higher
