Feature: TC-005 Resend OTP

  @android @TC-005
  Scenario: Resend OTP when countdown expires
    Given User opens the BeetRide Driver app
    When User enters active phone number "650629206"
    And User accepts terms and conditions
    And User taps on "Submit" button
    Then User should see OTP verification screen
    When User waits for resend countdown to expire
    And User taps on Resend OTP button
    Then New OTP should be sent successfully
