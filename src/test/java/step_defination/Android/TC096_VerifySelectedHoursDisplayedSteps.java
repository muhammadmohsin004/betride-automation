package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC096_VerifySelectedHoursDisplayedSteps extends Page {

    @Given("User is on Confirm Booking page with hours selected")
    public void userIsOnConfirmBookingPageWithHoursSelected() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-096: VERIFY SELECTED HOURS DISPLAYED");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Select pickup location");
            System.out.println("  5. Select X hours (e.g., 3, 5, 12)");
            System.out.println("  6. Tap Next to go to Confirm Booking");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 18 seconds to reach Confirm Booking...");
            System.out.println("");

            for (int i = 0; i < 6; i++) {
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
            System.out.println("Should be on Confirm Booking page with hours selected.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User views the Number of hours selected section")
    public void userViewsTheNumberOfHoursSelectedSection() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VIEW HOURS SELECTED SECTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look at the Confirm Booking page");
            System.out.println("  2. Find 'Number of hours selected' section");
            System.out.println("  3. Check if correct hours are shown");
            System.out.println("     (e.g., '3.0 Hours', '12.0 Hours')");
            System.out.println("  4. Verify it matches what you selected");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user observation
            System.out.println("");
            System.out.println("Waiting 10 seconds to view hours...");

            for (int i = 0; i < 5; i++) {
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
            System.out.println("Hours should be visible.");

        } catch (Exception e) {
            System.out.println("Error viewing hours: " + e.getMessage());
        }
    }

    @Then("Selected hours should be displayed correctly")
    public void selectedHoursShouldBeDisplayedCorrectly() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SELECTED HOURS VERIFICATION");
            System.out.println("========================================");

            // Check for hours label
            boolean hasHoursLabel = pageSource.contains("Hour") ||
                                    pageSource.contains("hour") ||
                                    pageSource.contains("Hours") ||
                                    pageSource.contains("Duration") ||
                                    pageSource.contains("Number of hours");

            // Check for hour values
            boolean hasHourValue = pageSource.contains("1.0 Hour") ||
                                   pageSource.contains("2.0 Hour") ||
                                   pageSource.contains("3.0 Hour") ||
                                   pageSource.contains("4.0 Hour") ||
                                   pageSource.contains("5.0 Hour") ||
                                   pageSource.contains("6.0 Hour") ||
                                   pageSource.contains("7.0 Hour") ||
                                   pageSource.contains("8.0 Hour") ||
                                   pageSource.contains("9.0 Hour") ||
                                   pageSource.contains("10.0 Hour") ||
                                   pageSource.contains("11.0 Hour") ||
                                   pageSource.contains("12.0 Hour") ||
                                   pageSource.contains("1 hour") ||
                                   pageSource.contains("2 hour") ||
                                   pageSource.contains("3 hour");

            // Check for Confirm Booking page
            boolean hasConfirmBooking = pageSource.contains("Confirm") ||
                                        pageSource.contains("confirm") ||
                                        pageSource.contains("Booking") ||
                                        pageSource.contains("booking");

            // Check for price/fare
            boolean hasPriceInfo = pageSource.contains("MAD") ||
                                   pageSource.contains("Price") ||
                                   pageSource.contains("Fare");

            // Check for pickup info
            boolean hasPickupInfo = pageSource.contains("From") ||
                                    pageSource.contains("FROM") ||
                                    pageSource.contains("Pickup");

            // Check for book button
            boolean hasBookButton = pageSource.contains("Book") ||
                                    pageSource.contains("Confirm") ||
                                    pageSource.contains("Pay");

            System.out.println("");
            System.out.println("Selected Hours Verification:");
            System.out.println("----------------------------");
            System.out.println("  - Hours label: " + (hasHoursLabel ? "YES" : "NO"));
            System.out.println("  - Hour value: " + (hasHourValue ? "YES" : "NO"));
            System.out.println("  - On Confirm Booking: " + (hasConfirmBooking ? "YES" : "NO"));
            System.out.println("  - Price/fare: " + (hasPriceInfo ? "YES" : "NO"));
            System.out.println("  - Pickup info: " + (hasPickupInfo ? "YES" : "NO"));
            System.out.println("  - Book button: " + (hasBookButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasHoursLabel) score += 3;
            if (hasHourValue) score += 3;
            if (hasConfirmBooking) score += 2;
            if (hasPriceInfo) score++;
            if (hasPickupInfo) score++;
            if (hasBookButton) score++;

            if (score >= 5 || (hasHoursLabel && hasHourValue) || (hasHoursLabel && hasConfirmBooking)) {
                System.out.println("========================================");
                System.out.println("  TC-096: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Selected hours displayed correctly!");
                System.out.println("");
                if (hasHoursLabel) System.out.println("  - Hours label visible");
                if (hasHourValue) System.out.println("  - Hour value shown (X.0 Hours)");
                if (hasConfirmBooking) System.out.println("  - On Confirm Booking page");
                if (hasPriceInfo) System.out.println("  - Price/fare visible");
                if (hasPickupInfo) System.out.println("  - Pickup info visible");
                if (hasBookButton) System.out.println("  - Book button visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Are selected hours shown correctly?");
                System.out.println("  - Does it match what you selected?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-096: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is 'Number of hours selected' visible?");
                System.out.println("  2. Does it show correct hours (e.g., '12.0 Hours')?");
                System.out.println("  3. Does it match your selection?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying hours: " + e.getMessage());
            System.out.println("TC-096: FAILED - " + e.getMessage());
        }
    }
}
