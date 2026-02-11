Feature: TC-002 Login with Inactive/Unregistered Mobile Number

  @android @TC-002
  Scenario: Login with unregistered mobile number and complete registration
    Given User opens the BeetRide Driver app
    When User enters inactive phone number "123456789"
    And User accepts terms and conditions
    And User taps on "Submit" button
    Then User should be redirected to Details page for registration
    When User fills registration form with name "Test Driver" and city "Ahfir"
    And User taps on "Submit" button
    Then User should see OTP verification screen
    When User enters OTP code "12345"
    And User taps on verify button
    Then User should see registration completed or home screen
