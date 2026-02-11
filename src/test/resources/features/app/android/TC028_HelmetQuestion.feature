@android @TC-028
Feature: TC-028 Rate Driver Page - Did Driver Provide Helmet Question

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-028
  Scenario: Rate Driver page shows Did driver provide helmet radio options
    Given Rider is on the Rate Driver page for helmet question test
    When Rider scrolls to Did driver provide you a helmet question
    Then Helmet question Yes and No options should be displayed
