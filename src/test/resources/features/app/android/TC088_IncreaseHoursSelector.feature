@android @TC-088
Feature: TC-088 Book Hourly - Increase Hours Using Selector

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-088
  Scenario: Verify hours increase when moving selector clockwise
    Given User is on Book Hourly page with selector active
    When User moves the selector clockwise to increase hours
    Then Hours should increase from 1 to 2 to 3 and so on
