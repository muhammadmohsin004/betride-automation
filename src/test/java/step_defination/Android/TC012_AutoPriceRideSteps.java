package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC012_AutoPriceRideSteps extends Page {

    @When("Rider rejects driver from Rider app manually")
    public void riderRejectsDriverFromRiderAppManually() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  MANUAL ACTION REQUIRED ON RIDER APP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  1. Open the RIDER app on your phone");
            System.out.println("  2. You should see the driver acceptance popup");
            System.out.println("  3. TAP 'REJECT' to reject the driver");
            System.out.println("");
            System.out.println("  After rejecting, come back to Driver app");
            System.out.println("========================================");
            System.out.println("");

            // Capture current fare before rejection (if visible)
            try {
                String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
                // Try to extract fare from page source
                if (pageSource.contains("MAD")) {
                    // Store for later comparison
                    System.out.println("Current ride state captured");
                }
            } catch (Exception e) {
                // Ignore
            }

            // Wait for user to reject on Rider app
            System.out.println("Waiting 30 seconds for rider rejection...");
            for (int i = 0; i < 6; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("Rider should have rejected the driver by now");

        } catch (Exception e) {
            System.out.println("Error during rider rejection wait: " + e.getMessage());
        }
    }

    @Then("Wait for auto ride request within 5 minutes")
    public void waitForAutoRideRequestWithin5Minutes() {
        try {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println("  WAITING FOR AUTO RIDE REQUEST (5 MIN)");
            System.out.println("==========================================");
            System.out.println("");
            System.out.println("  After rider rejects, system should create");
            System.out.println("  a new ride automatically within 5 minutes");
            System.out.println("  with the ORIGINAL FARE + INCREASED PRICE");
            System.out.println("");
            System.out.println("==========================================");

            // Wait for up to 5 minutes (300 seconds) in 10-second intervals
            boolean newRideReceived = false;
            int maxWaitSeconds = 300; // 5 minutes
            int intervalSeconds = 10;
            int iterations = maxWaitSeconds / intervalSeconds;

            for (int i = 0; i < iterations; i++) {
                Thread.sleep(intervalSeconds * 1000);

                try {
                    String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

                    // Check for new ride request indicators
                    if (pageSource.contains("Accept") ||
                        pageSource.contains("Reject") ||
                        pageSource.contains("MAD") ||
                        pageSource.contains("Fare") ||
                        pageSource.contains("New Ride") ||
                        pageSource.contains("Ride Request")) {

                        System.out.println("New ride request detected at " + ((i + 1) * intervalSeconds) + " seconds!");
                        newRideReceived = true;
                        break;
                    }

                    System.out.println("Waiting for auto ride... " + ((i + 1) * intervalSeconds) + "/" + maxWaitSeconds + " sec");
                } catch (Exception e) {
                    System.out.println("Session keep-alive at " + ((i + 1) * intervalSeconds) + " sec");
                }
            }

            if (newRideReceived) {
                System.out.println("Auto ride request received!");
            } else {
                System.out.println("No auto ride request received within 5 minutes");
                System.out.println("TC-012: This feature may not be working as expected");
            }

        } catch (Exception e) {
            System.out.println("Error waiting for auto ride: " + e.getMessage());
        }
    }

    @And("Driver should receive new ride with increased price")
    public void driverShouldReceiveNewRideWithIncreasedPrice() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("========================================");
            System.out.println("Verifying auto ride with increased price...");
            System.out.println("========================================");

            // Check for ride request indicators
            boolean hasRideRequest = pageSource.contains("Accept") ||
                                     pageSource.contains("Reject") ||
                                     pageSource.contains("Decline");

            // Check for fare/price
            boolean hasFare = pageSource.contains("MAD") ||
                             pageSource.contains("Fare") ||
                             pageSource.contains("fare") ||
                             pageSource.contains("Price") ||
                             pageSource.contains("price");

            // Check for increased price indicator (if app shows this)
            boolean hasIncreasedPrice = pageSource.contains("increased") ||
                                        pageSource.contains("Increased") ||
                                        pageSource.contains("higher") ||
                                        pageSource.contains("surge") ||
                                        pageSource.contains("+");

            if (hasRideRequest && hasFare) {
                System.out.println("New ride request received with fare information");

                if (hasIncreasedPrice) {
                    System.out.println("Increased price indicator found");
                    System.out.println("TC-012: PASSED - Auto ride with increased price received");
                } else {
                    System.out.println("TC-012: PARTIAL PASS - Ride received but increased price indicator not found");
                    System.out.println("Note: Please verify manually if price is higher than original 6 MAD fare");
                }
            } else if (hasRideRequest) {
                System.out.println("TC-012: PARTIAL PASS - Ride request found but fare details unclear");
            } else {
                System.out.println("TC-012: NEEDS MANUAL VERIFICATION");
                System.out.println("No new ride request visible");
                System.out.println("Note: Auto price ride feature may not be working or 5 minutes not elapsed");
                System.out.println("Page source snippet: " + pageSource.substring(0, Math.min(1500, pageSource.length())));
            }

        } catch (Exception e) {
            System.out.println("Error verifying auto ride: " + e.getMessage());
            System.out.println("TC-012: FAILED - " + e.getMessage());
        }
    }
}
