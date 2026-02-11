@android @TC-076
Feature: TC-076 Ride Booking - Multiple Recent Locations

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-076
  Scenario: Verify recent locations list scrolls correctly with multiple items
    Given User has recent history with multiple locations
    When User views Last visited places
    Then List should scroll correctly and all items should be visible
