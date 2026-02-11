@android @TC-024
Feature: TC-024 Ride Rating - Rate Your Driver Popup After Completed Ride

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-024
  Scenario: Completed ride shows Rate Your Driver popup when rider reopens app
    Given Driver completes a ride with rider
    When Rider closes and reopens the Rider app
    Then Rider should see Rate Your Driver popup with address and star rating
