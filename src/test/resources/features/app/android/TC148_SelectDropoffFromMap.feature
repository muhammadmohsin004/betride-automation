@android @TC-148
Feature: TC-148 Send/Receive - Select Drop-off From Map

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-148
  Scenario: Verify drop-off location can be selected from map
    Given User is on Send or Receive page with drop-off empty for map selection
    When User taps select drop-off location and chooses from map
    Then Send Receive drop-off field should be updated correctly
