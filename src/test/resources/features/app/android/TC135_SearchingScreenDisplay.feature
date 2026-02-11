@android @TC-135
Feature: TC-135 Driver Search - Searching Screen Display

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-135
  Scenario: Verify searching screen displays ride request message and driver icons
    Given User is on driver searching screen after requesting ride
    Then Searching screen should show ride request sent message and driver icons
