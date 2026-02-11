@android @TC-072
Feature: TC-072 Ride Booking - Reopen App During Searching

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-072
  Scenario: Verify app resumes at searching screen after reopen
    Given App is in searching state
    When User closes and reopens the app
    Then App should resume at searching screen or show correct ride state
