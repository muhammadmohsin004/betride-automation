@android @TC-034
Feature: TC-034 Invite Friends - Click Here to Share Button

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-034
  Scenario: Invite Friends page contains Click here to share button
    Given Rider navigates to the Invite Friends page
    Then Click Here to Share button should be displayed
