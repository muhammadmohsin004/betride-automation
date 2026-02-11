Feature: TC-003 Correct OTP Login

  @android @TC-003
  Scenario: Login with correct OTP
    Given User opens the BeetRide Driver app
    When User enters active phone number "650629206"
    And User accepts terms and conditions
    And User taps on "Submit" button
    Then User should see OTP verification screen
    When User enters OTP code "12345"
    And User taps on verify button
    Then User should be logged in and see Home screen
