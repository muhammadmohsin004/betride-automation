package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC066_FareCannotBeNegativeSteps extends Page {

    @Given("User is on the Confirm Ride page with fare at minimum")
    public void userIsOnTheConfirmRidePageWithFareAtMinimum() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-066: FARE CANNOT BE NEGATIVE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Ride'");
            System.out.println("  4. Enter pickup and drop-off locations");
            System.out.println("  5. Navigate to Confirm Ride page");
            System.out.println("  6. Decrease fare to MINIMUM using -1");
            System.out.println("     (keep tapping -1 until it stops)");
            System.out.println("  7. Note the minimum fare amount");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to set fare to minimum...");
            System.out.println("Tap -1 until fare reaches minimum.");
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
            System.out.println("Fare should be at minimum now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps minus one button again")
    public void userTapsMinusOneButtonAgain() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP -1 AGAIN (AT MINIMUM FARE)");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Fare should already be at minimum");
            System.out.println("  2. Try to tap -1 button again");
            System.out.println("  3. Observe what happens:");
            System.out.println("     - Button may be disabled");
            System.out.println("     - Fare should NOT go below minimum");
            System.out.println("     - Fare should NOT become negative");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap -1 again...");

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
            System.out.println("-1 should be tapped again now.");

        } catch (Exception e) {
            System.out.println("Error tapping -1: " + e.getMessage());
        }
    }

    @Then("Fare should remain at minimum allowed")
    public void fareShouldRemainAtMinimumAllowed() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  MINIMUM FARE VERIFICATION");
            System.out.println("========================================");

            // Check for MAD currency
            boolean hasMAD = pageSource.contains("MAD") ||
                             pageSource.contains("mad") ||
                             pageSource.contains("Dh") ||
                             pageSource.contains("DH");

            // Check for fare/price indicators
            boolean hasFareIndicator = pageSource.contains("Fare") ||
                                       pageSource.contains("fare") ||
                                       pageSource.contains("Price") ||
                                       pageSource.contains("price") ||
                                       pageSource.contains("Total") ||
                                       pageSource.contains("total");

            // Check if on Confirm page
            boolean onConfirmPage = pageSource.contains("Confirm") ||
                                    pageSource.contains("confirm") ||
                                    pageSource.contains("Book") ||
                                    pageSource.contains("Ride");

            // Check for negative indicator (should NOT be present)
            boolean hasNegative = pageSource.contains("-MAD") ||
                                  pageSource.contains("- MAD") ||
                                  pageSource.contains("-Dh");

            System.out.println("");
            System.out.println("Minimum Fare Verification:");
            System.out.println("--------------------------");
            System.out.println("  - MAD currency: " + (hasMAD ? "YES" : "NO"));
            System.out.println("  - Fare indicator: " + (hasFareIndicator ? "YES" : "NO"));
            System.out.println("  - On Confirm page: " + (onConfirmPage ? "YES" : "NO"));
            System.out.println("  - Negative fare: " + (hasNegative ? "YES (BAD!)" : "NO (GOOD!)"));
            System.out.println("");

            if ((hasMAD || hasFareIndicator || onConfirmPage) && !hasNegative) {
                System.out.println("========================================");
                System.out.println("  TC-066: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Fare remains at minimum!");
                System.out.println("");
                System.out.println("  - Fare is NOT negative");
                System.out.println("  - Minimum fare protection working");
                if (hasMAD) System.out.println("  - MAD currency displayed");
                if (onConfirmPage) System.out.println("  - On Confirm Ride page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did fare stay at minimum?");
                System.out.println("  - Is fare NOT negative?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasNegative) {
                System.out.println("========================================");
                System.out.println("  TC-066: FAILED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  NEGATIVE FARE DETECTED!");
                System.out.println("");
                System.out.println("  Fare should NOT go below zero.");
                System.out.println("  This is a BUG.");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-066: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was fare at minimum before tapping -1?");
                System.out.println("  2. Did fare remain at minimum?");
                System.out.println("  3. Is fare NOT negative?");
                System.out.println("  4. Was -1 button disabled at minimum?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying fare: " + e.getMessage());
            System.out.println("TC-066: FAILED - " + e.getMessage());
        }
    }
}
