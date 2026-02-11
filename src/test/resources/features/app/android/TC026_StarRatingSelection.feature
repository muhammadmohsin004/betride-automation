@android @TC-026
Feature: TC-026 Rate Driver Page - Star Rating Selection

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-026
  Scenario: Rate Driver page allows rider to select star rating
    Given Rider is on the Rate Driver page after completing a ride
    When Rider taps any star rating from 1 to 5
    Then Star selection should be highlighted and saved
