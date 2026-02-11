Feature: TC-010 Ride Reject - Driver Rejects Ride

  @android @TC-010
  Scenario: Driver rejects ride and rider receives no alert
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in
    And Driver goes online to receive rides
    Then Driver waits for ride request with shorter timeout
    When Driver taps Reject button on ride popup
    Then Ride should be rejected successfully
