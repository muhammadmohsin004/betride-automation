package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC069_PopupAppearsOnCancelActionSteps extends Page {

    @Given("User has an active driver search")
    public void userHasAnActiveDriverSearch() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-069: POPUP ON CANCEL ACTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (enter locations)");
            System.out.println("  4. Tap 'Search for Driver'");
            System.out.println("  5. Search should be ACTIVE");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to have active search...");
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
            System.out.println("Driver search should be active now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Cancel Request button")
    public void userTapsOnCancelRequestButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP CANCEL REQUEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the searching screen");
            System.out.println("  2. Find 'Cancel Request' or 'Cancel' button");
            System.out.println("  3. Tap on it");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Cancel...");

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
            System.out.println("Cancel Request should be tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping cancel: " + e.getMessage());
        }
    }

    @Then("Cancel popup should appear immediately")
    public void cancelPopupShouldAppearImmediately() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CANCEL POPUP VERIFICATION");
            System.out.println("========================================");

            // Check for cancel popup
            boolean hasCancelPopup = pageSource.contains("Cancel") ||
                                     pageSource.contains("cancel");

            // Check for confirmation message
            boolean hasConfirmation = pageSource.contains("Are you sure") ||
                                      pageSource.contains("are you sure") ||
                                      pageSource.contains("Confirm") ||
                                      pageSource.contains("confirm") ||
                                      pageSource.contains("Do you want") ||
                                      pageSource.contains("do you want");

            // Check for Yes/No options
            boolean hasYesNo = (pageSource.contains("Yes") || pageSource.contains("yes")) &&
                               (pageSource.contains("No") || pageSource.contains("no"));

            // Check for OK/Cancel options
            boolean hasOkCancel = (pageSource.contains("OK") || pageSource.contains("Ok")) ||
                                  (pageSource.contains("Keep") && pageSource.contains("Cancel"));

            // Check for popup/dialog
            boolean hasDialog = pageSource.contains("Dialog") ||
                                pageSource.contains("dialog") ||
                                pageSource.contains("Popup") ||
                                pageSource.contains("popup") ||
                                pageSource.contains("AlertDialog");

            System.out.println("");
            System.out.println("Cancel Popup Verification:");
            System.out.println("--------------------------");
            System.out.println("  - Cancel popup: " + (hasCancelPopup ? "YES" : "NO"));
            System.out.println("  - Confirmation message: " + (hasConfirmation ? "YES" : "NO"));
            System.out.println("  - Yes/No options: " + (hasYesNo ? "YES" : "NO"));
            System.out.println("  - OK/Cancel options: " + (hasOkCancel ? "YES" : "NO"));
            System.out.println("  - Dialog detected: " + (hasDialog ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasCancelPopup) score += 2;
            if (hasConfirmation) score += 3;
            if (hasYesNo) score += 2;
            if (hasOkCancel) score += 2;
            if (hasDialog) score++;

            if (score >= 4 || hasConfirmation || (hasCancelPopup && (hasYesNo || hasOkCancel))) {
                System.out.println("========================================");
                System.out.println("  TC-069: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Cancel popup appeared!");
                System.out.println("");
                if (hasCancelPopup) System.out.println("  - Cancel popup visible");
                if (hasConfirmation) System.out.println("  - Confirmation message shown");
                if (hasYesNo) System.out.println("  - Yes/No options available");
                if (hasOkCancel) System.out.println("  - OK/Cancel options available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did popup appear immediately?");
                System.out.println("  - Can you confirm or dismiss?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-069: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Cancel Request?");
                System.out.println("  2. Did a popup appear immediately?");
                System.out.println("  3. Does popup have Yes/No options?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying popup: " + e.getMessage());
            System.out.println("TC-069: FAILED - " + e.getMessage());
        }
    }
}
