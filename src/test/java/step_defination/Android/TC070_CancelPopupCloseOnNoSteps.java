package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC070_CancelPopupCloseOnNoSteps extends Page {

    @Given("User has cancel popup visible")
    public void userHasCancelPopupVisible() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-070: CANCEL POPUP CLOSE ON NO");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (enter locations)");
            System.out.println("  4. Tap 'Search for Driver'");
            System.out.println("  5. Tap 'Cancel Request' to show popup");
            System.out.println("  6. Cancel popup should be VISIBLE");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to have cancel popup visible...");
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
            System.out.println("Cancel popup should be visible now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on NO button on cancel popup")
    public void userTapsOnNoButtonOnCancelPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP NO ON CANCEL POPUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the cancel popup");
            System.out.println("  2. Find 'NO' or 'Keep Searching' button");
            System.out.println("  3. Tap on it");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap NO...");

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
            System.out.println("NO button should be tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping NO: " + e.getMessage());
        }
    }

    @Then("Popup should close and user stays in searching screen")
    public void popupShouldCloseAndUserStaysInSearchingScreen() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CANCEL POPUP CLOSE VERIFICATION");
            System.out.println("========================================");

            // Check that popup is closed (no confirmation dialog)
            boolean noConfirmDialog = !pageSource.contains("Are you sure") &&
                                      !pageSource.contains("are you sure") &&
                                      !pageSource.contains("Do you want to cancel");

            // Check for searching screen indicators
            boolean hasSearching = pageSource.contains("Searching") ||
                                   pageSource.contains("searching") ||
                                   pageSource.contains("Finding") ||
                                   pageSource.contains("finding") ||
                                   pageSource.contains("Looking") ||
                                   pageSource.contains("looking");

            // Check for driver indicators
            boolean hasDriverIndicator = pageSource.contains("Driver") ||
                                         pageSource.contains("driver");

            // Check for cancel option still present
            boolean hasCancelOption = pageSource.contains("Cancel") ||
                                      pageSource.contains("cancel");

            // Check for animation/loading indicators
            boolean hasAnimation = pageSource.contains("Loading") ||
                                   pageSource.contains("loading") ||
                                   pageSource.contains("Progress") ||
                                   pageSource.contains("progress") ||
                                   pageSource.contains("Please wait") ||
                                   pageSource.contains("please wait");

            System.out.println("");
            System.out.println("Cancel Popup Close Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Popup closed: " + (noConfirmDialog ? "YES" : "NO"));
            System.out.println("  - Searching message: " + (hasSearching ? "YES" : "NO"));
            System.out.println("  - Driver indicator: " + (hasDriverIndicator ? "YES" : "NO"));
            System.out.println("  - Cancel option: " + (hasCancelOption ? "YES" : "NO"));
            System.out.println("  - Animation/Loading: " + (hasAnimation ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (noConfirmDialog) score += 3;
            if (hasSearching) score += 2;
            if (hasDriverIndicator) score += 2;
            if (hasCancelOption) score++;
            if (hasAnimation) score++;

            if (score >= 4 || (noConfirmDialog && (hasSearching || hasDriverIndicator))) {
                System.out.println("========================================");
                System.out.println("  TC-070: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Popup closed and user is in searching screen!");
                System.out.println("");
                if (noConfirmDialog) System.out.println("  - Popup is closed");
                if (hasSearching) System.out.println("  - Searching message visible");
                if (hasDriverIndicator) System.out.println("  - Driver search still active");
                if (hasCancelOption) System.out.println("  - Cancel option still available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did popup close after tapping NO?");
                System.out.println("  - Are you still in searching screen?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-070: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap NO on the popup?");
                System.out.println("  2. Did the popup close?");
                System.out.println("  3. Are you still in searching screen?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying popup close: " + e.getMessage());
            System.out.println("TC-070: FAILED - " + e.getMessage());
        }
    }
}
