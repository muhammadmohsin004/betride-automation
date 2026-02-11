Feature: TC-012 Auto Price Ride - Rider Rejects Creates New Ride

  @android @TC-012
  Scenario: Rider rejects driver and auto ride creates in 5 minutes
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in
    And Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    When Driver taps Accept button on ride popup
    Then Ride should be accepted successfully
    When Rider rejects driver from Rider app manually
    Then Wait for auto ride request within 5 minutes
    And Driver should receive new ride with increased price
