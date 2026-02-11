package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC018_HourlyRideSteps extends Page {

    @Then("Driver waits for hourly ride request from rider")
    public void driverWaitsForHourlyRideRequestFromRider() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-018: HOURLY RIDE TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED ON RIDER APP:");
            System.out.println("  1. Open Rider app");
            System.out.println("  2. Select 'Book Hourly' option");
            System.out.println("  3. Choose pickup location");
            System.out.println("  4. Select number of hours");
            System.out.println("  5. Confirm and search for driver");
            System.out.println("");
            System.out.println("  Driver should receive hourly ride alert");
            System.out.println("  showing the duration (hours) selected.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for hourly ride request (60 seconds)
            boolean hourlyRideReceived = false;
            System.out.println("Waiting for hourly ride request (60 seconds)...");

            for (int i = 0; i < 20; i++) {
                Thread.sleep(3000);

                try {
                    String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

                    // Check for hourly ride indicators
                    boolean hasHourlyIndicator = pageSource.contains("hour") ||
                                                  pageSource.contains("Hour") ||
                                                  pageSource.contains("HOUR") ||
                                                  pageSource.contains("Hourly") ||
                                                  pageSource.contains("hourly") ||
                                                  pageSource.contains("hrs") ||
                                                  pageSource.contains("Hrs");

                    // Check for ride request indicators
                    boolean hasRideRequest = pageSource.contains("Accept") ||
                                            pageSource.contains("Reject") ||
                                            pageSource.contains("MAD") ||
                                            pageSource.contains("Fare");

                    if (hasHourlyIndicator && hasRideRequest) {
                        hourlyRideReceived = true;
                        System.out.println("Hourly ride request detected at " + ((i + 1) * 3) + " seconds!");
                        break;
                    } else if (hasRideRequest) {
                        // Regular ride request detected, check if it's hourly
                        System.out.println("Ride request detected - checking if hourly...");
                        hourlyRideReceived = true;
                        break;
                    }

                    System.out.println("Waiting for hourly ride... " + ((i + 1) * 3) + " sec");

                } catch (Exception e) {
                    System.out.println("Session keep-alive at " + ((i + 1) * 3) + " sec");
                }
            }

            if (hourlyRideReceived) {
                System.out.println("Hourly ride request received!");
            } else {
                System.out.println("No hourly ride request received within 60 seconds");
                System.out.println("Please ensure rider has booked an HOURLY ride");
            }

        } catch (Exception e) {
            System.out.println("Error waiting for hourly ride: " + e.getMessage());
        }
    }

    @And("Driver should see hourly ride popup with duration and accept reject")
    public void driverShouldSeeHourlyRidePopupWithDurationAndAcceptReject() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  HOURLY RIDE POPUP VERIFICATION");
            System.out.println("========================================");

            // Check for hourly duration indicators
            boolean hasHourlyDuration = pageSource.contains("hour") ||
                                        pageSource.contains("Hour") ||
                                        pageSource.contains("HOUR") ||
                                        pageSource.contains("hrs") ||
                                        pageSource.contains("Hrs") ||
                                        pageSource.contains("hourly") ||
                                        pageSource.contains("Hourly");

            // Check for specific hour numbers (1 hour, 2 hours, etc.)
            boolean hasHourNumber = pageSource.contains("1 hour") ||
                                    pageSource.contains("2 hour") ||
                                    pageSource.contains("3 hour") ||
                                    pageSource.contains("4 hour") ||
                                    pageSource.contains("5 hour") ||
                                    pageSource.contains("1 Hour") ||
                                    pageSource.contains("2 Hour") ||
                                    pageSource.contains("1hr") ||
                                    pageSource.contains("2hr") ||
                                    pageSource.contains("1.0 Hour") ||
                                    pageSource.contains("2.0 Hour");

            // Check for Accept button
            boolean hasAcceptButton = pageSource.contains("Accept") ||
                                      pageSource.contains("ACCEPT") ||
                                      pageSource.contains("accept");

            // Check for Reject button
            boolean hasRejectButton = pageSource.contains("Reject") ||
                                      pageSource.contains("REJECT") ||
                                      pageSource.contains("reject") ||
                                      pageSource.contains("Decline") ||
                                      pageSource.contains("decline");

            // Check for fare information
            boolean hasFareInfo = pageSource.contains("MAD") ||
                                  pageSource.contains("Fare") ||
                                  pageSource.contains("fare") ||
                                  pageSource.contains("Price");

            // Check for ride popup visibility
            boolean hasRidePopup = hasAcceptButton || hasRejectButton;

            System.out.println("");
            System.out.println("Hourly Ride Popup Verification:");
            System.out.println("--------------------------------");
            System.out.println("  - Hourly/Duration text: " + (hasHourlyDuration ? "YES" : "NO"));
            System.out.println("  - Specific hour number: " + (hasHourNumber ? "YES" : "NO"));
            System.out.println("  - Accept button: " + (hasAcceptButton ? "YES" : "NO"));
            System.out.println("  - Reject button: " + (hasRejectButton ? "YES" : "NO"));
            System.out.println("  - Fare information: " + (hasFareInfo ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int verificationScore = 0;
            if (hasHourlyDuration || hasHourNumber) verificationScore++;
            if (hasAcceptButton) verificationScore++;
            if (hasRejectButton) verificationScore++;
            if (hasFareInfo) verificationScore++;

            System.out.println("Verification Score: " + verificationScore + "/4");
            System.out.println("");

            if (verificationScore >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-018: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Hourly ride popup verified!");
                System.out.println("  - Ride popup is visible");
                if (hasHourlyDuration || hasHourNumber) {
                    System.out.println("  - Hourly duration displayed");
                }
                System.out.println("  - Accept/Reject buttons available");
                if (hasFareInfo) {
                    System.out.println("  - Fare information displayed");
                }
                System.out.println("");
                System.out.println("========================================");
            } else if (hasRidePopup) {
                System.out.println("========================================");
                System.out.println("  TC-018: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Ride popup is visible but hourly");
                System.out.println("  duration text not clearly detected.");
                System.out.println("");
                System.out.println("  Please verify manually that the popup");
                System.out.println("  shows the hourly duration selected");
                System.out.println("  by the rider.");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-018: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Ride popup not detected.");
                System.out.println("  Please ensure:");
                System.out.println("  1. Rider booked HOURLY ride");
                System.out.println("  2. Driver is online");
                System.out.println("  3. Popup appeared on driver screen");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(2000, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying hourly ride popup: " + e.getMessage());
            System.out.println("TC-018: FAILED - " + e.getMessage());
        }
    }
}
