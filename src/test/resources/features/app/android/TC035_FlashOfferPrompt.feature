@android @TC-035
Feature: TC-035 Ride Offers - Flash Offer Prompt

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-035
  Scenario: Flash Offer prompt appears when rider opens an active ride
    Given Rider has an active or eligible ride
    When Rider opens the ride details page
    Then Flash Offer prompt should appear
