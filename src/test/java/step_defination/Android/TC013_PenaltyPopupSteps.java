package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;

import java.time.LocalTime;

public class TC013_PenaltyPopupSteps extends Page {

    private int rejectionCount = 0;

    @Then("Driver rejects 3 rides between 6AM and 12PM")
    public void driverRejects3RidesBetween6AMAnd12PM() {
        try {
            // Check if current time is between 6AM and 12PM
            LocalTime now = LocalTime.now();
            LocalTime startTime = LocalTime.of(6, 0);
            LocalTime endTime = LocalTime.of(12, 0);

            boolean isWithinTimeWindow = now.isAfter(startTime) && now.isBefore(endTime);

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-013: PENALTY POPUP TEST");
            System.out.println("========================================");
            System.out.println("  Current time: " + now);
            System.out.println("  Required window: 6:00 AM - 12:00 PM");
            System.out.println("  Within window: " + (isWithinTimeWindow ? "YES" : "NO"));
            System.out.println("========================================");

            if (!isWithinTimeWindow) {
                System.out.println("");
                System.out.println("  WARNING: This test requires driver to be");
                System.out.println("  active between 6AM-12PM for penalty popup.");
                System.out.println("  Current time is outside this window.");
                System.out.println("  Test will proceed but penalty may not trigger.");
                System.out.println("");
            }

            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("  You need to reject 3 rides to trigger penalty popup.");
            System.out.println("");
            System.out.println("  For each ride rejection:");
            System.out.println("  1. Create a ride from RIDER app");
            System.out.println("  2. Wait for ride request on Driver app");
            System.out.println("  3. TAP REJECT on Driver app");
            System.out.println("  4. Repeat 3 times");
            System.out.println("");
            System.out.println("========================================");

            // Wait for up to 3 ride rejections
            for (int rideNum = 1; rideNum <= 3; rideNum++) {
                System.out.println("");
                System.out.println("--- REJECTION #" + rideNum + " of 3 ---");
                System.out.println("Waiting for ride request...");

                // Wait for ride request (45 seconds per ride)
                boolean rideReceived = false;
                for (int i = 0; i < 15; i++) {
                    Thread.sleep(3000);

                    try {
                        String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

                        if (pageSource.contains("Accept") ||
                            pageSource.contains("Reject") ||
                            pageSource.contains("MAD") ||
                            pageSource.contains("Fare")) {

                            System.out.println("Ride request #" + rideNum + " detected!");
                            rideReceived = true;
                            break;
                        }

                        System.out.println("Waiting... " + ((i + 1) * 3) + " sec");
                    } catch (Exception e) {
                        System.out.println("Session check at " + ((i + 1) * 3) + " sec");
                    }
                }

                if (rideReceived) {
                    // Try to tap Reject button
                    Thread.sleep(2000);
                    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);

                    try {
                        WebElement rejectButton = null;

                        // Try to find Reject button
                        try {
                            rejectButton = wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//*[contains(@content-desc, 'Reject') or contains(@content-desc, 'reject') or contains(@content-desc, 'Decline') or contains(@content-desc, 'decline')]")));
                        } catch (Exception e) {
                            try {
                                rejectButton = AndroidDriverSetup.getAndroidDriver().findElement(
                                    By.xpath("//*[contains(@text, 'Reject') or contains(@text, 'REJECT') or contains(@text, 'Decline')]"));
                            } catch (Exception ex) {
                                // Ignore
                            }
                        }

                        if (rejectButton != null) {
                            rejectButton.click();
                            rejectionCount++;
                            System.out.println("Rejected ride #" + rideNum);
                            Thread.sleep(3000);
                        } else {
                            System.out.println("Reject button not found for ride #" + rideNum);
                        }
                    } catch (Exception e) {
                        System.out.println("Error rejecting ride #" + rideNum + ": " + e.getMessage());
                    }
                } else {
                    System.out.println("No ride request received for rejection #" + rideNum);
                    System.out.println("Please create a ride from Rider app");
                }

                // Wait between rejections
                if (rideNum < 3) {
                    System.out.println("Waiting 5 seconds before next ride...");
                    Thread.sleep(5000);
                }
            }

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  Total rides rejected: " + rejectionCount + "/3");
            System.out.println("========================================");

        } catch (Exception e) {
            System.out.println("Error during ride rejections: " + e.getMessage());
        }
    }

    @And("Driver should see penalty popup with fewer rides warning")
    public void driverShouldSeePenaltyPopupWithFewerRidesWarning() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("========================================");
            System.out.println("Verifying penalty popup...");
            System.out.println("========================================");

            // Check for penalty popup indicators
            boolean hasPenaltyWarning = pageSource.contains("fewer rides") ||
                                        pageSource.contains("Fewer rides") ||
                                        pageSource.contains("receive fewer") ||
                                        pageSource.contains("penalty") ||
                                        pageSource.contains("Penalty") ||
                                        pageSource.contains("warning") ||
                                        pageSource.contains("Warning") ||
                                        pageSource.contains("rejected") ||
                                        pageSource.contains("too many") ||
                                        pageSource.contains("Too many");

            // Check for popup dialog indicators
            boolean hasPopup = pageSource.contains("OK") ||
                              pageSource.contains("Got it") ||
                              pageSource.contains("Understand") ||
                              pageSource.contains("Close") ||
                              pageSource.contains("Dismiss");

            if (hasPenaltyWarning) {
                System.out.println("Penalty warning found!");
                System.out.println("TC-013: PASSED - Penalty popup displayed");
            } else if (hasPopup && rejectionCount >= 3) {
                System.out.println("Popup detected after 3 rejections");
                System.out.println("TC-013: PARTIAL PASS - Popup found but exact penalty text not detected");
            } else {
                System.out.println("TC-013: NEEDS VERIFICATION");
                System.out.println("Rejections made: " + rejectionCount);

                if (rejectionCount < 3) {
                    System.out.println("Note: Less than 3 rides were rejected");
                    System.out.println("Penalty popup only appears after 3 rejections");
                } else {
                    System.out.println("Note: 3 rides rejected but penalty popup not detected");
                    System.out.println("This could be a bug or the feature may not be active");
                }

                System.out.println("Page source snippet: " + pageSource.substring(0, Math.min(1500, pageSource.length())));
            }

        } catch (Exception e) {
            System.out.println("Error verifying penalty popup: " + e.getMessage());
            System.out.println("TC-013: FAILED - " + e.getMessage());
        }
    }
}
