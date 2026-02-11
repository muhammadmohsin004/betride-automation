@android @TC-043
Feature: TC-043 Settings - Verify Selecting a Language

  Background:
    Given User opens the BeetRide Driver app
    Then User should be on Home screen or Login screen
    When User logs in if not already logged in

  @TC-043
  Scenario: Verify selecting a language option
    Given User is on the Language selection screen
    When User taps on a language option like English or Arabic or French
    Then Language option should get selected with radio button active
