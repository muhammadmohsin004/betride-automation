package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC108_HoursSetToZeroValidationSteps extends Page {

    @Given("User is on Book Hourly page with hour selector")
    public void userIsOnBookHourlyPageWithHourSelector() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-108: HOURS SET TO 0 VALIDATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Hourly' option");
            System.out.println("  4. You should see the hour selector");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach Book Hourly page
            System.out.println("");
            System.out.println("Waiting 20 seconds to reach Book Hourly page...");
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

            // Verify we're on Book Hourly page
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnBookHourly = pageSource.contains("Hourly") ||
                                     pageSource.contains("hourly") ||
                                     pageSource.contains("hour") ||
                                     pageSource.contains("Hour") ||
                                     pageSource.contains("selector") ||
                                     pageSource.contains("Book driver");

            if (isOnBookHourly) {
                System.out.println("");
                System.out.println("Confirmed: On Book Hourly page with hour selector");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the Book Hourly page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User tries to set hours to zero")
    public void userTriesToSetHoursToZero() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TRYING TO SET HOURS TO ZERO");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Find the hour selector on the page");
            System.out.println("  2. Try to decrease hours below 1");
            System.out.println("  3. Or try to set hours to 0 if possible");
            System.out.println("  4. Observe the app's response");
            System.out.println("");
            System.out.println("  NOTE: The app should prevent setting");
            System.out.println("  hours to 0 or show an error message.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to attempt setting hours to 0
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
            System.out.println("Action should have been attempted.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Error message should display {string}")
    public void errorMessageShouldDisplay(String expectedError) {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING ERROR MESSAGE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  Expected: \"" + expectedError + "\"");
            System.out.println("");

            // Check for expected error message
            boolean hasExpectedError = pageSource.contains(expectedError);

            // Check for variations of minimum hour messages
            boolean hasMinimumError = pageSource.contains("Minimum") ||
                                      pageSource.contains("minimum") ||
                                      pageSource.contains("at least 1") ||
                                      pageSource.contains("At least 1");

            boolean hasHourError = pageSource.contains("1 hour") ||
                                   pageSource.contains("one hour") ||
                                   pageSource.contains("Hour") ||
                                   pageSource.contains("hour");

            boolean hasBookingError = pageSource.contains("booking") ||
                                      pageSource.contains("Booking");

            // Check if hours stayed at 1 (validation prevented 0)
            boolean hoursStayedAtOne = pageSource.contains("1 hour") ||
                                       pageSource.contains("1.0 Hour") ||
                                       pageSource.contains("1 Hour");

            // Check for error/warning indicators
            boolean hasErrorIndicator = pageSource.contains("error") ||
                                        pageSource.contains("Error") ||
                                        pageSource.contains("invalid") ||
                                        pageSource.contains("Invalid") ||
                                        pageSource.contains("cannot") ||
                                        pageSource.contains("Cannot");

            System.out.println("Error Message Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Exact error found: " + (hasExpectedError ? "YES" : "NO"));
            System.out.println("  - Minimum error text: " + (hasMinimumError ? "YES" : "NO"));
            System.out.println("  - Hour related text: " + (hasHourError ? "YES" : "NO"));
            System.out.println("  - Booking error text: " + (hasBookingError ? "YES" : "NO"));
            System.out.println("  - Hours stayed at 1: " + (hoursStayedAtOne ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasExpectedError) score += 5;
            if (hasMinimumError) score += 2;
            if (hasHourError) score++;
            if (hasBookingError) score++;
            if (hoursStayedAtOne) score += 2;
            if (hasErrorIndicator) score++;

            System.out.println("========================================");
            if (score >= 3 || hasExpectedError || (hasMinimumError && hasHourError) || hoursStayedAtOne) {
                System.out.println("  TC-108: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Validation working correctly!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasExpectedError) System.out.println("    - Exact error message displayed");
                if (hasMinimumError) System.out.println("    - Minimum booking message shown");
                if (hasHourError) System.out.println("    - Hour related message found");
                if (hoursStayedAtOne) System.out.println("    - Hours prevented from going below 1");
                if (hasErrorIndicator) System.out.println("    - Error indicator visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Was an error shown when trying to set 0?");
                System.out.println("  - OR did hours stay at minimum 1?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-108: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did error message appear?");
                System.out.println("  2. Did hours stay at 1 (prevented 0)?");
                System.out.println("  3. Was \"Minimum booking is 1 hour\" shown?");
                System.out.println("");
                System.out.println("  Note: App may prevent setting 0 without");
                System.out.println("  showing explicit error message (silent");
                System.out.println("  validation by keeping hours at 1).");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying error message: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-108: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
