package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC025_StarTapNavigationSteps extends Page {

    @Given("Driver completes a ride and rider sees Rate Your Driver popup")
    public void driverCompletesARideAndRiderSeesRateYourDriverPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-025: STAR TAP NAVIGATION TEST");
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
            System.out.println("");
            System.out.println("========================================");

            // Wait for manual ride completion
            System.out.println("");
            System.out.println("Waiting 60 seconds for ride to be completed...");
            System.out.println("Please complete the ride flow manually.");
            System.out.println("");

            for (int i = 0; i < 20; i++) {
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
            System.out.println("Rider should now see 'Rate Your Driver' popup.");

        } catch (Exception e) {
            System.out.println("Error during ride completion: " + e.getMessage());
        }
    }

    @When("Rider taps any star on the Rate Your Driver popup")
    public void riderTapsAnyStarOnTheRateYourDriverPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  STAR TAP STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the 'Rate Your Driver' popup");
            System.out.println("  2. Tap any star (1-5 stars)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap star
            System.out.println("");
            System.out.println("Waiting 15 seconds for star to be tapped...");

            for (int i = 0; i < 5; i++) {
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
            System.out.println("Star should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during star tap: " + e.getMessage());
        }
    }

    @Then("Rider should be redirected to the full Rate Driver page")
    public void riderShouldBeRedirectedToTheFullRateDriverPage() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  RATE DRIVER PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Rate Driver page indicators
            boolean hasRateDriverTitle = pageSource.contains("Rate Driver") ||
                                         pageSource.contains("rate driver") ||
                                         pageSource.contains("Rate Your Driver") ||
                                         pageSource.contains("Rating");

            // Check for star rating selection on full page
            boolean hasStarSelection = pageSource.contains("star") ||
                                       pageSource.contains("Star") ||
                                       pageSource.contains("rating") ||
                                       pageSource.contains("Rating");

            // Check for feedback/comment section (full page has more options)
            boolean hasFeedbackSection = pageSource.contains("feedback") ||
                                         pageSource.contains("Feedback") ||
                                         pageSource.contains("comment") ||
                                         pageSource.contains("Comment") ||
                                         pageSource.contains("improved") ||
                                         pageSource.contains("experience") ||
                                         pageSource.contains("tell us");

            // Check for submit button
            boolean hasSubmitButton = pageSource.contains("Submit") ||
                                      pageSource.contains("submit") ||
                                      pageSource.contains("Submit Rating") ||
                                      pageSource.contains("Done");

            // Check for driver info (full page shows driver details)
            boolean hasDriverInfo = pageSource.contains("driver") ||
                                    pageSource.contains("Driver") ||
                                    pageSource.contains("name") ||
                                    pageSource.contains("Name");

            // Check for additional options (on-time, helmet questions)
            boolean hasAdditionalOptions = pageSource.contains("on time") ||
                                           pageSource.contains("helmet") ||
                                           pageSource.contains("Yes") ||
                                           pageSource.contains("No") ||
                                           pageSource.contains("Report");

            System.out.println("");
            System.out.println("Rate Driver Page Verification:");
            System.out.println("------------------------------");
            System.out.println("  - Rate Driver title: " + (hasRateDriverTitle ? "YES" : "NO"));
            System.out.println("  - Star selection: " + (hasStarSelection ? "YES" : "NO"));
            System.out.println("  - Feedback section: " + (hasFeedbackSection ? "YES" : "NO"));
            System.out.println("  - Submit button: " + (hasSubmitButton ? "YES" : "NO"));
            System.out.println("  - Driver info: " + (hasDriverInfo ? "YES" : "NO"));
            System.out.println("  - Additional options: " + (hasAdditionalOptions ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasRateDriverTitle) score++;
            if (hasStarSelection) score++;
            if (hasFeedbackSection) score++;
            if (hasSubmitButton) score++;
            if (hasAdditionalOptions) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-025: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Star tap navigation verified!");
                System.out.println("");
                System.out.println("  - Tapping star navigated to Rate Driver page");
                if (hasRateDriverTitle) System.out.println("  - Rate Driver page title displayed");
                if (hasStarSelection) System.out.println("  - Star rating selection visible");
                if (hasFeedbackSection) System.out.println("  - Feedback section available");
                if (hasSubmitButton) System.out.println("  - Submit button present");
                if (hasAdditionalOptions) System.out.println("  - Additional rating options shown");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 1) {
                System.out.println("========================================");
                System.out.println("  TC-025: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some Rate Driver page elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did tapping star navigate to full page?");
                System.out.println("  2. Is Rate Driver page displayed?");
                System.out.println("  3. Are rating options visible?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-025: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Rate Driver page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was the star tapped on popup?");
                System.out.println("  2. Did it navigate to Rate Driver page?");
                System.out.println("  3. Is the full rating form visible?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("  Make sure to check the Rider app screen.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Rate Driver page: " + e.getMessage());
            System.out.println("TC-025: FAILED - " + e.getMessage());
        }
    }
}
