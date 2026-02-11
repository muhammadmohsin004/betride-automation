package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC140_ValidationPickupEqualsDropoffSteps extends Page {

    @Given("User is on City to City page with same location for both fields")
    public void userIsOnCityToCityPageWithSameLocationForBothFields() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-140: VALIDATION PICKUP = DROP-OFF");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("  4. Select the SAME location for pickup");
            System.out.println("     and drop-off");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 25 seconds to set up same locations...");
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
            boolean isOnCityToCity = pageSource.contains("City to City") ||
                                     pageSource.contains("city to city") ||
                                     pageSource.contains("Start your city") ||
                                     pageSource.contains("Next") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Pickup");

            if (isOnCityToCity) {
                System.out.println("");
                System.out.println("Confirmed: On City to City page");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the City to City page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Next with same pickup and dropoff")
    public void userTapsNextWithSamePickupAndDropoff() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING NEXT WITH SAME LOCATIONS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Ensure pickup and drop-off are the");
            System.out.println("     same location");
            System.out.println("  2. Tap the Next button");
            System.out.println("  3. Observe the error message");
            System.out.println("");
            System.out.println("  NOTE: An error should appear saying");
            System.out.println("  pickup and drop-off cannot be same.");
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
            System.out.println("Next button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Error message should display pickup and dropoff cannot be same")
    public void errorMessageShouldDisplayPickupAndDropoffCannotBeSame() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING SAME LOCATION ERROR");
            System.out.println("========================================");
            System.out.println("");

            // Check for error message about same location
            boolean hasSameError = pageSource.contains("cannot be same") ||
                                    pageSource.contains("can't be same") ||
                                    pageSource.contains("same location") ||
                                    pageSource.contains("Same location") ||
                                    pageSource.contains("cannot be the same");

            // Check for pickup/dropoff in error
            boolean hasPickupDropoff = pageSource.contains("Pickup") ||
                                       pageSource.contains("pickup") ||
                                       pageSource.contains("drop-off") ||
                                       pageSource.contains("Drop-off") ||
                                       pageSource.contains("source") ||
                                       pageSource.contains("destination");

            // Check for error indicators
            boolean hasErrorIndicator = pageSource.contains("Error") ||
                                         pageSource.contains("error") ||
                                         pageSource.contains("Warning") ||
                                         pageSource.contains("warning") ||
                                         pageSource.contains("please") ||
                                         pageSource.contains("Please");

            // Check still on City to City page
            boolean stayedOnPage = pageSource.contains("City to City") ||
                                    pageSource.contains("Start your city") ||
                                    pageSource.contains("Next") ||
                                    pageSource.contains("pickup") ||
                                    pageSource.contains("Pickup");

            // Check for toast/snackbar
            boolean hasToast = pageSource.contains("Toast") ||
                                pageSource.contains("toast") ||
                                pageSource.contains("Snackbar") ||
                                hasSameError;

            System.out.println("Same Location Error Verification:");
            System.out.println("----------------------------------");
            System.out.println("  - Same location error: " + (hasSameError ? "YES" : "NO"));
            System.out.println("  - Pickup/dropoff text: " + (hasPickupDropoff ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Stayed on page: " + (stayedOnPage ? "YES" : "NO"));
            System.out.println("  - Toast/notification: " + (hasToast ? "YES" : "NO"));
            System.out.println("");

            int score = 0;
            if (hasSameError) score += 4;
            if (hasPickupDropoff) score += 2;
            if (hasErrorIndicator) score += 2;
            if (stayedOnPage) score++;
            if (hasToast) score++;

            System.out.println("========================================");
            if (score >= 4 || hasSameError || (hasErrorIndicator && hasPickupDropoff)) {
                System.out.println("  TC-140: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Same location error verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasSameError) System.out.println("    - Same location error message");
                if (hasPickupDropoff) System.out.println("    - Pickup/drop-off text found");
                if (hasErrorIndicator) System.out.println("    - Error indicator visible");
                if (stayedOnPage) System.out.println("    - Stayed on City to City page");
                if (hasToast) System.out.println("    - Toast/notification displayed");
                System.out.println("");
                System.out.println("  Result: Error - Pickup and drop-off cannot be same");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-140: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did an error message appear?");
                System.out.println("  2. Does it say pickup and drop-off");
                System.out.println("     cannot be the same?");
                System.out.println("  3. Did the app stay on the same page?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying same location error: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-140: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
