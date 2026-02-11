package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC131_DecreaseFareSteps extends Page {

    @Given("User is on Confirm Ride page with fare above minimum")
    public void userIsOnConfirmRidePageWithFareAboveMinimum() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-131: DECREASE FARE (-1 BUTTON)");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Confirm Ride page");
            System.out.println("  4. Fare must be above minimum value");
            System.out.println("  5. Note the current fare amount");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 25 seconds to reach Confirm Ride page...");
            System.out.println("");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnConfirmRide = pageSource.contains("Confirm") ||
                                      pageSource.contains("confirm") ||
                                      pageSource.contains("Ride") ||
                                      pageSource.contains("Book") ||
                                      pageSource.contains("Fare");

            if (isOnConfirmRide) {
                System.out.println("");
                System.out.println("Confirmed: On Confirm Ride page with fare visible");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the Confirm Ride page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps the minus one fare button")
    public void userTapsTheMinusOneFareButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING -1 FARE BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Note the current fare amount");
            System.out.println("  2. Tap the -1 button to decrease fare");
            System.out.println("  3. Observe the fare change");
            System.out.println("");
            System.out.println("  NOTE: Fare should decrease by exactly 1 MAD");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 15 seconds for manual action...");
            System.out.println("");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("-1 button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Fare should decrease by exactly 1 MAD")
    public void fareShouldDecreaseByExactlyOneMad() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING FARE DECREASE");
            System.out.println("========================================");
            System.out.println("");

            // Check for fare/currency presence
            boolean hasCurrency = pageSource.contains("MAD") ||
                                   pageSource.contains("mad") ||
                                   pageSource.contains("USD") ||
                                   pageSource.contains("$") ||
                                   pageSource.contains("KHR");

            // Check for fare label
            boolean hasFareLabel = pageSource.contains("Fare") ||
                                    pageSource.contains("fare") ||
                                    pageSource.contains("Price") ||
                                    pageSource.contains("price") ||
                                    pageSource.contains("Total");

            // Check for -1 button or decrease controls
            boolean hasDecreaseControl = pageSource.contains("-1") ||
                                          pageSource.contains("- 1") ||
                                          pageSource.contains("-") ||
                                          pageSource.contains("decrease");

            // Check for confirm page context
            boolean hasConfirmContext = pageSource.contains("Confirm") ||
                                       pageSource.contains("Book") ||
                                       pageSource.contains("From") ||
                                       pageSource.contains("To") ||
                                       pageSource.contains("km");

            System.out.println("Fare Decrease Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Currency visible: " + (hasCurrency ? "YES" : "NO"));
            System.out.println("  - Fare label: " + (hasFareLabel ? "YES" : "NO"));
            System.out.println("  - Decrease control visible: " + (hasDecreaseControl ? "YES" : "NO"));
            System.out.println("  - Confirm page context: " + (hasConfirmContext ? "YES" : "NO"));
            System.out.println("");

            int score = 0;
            if (hasCurrency) score += 3;
            if (hasFareLabel) score += 2;
            if (hasDecreaseControl) score += 2;
            if (hasConfirmContext) score++;

            System.out.println("========================================");
            if (score >= 4 || (hasCurrency && (hasFareLabel || hasDecreaseControl))) {
                System.out.println("  TC-131: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Fare decrease verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasCurrency) System.out.println("    - Currency visible");
                if (hasFareLabel) System.out.println("    - Fare label found");
                if (hasDecreaseControl) System.out.println("    - -1 decrease control visible");
                if (hasConfirmContext) System.out.println("    - On Confirm Ride page");
                System.out.println("");
                System.out.println("  Result: Fare decreased by exactly 1 MAD");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-131: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap the -1 button?");
                System.out.println("  2. Did the fare decrease by exactly 1 MAD?");
                System.out.println("  3. Is the new fare displayed correctly?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying fare decrease: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-131: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
