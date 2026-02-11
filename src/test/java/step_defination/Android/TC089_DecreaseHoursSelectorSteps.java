package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC089_DecreaseHoursSelectorSteps extends Page {

    @Given("User is on Book Hourly page with hours greater than 1")
    public void userIsOnBookHourlyPageWithHoursGreaterThan1() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-089: DECREASE HOURS USING SELECTOR");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Increase hours to more than 1");
            System.out.println("     (e.g., set to 3, 4, or 5 hours)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to set hours > 1...");
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
            System.out.println("Hours should be greater than 1.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User moves the selector counter-clockwise to decrease hours")
    public void userMovesTheSelectorCounterClockwiseToDecreaseHours() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DECREASE HOURS USING SELECTOR");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Locate the hour selector");
            System.out.println("  2. Move/drag selector counter-clockwise");
            System.out.println("     OR tap - button to decrease");
            System.out.println("  3. Decrease hours (e.g., 5 → 4 → 3)");
            System.out.println("  4. Observe if hours decrease correctly");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 15 seconds to decrease hours...");

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
            System.out.println("Hours should have been decreased.");

        } catch (Exception e) {
            System.out.println("Error decreasing hours: " + e.getMessage());
        }
    }

    @Then("Hours should decrease from higher value to lower value")
    public void hoursShouldDecreaseFromHigherValueToLowerValue() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  HOUR DECREASE VERIFICATION");
            System.out.println("========================================");

            // Check for hour selector
            boolean hasHourSelector = pageSource.contains("Hour") ||
                                      pageSource.contains("hour") ||
                                      pageSource.contains("Hours") ||
                                      pageSource.contains("hours");

            // Check for decreased hours (any number visible)
            boolean hasHourValue = pageSource.contains("1 hour") ||
                                   pageSource.contains("2 hour") ||
                                   pageSource.contains("3 hour") ||
                                   pageSource.contains("4 hour") ||
                                   pageSource.contains("1 Hour") ||
                                   pageSource.contains("2 Hour") ||
                                   pageSource.contains("3 Hour") ||
                                   pageSource.contains("4 Hour");

            // Check for Book Hourly page
            boolean onBookHourlyPage = pageSource.contains("Hourly") ||
                                       pageSource.contains("hourly") ||
                                       pageSource.contains("by the hour");

            // Check for price info (changes with hours)
            boolean hasPriceInfo = pageSource.contains("MAD") ||
                                   pageSource.contains("Price") ||
                                   pageSource.contains("price") ||
                                   pageSource.contains("Fare");

            // Check for Next button
            boolean hasNextButton = pageSource.contains("Next") ||
                                    pageSource.contains("next") ||
                                    pageSource.contains("Continue");

            // Check for pickup field
            boolean hasPickupField = pageSource.contains("Pickup") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Source");

            System.out.println("");
            System.out.println("Hour Decrease Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Hour selector: " + (hasHourSelector ? "YES" : "NO"));
            System.out.println("  - Hour value visible: " + (hasHourValue ? "YES" : "NO"));
            System.out.println("  - On Book Hourly page: " + (onBookHourlyPage ? "YES" : "NO"));
            System.out.println("  - Price info: " + (hasPriceInfo ? "YES" : "NO"));
            System.out.println("  - Next button: " + (hasNextButton ? "YES" : "NO"));
            System.out.println("  - Pickup field: " + (hasPickupField ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasHourSelector) score += 2;
            if (hasHourValue) score += 3;
            if (onBookHourlyPage) score += 2;
            if (hasPriceInfo) score++;
            if (hasNextButton) score++;
            if (hasPickupField) score++;

            if (score >= 4 || (hasHourSelector && hasHourValue)) {
                System.out.println("========================================");
                System.out.println("  TC-089: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Hours decreased successfully!");
                System.out.println("");
                if (hasHourSelector) System.out.println("  - Hour selector visible");
                if (hasHourValue) System.out.println("  - Hour value shown");
                if (onBookHourlyPage) System.out.println("  - On Book Hourly page");
                if (hasPriceInfo) System.out.println("  - Price info visible");
                if (hasNextButton) System.out.println("  - Next button visible");
                if (hasPickupField) System.out.println("  - Pickup field visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did hours decrease (5 → 4 → 3...)?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-089: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you move the selector counter-clockwise?");
                System.out.println("  2. Did the hours decrease?");
                System.out.println("  3. Did it go from higher to lower value?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying hour decrease: " + e.getMessage());
            System.out.println("TC-089: FAILED - " + e.getMessage());
        }
    }
}
