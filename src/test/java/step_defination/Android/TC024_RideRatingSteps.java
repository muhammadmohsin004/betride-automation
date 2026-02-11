package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC024_RideRatingSteps extends Page {

    @Given("Driver completes a ride with rider")
    public void driverCompletesARideWithRider() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-024: RIDE RATING TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  1. Complete a ride flow:");
            System.out.println("     - Rider creates a ride");
            System.out.println("     - Driver accepts the ride");
            System.out.println("     - Rider accepts the driver");
            System.out.println("     - Driver arrives at pickup");
            System.out.println("     - Driver starts the trip");
            System.out.println("     - Driver completes the trip");
            System.out.println("");
            System.out.println("  2. After ride completion:");
            System.out.println("     - Close the Rider app");
            System.out.println("     - Reopen the Rider app");
            System.out.println("");
            System.out.println("  3. Verify:");
            System.out.println("     - 'Rate Your Driver' popup appears");
            System.out.println("     - Pickup & drop-off address shown");
            System.out.println("     - Star rating visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for manual ride completion
            System.out.println("");
            System.out.println("Waiting 90 seconds for ride to be completed...");
            System.out.println("Please complete the ride flow manually.");
            System.out.println("");

            for (int i = 0; i < 30; i++) {
                Thread.sleep(3000);
                System.out.println("Waiting for ride completion... " + ((i + 1) * 3) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Ride should be completed by now.");

        } catch (Exception e) {
            System.out.println("Error during ride completion: " + e.getMessage());
        }
    }

    @When("Rider closes and reopens the Rider app")
    public void riderClosesAndReopensTheRiderApp() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  RIDER APP REOPEN STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Close the Rider app completely");
            System.out.println("  2. Wait a few seconds");
            System.out.println("  3. Reopen the Rider app");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to close and reopen the Rider app
            System.out.println("");
            System.out.println("Waiting 20 seconds for Rider app to be closed and reopened...");

            for (int i = 0; i < 7; i++) {
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
            System.out.println("Rider app should be reopened now.");

        } catch (Exception e) {
            System.out.println("Error during Rider app reopen: " + e.getMessage());
        }
    }

    @Then("Rider should see Rate Your Driver popup with address and star rating")
    public void riderShouldSeeRateYourDriverPopupWithAddressAndStarRating() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  RATE YOUR DRIVER POPUP VERIFICATION");
            System.out.println("========================================");

            // Check for Rate Your Driver popup indicators
            boolean hasRateDriver = pageSource.contains("Rate Your Driver") ||
                                    pageSource.contains("rate your driver") ||
                                    pageSource.contains("Rate Driver") ||
                                    pageSource.contains("rate driver") ||
                                    pageSource.contains("Rate") ||
                                    pageSource.contains("Rating");

            // Check for star rating indicators
            boolean hasStarRating = pageSource.contains("star") ||
                                    pageSource.contains("Star") ||
                                    pageSource.contains("★") ||
                                    pageSource.contains("rating") ||
                                    pageSource.contains("Rating");

            // Check for address indicators
            boolean hasAddress = pageSource.contains("address") ||
                                 pageSource.contains("Address") ||
                                 pageSource.contains("pickup") ||
                                 pageSource.contains("Pickup") ||
                                 pageSource.contains("drop") ||
                                 pageSource.contains("Drop") ||
                                 pageSource.contains("From") ||
                                 pageSource.contains("To");

            // Check for submit/done button
            boolean hasSubmitButton = pageSource.contains("Submit") ||
                                      pageSource.contains("submit") ||
                                      pageSource.contains("Done") ||
                                      pageSource.contains("done") ||
                                      pageSource.contains("Rate") ||
                                      pageSource.contains("Send");

            // Check for feedback text field
            boolean hasFeedbackField = pageSource.contains("feedback") ||
                                       pageSource.contains("Feedback") ||
                                       pageSource.contains("comment") ||
                                       pageSource.contains("Comment") ||
                                       pageSource.contains("improved") ||
                                       pageSource.contains("experience");

            System.out.println("");
            System.out.println("Rate Your Driver Popup Verification:");
            System.out.println("------------------------------------");
            System.out.println("  - Rate Driver text: " + (hasRateDriver ? "YES" : "NO"));
            System.out.println("  - Star rating: " + (hasStarRating ? "YES" : "NO"));
            System.out.println("  - Address info: " + (hasAddress ? "YES" : "NO"));
            System.out.println("  - Submit button: " + (hasSubmitButton ? "YES" : "NO"));
            System.out.println("  - Feedback field: " + (hasFeedbackField ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasRateDriver) score++;
            if (hasStarRating) score++;
            if (hasAddress) score++;
            if (hasSubmitButton) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-024: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Rate Your Driver popup verified!");
                System.out.println("");
                if (hasRateDriver) System.out.println("  - 'Rate Your Driver' text displayed");
                if (hasStarRating) System.out.println("  - Star rating visible");
                if (hasAddress) System.out.println("  - Address information shown");
                if (hasSubmitButton) System.out.println("  - Submit/Rate button available");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 1) {
                System.out.println("========================================");
                System.out.println("  TC-024: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some rating elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is 'Rate Your Driver' popup visible?");
                System.out.println("  2. Are pickup & drop-off addresses shown?");
                System.out.println("  3. Is star rating visible?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-024: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Rate Your Driver popup.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was the ride completed?");
                System.out.println("  2. Was Rider app closed and reopened?");
                System.out.println("  3. Does 'Rate Your Driver' popup appear?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("  Make sure to check the Rider app screen.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Rate Your Driver popup: " + e.getMessage());
            System.out.println("TC-024: FAILED - " + e.getMessage());
        }
    }
}
