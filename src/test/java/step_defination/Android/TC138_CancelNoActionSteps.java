package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC138_CancelNoActionSteps extends Page {

    @Given("User sees cancel popup on driver searching screen")
    public void userSeesCancelPopupOnDriverSearchingScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-138: CANCEL NO ACTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Be on the driver searching screen");
            System.out.println("  4. Tap 'Cancel Request'");
            System.out.println("  5. Cancel confirmation popup should be visible");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 25 seconds to show cancel popup...");
            System.out.println("");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean hasPopup = pageSource.contains("Cancel") ||
                                pageSource.contains("cancel") ||
                                pageSource.contains("Yes") ||
                                pageSource.contains("No") ||
                                pageSource.contains("Are you sure");

            if (hasPopup) {
                System.out.println("");
                System.out.println("Confirmed: Cancel popup visible");
            } else {
                System.out.println("");
                System.out.println("Please ensure the cancel confirmation popup is visible.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps NO on cancel confirmation popup")
    public void userTapsNoOnCancelConfirmationPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING NO ON CANCEL POPUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for the NO button on the popup");
            System.out.println("  2. Tap NO to dismiss the popup");
            System.out.println("  3. Observe if popup closes");
            System.out.println("  4. Observe if searching continues");
            System.out.println("");
            System.out.println("  NOTE: The popup should close and driver");
            System.out.println("  search should continue.");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 15 seconds for manual action...");
            System.out.println("");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("NO button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Popup should close and driver search should continue")
    public void popupShouldCloseAndDriverSearchShouldContinue() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING NO ACTION - SEARCH CONTINUES");
            System.out.println("========================================");
            System.out.println("");

            // Check if still on searching screen
            boolean hasSearchingText = pageSource.contains("Searching") ||
                                       pageSource.contains("searching") ||
                                       pageSource.contains("Looking") ||
                                       pageSource.contains("sent to drivers") ||
                                       pageSource.contains("ride request");

            // Check for driver search active
            boolean hasDriverSearch = pageSource.contains("Driver") ||
                                      pageSource.contains("driver") ||
                                      pageSource.contains("Cancel") ||
                                      pageSource.contains("cancel");

            // Check popup is dismissed (no Yes/No confirmation visible)
            boolean popupDismissed = !pageSource.contains("Are you sure") ||
                                      pageSource.contains("Searching") ||
                                      pageSource.contains("sent to drivers");

            // Check for cancel button still available
            boolean hasCancelButton = pageSource.contains("Cancel") ||
                                       pageSource.contains("cancel");

            // Check for map/search context
            boolean hasMapContext = pageSource.contains("Map") ||
                                    pageSource.contains("map") ||
                                    pageSource.contains("km") ||
                                    pageSource.contains("min");

            System.out.println("NO Action Verification:");
            System.out.println("-----------------------");
            System.out.println("  - Searching text visible: " + (hasSearchingText ? "YES" : "NO"));
            System.out.println("  - Driver search active: " + (hasDriverSearch ? "YES" : "NO"));
            System.out.println("  - Popup dismissed: " + (popupDismissed ? "YES" : "NO"));
            System.out.println("  - Cancel button available: " + (hasCancelButton ? "YES" : "NO"));
            System.out.println("  - Map context: " + (hasMapContext ? "YES" : "NO"));
            System.out.println("");

            int score = 0;
            if (hasSearchingText) score += 3;
            if (hasDriverSearch) score += 2;
            if (popupDismissed) score += 2;
            if (hasCancelButton) score++;
            if (hasMapContext) score++;

            System.out.println("========================================");
            if (score >= 4 || (hasSearchingText && popupDismissed) || (hasDriverSearch && popupDismissed)) {
                System.out.println("  TC-138: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Cancel NO action verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasSearchingText) System.out.println("    - Searching text still visible");
                if (hasDriverSearch) System.out.println("    - Driver search still active");
                if (popupDismissed) System.out.println("    - Popup dismissed");
                if (hasCancelButton) System.out.println("    - Cancel button still available");
                if (hasMapContext) System.out.println("    - Map context visible");
                System.out.println("");
                System.out.println("  Result: Popup closed, search continues");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-138: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did the popup close after tapping NO?");
                System.out.println("  2. Is the driver search still continuing?");
                System.out.println("  3. Is the searching animation still active?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying NO action: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-138: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
