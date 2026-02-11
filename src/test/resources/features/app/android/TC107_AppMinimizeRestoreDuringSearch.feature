@android @TC-107
Feature: TC-107 Driver Search - App Minimize/Restore During Search

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-107
  Scenario: Verify app resumes in search mode after minimize and restore
    Given User is on active searching screen
    When User minimizes the app
    And User reopens the app
    Then App should resume in search mode
    And Search state should not be reset
