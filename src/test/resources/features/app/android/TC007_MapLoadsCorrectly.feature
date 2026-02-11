Feature: TC-007 Map Loads Correctly

  @android @TC-007
  Scenario: Map loads correctly on home screen
    Given User opens the BeetRide Driver app
    When User enters active phone number "650629206"
    And User accepts terms and conditions
    And User taps on "Submit" button
    Then User should see OTP verification screen
    When User enters OTP code "12345"
    And User taps on verify button
    Then User should be logged in and see Home screen
    And Map should load with driver location
