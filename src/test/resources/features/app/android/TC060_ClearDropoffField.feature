@android @TC-060
Feature: TC-060 Ride Booking - Clear Drop-off Field

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-060
  Scenario: Verify clear icon clears drop-off field
    Given User has filled the drop-off field with text
    When User taps on the clear x icon for drop-off
    Then Drop-off field should become empty
