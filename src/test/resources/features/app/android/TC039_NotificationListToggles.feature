@android @TC-039
Feature: TC-039 Notifications - Notification List Items and Toggles

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-039
  Scenario: Verify notification list items and toggles appear on Notifications page
    Given User is on the Notifications page
    Then Notification categories or toggles should display correctly
