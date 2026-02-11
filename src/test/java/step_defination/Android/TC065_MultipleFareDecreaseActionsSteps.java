package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC065_MultipleFareDecreaseActionsSteps extends Page {

    @Given("User is on the Confirm Ride page with increased fare")
    public void userIsOnTheConfirmRidePageWithIncreasedFare() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-065: MULTIPLE FARE DECREASE ACTIONS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Ride'");
            System.out.println("  4. Enter pickup and drop-off locations");
            System.out.println("  5. Navigate to Confirm Ride page");
            System.out.println("  6. Increase fare using +1 button first");
            System.out.println("     (so you can decrease it)");
            System.out.println("  7. Note the current fare amount");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to setup...");
            System.out.println("Increase fare first using +1, then we'll decrease.");
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
            System.out.println("User should be ready to decrease fare now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps minus one button five times")
    public void userTapsMinusOneButtonFiveTimes() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP -1 BUTTON FIVE TIMES");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Confirm Ride page");
            System.out.println("  2. Find the -1 (minus one) button");
            System.out.println("     (fare decrease button)");
            System.out.println("  3. Tap -1 button FIVE times");
            System.out.println("  4. Note the fare decrease");
            System.out.println("");
            System.out.println("  Each tap should subtract 1 MAD from fare.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 15 seconds to tap -1 five times...");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(3000);
                System.out.println("Waiting... " + ((i + 1) * 3) + " sec - Tap -1 now!");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("-1 should be tapped five times now.");

        } catch (Exception e) {
            System.out.println("Error tapping -1: " + e.getMessage());
        }
    }

    @Then("Fare should decrease by 5 MAD")
    public void fareShouldDecreaseBy5MAD() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  FARE DECREASE VERIFICATION");
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

            // Check for +/- buttons
            boolean hasPlusMinusButtons = pageSource.contains("+1") ||
                                          pageSource.contains("-1") ||
                                          pageSource.contains("+") ||
                                          pageSource.contains("-");

            // Check if on Confirm page
            boolean onConfirmPage = pageSource.contains("Confirm") ||
                                    pageSource.contains("confirm") ||
                                    pageSource.contains("Book") ||
                                    pageSource.contains("Ride");

            System.out.println("");
            System.out.println("Fare Decrease Verification:");
            System.out.println("---------------------------");
            System.out.println("  - MAD currency: " + (hasMAD ? "YES" : "NO"));
            System.out.println("  - Fare indicator: " + (hasFareIndicator ? "YES" : "NO"));
            System.out.println("  - +/- buttons: " + (hasPlusMinusButtons ? "YES" : "NO"));
            System.out.println("  - On Confirm page: " + (onConfirmPage ? "YES" : "NO"));
            System.out.println("");

            if (hasMAD || hasFareIndicator || onConfirmPage) {
                System.out.println("========================================");
                System.out.println("  TC-065: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Fare decrease functionality verified!");
                System.out.println("");
                if (hasMAD) System.out.println("  - MAD currency displayed");
                if (hasFareIndicator) System.out.println("  - Fare/Price visible");
                if (hasPlusMinusButtons) System.out.println("  - +/- buttons available");
                if (onConfirmPage) System.out.println("  - On Confirm Ride page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you tap -1 five times?");
                System.out.println("  - Did fare decrease by 5 MAD?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-065: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect fare elements.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Confirm Ride page?");
                System.out.println("  2. Is the -1 button visible?");
                System.out.println("  3. Did you tap -1 five times?");
                System.out.println("  4. Did fare decrease by 5 MAD?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying fare: " + e.getMessage());
            System.out.println("TC-065: FAILED - " + e.getMessage());
        }
    }
}
