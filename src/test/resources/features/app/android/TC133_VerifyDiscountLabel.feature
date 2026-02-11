@android @TC-133
Feature: TC-133 Confirm Ride - Verify Discount Label

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-133
  Scenario: Verify discount automatically applied label is visible
    Given User is on Confirm Ride page with discount enabled
    Then Discount automatically applied label should be visible
