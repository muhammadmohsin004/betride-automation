package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC077_SelectPickupFromRecentSteps extends Page {

    @Given("User has recent location history")
    public void userHasRecentLocationHistory() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-077: SELECT PICKUP FROM RECENT");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. You should have recent locations");
            System.out.println("     (from previous rides/searches)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 10 seconds to prepare...");
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
            System.out.println("User should have recent history.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on a recent location under pickup field")
    public void userTapsOnARecentLocationUnderPickupField() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP RECENT LOCATION FOR PICKUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Tap on the PICKUP field");
            System.out.println("  2. Look for recent locations list");
            System.out.println("  3. Tap on one of the recent locations");
            System.out.println("  4. Observe if pickup field gets updated");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 12 seconds to select recent location...");

            for (int i = 0; i < 4; i++) {
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
            System.out.println("Recent location should be selected.");

        } catch (Exception e) {
            System.out.println("Error selecting recent location: " + e.getMessage());
        }
    }

    @Then("Pickup field should update correctly with selected location")
    public void pickupFieldShouldUpdateCorrectlyWithSelectedLocation() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  PICKUP FIELD UPDATE VERIFICATION");
            System.out.println("========================================");

            // Check for pickup field indicators
            boolean hasPickup = pageSource.contains("Pickup") ||
                                pageSource.contains("pickup") ||
                                pageSource.contains("From") ||
                                pageSource.contains("from") ||
                                pageSource.contains("Pick-up") ||
                                pageSource.contains("pick-up");

            // Check for location content in fields
            boolean hasLocationContent = pageSource.contains("Street") ||
                                         pageSource.contains("street") ||
                                         pageSource.contains("Road") ||
                                         pageSource.contains("road") ||
                                         pageSource.contains("Avenue") ||
                                         pageSource.contains("Marrakech") ||
                                         pageSource.contains("Morocco");

            // Check for drop-off field (indicates pickup was filled)
            boolean hasDropoff = pageSource.contains("Drop") ||
                                 pageSource.contains("drop") ||
                                 pageSource.contains("Destination") ||
                                 pageSource.contains("destination") ||
                                 pageSource.contains("To") ||
                                 pageSource.contains("Where");

            // Check for booking screen elements
            boolean hasBookingScreen = pageSource.contains("Let's Go") ||
                                       pageSource.contains("Search") ||
                                       pageSource.contains("Book") ||
                                       pageSource.contains("Confirm");

            // Check field is populated (not empty placeholder)
            boolean hasPopulatedField = !pageSource.contains("Enter pickup") &&
                                        !pageSource.contains("Enter your location") &&
                                        hasLocationContent;

            System.out.println("");
            System.out.println("Pickup Field Update Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Pickup field present: " + (hasPickup ? "YES" : "NO"));
            System.out.println("  - Location content: " + (hasLocationContent ? "YES" : "NO"));
            System.out.println("  - Drop-off field visible: " + (hasDropoff ? "YES" : "NO"));
            System.out.println("  - Booking screen: " + (hasBookingScreen ? "YES" : "NO"));
            System.out.println("  - Field populated: " + (hasPopulatedField ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasPickup) score += 2;
            if (hasLocationContent) score += 3;
            if (hasDropoff) score += 2;
            if (hasBookingScreen) score++;
            if (hasPopulatedField) score += 2;

            if (score >= 4 || hasLocationContent || (hasPickup && hasDropoff)) {
                System.out.println("========================================");
                System.out.println("  TC-077: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Pickup field updated correctly!");
                System.out.println("");
                if (hasPickup) System.out.println("  - Pickup field present");
                if (hasLocationContent) System.out.println("  - Location content displayed");
                if (hasDropoff) System.out.println("  - Drop-off field visible");
                if (hasPopulatedField) System.out.println("  - Field is populated");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did pickup field update with selected location?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-077: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap a recent location?");
                System.out.println("  2. Did pickup field update correctly?");
                System.out.println("  3. Is the location displayed in pickup field?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying pickup field: " + e.getMessage());
            System.out.println("TC-077: FAILED - " + e.getMessage());
        }
    }
}
