Feature: TC-001 Login with Active Mobile Number

  @android @TC-001
  Scenario: Login with active mobile number
    Given User opens the BeetRide Driver app
    When User enters active phone number "650629206"
    And User accepts terms and conditions
    And User taps on "Submit" button
    Then User should see OTP verification screen
    And OTP should be sent to the user
