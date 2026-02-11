@android @TC-037
Feature: TC-037 Ride History - History Tab Displays Rides

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-037
  Scenario: History tab displays In-Progress Completed and Cancelled rides
    Given Rider has past and ongoing rides
    When Rider navigates to the History Tab
    Then History tab should show In Progress Completed and Cancelled sections
