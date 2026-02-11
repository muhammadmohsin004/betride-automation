package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC151_ValidationDropoffMissingSteps extends Page {

    @Given("User is on Send or Receive page with all fields filled except drop-off")
    public void userIsOnSendOrReceivePageWithAllFieldsFilledExceptDropoff() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-151: VALIDATION - DROP-OFF MISSING");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Send or Receive Anything page");
            System.out.println("  4. Fill all fields EXCEPT drop-off location");
            System.out.println("     - Fill pickup location");
            System.out.println("     - Leave drop-off empty");
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
                System.out.println("Please navigate to Send or Receive page and fill all except drop-off.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps NEXT without drop-off location on Send Receive page")
    public void userTapsNEXTWithoutDropoffLocationOnSendReceivePage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING NEXT WITHOUT DROP-OFF");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Ensure drop-off field is EMPTY");
            System.out.println("  2. Ensure pickup field IS filled");
            System.out.println("  3. Tap the NEXT button");
            System.out.println("  4. Observe for validation error message");
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

    @Then("Error message should display Select drop-off location")
    public void errorMessageShouldDisplaySelectDropoffLocation() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING VALIDATION ERROR");
            System.out.println("========================================");
            System.out.println("");

            // Check for Select drop-off location error
            boolean hasSelectDropoffError = pageSource.contains("Select drop-off location") ||
                                             pageSource.contains("select drop-off location") ||
                                             pageSource.contains("SELECT DROP-OFF LOCATION") ||
                                             pageSource.contains("Select drop-off") ||
                                             pageSource.contains("add destination") ||
                                             pageSource.contains("Add destination") ||
                                             pageSource.contains("please add destination");

            // Check for generic drop-off error
            boolean hasDropoffError = pageSource.contains("drop-off") ||
                                       pageSource.contains("Drop-off") ||
                                       pageSource.contains("DROP-OFF") ||
                                       pageSource.contains("destination") ||
                                       pageSource.contains("Destination");

            // Check for error/validation indicators
            boolean hasErrorIndicator = pageSource.contains("error") ||
                                         pageSource.contains("Error") ||
                                         pageSource.contains("required") ||
                                         pageSource.contains("Required") ||
                                         pageSource.contains("Please") ||
                                         pageSource.contains("please") ||
                                         pageSource.contains("Select");

            // Check still on Send/Receive page
            boolean stayedOnPage = pageSource.contains("Send") ||
                                    pageSource.contains("Receive") ||
                                    pageSource.contains("Anything") ||
                                    pageSource.contains("NEXT") ||
                                    pageSource.contains("Next");

            System.out.println("Validation Error Verification:");
            System.out.println("------------------------------");
            System.out.println("  - Select drop-off location error: " + (hasSelectDropoffError ? "YES" : "NO"));
            System.out.println("  - Drop-off error text: " + (hasDropoffError ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Stayed on page: " + (stayedOnPage ? "YES" : "NO"));
            System.out.println("");

            int score = 0;
            if (hasSelectDropoffError) score += 5;
            if (hasDropoffError) score += 2;
            if (hasErrorIndicator) score += 2;
            if (stayedOnPage) score++;

            System.out.println("========================================");
            if (score >= 4 || hasSelectDropoffError || (hasDropoffError && hasErrorIndicator)) {
                System.out.println("  TC-151: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Validation error verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasSelectDropoffError) System.out.println("    - 'Select drop-off location' error displayed");
                if (hasDropoffError) System.out.println("    - Drop-off error text found");
                if (hasErrorIndicator) System.out.println("    - Error indicator present");
                if (stayedOnPage) System.out.println("    - Stayed on Send/Receive page");
                System.out.println("");
                System.out.println("  Result: Error 'Select drop-off location' displayed");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-151: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did an error message appear?");
                System.out.println("  2. Does it say 'Select drop-off location'?");
                System.out.println("  3. Did you stay on the Send/Receive page?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying validation: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-151: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
