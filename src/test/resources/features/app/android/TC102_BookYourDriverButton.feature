@android @TC-102
Feature: TC-102 Confirm Booking - Book Your Driver Button

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-102
  Scenario: Verify Book your driver button navigates to ride searching
    Given User is on Confirm Booking page with pickup hours and fare selected
    When User taps Book your driver button
    Then App should navigate to ride searching screen
