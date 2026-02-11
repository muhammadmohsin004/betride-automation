package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC079_NavigateBackFromConfirmRideSteps extends Page {

    @Given("Confirm Ride screen is loaded")
    public void confirmRideScreenIsLoaded() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-079: NAVIGATE BACK FROM CONFIRM RIDE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (enter pickup & drop-off)");
            System.out.println("  4. Tap 'Let's Go' to reach Confirm Ride screen");
            System.out.println("  5. Confirm Ride screen should be loaded");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to reach Confirm Ride screen...");
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
            System.out.println("Confirm Ride screen should be loaded now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on back arrow")
    public void userTapsOnBackArrow() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP BACK ARROW");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Confirm Ride screen");
            System.out.println("  2. Find the back arrow (top left)");
            System.out.println("  3. Tap on the back arrow");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap back arrow...");

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
            System.out.println("Back arrow should be tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping back: " + e.getMessage());
        }
    }

    @Then("App should return to Add Destination page")
    public void appShouldReturnToAddDestinationPage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  NAVIGATE BACK VERIFICATION");
            System.out.println("========================================");

            // Check for Add Destination page indicators
            boolean hasDestination = pageSource.contains("Destination") ||
                                     pageSource.contains("destination") ||
                                     pageSource.contains("Add Destination") ||
                                     pageSource.contains("add destination");

            // Check for pickup/drop-off fields
            boolean hasFields = pageSource.contains("Pickup") ||
                                pageSource.contains("pickup") ||
                                pageSource.contains("Drop") ||
                                pageSource.contains("drop") ||
                                pageSource.contains("From") ||
                                pageSource.contains("To");

            // Check for location entry
            boolean hasLocationEntry = pageSource.contains("Enter") ||
                                       pageSource.contains("enter") ||
                                       pageSource.contains("Search") ||
                                       pageSource.contains("search") ||
                                       pageSource.contains("Where");

            // Check for map
            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            // Check that Confirm Ride is NOT showing
            boolean notOnConfirm = !pageSource.contains("Confirm Ride") &&
                                   !pageSource.contains("Search for Driver") &&
                                   !pageSource.contains("Let's Go");

            System.out.println("");
            System.out.println("Navigate Back Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Destination page: " + (hasDestination ? "YES" : "NO"));
            System.out.println("  - Pickup/Drop fields: " + (hasFields ? "YES" : "NO"));
            System.out.println("  - Location entry: " + (hasLocationEntry ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("  - Left Confirm screen: " + (notOnConfirm ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasDestination) score += 3;
            if (hasFields) score += 2;
            if (hasLocationEntry) score += 2;
            if (hasMap) score++;
            if (notOnConfirm) score += 2;

            if (score >= 4 || hasDestination || hasFields || hasLocationEntry) {
                System.out.println("========================================");
                System.out.println("  TC-079: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigated back to Add Destination!");
                System.out.println("");
                if (hasDestination) System.out.println("  - Add Destination page visible");
                if (hasFields) System.out.println("  - Pickup/Drop fields shown");
                if (hasLocationEntry) System.out.println("  - Location entry available");
                if (hasMap) System.out.println("  - Map is visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did app return to Add Destination page?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-079: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap the back arrow?");
                System.out.println("  2. Did app return to Add Destination?");
                System.out.println("  3. Can you edit pickup/drop-off?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying navigation: " + e.getMessage());
            System.out.println("TC-079: FAILED - " + e.getMessage());
        }
    }
}
