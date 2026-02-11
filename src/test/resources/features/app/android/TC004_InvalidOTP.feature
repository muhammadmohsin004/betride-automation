Feature: TC-004 Invalid OTP

  @android @TC-004
  Scenario: Login with invalid OTP shows error
    Given User opens the BeetRide Driver app
    When User enters active phone number "650629206"
    And User accepts terms and conditions
    And User taps on "Submit" button
    Then User should see OTP verification screen
    When User enters invalid OTP "00000"
    And User taps on verify button
    Then User should see "Invalid OTP" error message
