@android @TC-080
Feature: TC-080 Confirm Ride - Verify Correct Currency Shown

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-080
  Scenario: Verify fare is shown in MAD currency format
    Given App is configured to MAD currency
    When User opens Confirm Ride screen
    Then Fare should be shown in MAD currency format
