@android @TC-036
Feature: TC-036 Rider Profile - Profile Picture Opens History Tab

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-036
  Scenario: Clicking profile picture opens History tab
    Given Rider is on the home screen
    When Rider taps on the profile picture
    Then App should navigate to History Tab
