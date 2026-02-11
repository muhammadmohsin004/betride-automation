@android @TC-032
Feature: TC-032 Rate Driver Page - Validation Without Stars

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-032
  Scenario: Validation message appears when submitting without selecting stars
    Given Rider is on the Rate Driver page for validation test
    When Rider does not select any star rating
    And Rider taps Submit Rating button without stars
    Then Validation message should appear asking to give star rating
