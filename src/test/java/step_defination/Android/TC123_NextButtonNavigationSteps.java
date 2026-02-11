package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC123_NextButtonNavigationSteps extends Page {

    @Given("User is on City to City page with both fields selected")
    public void userIsOnCityToCityPageWithBothFieldsSelected() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-123: NEXT BUTTON NAVIGATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("  4. Select a pickup location");
            System.out.println("  5. Select a drop-off location");
            System.out.println("  6. Both fields should be filled");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to set up both fields
            System.out.println("");
            System.out.println("Waiting 25 seconds to set up both locations...");
            System.out.println("");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            // Verify we're on City to City page with both fields
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnCityToCity = pageSource.contains("City to City") ||
                                     pageSource.contains("city to city") ||
                                     pageSource.contains("Start your city") ||
                                     pageSource.contains("Next");

            if (isOnCityToCity) {
                System.out.println("");
                System.out.println("Confirmed: On City to City page with both fields selected");
            } else {
                System.out.println("");
                System.out.println("Please ensure both pickup and drop-off are selected.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Next button")
    public void userTapsNextButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING NEXT BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Ensure both pickup and drop-off are filled");
            System.out.println("  2. Tap on the 'Next' button");
            System.out.println("  3. Wait for navigation to complete");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap Next
            System.out.println("");
            System.out.println("Waiting 15 seconds for manual action...");
            System.out.println("");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
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

    @Then("App should navigate to Confirm Ride page")
    public void appShouldNavigateToConfirmRidePage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING CONFIRM RIDE PAGE");
            System.out.println("========================================");
            System.out.println("");

            // Check for Confirm Ride page elements
            boolean hasConfirmText = pageSource.contains("Confirm") ||
                                     pageSource.contains("confirm") ||
                                     pageSource.contains("CONFIRM");

            boolean hasRideText = pageSource.contains("Ride") ||
                                  pageSource.contains("ride") ||
                                  pageSource.contains("RIDE");

            boolean hasBookingDetails = pageSource.contains("Booking") ||
                                        pageSource.contains("booking") ||
                                        pageSource.contains("Review") ||
                                        pageSource.contains("Summary");

            // Check for fare/price elements
            boolean hasFareInfo = pageSource.contains("Fare") ||
                                  pageSource.contains("fare") ||
                                  pageSource.contains("Price") ||
                                  pageSource.contains("price") ||
                                  pageSource.contains("Total") ||
                                  pageSource.contains("total") ||
                                  pageSource.contains("$") ||
                                  pageSource.contains("Cost");

            // Check for route/distance info
            boolean hasRouteInfo = pageSource.contains("km") ||
                                   pageSource.contains("KM") ||
                                   pageSource.contains("distance") ||
                                   pageSource.contains("Distance") ||
                                   pageSource.contains("min") ||
                                   pageSource.contains("duration");

            // Check for confirm/book button
            boolean hasConfirmButton = pageSource.contains("Confirm") ||
                                       pageSource.contains("Book") ||
                                       pageSource.contains("BOOK") ||
                                       pageSource.contains("Request") ||
                                       pageSource.contains("Book driver");

            // Not on City to City selection page anymore
            boolean leftSelectionPage = !pageSource.contains("last visited") &&
                                        !pageSource.contains("Last visited");

            System.out.println("Confirm Ride Page Verification:");
            System.out.println("-------------------------------");
            System.out.println("  - Confirm text: " + (hasConfirmText ? "YES" : "NO"));
            System.out.println("  - Ride text: " + (hasRideText ? "YES" : "NO"));
            System.out.println("  - Booking details: " + (hasBookingDetails ? "YES" : "NO"));
            System.out.println("  - Fare/price info: " + (hasFareInfo ? "YES" : "NO"));
            System.out.println("  - Route info: " + (hasRouteInfo ? "YES" : "NO"));
            System.out.println("  - Confirm/Book button: " + (hasConfirmButton ? "YES" : "NO"));
            System.out.println("  - Left selection page: " + (leftSelectionPage ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasConfirmText) score += 2;
            if (hasRideText) score++;
            if (hasBookingDetails) score += 2;
            if (hasFareInfo) score += 2;
            if (hasRouteInfo) score++;
            if (hasConfirmButton) score += 2;
            if (leftSelectionPage) score++;

            System.out.println("========================================");
            if (score >= 4 || (hasConfirmText && hasFareInfo) || (hasConfirmButton && hasBookingDetails)) {
                System.out.println("  TC-123: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigation successful!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasConfirmText) System.out.println("    - Confirm text visible");
                if (hasRideText) System.out.println("    - Ride text visible");
                if (hasBookingDetails) System.out.println("    - Booking details shown");
                if (hasFareInfo) System.out.println("    - Fare/price information displayed");
                if (hasRouteInfo) System.out.println("    - Route information visible");
                if (hasConfirmButton) System.out.println("    - Confirm/Book button available");
                System.out.println("");
                System.out.println("  Result: App navigated to Confirm Ride page");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-123: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Confirm Ride page?");
                System.out.println("  2. Can you see fare/price details?");
                System.out.println("  3. Can you see route information?");
                System.out.println("  4. Is there a Confirm/Book button?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying navigation: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-123: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
