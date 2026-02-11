@android @TC-126
Feature: TC-126 Confirm Ride - Verify TO Address

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-126
  Scenario: Verify correct drop-off address displayed in TO section
    Given User is on Confirm Ride page with addresses shown
    Then TO section should display correct drop-off address
