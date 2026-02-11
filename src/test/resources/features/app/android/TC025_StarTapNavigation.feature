@android @TC-025
Feature: TC-025 Ride Rating - Star Tap Navigates to Rate Driver Page

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-025
  Scenario: Tapping star on Rate Your Driver popup navigates to Rate Driver page
    Given Driver completes a ride and rider sees Rate Your Driver popup
    When Rider taps any star on the Rate Your Driver popup
    Then Rider should be redirected to the full Rate Driver page
