@android @TC-029
Feature: TC-029 Rate Driver Page - Feedback Text Field Input

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-029
  Scenario: Rider can input text in Tell us what can be improved field
    Given Rider is on the Rate Driver page for feedback test
    When Rider taps on the feedback text box
    And Rider enters feedback text in the field
    Then Feedback text should be accepted and displayed
