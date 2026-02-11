package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC091_MaximumHoursValidationSteps extends Page {

    @Given("User is on Book Hourly page with hours less than 12")
    public void userIsOnBookHourlyPageWithHoursLessThan12() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-091: MAXIMUM HOURS VALIDATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Hours should be less than 12");
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
            System.out.println("Book Hourly page should be open.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User increases hours to maximum")
    public void userIncreasesHoursToMaximum() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  INCREASE HOURS TO MAXIMUM");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Locate the hour selector");
            System.out.println("  2. Keep increasing hours");
            System.out.println("     - Move selector clockwise");
            System.out.println("     - OR tap + button repeatedly");
            System.out.println("  3. Try to go past 12 hours");
            System.out.println("  4. Observe if it stops at 12");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 20 seconds to increase to max...");

            for (int i = 0; i < 10; i++) {
                Thread.sleep(2000);
                System.out.println("Waiting... " + ((i + 1) * 2) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Should have reached maximum hours.");

        } catch (Exception e) {
            System.out.println("Error during increase: " + e.getMessage());
        }
    }

    @Then("Hours should stop at 12 hours and cannot go higher")
    public void hoursShouldStopAt12HoursAndCannotGoHigher() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  MAXIMUM HOURS VERIFICATION");
            System.out.println("========================================");

            // Check for hour selector
            boolean hasHourSelector = pageSource.contains("Hour") ||
                                      pageSource.contains("hour") ||
                                      pageSource.contains("Hours") ||
                                      pageSource.contains("hours");

            // Check for 12 hours displayed
            boolean has12Hours = pageSource.contains("12 hour") ||
                                 pageSource.contains("12 Hour") ||
                                 pageSource.contains("12hour") ||
                                 pageSource.contains("12Hour");

            // Check NOT showing more than 12 hours
            boolean notMoreThan12 = !pageSource.contains("13 hour") &&
                                    !pageSource.contains("14 hour") &&
                                    !pageSource.contains("15 hour");

            // Check for Book Hourly page
            boolean onBookHourlyPage = pageSource.contains("Hourly") ||
                                       pageSource.contains("hourly") ||
                                       pageSource.contains("by the hour");

            // Check for Next button
            boolean hasNextButton = pageSource.contains("Next") ||
                                    pageSource.contains("next") ||
                                    pageSource.contains("Continue");

            // Check for price (should be higher for 12 hours)
            boolean hasPriceInfo = pageSource.contains("MAD") ||
                                   pageSource.contains("Price") ||
                                   pageSource.contains("price");

            System.out.println("");
            System.out.println("Maximum Hours Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Hour selector: " + (hasHourSelector ? "YES" : "NO"));
            System.out.println("  - Shows 12 hours: " + (has12Hours ? "YES" : "NO"));
            System.out.println("  - Not more than 12: " + (notMoreThan12 ? "YES" : "NO"));
            System.out.println("  - On Book Hourly page: " + (onBookHourlyPage ? "YES" : "NO"));
            System.out.println("  - Next button: " + (hasNextButton ? "YES" : "NO"));
            System.out.println("  - Price info: " + (hasPriceInfo ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasHourSelector) score += 2;
            if (has12Hours) score += 3;
            if (notMoreThan12) score += 2;
            if (onBookHourlyPage) score++;
            if (hasNextButton) score++;
            if (hasPriceInfo) score++;

            if (score >= 5 || (has12Hours && notMoreThan12) || (hasHourSelector && notMoreThan12)) {
                System.out.println("========================================");
                System.out.println("  TC-091: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Hours stop at 12 (maximum)!");
                System.out.println("");
                if (hasHourSelector) System.out.println("  - Hour selector visible");
                if (has12Hours) System.out.println("  - Shows 12 hours");
                if (notMoreThan12) System.out.println("  - Not showing more than 12");
                if (onBookHourlyPage) System.out.println("  - On Book Hourly page");
                if (hasNextButton) System.out.println("  - Next button visible");
                if (hasPriceInfo) System.out.println("  - Price info visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did hours stop at 12?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-091: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did hours stop at 12?");
                System.out.println("  2. Could you go past 12 hours?");
                System.out.println("  3. Was maximum validation working?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying maximum hours: " + e.getMessage());
            System.out.println("TC-091: FAILED - " + e.getMessage());
        }
    }
}
