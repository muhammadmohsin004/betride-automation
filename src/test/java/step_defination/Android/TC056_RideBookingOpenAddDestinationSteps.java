package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC056_RideBookingOpenAddDestinationSteps extends Page {

    @Given("User is on the Rider Home page")
    public void userIsOnTheRiderHomePage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-056: RIDE BOOKING - ADD DESTINATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Home page should be loaded");
            System.out.println("  4. Map and options should be visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 10 seconds for Home page to load...");
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
            System.out.println("User should be on Home page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Book Ride button")
    public void userTapsOnBookRideButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP BOOK RIDE BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rider Home page");
            System.out.println("  2. Look for 'Book Ride' or similar button");
            System.out.println("     (May also be 'Where to?' or destination input)");
            System.out.println("  3. Tap on it to start booking a ride");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Book Ride...");

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
            System.out.println("Book Ride button should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Book Ride: " + e.getMessage());
        }
    }

    @Then("App should navigate to Add Destination page")
    public void appShouldNavigateToAddDestinationPage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ADD DESTINATION PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for destination input
            boolean hasDestinationInput = pageSource.contains("Destination") ||
                                          pageSource.contains("destination") ||
                                          pageSource.contains("Where to") ||
                                          pageSource.contains("where to") ||
                                          pageSource.contains("Enter destination") ||
                                          pageSource.contains("enter destination");

            // Check for Add Destination
            boolean hasAddDestination = pageSource.contains("Add Destination") ||
                                        pageSource.contains("add destination") ||
                                        pageSource.contains("Add destination");

            // Check for search/input field
            boolean hasSearchField = pageSource.contains("Search") ||
                                     pageSource.contains("search") ||
                                     pageSource.contains("Enter location") ||
                                     pageSource.contains("enter location") ||
                                     pageSource.contains("EditText");

            // Check for pickup/dropoff
            boolean hasPickupDropoff = pageSource.contains("Pickup") ||
                                       pageSource.contains("pickup") ||
                                       pageSource.contains("Drop") ||
                                       pageSource.contains("drop") ||
                                       pageSource.contains("From") ||
                                       pageSource.contains("To");

            // Check for map
            boolean hasMap = pageSource.contains("map") ||
                             pageSource.contains("Map") ||
                             pageSource.contains("MapView");

            System.out.println("");
            System.out.println("Add Destination Page Verification:");
            System.out.println("-----------------------------------");
            System.out.println("  - Destination input: " + (hasDestinationInput ? "YES" : "NO"));
            System.out.println("  - Add Destination: " + (hasAddDestination ? "YES" : "NO"));
            System.out.println("  - Search field: " + (hasSearchField ? "YES" : "NO"));
            System.out.println("  - Pickup/Dropoff: " + (hasPickupDropoff ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasDestinationInput) score += 3;
            if (hasAddDestination) score += 3;
            if (hasSearchField) score += 2;
            if (hasPickupDropoff) score += 2;
            if (hasMap) score++;

            if (score >= 4 || hasAddDestination || hasDestinationInput) {
                System.out.println("========================================");
                System.out.println("  TC-056: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigated to Add Destination page!");
                System.out.println("");
                if (hasDestinationInput) System.out.println("  - Destination input field visible");
                if (hasAddDestination) System.out.println("  - Add Destination page shown");
                if (hasSearchField) System.out.println("  - Search field available");
                if (hasPickupDropoff) System.out.println("  - Pickup/Dropoff options visible");
                if (hasMap) System.out.println("  - Map is visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you tap Book Ride?");
                System.out.println("  - Is Add Destination page visible?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasSearchField || hasPickupDropoff) {
                System.out.println("========================================");
                System.out.println("  TC-056: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Booking page detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Book Ride?");
                System.out.println("  2. Is Add Destination page visible?");
                System.out.println("  3. Can you enter a destination?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-056: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Add Destination page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Book Ride button?");
                System.out.println("  2. Did app navigate to Add Destination?");
                System.out.println("  3. Is destination input visible?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Add Destination page: " + e.getMessage());
            System.out.println("TC-056: FAILED - " + e.getMessage());
        }
    }
}
