Feature: Home Page Testing App

 @android @final

    Scenario: Verify user is able to Login to application
    # Given User is on Get Ride Requests screen
    # When User taps on "تخطي >"
    # Then User should see "اختر لغتك المفضلة"
    # When User taps on "English"
    # And User taps on "تأكيد اللغة"
    Given User should see "Enter your Whatsapp number"
    When User taps on Phone Number field
    And User type "650629206" in Phone Number field
    And User clicks on Accept Agreements and Terms checkbox
    And User taps on "Submit"
    Then User should see "OTP Verification"
    When user enter "12345" in otp field
    And User taps on "Allow"

    Then User should see "Your Status:"
    Then User should taps on "Active Jobs"
    Then User should see "Active Jobs" page
    When User accepts the ride request
    When User taps on 'Arrive' button
    Then User should see confirmation popup
    When User taps on 'Yes' toggle
    Then User should see 'Start Ride' button
    When User taps on 'Start Ride' button
    And User navigates back to the app from Google Maps
    Then User should see 'Ride Started' label
    When User taps on 'End Ride' button
    Then User should see "Rate Rider" page
    When User gives 5 star rating
    And User submits the review
    When user taps on profile button
    And User taps on the "Logout"
    Then user should see Alert Message
    When User taps on "Yes"
   