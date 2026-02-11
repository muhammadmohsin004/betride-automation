Feature: TC-008 Ride Creation - Driver Receives Alert

  @android @TC-008
  Scenario: Driver receives ride alert when rider creates ride
    Given User opens the BeetRide Driver app
    When User enters active phone number "650629206"
    And User accepts terms and conditions
    And User taps on "Submit" button
    Then User should see OTP verification screen
    When User enters OTP code "12345"
    And User taps on verify button
    Then User should be logged in and see Home screen
    And Driver goes online to receive rides
    Then Rider opens the BeetRide Rider app
    And Rider books a ride from current location
    Then Test switches back to Driver app and waits for ride alert
    And Driver should see ride popup with Accept Reject and Fare
