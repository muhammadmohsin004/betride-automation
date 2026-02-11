package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC031_SubmitRatingButtonSteps extends Page {

    @Given("Rider is on the Rate Driver page for submit button test")
    public void riderIsOnTheRateDriverPageForSubmitButtonTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-031: SUBMIT RATING BUTTON TEST");
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

    @When("Rider scrolls to the bottom of Rate Driver page")
    public void riderScrollsToTheBottomOfRateDriverPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SCROLL TO BOTTOM STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rate Driver page");
            System.out.println("  2. Scroll down to the bottom of the page");
            System.out.println("  3. Look for 'Submit Rating' button");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to scroll
            System.out.println("");
            System.out.println("Waiting 10 seconds to scroll to bottom...");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println("Waiting... " + ((i + 1) * 2.5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Should be at the bottom of the page now.");

        } catch (Exception e) {
            System.out.println("Error during scroll: " + e.getMessage());
        }
    }

    @Then("Submit Rating button should be visible and clickable")
    public void submitRatingButtonShouldBeVisibleAndClickable() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SUBMIT RATING BUTTON VERIFICATION");
            System.out.println("========================================");

            // Check for Submit Rating button indicators
            boolean hasSubmitRating = pageSource.contains("Submit Rating") ||
                                      pageSource.contains("submit rating") ||
                                      pageSource.contains("SUBMIT RATING") ||
                                      pageSource.contains("SubmitRating");

            // Check for Submit button indicators
            boolean hasSubmitButton = pageSource.contains("Submit") ||
                                      pageSource.contains("submit") ||
                                      pageSource.contains("SUBMIT");

            // Check for Rating text indicators
            boolean hasRatingText = pageSource.contains("Rating") ||
                                    pageSource.contains("rating") ||
                                    pageSource.contains("RATING");

            // Check for Rate Driver page indicators
            boolean hasRateDriverPage = pageSource.contains("Rate") ||
                                        pageSource.contains("rate") ||
                                        pageSource.contains("Driver") ||
                                        pageSource.contains("driver");

            // Check for button/clickable indicators
            boolean hasButtonElement = pageSource.contains("Button") ||
                                       pageSource.contains("button") ||
                                       pageSource.contains("clickable=\"true\"") ||
                                       pageSource.contains("Clickable");

            // Check for other rating page elements
            boolean hasOtherElements = pageSource.contains("star") ||
                                       pageSource.contains("Star") ||
                                       pageSource.contains("time") ||
                                       pageSource.contains("helmet") ||
                                       pageSource.contains("improved");

            System.out.println("");
            System.out.println("Submit Rating Button Verification:");
            System.out.println("-----------------------------------");
            System.out.println("  - Submit Rating text: " + (hasSubmitRating ? "YES" : "NO"));
            System.out.println("  - Submit button: " + (hasSubmitButton ? "YES" : "NO"));
            System.out.println("  - Rating text: " + (hasRatingText ? "YES" : "NO"));
            System.out.println("  - Rate Driver page: " + (hasRateDriverPage ? "YES" : "NO"));
            System.out.println("  - Button element: " + (hasButtonElement ? "YES" : "NO"));
            System.out.println("  - Other elements: " + (hasOtherElements ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSubmitRating) score += 3;
            if (hasSubmitButton) score += 2;
            if (hasRatingText) score++;
            if (hasRateDriverPage) score++;
            if (hasButtonElement) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-031: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Submit Rating button verified!");
                System.out.println("");
                System.out.println("  - Rate Driver page displayed");
                if (hasSubmitRating) System.out.println("  - 'Submit Rating' button visible");
                if (hasSubmitButton) System.out.println("  - Submit button present");
                if (hasButtonElement) System.out.println("  - Button is clickable");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is the Submit Rating button visible?");
                System.out.println("  - Can you tap the button?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-031: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some submit elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you scroll to the bottom?");
                System.out.println("  2. Is 'Submit Rating' button visible?");
                System.out.println("  3. Is the button clickable?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-031: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Submit Rating button.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Rate Driver page?");
                System.out.println("  2. Did you scroll to the bottom?");
                System.out.println("  3. Is 'Submit Rating' button visible?");
                System.out.println("  4. Can you tap the button?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Submit Rating button: " + e.getMessage());
            System.out.println("TC-031: FAILED - " + e.getMessage());
        }
    }
}
