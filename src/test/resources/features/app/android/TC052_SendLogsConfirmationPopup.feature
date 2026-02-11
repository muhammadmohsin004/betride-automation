@android @TC-052
Feature: TC-052 Settings - Verify Send Logs Confirmation Popup

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-052
  Scenario: Verify send logs confirmation popup with Yes No buttons
    Given User has tapped on Send Device Logs option
    Then Popup should appear with Send device logs message and Yes No buttons
