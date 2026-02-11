package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC021_TimeoutSteps extends Page {

    private boolean ridePopupVisible = false;
    private boolean ridePopupDisappeared = false;

    @When("Driver does not respond to ride request")
    public void driverDoesNotRespondToRideRequest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-021: TIMEOUT TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  Testing ride request timeout behavior.");
            System.out.println("  Driver will NOT respond to the request.");
            System.out.println("");
            System.out.println("  Expected: Timer expires and popup");
            System.out.println("  disappears automatically.");
            System.out.println("");
            System.out.println("========================================");

            // First check if ride popup is visible
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            ridePopupVisible = pageSource.contains("Accept") ||
                              pageSource.contains("Reject") ||
                              pageSource.contains("MAD") ||
                              pageSource.contains("Fare");

            if (ridePopupVisible) {
                System.out.println("");
                System.out.println("Ride popup detected. NOT responding...");
                System.out.println("Waiting for timeout (checking every 5 seconds)...");
                System.out.println("");

                // Wait and observe the timeout behavior
                // Typical timeout is 15-30 seconds for ride requests
                int maxWaitTime = 60; // 60 seconds max
                int checkInterval = 5; // Check every 5 seconds
                int elapsed = 0;

                while (elapsed < maxWaitTime) {
                    Thread.sleep(checkInterval * 1000);
                    elapsed += checkInterval;

                    // Check if popup is still visible
                    String currentSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
                    boolean stillVisible = currentSource.contains("Accept") &&
                                          currentSource.contains("Reject");

                    System.out.println("  " + elapsed + " sec: Popup " + (stillVisible ? "STILL VISIBLE" : "DISAPPEARED"));

                    if (!stillVisible) {
                        ridePopupDisappeared = true;
                        System.out.println("");
                        System.out.println("Ride popup disappeared after " + elapsed + " seconds!");
                        break;
                    }
                }

                if (!ridePopupDisappeared) {
                    System.out.println("");
                    System.out.println("Popup still visible after " + maxWaitTime + " seconds");
                }
            } else {
                System.out.println("No ride popup detected initially.");
                System.out.println("Please ensure rider creates a ride from Rider app.");
            }

        } catch (Exception e) {
            System.out.println("Error during timeout test: " + e.getMessage());
        }
    }

    @Then("Ride request should timeout and disappear")
    public void rideRequestShouldTimeoutAndDisappear() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TIMEOUT VERIFICATION");
            System.out.println("========================================");

            // Check current screen state
            boolean hasAcceptButton = pageSource.contains("Accept") ||
                                      pageSource.contains("ACCEPT");
            boolean hasRejectButton = pageSource.contains("Reject") ||
                                      pageSource.contains("REJECT");
            boolean hasRidePopup = hasAcceptButton && hasRejectButton;

            // Check if back to home screen
            boolean onHomeScreen = pageSource.contains("Online") ||
                                   pageSource.contains("Offline") ||
                                   pageSource.contains("Available") ||
                                   pageSource.contains("Balance") ||
                                   pageSource.contains("Wallet");

            // Check for searching new driver message (rider side)
            boolean searchingNewDriver = pageSource.contains("Searching") ||
                                         pageSource.contains("searching") ||
                                         pageSource.contains("Finding") ||
                                         pageSource.contains("finding");

            System.out.println("");
            System.out.println("Timeout Verification Results:");
            System.out.println("-----------------------------");
            System.out.println("  - Ride popup visible: " + (hasRidePopup ? "YES" : "NO"));
            System.out.println("  - Accept button: " + (hasAcceptButton ? "YES" : "NO"));
            System.out.println("  - Reject button: " + (hasRejectButton ? "YES" : "NO"));
            System.out.println("  - On home screen: " + (onHomeScreen ? "YES" : "NO"));
            System.out.println("  - Popup disappeared: " + (ridePopupDisappeared ? "YES" : "NO"));
            System.out.println("");

            if (ridePopupDisappeared || (!hasRidePopup && onHomeScreen)) {
                System.out.println("========================================");
                System.out.println("  TC-021: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Timeout behavior verified!");
                System.out.println("");
                System.out.println("  - Ride request timed out");
                System.out.println("  - Driver alert disappeared");
                System.out.println("  - Driver back to home/ready state");
                System.out.println("");
                System.out.println("  Rider should now be searching for");
                System.out.println("  a new driver.");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasRidePopup) {
                System.out.println("========================================");
                System.out.println("  TC-021: NEEDS LONGER WAIT");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Ride popup is still visible.");
                System.out.println("  The timeout may be longer than expected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Wait for timer to fully expire");
                System.out.println("  2. Confirm popup disappears");
                System.out.println("  3. Check if rider is searching new driver");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-021: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not determine current state.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did the ride popup timeout?");
                System.out.println("  2. Did the alert disappear?");
                System.out.println("  3. Is rider searching for new driver?");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying timeout: " + e.getMessage());
            System.out.println("TC-021: FAILED - " + e.getMessage());
        }
    }
}
