@android @TC-125
Feature: TC-125 Confirm Ride - Verify FROM Address

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-125
  Scenario: Verify correct pickup address displayed in FROM section
    Given User is on Confirm Ride page with route displayed
    Then FROM section should display correct pickup address
