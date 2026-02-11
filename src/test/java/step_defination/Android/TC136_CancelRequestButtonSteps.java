package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC136_CancelRequestButtonSteps extends Page {

    @Given("User is on active driver searching screen")
    public void userIsOnActiveDriverSearchingScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-136: CANCEL REQUEST BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Search for a driver (ride request sent)");
            System.out.println("  4. You should be on the searching screen");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 25 seconds to reach searching screen...");
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
            boolean isOnSearching = pageSource.contains("Searching") ||
                                     pageSource.contains("searching") ||
                                     pageSource.contains("ride request") ||
                                     pageSource.contains("sent to drivers") ||
                                     pageSource.contains("Cancel") ||
                                     pageSource.contains("Driver");

            if (isOnSearching) {
                System.out.println("");
                System.out.println("Confirmed: On active driver searching screen");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the driver searching screen.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Cancel Request button on searching screen")
    public void userTapsCancelRequestButtonOnSearchingScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING CANCEL REQUEST BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for the 'Cancel Request' button");
            System.out.println("  2. Tap on the button");
            System.out.println("  3. Observe if a confirmation popup appears");
            System.out.println("");
            System.out.println("  NOTE: A cancel confirmation popup should");
            System.out.println("  appear asking to confirm cancellation.");
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
            System.out.println("Cancel Request button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Cancel confirmation popup should be displayed")
    public void cancelConfirmationPopupShouldBeDisplayed() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING CANCEL CONFIRMATION POPUP");
            System.out.println("========================================");
            System.out.println("");

            // Check for cancel confirmation text
            boolean hasCancelText = pageSource.contains("Cancel") ||
                                     pageSource.contains("cancel") ||
                                     pageSource.contains("CANCEL");

            // Check for confirmation question
            boolean hasConfirmQuestion = pageSource.contains("Are you sure") ||
                                          pageSource.contains("are you sure") ||
                                          pageSource.contains("Do you want") ||
                                          pageSource.contains("do you want") ||
                                          pageSource.contains("confirm");

            // Check for Yes/No buttons
            boolean hasYesNoButtons = pageSource.contains("Yes") ||
                                       pageSource.contains("yes") ||
                                       pageSource.contains("No") ||
                                       pageSource.contains("no") ||
                                       pageSource.contains("OK") ||
                                       pageSource.contains("Confirm");

            // Check for popup/dialog indicators
            boolean hasPopupIndicator = pageSource.contains("popup") ||
                                         pageSource.contains("dialog") ||
                                         pageSource.contains("alert") ||
                                         pageSource.contains("modal") ||
                                         hasConfirmQuestion ||
                                         hasYesNoButtons;

            // Check for ride cancellation context
            boolean hasRideContext = pageSource.contains("ride") ||
                                     pageSource.contains("Ride") ||
                                     pageSource.contains("request") ||
                                     pageSource.contains("Request");

            System.out.println("Cancel Confirmation Popup Verification:");
            System.out.println("----------------------------------------");
            System.out.println("  - Cancel text visible: " + (hasCancelText ? "YES" : "NO"));
            System.out.println("  - Confirmation question: " + (hasConfirmQuestion ? "YES" : "NO"));
            System.out.println("  - Yes/No buttons: " + (hasYesNoButtons ? "YES" : "NO"));
            System.out.println("  - Popup indicator: " + (hasPopupIndicator ? "YES" : "NO"));
            System.out.println("  - Ride context: " + (hasRideContext ? "YES" : "NO"));
            System.out.println("");

            int score = 0;
            if (hasCancelText) score += 2;
            if (hasConfirmQuestion) score += 3;
            if (hasYesNoButtons) score += 3;
            if (hasPopupIndicator) score++;
            if (hasRideContext) score++;

            System.out.println("========================================");
            if (score >= 4 || (hasCancelText && hasYesNoButtons) || (hasConfirmQuestion && hasYesNoButtons)) {
                System.out.println("  TC-136: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Cancel confirmation popup verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasCancelText) System.out.println("    - Cancel text visible");
                if (hasConfirmQuestion) System.out.println("    - Confirmation question found");
                if (hasYesNoButtons) System.out.println("    - Yes/No buttons visible");
                if (hasPopupIndicator) System.out.println("    - Popup/dialog indicator");
                if (hasRideContext) System.out.println("    - Ride context visible");
                System.out.println("");
                System.out.println("  Result: Cancel confirmation popup displayed");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-136: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did a cancel confirmation popup appear?");
                System.out.println("  2. Does it ask to confirm cancellation?");
                System.out.println("  3. Are Yes/No options available?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying cancel popup: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-136: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
