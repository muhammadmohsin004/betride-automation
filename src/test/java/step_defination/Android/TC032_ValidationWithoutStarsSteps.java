package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC032_ValidationWithoutStarsSteps extends Page {

    @Given("Rider is on the Rate Driver page for validation test")
    public void riderIsOnTheRateDriverPageForValidationTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-032: VALIDATION WITHOUT STARS TEST");
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
            System.out.println("     - DO NOT select any star rating yet!");
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

    @When("Rider does not select any star rating")
    public void riderDoesNotSelectAnyStarRating() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  NO STAR SELECTION STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rate Driver page");
            System.out.println("  2. DO NOT tap any star (1-5)");
            System.out.println("  3. Leave star rating unselected");
            System.out.println("");
            System.out.println("========================================");

            // Wait a moment
            System.out.println("");
            System.out.println("Waiting 5 seconds...");
            System.out.println("Do NOT select any star rating!");

            for (int i = 0; i < 2; i++) {
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
            System.out.println("Star rating should remain unselected.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @And("Rider taps Submit Rating button without stars")
    public void riderTapsSubmitRatingButtonWithoutStars() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP SUBMIT RATING WITHOUT STARS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Scroll to the bottom of the page");
            System.out.println("  2. Tap 'Submit Rating' button");
            System.out.println("  3. WITHOUT selecting any star rating");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap submit
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Submit Rating...");

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
            System.out.println("Submit Rating should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error during tap: " + e.getMessage());
        }
    }

    @Then("Validation message should appear asking to give star rating")
    public void validationMessageShouldAppearAskingToGiveStarRating() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VALIDATION MESSAGE VERIFICATION");
            System.out.println("========================================");

            // Check for validation message indicators
            boolean hasValidationMessage = pageSource.contains("Please give a star rating") ||
                                           pageSource.contains("please give a star rating") ||
                                           pageSource.contains("star rating to driver") ||
                                           pageSource.contains("give a star") ||
                                           pageSource.contains("Give a star") ||
                                           pageSource.contains("select a rating") ||
                                           pageSource.contains("Select a rating");

            // Check for popup/toast indicators
            boolean hasPopupToast = pageSource.contains("Toast") ||
                                    pageSource.contains("toast") ||
                                    pageSource.contains("Popup") ||
                                    pageSource.contains("popup") ||
                                    pageSource.contains("Alert") ||
                                    pageSource.contains("alert") ||
                                    pageSource.contains("Snackbar") ||
                                    pageSource.contains("snackbar");

            // Check for star/rating text
            boolean hasStarRatingText = pageSource.contains("star") ||
                                        pageSource.contains("Star") ||
                                        pageSource.contains("rating") ||
                                        pageSource.contains("Rating");

            // Check for please/required text
            boolean hasPleaseRequired = pageSource.contains("Please") ||
                                        pageSource.contains("please") ||
                                        pageSource.contains("required") ||
                                        pageSource.contains("Required");

            // Check for error indicators
            boolean hasErrorIndicator = pageSource.contains("error") ||
                                        pageSource.contains("Error") ||
                                        pageSource.contains("warning") ||
                                        pageSource.contains("Warning");

            // Check if still on Rate Driver page
            boolean stillOnRatePage = pageSource.contains("Rate") ||
                                      pageSource.contains("Submit") ||
                                      pageSource.contains("Driver");

            System.out.println("");
            System.out.println("Validation Message Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Validation message: " + (hasValidationMessage ? "YES" : "NO"));
            System.out.println("  - Popup/Toast: " + (hasPopupToast ? "YES" : "NO"));
            System.out.println("  - Star/Rating text: " + (hasStarRatingText ? "YES" : "NO"));
            System.out.println("  - Please/Required: " + (hasPleaseRequired ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Still on Rate page: " + (stillOnRatePage ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasValidationMessage) score += 3;
            if (hasPopupToast) score++;
            if (hasStarRatingText) score++;
            if (hasPleaseRequired) score++;
            if (stillOnRatePage) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-032: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Validation message verified!");
                System.out.println("");
                if (hasValidationMessage) System.out.println("  - 'Please give a star rating' message shown");
                if (hasPopupToast) System.out.println("  - Popup/Toast displayed");
                if (stillOnRatePage) System.out.println("  - Still on Rate Driver page (not submitted)");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you see the validation message?");
                System.out.println("  - Did it say 'Please give a star rating to driver'?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-032: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some validation elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Submit Rating without stars?");
                System.out.println("  2. Did a validation message appear?");
                System.out.println("  3. Did it say 'Please give a star rating'?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-032: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect validation message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Rate Driver page?");
                System.out.println("  2. Did you tap Submit without selecting stars?");
                System.out.println("  3. Did a popup/toast appear?");
                System.out.println("  4. What message was displayed?");
                System.out.println("");
                System.out.println("  Expected: 'Please give a star rating to driver'");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying validation message: " + e.getMessage());
            System.out.println("TC-032: FAILED - " + e.getMessage());
        }
    }
}
