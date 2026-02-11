@android @TC-046
Feature: TC-046 Settings - Navigation to Delete Account Page

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-046
  Scenario: Verify navigation to Delete Account page
    Given User is logged in and navigates to Settings
    When User taps on Delete Account option
    Then Delete Your Account screen should open with warning text and captcha
