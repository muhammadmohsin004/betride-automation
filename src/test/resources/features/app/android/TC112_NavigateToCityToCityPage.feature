@android @TC-112
Feature: TC-112 Home Screen - Navigate to City to City Page

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-112
  Scenario: Verify navigation to City to City page
    Given User is on Home screen with City to City option
    When User taps on City to City option
    Then App should navigate to Start your city to city ride page
