@android @TC-027
Feature: TC-027 Rate Driver Page - Did Driver Come On Time Question

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-027
  Scenario: Rate Driver page shows Did driver come on time radio options
    Given Rider is on the Rate Driver page
    When Rider scrolls to Did driver come on time question
    Then Radio buttons Yes and No should be displayed
