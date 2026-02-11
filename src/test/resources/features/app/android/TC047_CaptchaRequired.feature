@android @TC-047
Feature: TC-047 Settings - Verify Captcha is Required

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-047
  Scenario: Verify captcha is required on Delete Account page
    Given User is on the Delete Account page
    When User leaves captcha input empty and taps Continue
    Then Error message should appear Please enter the correct sum
