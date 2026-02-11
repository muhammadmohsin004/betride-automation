@android @TC-057
Feature: TC-057 Ride Booking - Autocomplete Location Suggestions

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-057
  Scenario: Verify autocomplete location suggestions appear when typing
    Given User is on the Add Destination page
    When User types text in the pickup or destination field
    Then Suggestions should be displayed based on input
