@android @TC-063
Feature: TC-063 Confirm Ride - Discount Label Verification

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-063
  Scenario: Verify discount automatically applied message appears
    Given User is on the Confirm Ride page with discount applicable
    When User views the discount section
    Then Discount message should appear showing automatically applied
