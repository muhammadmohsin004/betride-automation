@android @TC-109
Feature: TC-109 Book Hourly - Error Validation Hours Above 12

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-109
  Scenario: Verify error message when hours set above 12
    Given User is on Book Hourly page with hours selector
    When User tries to set hours above twelve
    Then Maximum hours error should display "Maximum limit is 12 hours"
