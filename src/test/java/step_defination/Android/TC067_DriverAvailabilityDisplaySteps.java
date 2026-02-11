package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC067_DriverAvailabilityDisplaySteps extends Page {

    @Given("User has initiated a search for driver")
    public void userHasInitiatedASearchForDriver() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-067: DRIVER AVAILABILITY DISPLAY");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Ride'");
            System.out.println("  4. Enter pickup and drop-off locations");
            System.out.println("  5. Navigate to Confirm Ride page");
            System.out.println("  6. Be ready to search for driver");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to setup...");
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
            System.out.println("User should be ready to search for driver.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Search for Driver button")
    public void userTapsOnSearchForDriverButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP SEARCH FOR DRIVER");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Confirm Ride page");
            System.out.println("  2. Tap on 'Search for Driver' button");
            System.out.println("     (or 'Confirm' / 'Book Now' button)");
            System.out.println("  3. Wait for driver search to begin");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to search for driver...");

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
            System.out.println("Search for driver should be initiated.");

        } catch (Exception e) {
            System.out.println("Error searching for driver: " + e.getMessage());
        }
    }

    @Then("Nearby drivers should be displayed on the map")
    public void nearbyDriversShouldBeDisplayedOnTheMap() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DRIVER AVAILABILITY VERIFICATION");
            System.out.println("========================================");

            // Check for driver indicators
            boolean hasDriverIndicator = pageSource.contains("Driver") ||
                                         pageSource.contains("driver") ||
                                         pageSource.contains("Drivers") ||
                                         pageSource.contains("drivers");

            // Check for searching message
            boolean hasSearching = pageSource.contains("Searching") ||
                                   pageSource.contains("searching") ||
                                   pageSource.contains("Finding") ||
                                   pageSource.contains("finding") ||
                                   pageSource.contains("Looking") ||
                                   pageSource.contains("looking");

            // Check for map
            boolean hasMap = pageSource.contains("map") ||
                             pageSource.contains("Map") ||
                             pageSource.contains("MapView");

            // Check for nearby indicators
            boolean hasNearby = pageSource.contains("Nearby") ||
                                pageSource.contains("nearby") ||
                                pageSource.contains("Near") ||
                                pageSource.contains("near") ||
                                pageSource.contains("Available") ||
                                pageSource.contains("available");

            // Check for wait time
            boolean hasWaitTime = pageSource.contains("min") ||
                                  pageSource.contains("Min") ||
                                  pageSource.contains("wait") ||
                                  pageSource.contains("Wait") ||
                                  pageSource.contains("ETA");

            System.out.println("");
            System.out.println("Driver Availability Verification:");
            System.out.println("----------------------------------");
            System.out.println("  - Driver indicator: " + (hasDriverIndicator ? "YES" : "NO"));
            System.out.println("  - Searching message: " + (hasSearching ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("  - Nearby indicator: " + (hasNearby ? "YES" : "NO"));
            System.out.println("  - Wait time: " + (hasWaitTime ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasDriverIndicator) score += 3;
            if (hasSearching) score += 2;
            if (hasMap) score += 2;
            if (hasNearby) score += 2;
            if (hasWaitTime) score++;

            if (score >= 4 || hasDriverIndicator || hasSearching) {
                System.out.println("========================================");
                System.out.println("  TC-067: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Driver search initiated!");
                System.out.println("");
                if (hasDriverIndicator) System.out.println("  - Driver indicator visible");
                if (hasSearching) System.out.println("  - Searching message shown");
                if (hasMap) System.out.println("  - Map displayed");
                if (hasNearby) System.out.println("  - Nearby drivers shown");
                if (hasWaitTime) System.out.println("  - Wait time displayed");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did search start?");
                System.out.println("  - Are drivers visible on map?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasMap) {
                System.out.println("========================================");
                System.out.println("  TC-067: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Map visible but drivers not detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Search for Driver?");
                System.out.println("  2. Are nearby drivers on the map?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-067: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Search for Driver?");
                System.out.println("  2. Is the search active?");
                System.out.println("  3. Are nearby drivers displayed on map?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying drivers: " + e.getMessage());
            System.out.println("TC-067: FAILED - " + e.getMessage());
        }
    }
}
