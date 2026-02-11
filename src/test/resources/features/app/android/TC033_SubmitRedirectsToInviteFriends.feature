@android @TC-033
Feature: TC-033 Ride Rating - Submit Redirects to Invite Friends

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-033
  Scenario: Submitting rating redirects to Invite Friends page
    Given Rider is on the Rate Driver page for submit redirect test
    When Rider fills the rating fields with star selection
    And Rider taps Submit Rating button
    Then Rider should be redirected to Invite Friends page
