@android @TC-040
Feature: TC-040 Notifications - Toggle Notifications ON/OFF

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-040
  Scenario: Verify toggling notifications ON and OFF
    Given User is on the Notifications settings page
    When User toggles a notification setting ON
    And User toggles the same notification setting OFF
    Then Preference should be saved and toggle should update correctly
