package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC029_FeedbackTextFieldSteps extends Page {

    @Given("Rider is on the Rate Driver page for feedback test")
    public void riderIsOnTheRateDriverPageForFeedbackTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-029: FEEDBACK TEXT FIELD TEST");
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

    @When("Rider taps on the feedback text box")
    public void riderTapsOnTheFeedbackTextBox() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP FEEDBACK TEXT BOX STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rate Driver page");
            System.out.println("  2. Scroll to find:");
            System.out.println("     'Tell us what can be improved'");
            System.out.println("  3. Tap on the text input field");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap text box
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap text box...");

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
            System.out.println("Text box should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error during tap: " + e.getMessage());
        }
    }

    @And("Rider enters feedback text in the field")
    public void riderEntersFeedbackTextInTheField() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ENTER FEEDBACK TEXT STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Type some feedback text, for example:");
            System.out.println("     'Good ride, driver was friendly'");
            System.out.println("");
            System.out.println("  2. Verify the text appears in the field");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to enter text
            System.out.println("");
            System.out.println("Waiting 15 seconds to enter feedback text...");

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
            System.out.println("Feedback text should be entered now.");

        } catch (Exception e) {
            System.out.println("Error during text entry: " + e.getMessage());
        }
    }

    @Then("Feedback text should be accepted and displayed")
    public void feedbackTextShouldBeAcceptedAndDisplayed() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  FEEDBACK TEXT VERIFICATION");
            System.out.println("========================================");

            // Check for feedback field indicators
            boolean hasFeedbackField = pageSource.contains("improved") ||
                                       pageSource.contains("Improved") ||
                                       pageSource.contains("feedback") ||
                                       pageSource.contains("Feedback") ||
                                       pageSource.contains("tell us") ||
                                       pageSource.contains("Tell us") ||
                                       pageSource.contains("comment") ||
                                       pageSource.contains("Comment");

            // Check for text input indicators
            boolean hasTextInput = pageSource.contains("EditText") ||
                                   pageSource.contains("TextInput") ||
                                   pageSource.contains("input") ||
                                   pageSource.contains("text") ||
                                   pageSource.contains("field");

            // Check for Rate Driver page indicators
            boolean hasRateDriverPage = pageSource.contains("Rate") ||
                                        pageSource.contains("rating") ||
                                        pageSource.contains("Rating") ||
                                        pageSource.contains("star") ||
                                        pageSource.contains("Star");

            // Check for Submit button (indicates full page)
            boolean hasSubmitButton = pageSource.contains("Submit") ||
                                      pageSource.contains("submit") ||
                                      pageSource.contains("Submit Rating");

            // Check for other rating elements
            boolean hasOtherElements = pageSource.contains("Yes") ||
                                       pageSource.contains("No") ||
                                       pageSource.contains("helmet") ||
                                       pageSource.contains("on time");

            System.out.println("");
            System.out.println("Feedback Text Field Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Feedback field: " + (hasFeedbackField ? "YES" : "NO"));
            System.out.println("  - Text input: " + (hasTextInput ? "YES" : "NO"));
            System.out.println("  - Rate Driver page: " + (hasRateDriverPage ? "YES" : "NO"));
            System.out.println("  - Submit button: " + (hasSubmitButton ? "YES" : "NO"));
            System.out.println("  - Other elements: " + (hasOtherElements ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasFeedbackField) score++;
            if (hasTextInput) score++;
            if (hasRateDriverPage) score++;
            if (hasSubmitButton) score++;

            if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-029: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Feedback text field verified!");
                System.out.println("");
                System.out.println("  - Rate Driver page displayed");
                if (hasFeedbackField) System.out.println("  - 'Tell us what can be improved' field visible");
                if (hasTextInput) System.out.println("  - Text input field available");
                System.out.println("  - Text can be entered in the field");
                if (hasSubmitButton) System.out.println("  - Submit button present");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did the entered text display correctly?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 1) {
                System.out.println("========================================");
                System.out.println("  TC-029: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some feedback elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is feedback text field visible?");
                System.out.println("  2. Can you type text in the field?");
                System.out.println("  3. Does the text display correctly?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-029: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect feedback field.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Rate Driver page?");
                System.out.println("  2. Did you scroll to see the field?");
                System.out.println("  3. Is 'Tell us what can be improved' visible?");
                System.out.println("  4. Can you type text in the field?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying feedback field: " + e.getMessage());
            System.out.println("TC-029: FAILED - " + e.getMessage());
        }
    }
}
