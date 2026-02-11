@android @TC-083
Feature: TC-083 Book Hourly - Page UI Validation

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-083
  Scenario: Verify Book Hourly page has required UI elements
    Given Book Hourly page is open
    When User views the Book Hourly screen
    Then Pickup field and hour selector and Next button should be visible
