@android @TC-030
Feature: TC-030 Rate Driver Page - Report Driver Now Link

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-030
  Scenario: Had bad experience Report Driver Now link is clickable
    Given Rider is on the Rate Driver page for report test
    When Rider taps on Report Driver Now link
    Then Rider should be redirected to report submission page
