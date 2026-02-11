@android @TC-147
Feature: TC-147 Send/Receive - Select Drop-off Manually

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-147
  Scenario: Verify drop-off location can be selected manually
    Given User is on Send or Receive page with drop-off field empty
    When User taps drop-off field and types and selects a suggestion
    Then Send Receive drop-off location should be set correctly
