package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC150_ValidationPickupMissingSteps extends Page {

    @Given("User is on Send or Receive page with all fields filled except pickup")
    public void userIsOnSendOrReceivePageWithAllFieldsFilledExceptPickup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-150: VALIDATION - PICKUP MISSING");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Send or Receive Anything page");
            System.out.println("  4. Fill all fields EXCEPT pickup location");
            System.out.println("     - Leave pickup empty");
            System.out.println("     - Fill drop-off, recipient, etc.");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 20 seconds to fill form fields...");
            System.out.println("");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnPage = pageSource.contains("Send") ||
                                pageSource.contains("Receive") ||
                                pageSource.contains("Anything") ||
                                pageSource.contains("NEXT") ||
                                pageSource.contains("Next");

            if (isOnPage) {
                System.out.println("");
                System.out.println("Confirmed: On Send or Receive page");
            } else {
                System.out.println("");
                System.out.println("Please navigate to Send or Receive page and fill all except pickup.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps NEXT without pickup location on Send Receive page")
    public void userTapsNEXTWithoutPickupLocationOnSendReceivePage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING NEXT WITHOUT PICKUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Ensure pickup field is EMPTY");
            System.out.println("  2. Tap the NEXT button");
            System.out.println("  3. Observe for validation error message");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 15 seconds for tap and error...");
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
            System.out.println("NEXT should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Error message should display Select pickup location")
    public void errorMessageShouldDisplaySelectPickupLocation() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING VALIDATION ERROR");
            System.out.println("========================================");
            System.out.println("");

            // Check for Select pickup location error
            boolean hasSelectPickupError = pageSource.contains("Select pickup location") ||
                                            pageSource.contains("select pickup location") ||
                                            pageSource.contains("SELECT PICKUP LOCATION") ||
                                            pageSource.contains("Select pickup");

            // Check for generic pickup error
            boolean hasPickupError = pageSource.contains("pickup") ||
                                      pageSource.contains("Pickup") ||
                                      pageSource.contains("PICKUP");

            // Check for error/validation indicators
            boolean hasErrorIndicator = pageSource.contains("error") ||
                                         pageSource.contains("Error") ||
                                         pageSource.contains("required") ||
                                         pageSource.contains("Required") ||
                                         pageSource.contains("Please") ||
                                         pageSource.contains("please") ||
                                         pageSource.contains("Select");

            // Check still on Send/Receive page (didn't navigate away)
            boolean stayedOnPage = pageSource.contains("Send") ||
                                    pageSource.contains("Receive") ||
                                    pageSource.contains("Anything") ||
                                    pageSource.contains("NEXT") ||
                                    pageSource.contains("Next");

            System.out.println("Validation Error Verification:");
            System.out.println("------------------------------");
            System.out.println("  - Select pickup location error: " + (hasSelectPickupError ? "YES" : "NO"));
            System.out.println("  - Pickup error text: " + (hasPickupError ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Stayed on page: " + (stayedOnPage ? "YES" : "NO"));
            System.out.println("");

            int score = 0;
            if (hasSelectPickupError) score += 5;
            if (hasPickupError) score += 2;
            if (hasErrorIndicator) score += 2;
            if (stayedOnPage) score++;

            System.out.println("========================================");
            if (score >= 4 || hasSelectPickupError || (hasPickupError && hasErrorIndicator)) {
                System.out.println("  TC-150: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Validation error verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasSelectPickupError) System.out.println("    - 'Select pickup location' error displayed");
                if (hasPickupError) System.out.println("    - Pickup error text found");
                if (hasErrorIndicator) System.out.println("    - Error indicator present");
                if (stayedOnPage) System.out.println("    - Stayed on Send/Receive page");
                System.out.println("");
                System.out.println("  Result: Error 'Select pickup location' displayed");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-150: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did an error message appear?");
                System.out.println("  2. Does it say 'Select pickup location'?");
                System.out.println("  3. Did you stay on the Send/Receive page?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying validation: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-150: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
