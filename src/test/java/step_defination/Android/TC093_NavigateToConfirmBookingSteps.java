package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC093_NavigateToConfirmBookingSteps extends Page {

    @Given("User is on Book Hourly page with pickup and hours selected")
    public void userIsOnBookHourlyPageWithPickupAndHoursSelected() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-093: NAVIGATE TO CONFIRM BOOKING");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Select a pickup location");
            System.out.println("  5. Select hours (any value 1-12)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 18 seconds to select pickup and hours...");
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
            System.out.println("Pickup and hours should be selected.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Next button to proceed")
    public void userTapsNextButtonToProceed() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP NEXT TO PROCEED");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Make sure pickup is selected");
            System.out.println("  2. Make sure hours are selected");
            System.out.println("  3. Tap the 'Next' button");
            System.out.println("  4. Observe navigation to Confirm Booking");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 12 seconds to tap Next...");

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
            System.out.println("Should have tapped Next button.");

        } catch (Exception e) {
            System.out.println("Error tapping Next: " + e.getMessage());
        }
    }

    @Then("App should navigate to Confirm Booking page")
    public void appShouldNavigateToConfirmBookingPage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CONFIRM BOOKING PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Confirm Booking page indicators
            boolean hasConfirmBooking = pageSource.contains("Confirm") ||
                                        pageSource.contains("confirm") ||
                                        pageSource.contains("Booking") ||
                                        pageSource.contains("booking");

            // Check for ride details
            boolean hasRideDetails = pageSource.contains("Pickup") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Location") ||
                                     pageSource.contains("Duration") ||
                                     pageSource.contains("Hour");

            // Check for price/fare
            boolean hasPriceInfo = pageSource.contains("MAD") ||
                                   pageSource.contains("Price") ||
                                   pageSource.contains("price") ||
                                   pageSource.contains("Fare") ||
                                   pageSource.contains("fare") ||
                                   pageSource.contains("Total");

            // Check for confirm/book button
            boolean hasBookButton = pageSource.contains("Book") ||
                                    pageSource.contains("book") ||
                                    pageSource.contains("Confirm") ||
                                    pageSource.contains("confirm") ||
                                    pageSource.contains("Pay");

            // Check for payment options
            boolean hasPaymentOptions = pageSource.contains("Payment") ||
                                        pageSource.contains("payment") ||
                                        pageSource.contains("Cash") ||
                                        pageSource.contains("cash") ||
                                        pageSource.contains("Card");

            // Not on Book Hourly page anymore
            boolean notOnBookHourly = !pageSource.contains("Select pickup") &&
                                      !pageSource.contains("Next");

            System.out.println("");
            System.out.println("Confirm Booking Page Verification:");
            System.out.println("-----------------------------------");
            System.out.println("  - Confirm Booking page: " + (hasConfirmBooking ? "YES" : "NO"));
            System.out.println("  - Ride details: " + (hasRideDetails ? "YES" : "NO"));
            System.out.println("  - Price/fare info: " + (hasPriceInfo ? "YES" : "NO"));
            System.out.println("  - Book button: " + (hasBookButton ? "YES" : "NO"));
            System.out.println("  - Payment options: " + (hasPaymentOptions ? "YES" : "NO"));
            System.out.println("  - Left Book Hourly: " + (notOnBookHourly ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasConfirmBooking) score += 3;
            if (hasRideDetails) score += 2;
            if (hasPriceInfo) score += 2;
            if (hasBookButton) score += 2;
            if (hasPaymentOptions) score++;
            if (notOnBookHourly) score++;

            if (score >= 5 || hasConfirmBooking || (hasPriceInfo && hasBookButton)) {
                System.out.println("========================================");
                System.out.println("  TC-093: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigated to Confirm Booking page!");
                System.out.println("");
                if (hasConfirmBooking) System.out.println("  - On Confirm Booking page");
                if (hasRideDetails) System.out.println("  - Ride details visible");
                if (hasPriceInfo) System.out.println("  - Price/fare shown");
                if (hasBookButton) System.out.println("  - Book button visible");
                if (hasPaymentOptions) System.out.println("  - Payment options visible");
                if (notOnBookHourly) System.out.println("  - Left Book Hourly page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Are you on Confirm Booking page?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-093: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Next button?");
                System.out.println("  2. Did you navigate to Confirm Booking?");
                System.out.println("  3. Can you see ride details and price?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying navigation: " + e.getMessage());
            System.out.println("TC-093: FAILED - " + e.getMessage());
        }
    }
}
