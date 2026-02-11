@android @TC-145
Feature: TC-145 Send/Receive - Select Pickup From Map

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-145
  Scenario: Verify pickup location can be selected from map
    Given User is on Send or Receive page with pickup field empty for map selection
    When User taps select pickup location and chooses from map
    Then Map should close and pickup field should update accurately
