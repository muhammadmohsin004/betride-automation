@android @TC-101
Feature: TC-101 Confirm Booking - Verify Discount Label

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-101
  Scenario: Verify discount label shows automatically applied
    Given User is on Confirm Booking page with discount rule enabled
    When User views the discount text
    Then Discount label should show "Discount automatically applied"
