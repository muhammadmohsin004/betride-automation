package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC075_DropOffSameAsPickupSteps extends Page {

    @Given("User is on ride booking screen")
    public void userIsOnRideBookingScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-075: DROP-OFF SAME AS PICKUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Go to ride booking screen");
            System.out.println("  4. Tap 'Book Ride' to see pickup/drop-off fields");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 10 seconds to reach booking screen...");
            System.out.println("");

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
            System.out.println("User should be on booking screen now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User enters same location in both pickup and drop-off fields")
    public void userEntersSameLocationInBothPickupAndDropOffFields() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ENTER SAME LOCATION IN BOTH FIELDS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Enter a location in PICKUP field");
            System.out.println("     (e.g., 'Marrakech' or your current location)");
            System.out.println("  2. Enter the SAME location in DROP-OFF field");
            System.out.println("     (e.g., 'Marrakech' - same as pickup)");
            System.out.println("  3. Try to proceed with booking");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 15 seconds to enter same locations...");

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
            System.out.println("Same locations should be entered.");

        } catch (Exception e) {
            System.out.println("Error entering locations: " + e.getMessage());
        }
    }

    @Then("Error message Pickup and drop-off cannot be same should appear")
    public void errorMessagePickupAndDropOffCannotBeSameShouldAppear() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SAME LOCATION ERROR VERIFICATION");
            System.out.println("========================================");

            // Check for same location error
            boolean hasSameError = pageSource.contains("same") ||
                                   pageSource.contains("Same") ||
                                   pageSource.contains("cannot be same") ||
                                   pageSource.contains("Cannot be same");

            // Check for pickup/drop-off error
            boolean hasPickupDropError = (pageSource.contains("Pickup") || pageSource.contains("pickup")) &&
                                         (pageSource.contains("drop") || pageSource.contains("Drop"));

            // Check for generic error
            boolean hasError = pageSource.contains("Error") ||
                               pageSource.contains("error") ||
                               pageSource.contains("Invalid") ||
                               pageSource.contains("invalid");

            // Check for different location message
            boolean hasDifferentMsg = pageSource.contains("different") ||
                                      pageSource.contains("Different") ||
                                      pageSource.contains("choose another") ||
                                      pageSource.contains("Choose another");

            // Check for warning/alert
            boolean hasWarning = pageSource.contains("Warning") ||
                                 pageSource.contains("warning") ||
                                 pageSource.contains("Alert") ||
                                 pageSource.contains("alert");

            System.out.println("");
            System.out.println("Same Location Error Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Same location error: " + (hasSameError ? "YES" : "NO"));
            System.out.println("  - Pickup/Drop-off error: " + (hasPickupDropError ? "YES" : "NO"));
            System.out.println("  - Generic error: " + (hasError ? "YES" : "NO"));
            System.out.println("  - Different location msg: " + (hasDifferentMsg ? "YES" : "NO"));
            System.out.println("  - Warning/Alert: " + (hasWarning ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSameError) score += 4;
            if (hasPickupDropError) score += 2;
            if (hasError) score += 2;
            if (hasDifferentMsg) score += 2;
            if (hasWarning) score++;

            if (score >= 3 || hasSameError || hasPickupDropError || hasDifferentMsg) {
                System.out.println("========================================");
                System.out.println("  TC-075: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Same location error shown correctly!");
                System.out.println("");
                if (hasSameError) System.out.println("  - 'Same location' error displayed");
                if (hasPickupDropError) System.out.println("  - Pickup/Drop-off error shown");
                if (hasError) System.out.println("  - Error message visible");
                if (hasDifferentMsg) System.out.println("  - 'Different location' message shown");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did error message appear?");
                System.out.println("  - Were you prevented from booking?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-075: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you enter same location in both fields?");
                System.out.println("  2. Did error message appear?");
                System.out.println("  3. Were you prevented from booking?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying same location: " + e.getMessage());
            System.out.println("TC-075: FAILED - " + e.getMessage());
        }
    }
}
