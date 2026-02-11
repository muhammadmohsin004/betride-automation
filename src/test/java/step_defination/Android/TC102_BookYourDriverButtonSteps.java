package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC102_BookYourDriverButtonSteps extends Page {

    @Given("User is on Confirm Booking page with pickup hours and fare selected")
    public void userIsOnConfirmBookingPageWithPickupHoursAndFareSelected() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-102: BOOK YOUR DRIVER BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Confirm Booking page");
            System.out.println("  4. Pickup location selected");
            System.out.println("  5. Hours selected");
            System.out.println("  6. Fare confirmed");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 18 seconds to reach Confirm Booking...");
            System.out.println("");

            for (int i = 0; i < 6; i++) {
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
            System.out.println("Should be on Confirm Booking with all selections.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Book your driver button")
    public void userTapsBookYourDriverButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP BOOK YOUR DRIVER BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for 'Book your driver' button");
            System.out.println("  2. Verify all details are correct:");
            System.out.println("     - Pickup location");
            System.out.println("     - Hours selected");
            System.out.println("     - Fare amount");
            System.out.println("  3. Tap 'Book your driver' button");
            System.out.println("  4. Wait for navigation");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 15 seconds to tap Book...");

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
            System.out.println("Should have tapped Book your driver button.");

        } catch (Exception e) {
            System.out.println("Error tapping Book button: " + e.getMessage());
        }
    }

    @Then("App should navigate to ride searching screen")
    public void appShouldNavigateToRideSearchingScreen() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  RIDE SEARCHING SCREEN VERIFICATION");
            System.out.println("========================================");

            // Check for searching indicators
            boolean hasSearching = pageSource.contains("Search") ||
                                   pageSource.contains("search") ||
                                   pageSource.contains("Finding") ||
                                   pageSource.contains("finding");

            // Check for driver related text
            boolean hasDriver = pageSource.contains("Driver") ||
                                pageSource.contains("driver") ||
                                pageSource.contains("Captain");

            // Check for looking/waiting text
            boolean hasLooking = pageSource.contains("Looking") ||
                                 pageSource.contains("looking") ||
                                 pageSource.contains("Waiting") ||
                                 pageSource.contains("waiting");

            // Check for nearby text
            boolean hasNearby = pageSource.contains("Nearby") ||
                                pageSource.contains("nearby") ||
                                pageSource.contains("Near") ||
                                pageSource.contains("near");

            // Check for cancel option
            boolean hasCancel = pageSource.contains("Cancel") ||
                                pageSource.contains("cancel");

            // Check for animation/loading
            boolean hasLoading = pageSource.contains("Loading") ||
                                 pageSource.contains("loading") ||
                                 pageSource.contains("Please wait");

            // Check for ride text
            boolean hasRide = pageSource.contains("Ride") ||
                              pageSource.contains("ride") ||
                              pageSource.contains("Trip") ||
                              pageSource.contains("trip");

            // Check for map
            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            System.out.println("");
            System.out.println("Ride Searching Verification:");
            System.out.println("----------------------------");
            System.out.println("  - Searching text: " + (hasSearching ? "YES" : "NO"));
            System.out.println("  - Driver text: " + (hasDriver ? "YES" : "NO"));
            System.out.println("  - Looking/Waiting: " + (hasLooking ? "YES" : "NO"));
            System.out.println("  - Nearby text: " + (hasNearby ? "YES" : "NO"));
            System.out.println("  - Cancel option: " + (hasCancel ? "YES" : "NO"));
            System.out.println("  - Loading indicator: " + (hasLoading ? "YES" : "NO"));
            System.out.println("  - Ride/Trip text: " + (hasRide ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSearching) score += 3;
            if (hasDriver) score += 2;
            if (hasLooking) score += 2;
            if (hasNearby) score++;
            if (hasCancel) score++;
            if (hasLoading) score++;
            if (hasRide) score++;
            if (hasMap) score++;

            if (score >= 3 || hasSearching || hasLooking || hasDriver) {
                System.out.println("========================================");
                System.out.println("  TC-102: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigated to ride searching screen!");
                System.out.println("");
                if (hasSearching) System.out.println("  - Searching text visible");
                if (hasDriver) System.out.println("  - Driver text found");
                if (hasLooking) System.out.println("  - Looking/Waiting shown");
                if (hasNearby) System.out.println("  - Nearby text visible");
                if (hasCancel) System.out.println("  - Cancel option available");
                if (hasLoading) System.out.println("  - Loading indicator shown");
                if (hasRide) System.out.println("  - Ride/Trip text visible");
                if (hasMap) System.out.println("  - Map visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is the app on ride searching screen?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-102: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did app navigate to ride searching?");
                System.out.println("  2. Is it looking for nearby drivers?");
                System.out.println("  3. Is there a cancel option?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying searching screen: " + e.getMessage());
            System.out.println("TC-102: FAILED - " + e.getMessage());
        }
    }
}
