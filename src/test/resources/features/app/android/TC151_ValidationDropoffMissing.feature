@android @TC-151
Feature: TC-151 Send/Receive - Validation Error When Drop-off Missing

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-151
  Scenario: Verify error when NEXT tapped without drop-off location
    Given User is on Send or Receive page with all fields filled except drop-off
    When User taps NEXT without drop-off location on Send Receive page
    Then Error message should display Select drop-off location
