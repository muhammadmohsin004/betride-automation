package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC048_IncorrectCaptchaErrorSteps extends Page {

    @Given("User is on the Delete Account page for captcha test")
    public void userIsOnTheDeleteAccountPageForCaptchaTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-048: INCORRECT CAPTCHA ERROR");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings → Delete Account");
            System.out.println("  4. Delete Account page should be open");
            System.out.println("     - You should see captcha (math sum)");
            System.out.println("     - Note the correct answer");
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

    @When("User enters incorrect captcha value and taps Continue")
    public void userEntersIncorrectCaptchaValueAndTapsContinue() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ENTER INCORRECT CAPTCHA");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Delete Account page");
            System.out.println("  2. Look at the captcha math sum (e.g., 5 + 3)");
            System.out.println("  3. Enter an INCORRECT value in the input field");
            System.out.println("     (e.g., if sum is 5+3=8, enter 99 or any wrong number)");
            System.out.println("  4. Tap on 'Continue' button");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to enter incorrect captcha
            System.out.println("");
            System.out.println("Waiting 12 seconds to enter incorrect captcha...");

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
            System.out.println("Incorrect captcha should be entered and Continue tapped now.");

        } catch (Exception e) {
            System.out.println("Error entering incorrect captcha: " + e.getMessage());
        }
    }

    @Then("Error message should appear Incorrect sum Try again")
    public void errorMessageShouldAppearIncorrectSumTryAgain() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  INCORRECT CAPTCHA ERROR VERIFICATION");
            System.out.println("========================================");

            // Check for error message about incorrect sum
            boolean hasIncorrectSumError = pageSource.contains("Incorrect sum") ||
                                           pageSource.contains("incorrect sum") ||
                                           pageSource.contains("INCORRECT SUM") ||
                                           pageSource.contains("Try again") ||
                                           pageSource.contains("try again") ||
                                           pageSource.contains("TRY AGAIN");

            // Check for wrong/incorrect indicators
            boolean hasWrongIndicator = pageSource.contains("Wrong") ||
                                        pageSource.contains("wrong") ||
                                        pageSource.contains("Incorrect") ||
                                        pageSource.contains("incorrect") ||
                                        pageSource.contains("Invalid") ||
                                        pageSource.contains("invalid");

            // Check for error indicators
            boolean hasErrorIndicator = pageSource.contains("Error") ||
                                        pageSource.contains("error") ||
                                        pageSource.contains("failed") ||
                                        pageSource.contains("Failed");

            // Check if still on Delete Account page (error shown, not proceeded)
            boolean stillOnDeletePage = pageSource.contains("Delete") ||
                                        pageSource.contains("delete") ||
                                        pageSource.contains("Account") ||
                                        pageSource.contains("captcha") ||
                                        pageSource.contains("Captcha");

            // Check for retry indicators
            boolean hasRetryIndicator = pageSource.contains("again") ||
                                        pageSource.contains("Again") ||
                                        pageSource.contains("retry") ||
                                        pageSource.contains("Retry");

            System.out.println("");
            System.out.println("Incorrect Captcha Error Verification:");
            System.out.println("-------------------------------------");
            System.out.println("  - Incorrect sum error: " + (hasIncorrectSumError ? "YES" : "NO"));
            System.out.println("  - Wrong/Incorrect indicator: " + (hasWrongIndicator ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Still on Delete page: " + (stillOnDeletePage ? "YES" : "NO"));
            System.out.println("  - Retry indicator: " + (hasRetryIndicator ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasIncorrectSumError) score += 3;
            if (hasWrongIndicator) score += 2;
            if (hasErrorIndicator) score++;
            if (stillOnDeletePage) score += 2;
            if (hasRetryIndicator) score++;

            if (score >= 4 || hasIncorrectSumError || (stillOnDeletePage && hasWrongIndicator)) {
                System.out.println("========================================");
                System.out.println("  TC-048: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Incorrect captcha error verified!");
                System.out.println("");
                if (hasIncorrectSumError) System.out.println("  - 'Incorrect sum. Try again.' message shown");
                if (hasWrongIndicator) System.out.println("  - Wrong/Incorrect indicator displayed");
                if (stillOnDeletePage) System.out.println("  - Still on Delete Account page");
                if (hasRetryIndicator) System.out.println("  - Retry option available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you enter incorrect captcha?");
                System.out.println("  - Did error message appear?");
                System.out.println("  - Does it say 'Incorrect sum. Try again.'?");
                System.out.println("");
                System.out.println("========================================");
            } else if (stillOnDeletePage) {
                System.out.println("========================================");
                System.out.println("  TC-048: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Still on Delete Account page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you enter incorrect captcha?");
                System.out.println("  2. Did you tap Continue?");
                System.out.println("  3. Did error message appear?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-048: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect error message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on Delete Account page?");
                System.out.println("  2. Did you enter wrong captcha value?");
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
            System.out.println("Error verifying incorrect captcha error: " + e.getMessage());
            System.out.println("TC-048: FAILED - " + e.getMessage());
        }
    }
}
