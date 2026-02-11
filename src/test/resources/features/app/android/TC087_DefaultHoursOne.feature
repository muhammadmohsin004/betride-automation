@android @TC-087
Feature: TC-087 Book Hourly - Default Hours = 1

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-087
  Scenario: Verify default hours displayed is 1 hour
    Given User opens Book Hourly page
    When User views the hour selector
    Then Default hours displayed should be 1 hour
