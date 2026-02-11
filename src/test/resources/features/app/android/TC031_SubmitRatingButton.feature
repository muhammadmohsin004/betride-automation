@android @TC-031
Feature: TC-031 Rate Driver Page - Submit Rating Button Display

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-031
  Scenario: Submit Rating button is displayed and clickable
    Given Rider is on the Rate Driver page for submit button test
    When Rider scrolls to the bottom of Rate Driver page
    Then Submit Rating button should be visible and clickable
