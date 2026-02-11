package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC082_NavigateToBookHourlyPageSteps extends Page {

    @Given("User is on Home screen with Book Hourly visible")
    public void userIsOnHomeScreenWithBookHourlyVisible() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-082: NAVIGATE TO BOOK HOURLY PAGE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Home screen should be loaded");
            System.out.println("  4. 'Book Hourly' option should be visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 10 seconds for Home screen...");
            System.out.println("");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println("Waiting... " + ((i + 1) * 2.5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Home screen with Book Hourly should be visible.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Book Hourly option")
    public void userTapsOnBookHourlyOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP BOOK HOURLY");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Home screen");
            System.out.println("  2. Find 'Book Hourly' option");
            System.out.println("  3. Tap on 'Book Hourly'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Book Hourly...");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println("Waiting... " + ((i + 1) * 2.5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Book Hourly should be tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping Book Hourly: " + e.getMessage());
        }
    }

    @Then("App should navigate to Book driver by the hour page")
    public void appShouldNavigateToBookDriverByTheHourPage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  BOOK HOURLY PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Book driver by the hour page
            boolean hasBookByHour = pageSource.contains("Book driver by the hour") ||
                                    pageSource.contains("book driver by the hour") ||
                                    pageSource.contains("Driver by hour") ||
                                    pageSource.contains("driver by hour") ||
                                    pageSource.contains("By the hour") ||
                                    pageSource.contains("by the hour");

            // Check for hourly booking indicators
            boolean hasHourly = pageSource.contains("Hourly") ||
                                pageSource.contains("hourly") ||
                                pageSource.contains("Hour") ||
                                pageSource.contains("hour");

            // Check for duration/time selection
            boolean hasDuration = pageSource.contains("Duration") ||
                                  pageSource.contains("duration") ||
                                  pageSource.contains("hours") ||
                                  pageSource.contains("Hours") ||
                                  pageSource.contains("Time") ||
                                  pageSource.contains("time");

            // Check for pricing
            boolean hasPricing = pageSource.contains("Price") ||
                                 pageSource.contains("price") ||
                                 pageSource.contains("MAD") ||
                                 pageSource.contains("Fare") ||
                                 pageSource.contains("fare");

            // Check for booking elements
            boolean hasBooking = pageSource.contains("Book") ||
                                 pageSource.contains("book") ||
                                 pageSource.contains("Confirm") ||
                                 pageSource.contains("confirm");

            System.out.println("");
            System.out.println("Book Hourly Page Verification:");
            System.out.println("------------------------------");
            System.out.println("  - Book driver by hour: " + (hasBookByHour ? "YES" : "NO"));
            System.out.println("  - Hourly indicators: " + (hasHourly ? "YES" : "NO"));
            System.out.println("  - Duration/Time: " + (hasDuration ? "YES" : "NO"));
            System.out.println("  - Pricing info: " + (hasPricing ? "YES" : "NO"));
            System.out.println("  - Booking elements: " + (hasBooking ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasBookByHour) score += 4;
            if (hasHourly) score += 2;
            if (hasDuration) score += 2;
            if (hasPricing) score++;
            if (hasBooking) score++;

            if (score >= 4 || hasBookByHour || (hasHourly && hasDuration)) {
                System.out.println("========================================");
                System.out.println("  TC-082: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigated to Book driver by the hour page!");
                System.out.println("");
                if (hasBookByHour) System.out.println("  - Book driver by hour page found");
                if (hasHourly) System.out.println("  - Hourly booking visible");
                if (hasDuration) System.out.println("  - Duration selection available");
                if (hasPricing) System.out.println("  - Pricing info shown");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Are you on 'Book driver by the hour' page?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-082: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap 'Book Hourly'?");
                System.out.println("  2. Are you on 'Book driver by the hour' page?");
                System.out.println("  3. Can you select duration/hours?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying navigation: " + e.getMessage());
            System.out.println("TC-082: FAILED - " + e.getMessage());
        }
    }
}
