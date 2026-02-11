@android @TC-078
Feature: TC-078 Ride Booking - Select Drop-off from Map

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-078
  Scenario: Verify moving map pin updates drop-off location
    Given Map is opened for location selection
    When User moves the map pin to a new location
    Then Drop-off should update based on pin location
