@android @TC-150
Feature: TC-150 Send/Receive - Validation Error When Pickup Missing

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-150
  Scenario: Verify error when NEXT tapped without pickup location
    Given User is on Send or Receive page with all fields filled except pickup
    When User taps NEXT without pickup location on Send Receive page
    Then Error message should display Select pickup location
