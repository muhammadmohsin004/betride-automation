Feature: TC-013 Penalty Popup - Driver Rejects Multiple Rides

  @android @TC-013
  Scenario: Driver rejects 3 rides and sees penalty popup
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in
    And Driver goes online to receive rides
    Then Driver rejects 3 rides between 6AM and 12PM
    And Driver should see penalty popup with fewer rides warning
