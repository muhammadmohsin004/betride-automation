@android @TC-089
Feature: TC-089 Book Hourly - Decrease Hours Using Selector

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-089
  Scenario: Verify hours decrease when moving selector counter-clockwise
    Given User is on Book Hourly page with hours greater than 1
    When User moves the selector counter-clockwise to decrease hours
    Then Hours should decrease from higher value to lower value
