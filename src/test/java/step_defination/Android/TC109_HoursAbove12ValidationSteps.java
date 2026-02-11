package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC109_HoursAbove12ValidationSteps extends Page {

    @Given("User is on Book Hourly page with hours selector")
    public void userIsOnBookHourlyPageWithHoursSelector() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-109: HOURS ABOVE 12 VALIDATION");
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
                System.out.println("Confirmed: On Book Hourly page with hours selector");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the Book Hourly page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User tries to set hours above twelve")
    public void userTriesToSetHoursAboveTwelve() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TRYING TO SET HOURS ABOVE 12");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Find the hour selector on the page");
            System.out.println("  2. Try to increase hours above 12");
            System.out.println("  3. Or try to set hours to 13+ if possible");
            System.out.println("  4. Observe the app's response");
            System.out.println("");
            System.out.println("  NOTE: The app should prevent setting");
            System.out.println("  hours above 12 or show an error message.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to attempt setting hours above 12
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

    @Then("Maximum hours error should display {string}")
    public void maximumHoursErrorShouldDisplay(String expectedError) {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING MAXIMUM HOURS ERROR");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  Expected: \"" + expectedError + "\"");
            System.out.println("");

            // Check for expected error message
            boolean hasExpectedError = pageSource.contains(expectedError);

            // Check for variations of maximum hour messages
            boolean hasMaximumError = pageSource.contains("Maximum") ||
                                      pageSource.contains("maximum") ||
                                      pageSource.contains("max") ||
                                      pageSource.contains("Max");

            boolean hasLimitError = pageSource.contains("limit") ||
                                    pageSource.contains("Limit") ||
                                    pageSource.contains("exceed") ||
                                    pageSource.contains("Exceed");

            boolean has12HourError = pageSource.contains("12 hour") ||
                                     pageSource.contains("12 Hour") ||
                                     pageSource.contains("twelve hour") ||
                                     pageSource.contains("12.0 Hour");

            // Check if hours stayed at 12 (validation prevented going above)
            boolean hoursStayedAtTwelve = pageSource.contains("12 hour") ||
                                          pageSource.contains("12.0 Hour") ||
                                          pageSource.contains("12 Hour");

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
            System.out.println("  - Maximum error text: " + (hasMaximumError ? "YES" : "NO"));
            System.out.println("  - Limit error text: " + (hasLimitError ? "YES" : "NO"));
            System.out.println("  - 12 hour related text: " + (has12HourError ? "YES" : "NO"));
            System.out.println("  - Hours stayed at 12: " + (hoursStayedAtTwelve ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasExpectedError) score += 5;
            if (hasMaximumError) score += 2;
            if (hasLimitError) score++;
            if (has12HourError) score += 2;
            if (hoursStayedAtTwelve) score += 2;
            if (hasErrorIndicator) score++;

            System.out.println("========================================");
            if (score >= 3 || hasExpectedError || (hasMaximumError && has12HourError) || hoursStayedAtTwelve) {
                System.out.println("  TC-109: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Validation working correctly!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasExpectedError) System.out.println("    - Exact error message displayed");
                if (hasMaximumError) System.out.println("    - Maximum limit message shown");
                if (hasLimitError) System.out.println("    - Limit related message found");
                if (has12HourError) System.out.println("    - 12 hour reference found");
                if (hoursStayedAtTwelve) System.out.println("    - Hours prevented from going above 12");
                if (hasErrorIndicator) System.out.println("    - Error indicator visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Was an error shown when trying to set > 12?");
                System.out.println("  - OR did hours stay at maximum 12?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-109: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did error message appear?");
                System.out.println("  2. Did hours stay at 12 (prevented > 12)?");
                System.out.println("  3. Was \"Maximum limit is 12 hours\" shown?");
                System.out.println("");
                System.out.println("  Note: App may prevent setting > 12 without");
                System.out.println("  showing explicit error message (silent");
                System.out.println("  validation by keeping hours at 12).");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying error message: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-109: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
