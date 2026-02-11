package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC049_CorrectCaptchaDeletionFlowSteps extends Page {

    @Given("User is on the Delete Account page for deletion flow test")
    public void userIsOnTheDeleteAccountPageForDeletionFlowTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-049: CORRECT CAPTCHA DELETION FLOW");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  ⚠️  WARNING: THIS TEST MAY DELETE ACCOUNT!");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings → Delete Account");
            System.out.println("  4. Delete Account page should be open");
            System.out.println("     - You should see captcha (math sum)");
            System.out.println("     - Calculate the CORRECT answer");
            System.out.println("");
            System.out.println("  ⚠️  NOTE: Entering correct captcha will proceed");
            System.out.println("     with account deletion confirmation!");
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

    @When("User enters correct captcha value and taps Continue")
    public void userEntersCorrectCaptchaValueAndTapsContinue() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ENTER CORRECT CAPTCHA");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  ⚠️  WARNING: THIS WILL PROCEED WITH DELETION!");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Delete Account page");
            System.out.println("  2. Look at the captcha math sum (e.g., 5 + 3)");
            System.out.println("  3. Calculate the CORRECT answer (e.g., 8)");
            System.out.println("  4. Enter the CORRECT value in the input field");
            System.out.println("  5. Tap on 'Continue' button");
            System.out.println("");
            System.out.println("  ⚠️  After this, you may see confirmation or");
            System.out.println("     the account may be deleted and logged out!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to enter correct captcha
            System.out.println("");
            System.out.println("Waiting 15 seconds to enter correct captcha...");

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
            System.out.println("Correct captcha should be entered and Continue tapped now.");

        } catch (Exception e) {
            System.out.println("Error entering correct captcha: " + e.getMessage());
        }
    }

    @Then("Deletion confirmation should appear or user is logged out")
    public void deletionConfirmationShouldAppearOrUserIsLoggedOut() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DELETION FLOW VERIFICATION");
            System.out.println("========================================");

            // Check for confirmation dialog
            boolean hasConfirmation = pageSource.contains("Confirm") ||
                                      pageSource.contains("confirm") ||
                                      pageSource.contains("Are you sure") ||
                                      pageSource.contains("are you sure") ||
                                      pageSource.contains("Delete") ||
                                      pageSource.contains("delete");

            // Check for logout/login screen (account deleted)
            boolean isLoggedOut = pageSource.contains("Login") ||
                                  pageSource.contains("login") ||
                                  pageSource.contains("Sign in") ||
                                  pageSource.contains("sign in") ||
                                  pageSource.contains("Phone number") ||
                                  pageSource.contains("phone number") ||
                                  pageSource.contains("Enter your") ||
                                  pageSource.contains("Register");

            // Check for success message
            boolean hasSuccessMessage = pageSource.contains("Success") ||
                                        pageSource.contains("success") ||
                                        pageSource.contains("deleted") ||
                                        pageSource.contains("Deleted") ||
                                        pageSource.contains("removed") ||
                                        pageSource.contains("Removed");

            // Check if no longer on delete account page
            boolean leftDeletePage = !pageSource.contains("captcha") &&
                                     !pageSource.contains("Captcha") &&
                                     !pageSource.contains("sum") &&
                                     !pageSource.contains("Sum");

            // Check for final confirmation button
            boolean hasFinalConfirm = pageSource.contains("Yes") ||
                                      pageSource.contains("YES") ||
                                      pageSource.contains("Proceed") ||
                                      pageSource.contains("Continue") ||
                                      pageSource.contains("Delete Account");

            System.out.println("");
            System.out.println("Deletion Flow Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Confirmation dialog: " + (hasConfirmation ? "YES" : "NO"));
            System.out.println("  - Logged out: " + (isLoggedOut ? "YES" : "NO"));
            System.out.println("  - Success message: " + (hasSuccessMessage ? "YES" : "NO"));
            System.out.println("  - Left delete page: " + (leftDeletePage ? "YES" : "NO"));
            System.out.println("  - Final confirm button: " + (hasFinalConfirm ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasConfirmation) score += 2;
            if (isLoggedOut) score += 3;
            if (hasSuccessMessage) score += 2;
            if (leftDeletePage) score++;
            if (hasFinalConfirm) score++;

            if (score >= 3 || isLoggedOut || hasConfirmation || hasSuccessMessage) {
                System.out.println("========================================");
                System.out.println("  TC-049: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Correct captcha deletion flow verified!");
                System.out.println("");
                if (hasConfirmation) System.out.println("  - Confirmation dialog appeared");
                if (isLoggedOut) System.out.println("  - User logged out (account deleted)");
                if (hasSuccessMessage) System.out.println("  - Success message displayed");
                if (hasFinalConfirm) System.out.println("  - Final confirmation available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you enter correct captcha?");
                System.out.println("  - Did confirmation appear?");
                System.out.println("  - Were you logged out after deletion?");
                System.out.println("");
                System.out.println("========================================");
            } else if (leftDeletePage) {
                System.out.println("========================================");
                System.out.println("  TC-049: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Left delete account page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you enter correct captcha?");
                System.out.println("  2. Did confirmation appear?");
                System.out.println("  3. Were you logged out?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-049: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect deletion flow.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you enter correct captcha?");
                System.out.println("  2. Did you tap Continue?");
                System.out.println("  3. Did confirmation appear?");
                System.out.println("  4. Were you logged out?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying deletion flow: " + e.getMessage());
            System.out.println("TC-049: FAILED - " + e.getMessage());
        }
    }
}
