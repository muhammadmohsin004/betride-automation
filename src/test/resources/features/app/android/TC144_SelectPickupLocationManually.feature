@android @TC-144
Feature: TC-144 Send/Receive - Select Pickup Location Manually

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-144
  Scenario: Verify pickup location can be selected manually
    Given User is on Send or Receive page with pickup field empty
    When User taps pickup and searches and selects a location
    Then Send Receive pickup location should be filled correctly
