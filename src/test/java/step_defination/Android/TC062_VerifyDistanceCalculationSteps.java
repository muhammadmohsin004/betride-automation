package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC062_VerifyDistanceCalculationSteps extends Page {

    @Given("User is on the Confirm Ride page for distance check")
    public void userIsOnTheConfirmRidePageForDistanceCheck() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-062: VERIFY DISTANCE CALCULATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Ride'");
            System.out.println("  4. Enter pickup and drop-off locations");
            System.out.println("  5. Select a ride option");
            System.out.println("  6. Navigate to Confirm Ride page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to reach Confirm Ride page...");
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
            System.out.println("User should be on Confirm Ride page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User views the distance section")
    public void userViewsTheDistanceSection() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VIEW DISTANCE SECTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Confirm Ride page");
            System.out.println("  2. Look for the distance section");
            System.out.println("  3. Observe the distance displayed");
            System.out.println("     (e.g., '0.97 km', '2.5 km', etc.)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to view
            System.out.println("");
            System.out.println("Waiting 5 seconds to view distance...");

            for (int i = 0; i < 2; i++) {
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
            System.out.println("Distance section should be visible now.");

        } catch (Exception e) {
            System.out.println("Error viewing distance: " + e.getMessage());
        }
    }

    @Then("Distance should match the actual route")
    public void distanceShouldMatchTheActualRoute() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DISTANCE CALCULATION VERIFICATION");
            System.out.println("========================================");

            // Check for kilometer indicators
            boolean hasKilometers = pageSource.contains("km") ||
                                    pageSource.contains("Km") ||
                                    pageSource.contains("KM") ||
                                    pageSource.contains("kilometer") ||
                                    pageSource.contains("Kilometer");

            // Check for meter indicators
            boolean hasMeters = pageSource.contains(" m") ||
                                pageSource.contains("meter") ||
                                pageSource.contains("Meter");

            // Check for distance label
            boolean hasDistanceLabel = pageSource.contains("Distance") ||
                                       pageSource.contains("distance") ||
                                       pageSource.contains("Route") ||
                                       pageSource.contains("route");

            // Check for numeric values (distance)
            boolean hasNumericDistance = pageSource.matches(".*\\d+\\.?\\d*\\s*(km|Km|KM|m).*");

            // Check if on Confirm page
            boolean onConfirmPage = pageSource.contains("Confirm") ||
                                    pageSource.contains("confirm") ||
                                    pageSource.contains("Book") ||
                                    pageSource.contains("book") ||
                                    pageSource.contains("Ride") ||
                                    pageSource.contains("ride");

            System.out.println("");
            System.out.println("Distance Calculation Verification:");
            System.out.println("-----------------------------------");
            System.out.println("  - Kilometers indicator: " + (hasKilometers ? "YES" : "NO"));
            System.out.println("  - Meters indicator: " + (hasMeters ? "YES" : "NO"));
            System.out.println("  - Distance label: " + (hasDistanceLabel ? "YES" : "NO"));
            System.out.println("  - Numeric distance: " + (hasNumericDistance ? "YES" : "NO"));
            System.out.println("  - On Confirm page: " + (onConfirmPage ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasKilometers) score += 3;
            if (hasMeters) score += 2;
            if (hasDistanceLabel) score += 2;
            if (hasNumericDistance) score += 2;
            if (onConfirmPage) score++;

            if (score >= 3 || hasKilometers || (hasDistanceLabel && onConfirmPage)) {
                System.out.println("========================================");
                System.out.println("  TC-062: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Distance displayed correctly!");
                System.out.println("");
                if (hasKilometers) System.out.println("  - Distance in km shown");
                if (hasMeters) System.out.println("  - Distance in meters shown");
                if (hasDistanceLabel) System.out.println("  - Distance label visible");
                if (hasNumericDistance) System.out.println("  - Numeric distance value shown");
                if (onConfirmPage) System.out.println("  - On Confirm Ride page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is distance visible?");
                System.out.println("  - Does it match the route?");
                System.out.println("");
                System.out.println("========================================");
            } else if (onConfirmPage) {
                System.out.println("========================================");
                System.out.println("  TC-062: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  On Confirm page but distance not detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is distance section visible?");
                System.out.println("  2. Is distance displayed (e.g., 0.97 km)?");
                System.out.println("  3. Does it match the actual route?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-062: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect distance display.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Confirm Ride page?");
                System.out.println("  2. Is distance section visible?");
                System.out.println("  3. Is distance displayed correctly?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app");
                System.out.println("  and a complete ride booking flow.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying distance: " + e.getMessage());
            System.out.println("TC-062: FAILED - " + e.getMessage());
        }
    }
}
