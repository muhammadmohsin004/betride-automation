@android @TC-106
Feature: TC-106 Driver Search - Cancel NO Action

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-106
  Scenario: Verify tapping NO on cancel popup closes popup and continues searching
    Given Cancel confirmation popup is visible
    When User taps NO on cancel popup
    Then Cancel popup should close
    And Searching should continue
