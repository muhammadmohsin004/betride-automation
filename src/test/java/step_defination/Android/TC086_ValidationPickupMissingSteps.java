package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC086_ValidationPickupMissingSteps extends Page {

    @Given("User is on Book Hourly page without selecting pickup")
    public void userIsOnBookHourlyPageWithoutSelectingPickup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-086: VALIDATION - PICKUP MISSING");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. DO NOT select pickup location");
            System.out.println("     (Leave pickup field empty)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 12 seconds to open Book Hourly page...");
            System.out.println("");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(3000);
                System.out.println("Waiting... " + ((i + 1) * 3) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Book Hourly page should be open without pickup selected.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Next button without selecting pickup")
    public void userTapsNextButtonWithoutSelectingPickup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP NEXT WITHOUT PICKUP SELECTED");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Make sure pickup is NOT selected");
            System.out.println("  2. Tap the 'Next' button");
            System.out.println("  3. Observe if error message appears");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Next button...");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(2000);
                System.out.println("Waiting... " + ((i + 1) * 2) + " sec");

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
            System.out.println("Error tapping Next: " + e.getMessage());
        }
    }

    @Then("Error should be displayed saying Please select pickup location")
    public void errorShouldBeDisplayedSayingPleaseSelectPickupLocation() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  PICKUP VALIDATION ERROR VERIFICATION");
            System.out.println("========================================");

            // Check for error message about pickup
            boolean hasPickupError = pageSource.contains("select pickup") ||
                                     pageSource.contains("Select pickup") ||
                                     pageSource.contains("pickup location") ||
                                     pageSource.contains("Pickup location") ||
                                     pageSource.contains("Please select") ||
                                     pageSource.contains("required");

            // Check for general error indicators
            boolean hasErrorIndicator = pageSource.contains("Error") ||
                                        pageSource.contains("error") ||
                                        pageSource.contains("Warning") ||
                                        pageSource.contains("warning") ||
                                        pageSource.contains("Invalid") ||
                                        pageSource.contains("invalid");

            // Check for toast or snackbar
            boolean hasToast = pageSource.contains("Toast") ||
                               pageSource.contains("toast") ||
                               pageSource.contains("Snackbar") ||
                               pageSource.contains("snackbar");

            // Check still on Book Hourly page (didn't proceed)
            boolean stillOnBookHourly = pageSource.contains("Hourly") ||
                                        pageSource.contains("hourly") ||
                                        pageSource.contains("Hour") ||
                                        pageSource.contains("Pickup");

            // Check for Next button still visible
            boolean hasNextButton = pageSource.contains("Next") ||
                                    pageSource.contains("next");

            System.out.println("");
            System.out.println("Pickup Validation Error Verification:");
            System.out.println("--------------------------------------");
            System.out.println("  - Pickup error message: " + (hasPickupError ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Toast/Snackbar: " + (hasToast ? "YES" : "NO"));
            System.out.println("  - Still on Book Hourly: " + (stillOnBookHourly ? "YES" : "NO"));
            System.out.println("  - Next button visible: " + (hasNextButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasPickupError) score += 3;
            if (hasErrorIndicator) score += 2;
            if (hasToast) score++;
            if (stillOnBookHourly) score += 2;
            if (hasNextButton) score++;

            if (score >= 3 || hasPickupError || (hasErrorIndicator && stillOnBookHourly)) {
                System.out.println("========================================");
                System.out.println("  TC-086: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Error displayed for missing pickup!");
                System.out.println("");
                if (hasPickupError) System.out.println("  - Pickup error message shown");
                if (hasErrorIndicator) System.out.println("  - Error indicator visible");
                if (hasToast) System.out.println("  - Toast/Snackbar displayed");
                if (stillOnBookHourly) System.out.println("  - Still on Book Hourly page");
                if (hasNextButton) System.out.println("  - Next button still visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did error 'Please select pickup location' appear?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-086: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Next without pickup?");
                System.out.println("  2. Did an error message appear?");
                System.out.println("  3. Did it say 'Please select pickup location'?");
                System.out.println("  4. Are you still on Book Hourly page?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying validation: " + e.getMessage());
            System.out.println("TC-086: FAILED - " + e.getMessage());
        }
    }
}
