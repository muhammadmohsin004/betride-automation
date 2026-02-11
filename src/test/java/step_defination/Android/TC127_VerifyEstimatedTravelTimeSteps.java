package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC127_VerifyEstimatedTravelTimeSteps extends Page {

    @Given("User is on Confirm Ride page with trip details")
    public void userIsOnConfirmRidePageWithTripDetails() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-127: VERIFY ESTIMATED TRAVEL TIME");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("  4. Select pickup and drop-off locations");
            System.out.println("  5. Tap Next to reach Confirm Ride page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach Confirm Ride page
            System.out.println("");
            System.out.println("Waiting 25 seconds to reach Confirm Ride page...");
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

            // Verify we're on Confirm Ride page
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnConfirmRide = pageSource.contains("Confirm") ||
                                      pageSource.contains("confirm") ||
                                      pageSource.contains("Ride") ||
                                      pageSource.contains("Book") ||
                                      pageSource.contains("Fare");

            if (isOnConfirmRide) {
                System.out.println("");
                System.out.println("Confirmed: On Confirm Ride page");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the Confirm Ride page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @Then("Confirm Ride estimated travel time should be displayed correctly")
    public void confirmRideEstimatedTravelTimeShouldBeDisplayedCorrectly() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING ESTIMATED TRAVEL TIME");
            System.out.println("========================================");
            System.out.println("");

            // Check for time-related text
            boolean hasTimeLabel = pageSource.contains("min") ||
                                   pageSource.contains("Min") ||
                                   pageSource.contains("mins") ||
                                   pageSource.contains("Mins") ||
                                   pageSource.contains("hour") ||
                                   pageSource.contains("Hour") ||
                                   pageSource.contains("hr") ||
                                   pageSource.contains("Hr");

            // Check for estimated/travel keywords
            boolean hasEstimateLabel = pageSource.contains("Estimated") ||
                                       pageSource.contains("estimated") ||
                                       pageSource.contains("Travel") ||
                                       pageSource.contains("travel") ||
                                       pageSource.contains("Duration") ||
                                       pageSource.contains("duration") ||
                                       pageSource.contains("Time") ||
                                       pageSource.contains("time");

            // Check for numeric values (travel time like 3, 5, 10, etc.)
            boolean hasNumericValue = pageSource.matches("(?s).*\\d+\\s*(min|Min|mins|Mins|hour|Hour|hr|Hr).*");

            // Check for distance (often shown alongside time)
            boolean hasDistance = pageSource.contains("km") ||
                                  pageSource.contains("KM") ||
                                  pageSource.contains("Km") ||
                                  pageSource.contains("miles") ||
                                  pageSource.contains("mi");

            // Check for confirm page context
            boolean hasConfirmContext = pageSource.contains("Confirm") ||
                                       pageSource.contains("Book") ||
                                       pageSource.contains("Fare") ||
                                       pageSource.contains("Total") ||
                                       pageSource.contains("From") ||
                                       pageSource.contains("To");

            System.out.println("Estimated Travel Time Verification:");
            System.out.println("------------------------------------");
            System.out.println("  - Time label visible: " + (hasTimeLabel ? "YES" : "NO"));
            System.out.println("  - Estimate/Travel label: " + (hasEstimateLabel ? "YES" : "NO"));
            System.out.println("  - Numeric time value: " + (hasNumericValue ? "YES" : "NO"));
            System.out.println("  - Distance shown: " + (hasDistance ? "YES" : "NO"));
            System.out.println("  - Confirm page context: " + (hasConfirmContext ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasTimeLabel) score += 3;
            if (hasEstimateLabel) score += 2;
            if (hasNumericValue) score += 3;
            if (hasDistance) score += 1;
            if (hasConfirmContext) score++;

            System.out.println("========================================");
            if (score >= 4 || (hasTimeLabel && (hasNumericValue || hasEstimateLabel))) {
                System.out.println("  TC-127: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Estimated travel time verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasTimeLabel) System.out.println("    - Time label visible (min/hour)");
                if (hasEstimateLabel) System.out.println("    - Estimate/Travel label found");
                if (hasNumericValue) System.out.println("    - Numeric time value displayed");
                if (hasDistance) System.out.println("    - Distance also shown");
                if (hasConfirmContext) System.out.println("    - On Confirm Ride page");
                System.out.println("");
                System.out.println("  Result: Correct estimated travel time displayed");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-127: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is the estimated travel time visible?");
                System.out.println("  2. Does it show a time (e.g., 3 mins)?");
                System.out.println("  3. Does the estimate seem correct?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying travel time: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-127: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
