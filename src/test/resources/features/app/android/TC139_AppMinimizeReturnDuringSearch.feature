@android @TC-139
Feature: TC-139 Driver Search - App Minimize and Return During Search

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-139
  Scenario: Verify app resumes in correct searching state after minimize and return
    Given User is on searching screen with active driver search
    When User minimizes and reopens the app during search
    Then App should resume in correct searching state
