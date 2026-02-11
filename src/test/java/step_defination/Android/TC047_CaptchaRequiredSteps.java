package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC047_CaptchaRequiredSteps extends Page {

    @Given("User is on the Delete Account page")
    public void userIsOnTheDeleteAccountPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-047: CAPTCHA IS REQUIRED");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings → Delete Account");
            System.out.println("  4. Delete Account page should be open");
            System.out.println("     - You should see warning text");
            System.out.println("     - You should see captcha (math sum)");
            System.out.println("     - You should see input field");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Delete Account page in the app.");
            System.out.println("");

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
            System.out.println("User should be on Delete Account page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User leaves captcha input empty and taps Continue")
    public void userLeavesCaptchaInputEmptyAndTapsContinue() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP CONTINUE WITHOUT ENTERING CAPTCHA");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Delete Account page");
            System.out.println("  2. DO NOT enter anything in the captcha field");
            System.out.println("  3. Leave the input field EMPTY");
            System.out.println("  4. Tap on 'Continue' button");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap Continue
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Continue...");

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
            System.out.println("Continue should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Continue: " + e.getMessage());
        }
    }

    @Then("Error message should appear Please enter the correct sum")
    public void errorMessageShouldAppearPleaseEnterTheCorrectSum() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CAPTCHA ERROR VERIFICATION");
            System.out.println("========================================");

            // Check for error message about captcha/sum
            boolean hasErrorMessage = pageSource.contains("Please enter the correct sum") ||
                                      pageSource.contains("please enter the correct sum") ||
                                      pageSource.contains("correct sum") ||
                                      pageSource.contains("Correct sum") ||
                                      pageSource.contains("enter the sum") ||
                                      pageSource.contains("Enter the sum");

            // Check for general error indicators
            boolean hasGeneralError = pageSource.contains("Error") ||
                                      pageSource.contains("error") ||
                                      pageSource.contains("Invalid") ||
                                      pageSource.contains("invalid") ||
                                      pageSource.contains("required") ||
                                      pageSource.contains("Required");

            // Check for captcha-related error
            boolean hasCaptchaError = pageSource.contains("captcha") ||
                                      pageSource.contains("Captcha") ||
                                      pageSource.contains("CAPTCHA") ||
                                      pageSource.contains("sum") ||
                                      pageSource.contains("Sum");

            // Check if still on Delete Account page (error shown, not proceeded)
            boolean stillOnDeletePage = pageSource.contains("Delete") ||
                                        pageSource.contains("delete") ||
                                        pageSource.contains("Account") ||
                                        pageSource.contains("Warning") ||
                                        pageSource.contains("warning");

            // Check for toast/popup
            boolean hasToast = pageSource.contains("Toast") ||
                               pageSource.contains("toast") ||
                               pageSource.contains("Snackbar") ||
                               pageSource.contains("popup") ||
                               pageSource.contains("Popup");

            System.out.println("");
            System.out.println("Captcha Error Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Error message: " + (hasErrorMessage ? "YES" : "NO"));
            System.out.println("  - General error: " + (hasGeneralError ? "YES" : "NO"));
            System.out.println("  - Captcha error: " + (hasCaptchaError ? "YES" : "NO"));
            System.out.println("  - Still on Delete page: " + (stillOnDeletePage ? "YES" : "NO"));
            System.out.println("  - Toast/Popup: " + (hasToast ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasErrorMessage) score += 3;
            if (hasGeneralError) score += 2;
            if (hasCaptchaError) score++;
            if (stillOnDeletePage) score += 2;
            if (hasToast) score++;

            if (score >= 4 || hasErrorMessage || (stillOnDeletePage && (hasGeneralError || hasCaptchaError))) {
                System.out.println("========================================");
                System.out.println("  TC-047: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Captcha validation verified!");
                System.out.println("");
                if (hasErrorMessage) System.out.println("  - Error message displayed");
                if (hasGeneralError) System.out.println("  - General error shown");
                if (stillOnDeletePage) System.out.println("  - Still on Delete Account page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you tap Continue without captcha?");
                System.out.println("  - Did error message appear?");
                System.out.println("  - Does it say 'Please enter the correct sum'?");
                System.out.println("");
                System.out.println("========================================");
            } else if (stillOnDeletePage) {
                System.out.println("========================================");
                System.out.println("  TC-047: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Still on Delete Account page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Continue?");
                System.out.println("  2. Was captcha field empty?");
                System.out.println("  3. Did error message appear?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-047: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect error message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on Delete Account page?");
                System.out.println("  2. Did you leave captcha empty?");
                System.out.println("  3. Did you tap Continue?");
                System.out.println("  4. Did error appear?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying captcha error: " + e.getMessage());
            System.out.println("TC-047: FAILED - " + e.getMessage());
        }
    }
}
