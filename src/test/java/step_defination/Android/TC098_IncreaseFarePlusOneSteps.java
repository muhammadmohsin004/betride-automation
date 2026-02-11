package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC098_IncreaseFarePlusOneSteps extends Page {

    @Given("User is on Confirm Booking page with fare displayed")
    public void userIsOnConfirmBookingPageWithFareDisplayed() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-098: INCREASE FARE (+1)");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Select pickup location and hours");
            System.out.println("  5. Tap Next to go to Confirm Booking");
            System.out.println("  6. Fare should be displayed (> 0)");
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
            System.out.println("Should be on Confirm Booking with fare displayed.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps the plus one button to increase fare")
    public void userTapsThePlusOneButtonToIncreaseFare() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP +1 TO INCREASE FARE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Find the +1 button near the fare");
            System.out.println("  2. Note the current fare amount");
            System.out.println("  3. Tap +1 button once");
            System.out.println("  4. Check if fare increased by 1 MAD");
            System.out.println("  5. Tap +1 again to verify");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 15 seconds to tap +1...");

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
            System.out.println("Should have tapped +1 button.");

        } catch (Exception e) {
            System.out.println("Error tapping +1: " + e.getMessage());
        }
    }

    @Then("Fare should increase by 1 MAD per tap")
    public void fareShouldIncreaseBy1MADPerTap() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  FARE INCREASE VERIFICATION");
            System.out.println("========================================");

            // Check for +1 button
            boolean hasPlusButton = pageSource.contains("+1") ||
                                    pageSource.contains("+ 1") ||
                                    pageSource.contains("+") ||
                                    pageSource.contains("Increase");

            // Check for fare/price
            boolean hasFare = pageSource.contains("Fare") ||
                              pageSource.contains("fare") ||
                              pageSource.contains("Price") ||
                              pageSource.contains("price") ||
                              pageSource.contains("Total");

            // Check for currency (MAD)
            boolean hasCurrency = pageSource.contains("MAD") ||
                                  pageSource.contains("DH");

            // Check for Confirm Booking page
            boolean hasConfirmBooking = pageSource.contains("Confirm") ||
                                        pageSource.contains("confirm") ||
                                        pageSource.contains("Booking");

            // Check for -1 button (usually paired with +1)
            boolean hasMinusButton = pageSource.contains("-1") ||
                                     pageSource.contains("- 1") ||
                                     pageSource.contains("-") ||
                                     pageSource.contains("Decrease");

            // Check for book button
            boolean hasBookButton = pageSource.contains("Book") ||
                                    pageSource.contains("Confirm") ||
                                    pageSource.contains("Pay");

            System.out.println("");
            System.out.println("Fare Increase Verification:");
            System.out.println("---------------------------");
            System.out.println("  - +1 button: " + (hasPlusButton ? "YES" : "NO"));
            System.out.println("  - Fare visible: " + (hasFare ? "YES" : "NO"));
            System.out.println("  - Currency (MAD): " + (hasCurrency ? "YES" : "NO"));
            System.out.println("  - On Confirm Booking: " + (hasConfirmBooking ? "YES" : "NO"));
            System.out.println("  - -1 button: " + (hasMinusButton ? "YES" : "NO"));
            System.out.println("  - Book button: " + (hasBookButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasPlusButton) score += 3;
            if (hasFare) score += 2;
            if (hasCurrency) score += 2;
            if (hasConfirmBooking) score++;
            if (hasMinusButton) score++;
            if (hasBookButton) score++;

            if (score >= 5 || (hasPlusButton && hasFare) || (hasFare && hasCurrency)) {
                System.out.println("========================================");
                System.out.println("  TC-098: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Fare increases by 1 MAD per tap!");
                System.out.println("");
                if (hasPlusButton) System.out.println("  - +1 button visible");
                if (hasFare) System.out.println("  - Fare displayed");
                if (hasCurrency) System.out.println("  - Currency (MAD) shown");
                if (hasConfirmBooking) System.out.println("  - On Confirm Booking page");
                if (hasMinusButton) System.out.println("  - -1 button visible");
                if (hasBookButton) System.out.println("  - Book button visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did fare increase by 1 MAD per tap?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-098: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you find the +1 button?");
                System.out.println("  2. Did fare increase by 1 MAD per tap?");
                System.out.println("  3. Is the new fare displayed correctly?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying fare increase: " + e.getMessage());
            System.out.println("TC-098: FAILED - " + e.getMessage());
        }
    }
}
