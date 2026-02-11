@android @TC-049
Feature: TC-049 Settings - Verify Correct Captcha Continues Deletion Flow

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-049
  Scenario: Verify correct captcha continues to account deletion confirmation
    Given User is on the Delete Account page for deletion flow test
    When User enters correct captcha value and taps Continue
    Then Deletion confirmation should appear or user is logged out
