@android @TC-142
Feature: TC-142 Home Screen - Open Get Anything Screen

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-142
  Scenario: Verify tapping Get Anything navigates to Send or Receive Anything page
    Given User is on the Rider app Home screen with Get Anything visible
    When User taps on Get Anything option
    Then User should navigate to Send or Receive Anything page
