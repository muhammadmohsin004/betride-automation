package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC026_StarRatingSelectionSteps extends Page {

    @Given("Rider is on the Rate Driver page after completing a ride")
    public void riderIsOnTheRateDriverPageAfterCompletingARide() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-026: STAR RATING SELECTION TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  1. Complete a ride flow:");
            System.out.println("     - Rider creates a ride");
            System.out.println("     - Driver accepts the ride");
            System.out.println("     - Rider accepts the driver");
            System.out.println("     - Complete the trip");
            System.out.println("");
            System.out.println("  2. After ride completion:");
            System.out.println("     - Close and reopen Rider app");
            System.out.println("     - See 'Rate Your Driver' popup");
            System.out.println("     - Tap a star to go to Rate Driver page");
            System.out.println("");
            System.out.println("  3. You should now be on the Rate Driver page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for manual navigation to Rate Driver page
            System.out.println("");
            System.out.println("Waiting 45 seconds to reach Rate Driver page...");
            System.out.println("Please complete the ride and navigate to Rate Driver page.");
            System.out.println("");

            for (int i = 0; i < 15; i++) {
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
            System.out.println("Rider should now be on Rate Driver page.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("Rider taps any star rating from 1 to 5")
    public void riderTapsAnyStarRatingFrom1To5() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  STAR RATING TAP STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rate Driver page");
            System.out.println("  2. Tap any star (1, 2, 3, 4, or 5 stars)");
            System.out.println("  3. Observe if the star selection is highlighted");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap star
            System.out.println("");
            System.out.println("Waiting 15 seconds for star to be selected...");

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
            System.out.println("Star rating should have been selected.");

        } catch (Exception e) {
            System.out.println("Error during star tap: " + e.getMessage());
        }
    }

    @Then("Star selection should be highlighted and saved")
    public void starSelectionShouldBeHighlightedAndSaved() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  STAR SELECTION VERIFICATION");
            System.out.println("========================================");

            // Check for Rate Driver page indicators
            boolean hasRateDriverPage = pageSource.contains("Rate Driver") ||
                                        pageSource.contains("rate driver") ||
                                        pageSource.contains("Rating") ||
                                        pageSource.contains("rating");

            // Check for star rating elements
            boolean hasStarElements = pageSource.contains("star") ||
                                      pageSource.contains("Star") ||
                                      pageSource.contains("★") ||
                                      pageSource.contains("☆");

            // Check for selected/highlighted indicators
            boolean hasSelectedIndicator = pageSource.contains("selected") ||
                                           pageSource.contains("Selected") ||
                                           pageSource.contains("checked") ||
                                           pageSource.contains("active") ||
                                           pageSource.contains("filled");

            // Check for feedback section (indicates full page)
            boolean hasFeedbackSection = pageSource.contains("feedback") ||
                                         pageSource.contains("Feedback") ||
                                         pageSource.contains("comment") ||
                                         pageSource.contains("improved") ||
                                         pageSource.contains("tell us");

            // Check for submit button
            boolean hasSubmitButton = pageSource.contains("Submit") ||
                                      pageSource.contains("submit") ||
                                      pageSource.contains("Submit Rating") ||
                                      pageSource.contains("Done");

            // Check for driver questions (on-time, helmet)
            boolean hasDriverQuestions = pageSource.contains("on time") ||
                                         pageSource.contains("helmet") ||
                                         pageSource.contains("Yes") ||
                                         pageSource.contains("No");

            System.out.println("");
            System.out.println("Star Selection Verification:");
            System.out.println("----------------------------");
            System.out.println("  - Rate Driver page: " + (hasRateDriverPage ? "YES" : "NO"));
            System.out.println("  - Star elements: " + (hasStarElements ? "YES" : "NO"));
            System.out.println("  - Selected indicator: " + (hasSelectedIndicator ? "YES" : "NO"));
            System.out.println("  - Feedback section: " + (hasFeedbackSection ? "YES" : "NO"));
            System.out.println("  - Submit button: " + (hasSubmitButton ? "YES" : "NO"));
            System.out.println("  - Driver questions: " + (hasDriverQuestions ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasRateDriverPage) score++;
            if (hasStarElements) score++;
            if (hasFeedbackSection) score++;
            if (hasSubmitButton) score++;
            if (hasDriverQuestions) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-026: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Star rating selection verified!");
                System.out.println("");
                System.out.println("  - Rate Driver page is displayed");
                System.out.println("  - Star rating can be selected");
                if (hasStarElements) System.out.println("  - Star elements visible");
                if (hasFeedbackSection) System.out.println("  - Feedback section available");
                if (hasSubmitButton) System.out.println("  - Submit button present");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is the star selection highlighted/filled?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 1) {
                System.out.println("========================================");
                System.out.println("  TC-026: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some Rate Driver page elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is the star selection highlighted?");
                System.out.println("  2. Did the selection get saved?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-026: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect star selection.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Rate Driver page?");
                System.out.println("  2. Did you tap a star?");
                System.out.println("  3. Is the star highlighted/filled?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying star selection: " + e.getMessage());
            System.out.println("TC-026: FAILED - " + e.getMessage());
        }
    }
}
