@android @TC-095
Feature: TC-095 Confirm Booking - Verify Pickup Location Displayed

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-095
  Scenario: Verify correct pickup address displayed under FROM
    Given User is on Confirm Booking page for pickup verification
    When User views the FROM address section
    Then Correct pickup address should be displayed under FROM
