@android @TC-092
Feature: TC-092 Book Hourly - Select Full Range of Hours

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-092
  Scenario: Verify hours update accurately for each position from 1 to 12
    Given User is on Book Hourly page with selector active for full range test
    When User moves selector from 1 to 12 checking each position
    Then Hours should update accurately for each position
