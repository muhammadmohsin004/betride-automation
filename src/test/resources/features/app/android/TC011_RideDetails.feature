Feature: TC-011 Ride Details - Driver Views Ride Details

  @android @TC-011
  Scenario: Driver sees ride details on popup
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in
    And Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    Then Driver should see ride details with fare distance and status bar
