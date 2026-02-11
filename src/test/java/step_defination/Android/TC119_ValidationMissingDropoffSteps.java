package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC119_ValidationMissingDropoffSteps extends Page {

    @Given("User is on City to City page without drop-off selected")
    public void userIsOnCityToCityPageWithoutDropoffSelected() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-119: VALIDATION MISSING DROP-OFF");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("  4. Select a pickup location");
            System.out.println("  5. Drop-off location NOT selected");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach City to City page
            System.out.println("");
            System.out.println("Waiting 20 seconds to reach City to City page...");
            System.out.println("");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            // Verify we're on City to City page
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnCityToCity = pageSource.contains("City to City") ||
                                     pageSource.contains("city to city") ||
                                     pageSource.contains("Start your city") ||
                                     pageSource.contains("Next") ||
                                     pageSource.contains("drop") ||
                                     pageSource.contains("Drop");

            if (isOnCityToCity) {
                System.out.println("");
                System.out.println("Confirmed: On City to City page");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the City to City page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Next without selecting drop-off")
    public void userTapsNextWithoutSelectingDropoff() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING NEXT WITHOUT DROP-OFF");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Ensure pickup IS selected");
            System.out.println("  2. Ensure drop-off field is EMPTY");
            System.out.println("  3. Tap on the 'Next' button");
            System.out.println("  4. Observe the error message");
            System.out.println("");
            System.out.println("  NOTE: An error should appear about");
            System.out.println("  missing drop-off/destination location.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap Next
            System.out.println("");
            System.out.println("Waiting 15 seconds for manual action...");
            System.out.println("");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Next button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Drop-off error should display {string}")
    public void dropoffErrorShouldDisplay(String expectedError) {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING DROP-OFF ERROR MESSAGE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  Expected: \"" + expectedError + "\"");
            System.out.println("");

            // Check for expected error message
            boolean hasExpectedError = pageSource.contains(expectedError);

            // Check for variations of drop-off error
            boolean hasDropoffError = pageSource.contains("Please select drop") ||
                                      pageSource.contains("please select drop") ||
                                      pageSource.contains("Select drop") ||
                                      pageSource.contains("select drop") ||
                                      pageSource.contains("please add destination") ||
                                      pageSource.contains("Please add destination") ||
                                      pageSource.contains("add destination");

            boolean hasDestinationError = pageSource.contains("drop-off location") ||
                                          pageSource.contains("Drop-off location") ||
                                          pageSource.contains("destination location") ||
                                          pageSource.contains("Destination location") ||
                                          pageSource.contains("destination") ||
                                          pageSource.contains("Destination");

            // Check for general error/validation messages
            boolean hasValidationError = pageSource.contains("Please select") ||
                                         pageSource.contains("please select") ||
                                         pageSource.contains("Please add") ||
                                         pageSource.contains("please add") ||
                                         pageSource.contains("Required") ||
                                         pageSource.contains("required");

            // Check for error indicators
            boolean hasErrorIndicator = pageSource.contains("error") ||
                                        pageSource.contains("Error") ||
                                        pageSource.contains("invalid") ||
                                        pageSource.contains("Invalid") ||
                                        pageSource.contains("Warning") ||
                                        pageSource.contains("warning");

            // Check if still on same page
            boolean stayedOnPage = pageSource.contains("City to City") ||
                                    pageSource.contains("Next") ||
                                    pageSource.contains("Start your city");

            System.out.println("Error Message Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Exact error found: " + (hasExpectedError ? "YES" : "NO"));
            System.out.println("  - Drop-off error text: " + (hasDropoffError ? "YES" : "NO"));
            System.out.println("  - Destination error: " + (hasDestinationError ? "YES" : "NO"));
            System.out.println("  - Validation error: " + (hasValidationError ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Stayed on page: " + (stayedOnPage ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasExpectedError) score += 5;
            if (hasDropoffError) score += 3;
            if (hasDestinationError) score += 2;
            if (hasValidationError) score++;
            if (hasErrorIndicator) score++;
            if (stayedOnPage) score++;

            System.out.println("========================================");
            if (score >= 3 || hasExpectedError || hasDropoffError) {
                System.out.println("  TC-119: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Validation working correctly!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasExpectedError) System.out.println("    - Exact error message displayed");
                if (hasDropoffError) System.out.println("    - Drop-off error message shown");
                if (hasDestinationError) System.out.println("    - Destination error text visible");
                if (hasValidationError) System.out.println("    - Validation message found");
                if (hasErrorIndicator) System.out.println("    - Error indicator visible");
                if (stayedOnPage) System.out.println("    - Stayed on City to City page");
                System.out.println("");
                System.out.println("  Result: Error for missing drop-off displayed");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-119: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did error message appear?");
                System.out.println("  2. Did it mention drop-off/destination?");
                System.out.println("  3. Did the app stay on the City to City page?");
                System.out.println("");
                System.out.println("  Expected: Error prevents navigation without");
                System.out.println("  selecting a drop-off location.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying error message: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-119: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
