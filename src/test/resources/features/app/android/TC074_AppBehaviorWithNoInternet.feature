@android @TC-074
Feature: TC-074 Ride Booking - App Behavior with No Internet

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-074
  Scenario: Verify app shows error when internet is off
    Given Internet is turned off on the device
    When User taps on Lets Go button
    Then Error message No internet connection should appear
