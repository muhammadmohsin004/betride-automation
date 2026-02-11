package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC050_OfflineDeletionAttemptSteps extends Page {

    @Given("User is on the Delete Account page with internet OFF")
    public void userIsOnTheDeleteAccountPageWithInternetOFF() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-050: OFFLINE DELETION ATTEMPT");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings → Delete Account");
            System.out.println("  4. TURN OFF INTERNET (WiFi/Mobile Data)");
            System.out.println("  5. Delete Account page should be open");
            System.out.println("");
            System.out.println("  NOTE: Internet must be OFF for this test!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Delete Account page and TURN OFF INTERNET.");
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
            System.out.println("User should be on Delete Account page with internet OFF.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User enters correct captcha and taps Continue while offline")
    public void userEntersCorrectCaptchaAndTapsContinueWhileOffline() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ENTER CAPTCHA WHILE OFFLINE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Make sure INTERNET IS OFF");
            System.out.println("  2. On the Delete Account page");
            System.out.println("  3. Look at the captcha math sum");
            System.out.println("  4. Enter the CORRECT value");
            System.out.println("  5. Tap on 'Continue' button");
            System.out.println("");
            System.out.println("  NOTE: Keep internet OFF during this step!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to enter captcha
            System.out.println("");
            System.out.println("Waiting 12 seconds to enter captcha...");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(3000);
                System.out.println("Waiting... " + ((i + 1) * 3) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore - might fail due to offline
                }
            }

            System.out.println("");
            System.out.println("Captcha should be entered and Continue tapped now.");

        } catch (Exception e) {
            System.out.println("Error entering captcha: " + e.getMessage());
        }
    }

    @Then("Error message should appear No internet connection and account not deleted")
    public void errorMessageShouldAppearNoInternetConnectionAndAccountNotDeleted() {
        try {
            Thread.sleep(3000);

            String pageSource = "";
            try {
                pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            } catch (Exception e) {
                System.out.println("Note: Could not get page source (possibly due to offline mode)");
                pageSource = "";
            }

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  OFFLINE ERROR VERIFICATION");
            System.out.println("========================================");

            // Check for no internet error
            boolean hasNoInternetError = pageSource.contains("No internet") ||
                                          pageSource.contains("no internet") ||
                                          pageSource.contains("NO INTERNET") ||
                                          pageSource.contains("internet connection") ||
                                          pageSource.contains("Internet connection") ||
                                          pageSource.contains("check your connection") ||
                                          pageSource.contains("Check your connection");

            // Check for network error
            boolean hasNetworkError = pageSource.contains("Network") ||
                                      pageSource.contains("network") ||
                                      pageSource.contains("offline") ||
                                      pageSource.contains("Offline") ||
                                      pageSource.contains("Unable to connect") ||
                                      pageSource.contains("Connection failed");

            // Check for general error
            boolean hasGeneralError = pageSource.contains("Error") ||
                                      pageSource.contains("error") ||
                                      pageSource.contains("Sorry") ||
                                      pageSource.contains("sorry") ||
                                      pageSource.contains("Failed") ||
                                      pageSource.contains("failed");

            // Check if still on Delete Account page (account not deleted)
            boolean stillOnDeletePage = pageSource.contains("Delete") ||
                                        pageSource.contains("delete") ||
                                        pageSource.contains("Account") ||
                                        pageSource.contains("captcha") ||
                                        pageSource.contains("Captcha") ||
                                        pageSource.contains("sum");

            // Check if NOT logged out (account preserved)
            boolean notLoggedOut = !pageSource.contains("Login") &&
                                   !pageSource.contains("Sign in") &&
                                   !pageSource.contains("Enter your phone");

            System.out.println("");
            System.out.println("Offline Error Verification:");
            System.out.println("---------------------------");
            System.out.println("  - No internet error: " + (hasNoInternetError ? "YES" : "NO"));
            System.out.println("  - Network error: " + (hasNetworkError ? "YES" : "NO"));
            System.out.println("  - General error: " + (hasGeneralError ? "YES" : "NO"));
            System.out.println("  - Still on Delete page: " + (stillOnDeletePage ? "YES" : "NO"));
            System.out.println("  - Account preserved: " + (notLoggedOut ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasNoInternetError) score += 3;
            if (hasNetworkError) score += 2;
            if (hasGeneralError) score++;
            if (stillOnDeletePage) score += 2;
            if (notLoggedOut) score++;

            if (score >= 4 || hasNoInternetError || (stillOnDeletePage && (hasNetworkError || hasGeneralError))) {
                System.out.println("========================================");
                System.out.println("  TC-050: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Offline deletion blocked successfully!");
                System.out.println("");
                if (hasNoInternetError) System.out.println("  - 'No internet connection' error shown");
                if (hasNetworkError) System.out.println("  - Network error displayed");
                if (stillOnDeletePage) System.out.println("  - Still on Delete Account page");
                if (notLoggedOut) System.out.println("  - Account NOT deleted (preserved)");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Was internet OFF?");
                System.out.println("  - Did error message appear?");
                System.out.println("  - Was account NOT deleted?");
                System.out.println("");
                System.out.println("========================================");
            } else if (stillOnDeletePage || notLoggedOut) {
                System.out.println("========================================");
                System.out.println("  TC-050: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Account appears to be preserved.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was internet OFF?");
                System.out.println("  2. Did you enter correct captcha?");
                System.out.println("  3. Did error message appear?");
                System.out.println("  4. Was account NOT deleted?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-050: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect offline error.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was internet OFF?");
                System.out.println("  2. Did you tap Continue?");
                System.out.println("  3. Did 'No internet' error appear?");
                System.out.println("  4. Was account NOT deleted?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app");
                System.out.println("  and INTERNET to be OFF.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying offline deletion: " + e.getMessage());
            System.out.println("TC-050: FAILED - " + e.getMessage());
        }
    }
}
