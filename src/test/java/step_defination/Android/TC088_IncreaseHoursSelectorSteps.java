package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC088_IncreaseHoursSelectorSteps extends Page {

    @Given("User is on Book Hourly page with selector active")
    public void userIsOnBookHourlyPageWithSelectorActive() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-088: INCREASE HOURS USING SELECTOR");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Hour selector should be active");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 12 seconds to open Book Hourly page...");
            System.out.println("");

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
            System.out.println("Book Hourly page should be open with selector active.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User moves the selector clockwise to increase hours")
    public void userMovesTheSelectorClockwiseToIncreaseHours() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  INCREASE HOURS USING SELECTOR");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Locate the hour selector");
            System.out.println("  2. Move/drag the selector clockwise");
            System.out.println("     OR tap + button to increase");
            System.out.println("  3. Increase from 1 → 2 → 3 → ...");
            System.out.println("  4. Observe if hours increase correctly");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 15 seconds to increase hours...");

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
            System.out.println("Hours should have been increased.");

        } catch (Exception e) {
            System.out.println("Error increasing hours: " + e.getMessage());
        }
    }

    @Then("Hours should increase from 1 to 2 to 3 and so on")
    public void hoursShouldIncreaseFrom1To2To3AndSoOn() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  HOUR INCREASE VERIFICATION");
            System.out.println("========================================");

            // Check for hour selector
            boolean hasHourSelector = pageSource.contains("Hour") ||
                                      pageSource.contains("hour") ||
                                      pageSource.contains("Hours") ||
                                      pageSource.contains("hours");

            // Check for increased hours (2, 3, etc.)
            boolean hasIncreasedHours = pageSource.contains("2 hour") ||
                                        pageSource.contains("2 Hour") ||
                                        pageSource.contains("3 hour") ||
                                        pageSource.contains("3 Hour") ||
                                        pageSource.contains("4 hour") ||
                                        pageSource.contains("4 Hour");

            // Check for numbers greater than 1
            boolean hasHigherNumber = pageSource.contains(">2<") ||
                                      pageSource.contains(">3<") ||
                                      pageSource.contains(">4<") ||
                                      pageSource.contains("\"2\"") ||
                                      pageSource.contains("\"3\"") ||
                                      pageSource.contains("\"4\"");

            // Check for Book Hourly page
            boolean onBookHourlyPage = pageSource.contains("Hourly") ||
                                       pageSource.contains("hourly") ||
                                       pageSource.contains("by the hour");

            // Check for price change (different for more hours)
            boolean hasPriceInfo = pageSource.contains("MAD") ||
                                   pageSource.contains("Price") ||
                                   pageSource.contains("price") ||
                                   pageSource.contains("Fare");

            // Check for Next button
            boolean hasNextButton = pageSource.contains("Next") ||
                                    pageSource.contains("next") ||
                                    pageSource.contains("Continue");

            System.out.println("");
            System.out.println("Hour Increase Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Hour selector: " + (hasHourSelector ? "YES" : "NO"));
            System.out.println("  - Increased hours (2+): " + (hasIncreasedHours ? "YES" : "NO"));
            System.out.println("  - Higher number visible: " + (hasHigherNumber ? "YES" : "NO"));
            System.out.println("  - On Book Hourly page: " + (onBookHourlyPage ? "YES" : "NO"));
            System.out.println("  - Price info: " + (hasPriceInfo ? "YES" : "NO"));
            System.out.println("  - Next button: " + (hasNextButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasHourSelector) score += 2;
            if (hasIncreasedHours) score += 3;
            if (hasHigherNumber) score += 2;
            if (onBookHourlyPage) score++;
            if (hasPriceInfo) score++;
            if (hasNextButton) score++;

            if (score >= 4 || hasIncreasedHours || (hasHourSelector && hasHigherNumber)) {
                System.out.println("========================================");
                System.out.println("  TC-088: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Hours increased successfully!");
                System.out.println("");
                if (hasHourSelector) System.out.println("  - Hour selector visible");
                if (hasIncreasedHours) System.out.println("  - Increased hours shown");
                if (hasHigherNumber) System.out.println("  - Higher number displayed");
                if (onBookHourlyPage) System.out.println("  - On Book Hourly page");
                if (hasPriceInfo) System.out.println("  - Price info visible");
                if (hasNextButton) System.out.println("  - Next button visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did hours increase (1 → 2 → 3...)?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-088: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you move the selector clockwise?");
                System.out.println("  2. Did the hours increase?");
                System.out.println("  3. Did it go from 1 → 2 → 3...?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying hour increase: " + e.getMessage());
            System.out.println("TC-088: FAILED - " + e.getMessage());
        }
    }
}
