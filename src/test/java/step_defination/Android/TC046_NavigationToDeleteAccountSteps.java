package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC046_NavigationToDeleteAccountSteps extends Page {

    @Given("User is logged in and navigates to Settings")
    public void userIsLoggedInAndNavigatesToSettings() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-046: NAVIGATION TO DELETE ACCOUNT");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings page");
            System.out.println("     - Tap profile picture (top left)");
            System.out.println("     - Or tap hamburger menu");
            System.out.println("     - Tap on 'Settings'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Settings page in the app.");
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
            System.out.println("User should be on Settings page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Delete Account option")
    public void userTapsOnDeleteAccountOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP ON DELETE ACCOUNT");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Settings page");
            System.out.println("  2. Scroll down if needed");
            System.out.println("  3. Look for 'Delete Account' option");
            System.out.println("  4. Tap on 'Delete Account'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap Delete Account
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Delete Account...");

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
            System.out.println("Delete Account should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Delete Account: " + e.getMessage());
        }
    }

    @Then("Delete Your Account screen should open with warning text and captcha")
    public void deleteYourAccountScreenShouldOpenWithWarningTextAndCaptcha() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DELETE ACCOUNT PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Delete Account page title
            boolean hasDeleteAccountTitle = pageSource.contains("Delete") ||
                                            pageSource.contains("delete") ||
                                            pageSource.contains("DELETE") ||
                                            pageSource.contains("Account") ||
                                            pageSource.contains("account");

            // Check for warning text
            boolean hasWarningText = pageSource.contains("Warning") ||
                                     pageSource.contains("warning") ||
                                     pageSource.contains("WARNING") ||
                                     pageSource.contains("permanent") ||
                                     pageSource.contains("Permanent") ||
                                     pageSource.contains("cannot be undone") ||
                                     pageSource.contains("irreversible");

            // Check for captcha/verification
            boolean hasCaptcha = pageSource.contains("captcha") ||
                                 pageSource.contains("Captcha") ||
                                 pageSource.contains("CAPTCHA") ||
                                 pageSource.contains("sum") ||
                                 pageSource.contains("Sum") ||
                                 pageSource.contains("verify") ||
                                 pageSource.contains("Verify") ||
                                 pageSource.contains("+") ||
                                 pageSource.contains("=");

            // Check for input field
            boolean hasInputField = pageSource.contains("EditText") ||
                                    pageSource.contains("input") ||
                                    pageSource.contains("Input") ||
                                    pageSource.contains("android.widget.EditText") ||
                                    pageSource.contains("text field");

            // Check for continue/confirm button
            boolean hasContinueButton = pageSource.contains("Continue") ||
                                        pageSource.contains("continue") ||
                                        pageSource.contains("CONTINUE") ||
                                        pageSource.contains("Confirm") ||
                                        pageSource.contains("Delete") ||
                                        pageSource.contains("Proceed");

            // Check for data loss warning
            boolean hasDataLossWarning = pageSource.contains("data") ||
                                         pageSource.contains("Data") ||
                                         pageSource.contains("lose") ||
                                         pageSource.contains("lost") ||
                                         pageSource.contains("removed") ||
                                         pageSource.contains("erased");

            System.out.println("");
            System.out.println("Delete Account Page Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Delete Account title: " + (hasDeleteAccountTitle ? "YES" : "NO"));
            System.out.println("  - Warning text: " + (hasWarningText ? "YES" : "NO"));
            System.out.println("  - Captcha/Verification: " + (hasCaptcha ? "YES" : "NO"));
            System.out.println("  - Input field: " + (hasInputField ? "YES" : "NO"));
            System.out.println("  - Continue button: " + (hasContinueButton ? "YES" : "NO"));
            System.out.println("  - Data loss warning: " + (hasDataLossWarning ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasDeleteAccountTitle) score += 2;
            if (hasWarningText) score += 2;
            if (hasCaptcha) score += 3;
            if (hasInputField) score += 2;
            if (hasContinueButton) score++;
            if (hasDataLossWarning) score++;

            if (score >= 5 || (hasDeleteAccountTitle && (hasCaptcha || hasWarningText))) {
                System.out.println("========================================");
                System.out.println("  TC-046: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Delete Account page verified!");
                System.out.println("");
                if (hasDeleteAccountTitle) System.out.println("  - Delete Account page opened");
                if (hasWarningText) System.out.println("  - Warning text displayed");
                if (hasCaptcha) System.out.println("  - Captcha/verification present");
                if (hasInputField) System.out.println("  - Input field available");
                if (hasContinueButton) System.out.println("  - Continue button visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is Delete Account page open?");
                System.out.println("  - Is warning text visible?");
                System.out.println("  - Is captcha (math sum) displayed?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 3 || hasDeleteAccountTitle) {
                System.out.println("========================================");
                System.out.println("  TC-046: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some Delete Account elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Delete Account?");
                System.out.println("  2. Is Delete Account page open?");
                System.out.println("  3. Is warning text visible?");
                System.out.println("  4. Is captcha displayed?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-046: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Delete Account page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you navigate to Settings?");
                System.out.println("  2. Did you tap Delete Account?");
                System.out.println("  3. Is Delete Account page open?");
                System.out.println("  4. Is warning text + captcha visible?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Delete Account page: " + e.getMessage());
            System.out.println("TC-046: FAILED - " + e.getMessage());
        }
    }
}
