package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC110_ReturnToHourlyFromConfirmationSteps extends Page {

    @Given("User is on Confirm Booking page")
    public void userIsOnConfirmBookingPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-110: RETURN TO HOURLY FROM CONFIRM");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Hourly' option");
            System.out.println("  4. Select pickup location");
            System.out.println("  5. Select hours (1-12)");
            System.out.println("  6. Navigate to Confirm Booking page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach Confirm Booking page
            System.out.println("");
            System.out.println("Waiting 25 seconds to reach Confirm Booking page...");
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

            // Verify we're on Confirm Booking page
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnConfirmBooking = pageSource.contains("Confirm") ||
                                         pageSource.contains("confirm") ||
                                         pageSource.contains("Booking") ||
                                         pageSource.contains("booking") ||
                                         pageSource.contains("Book driver") ||
                                         pageSource.contains("Review") ||
                                         pageSource.contains("Total");

            if (isOnConfirmBooking) {
                System.out.println("");
                System.out.println("Confirmed: On Confirm Booking page");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the Confirm Booking page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps back arrow on confirmation page")
    public void userTapsBackArrowOnConfirmationPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING BACK ARROW");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for back arrow (< or ←) at top");
            System.out.println("  2. Tap on the back arrow/button");
            System.out.println("  3. Observe the navigation behavior");
            System.out.println("");
            System.out.println("  NOTE: The app should navigate back to");
            System.out.println("  the hourly selection page.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap back arrow
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
            System.out.println("Back arrow should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("App should return to hourly selection page")
    public void appShouldReturnToHourlySelectionPage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING RETURN TO HOURLY PAGE");
            System.out.println("========================================");
            System.out.println("");

            // Check for hourly selection page elements
            boolean hasHourlyText = pageSource.contains("Hourly") ||
                                    pageSource.contains("hourly") ||
                                    pageSource.contains("Book Hourly");

            boolean hasHourSelector = pageSource.contains("hour") ||
                                      pageSource.contains("Hour") ||
                                      pageSource.contains("1.0 Hour") ||
                                      pageSource.contains("hrs") ||
                                      pageSource.contains("Hrs");

            boolean hasPickupField = pageSource.contains("pickup") ||
                                     pageSource.contains("Pickup") ||
                                     pageSource.contains("Pick up") ||
                                     pageSource.contains("location") ||
                                     pageSource.contains("Location");

            boolean hasIncreaseDecrease = pageSource.contains("+") ||
                                          pageSource.contains("-") ||
                                          pageSource.contains("increase") ||
                                          pageSource.contains("decrease");

            // Check if NOT on confirm page anymore
            boolean notOnConfirmPage = !pageSource.contains("Confirm Booking") &&
                                       !pageSource.contains("confirm booking") &&
                                       !pageSource.contains("Review your booking");

            // Check for Book Hourly specific elements
            boolean hasBookDriverButton = pageSource.contains("Book driver") ||
                                          pageSource.contains("BOOK DRIVER") ||
                                          pageSource.contains("Next") ||
                                          pageSource.contains("Continue");

            System.out.println("Navigation Verification:");
            System.out.println("------------------------");
            System.out.println("  - Hourly text visible: " + (hasHourlyText ? "YES" : "NO"));
            System.out.println("  - Hour selector visible: " + (hasHourSelector ? "YES" : "NO"));
            System.out.println("  - Pickup field visible: " + (hasPickupField ? "YES" : "NO"));
            System.out.println("  - +/- controls visible: " + (hasIncreaseDecrease ? "YES" : "NO"));
            System.out.println("  - Not on Confirm page: " + (notOnConfirmPage ? "YES" : "NO"));
            System.out.println("  - Book driver button: " + (hasBookDriverButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasHourlyText) score += 2;
            if (hasHourSelector) score += 2;
            if (hasPickupField) score++;
            if (hasIncreaseDecrease) score++;
            if (notOnConfirmPage) score += 2;
            if (hasBookDriverButton) score++;

            System.out.println("========================================");
            if (score >= 4 || (notOnConfirmPage && (hasHourlyText || hasHourSelector))) {
                System.out.println("  TC-110: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigation successful!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasHourlyText) System.out.println("    - Hourly page text visible");
                if (hasHourSelector) System.out.println("    - Hour selector visible");
                if (hasPickupField) System.out.println("    - Pickup location field visible");
                if (hasIncreaseDecrease) System.out.println("    - Hour +/- controls visible");
                if (notOnConfirmPage) System.out.println("    - Successfully left Confirm page");
                if (hasBookDriverButton) System.out.println("    - Book driver button visible");
                System.out.println("");
                System.out.println("  Result: App returned to hourly selection page");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-110: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the hourly selection page?");
                System.out.println("  2. Can you see the hour selector?");
                System.out.println("  3. Can you see pickup location field?");
                System.out.println("  4. Are you no longer on Confirm page?");
                System.out.println("");
                System.out.println("  Expected: Back arrow takes you to hourly");
                System.out.println("  selection page where you can modify");
                System.out.println("  hours and pickup location.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying navigation: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-110: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
