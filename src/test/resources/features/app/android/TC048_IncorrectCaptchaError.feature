@android @TC-048
Feature: TC-048 Settings - Verify Incorrect Captcha Shows Error

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-048
  Scenario: Verify incorrect captcha shows error on Delete Account page
    Given User is on the Delete Account page for captcha test
    When User enters incorrect captcha value and taps Continue
    Then Error message should appear Incorrect sum Try again
