Feature: TC-009 Ride Accept - Driver Accepts Ride

  @android @TC-009
  Scenario: Driver accepts ride and rider receives notification
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in
    And Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    When Driver taps Accept button on ride popup
    Then Ride should be accepted successfully
