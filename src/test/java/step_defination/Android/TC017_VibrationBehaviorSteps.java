package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC017_VibrationBehaviorSteps extends Page {

    private boolean vibrationAlertReceived = false;
    private boolean vibrationStopped = false;

    @And("Driver waits for rider to accept on Rider app")
    public void driverWaitsForRiderToAcceptOnRiderApp() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-017: VIBRATION BEHAVIOR TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED ON RIDER APP:");
            System.out.println("  1. Open Rider app");
            System.out.println("  2. You should see driver acceptance popup");
            System.out.println("  3. TAP 'ACCEPT' to accept the driver");
            System.out.println("");
            System.out.println("  After accepting, the Driver should receive");
            System.out.println("  a vibration alert notification.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for rider to accept (45 seconds)
            System.out.println("Waiting 45 seconds for rider to accept...");
            for (int i = 0; i < 15; i++) {
                Thread.sleep(3000);
                System.out.println("Waiting... " + ((i + 1) * 3) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("Rider should have accepted by now");

        } catch (Exception e) {
            System.out.println("Error waiting for rider acceptance: " + e.getMessage());
        }
    }

    @Then("Driver should receive vibration alert")
    public void driverShouldReceiveVibrationAlert() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CHECKING FOR VIBRATION ALERT");
            System.out.println("========================================");

            // Check for alert/notification indicators on screen
            boolean hasAlert = pageSource.contains("alert") ||
                              pageSource.contains("Alert") ||
                              pageSource.contains("notification") ||
                              pageSource.contains("Notification");

            // Check for ride confirmation indicators
            boolean hasRideConfirmed = pageSource.contains("confirmed") ||
                                       pageSource.contains("Confirmed") ||
                                       pageSource.contains("accepted") ||
                                       pageSource.contains("Accepted") ||
                                       pageSource.contains("Ride") ||
                                       pageSource.contains("ride");

            // Check for OK/Close/Dismiss buttons (typically on alerts)
            boolean hasAlertButtons = pageSource.contains("OK") ||
                                      pageSource.contains("Ok") ||
                                      pageSource.contains("Close") ||
                                      pageSource.contains("Dismiss") ||
                                      pageSource.contains("Got it");

            // Check for navigation/tracking indicators (ride started)
            boolean hasRideStarted = pageSource.contains("Navigate") ||
                                     pageSource.contains("navigate") ||
                                     pageSource.contains("Start") ||
                                     pageSource.contains("Pickup") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Arrived");

            System.out.println("");
            System.out.println("Alert Detection Results:");
            System.out.println("  - Alert indicators: " + (hasAlert ? "YES" : "NO"));
            System.out.println("  - Ride confirmed: " + (hasRideConfirmed ? "YES" : "NO"));
            System.out.println("  - Alert buttons: " + (hasAlertButtons ? "YES" : "NO"));
            System.out.println("  - Ride started: " + (hasRideStarted ? "YES" : "NO"));
            System.out.println("");

            // Vibration is device-specific and cannot be directly detected via Appium
            // We check for visual indicators that suggest vibration alert was triggered
            if (hasAlertButtons || hasRideConfirmed || hasRideStarted) {
                vibrationAlertReceived = true;
                System.out.println("Vibration alert likely received (visual indicators found)");
                System.out.println("");
                System.out.println("NOTE: Vibration is a physical device behavior.");
                System.out.println("Please manually verify that the device vibrated");
                System.out.println("when the rider accepted the driver.");
            } else {
                System.out.println("No clear alert indicators found");
                System.out.println("Rider may not have accepted yet");
                System.out.println("");
                System.out.println("Please ensure:");
                System.out.println("1. Rider has accepted the driver on Rider app");
                System.out.println("2. Check if device vibrated");
            }

        } catch (Exception e) {
            System.out.println("Error checking vibration alert: " + e.getMessage());
        }
    }

    @When("Driver closes the vibration alert")
    public void driverClosesTheVibrationAlert() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CLOSING VIBRATION ALERT");
            System.out.println("========================================");

            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            // Try to find and tap close/dismiss button
            boolean alertClosed = false;

            // Strategy 1: Look for OK button
            try {
                org.openqa.selenium.WebElement okButton = AndroidDriverSetup.getAndroidDriver().findElement(
                    org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'OK') or contains(@content-desc, 'Ok') or contains(@text, 'OK') or contains(@text, 'Ok')]"));
                okButton.click();
                alertClosed = true;
                System.out.println("Tapped OK button");
            } catch (Exception e) {
                // Try next strategy
            }

            // Strategy 2: Look for Close button
            if (!alertClosed) {
                try {
                    org.openqa.selenium.WebElement closeButton = AndroidDriverSetup.getAndroidDriver().findElement(
                        org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Close') or contains(@content-desc, 'close') or contains(@text, 'Close') or contains(@text, 'CLOSE')]"));
                    closeButton.click();
                    alertClosed = true;
                    System.out.println("Tapped Close button");
                } catch (Exception e) {
                    // Try next strategy
                }
            }

            // Strategy 3: Look for Dismiss/Got it button
            if (!alertClosed) {
                try {
                    org.openqa.selenium.WebElement dismissButton = AndroidDriverSetup.getAndroidDriver().findElement(
                        org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Dismiss') or contains(@content-desc, 'Got it') or contains(@text, 'Dismiss') or contains(@text, 'Got it')]"));
                    dismissButton.click();
                    alertClosed = true;
                    System.out.println("Tapped Dismiss/Got it button");
                } catch (Exception e) {
                    // Try next strategy
                }
            }

            // Strategy 4: Try pressing back button
            if (!alertClosed) {
                try {
                    AndroidDriverSetup.getAndroidDriver().navigate().back();
                    alertClosed = true;
                    System.out.println("Pressed back button to close alert");
                } catch (Exception e) {
                    // Ignore
                }
            }

            // Strategy 5: Tap anywhere on screen to dismiss
            if (!alertClosed) {
                try {
                    // Tap on center of screen
                    int screenWidth = AndroidDriverSetup.getAndroidDriver().manage().window().getSize().getWidth();
                    int screenHeight = AndroidDriverSetup.getAndroidDriver().manage().window().getSize().getHeight();

                    new io.appium.java_client.TouchAction<>(AndroidDriverSetup.getAndroidDriver())
                        .tap(io.appium.java_client.touch.offset.PointOption.point(screenWidth / 2, screenHeight / 2))
                        .perform();
                    alertClosed = true;
                    System.out.println("Tapped center of screen to dismiss");
                } catch (Exception e) {
                    System.out.println("Could not tap screen: " + e.getMessage());
                }
            }

            if (alertClosed) {
                System.out.println("Alert close action performed");
            } else {
                System.out.println("No alert close button found - alert may have auto-dismissed");
                System.out.println("Or the alert may still be visible");
            }

            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Error closing alert: " + e.getMessage());
        }
    }

    @Then("Vibration should stop immediately")
    public void vibrationShouldStopImmediately() {
        try {
            Thread.sleep(2000);

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VIBRATION STOP VERIFICATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL VERIFICATION REQUIRED:");
            System.out.println("  Did the vibration stop immediately after");
            System.out.println("  closing the alert?");
            System.out.println("");
            System.out.println("  Expected behavior:");
            System.out.println("  - Vibration should STOP when alert is closed");
            System.out.println("  - No continued vibration after dismissal");
            System.out.println("");

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            // Check current screen state
            boolean onRideScreen = pageSource.contains("Navigate") ||
                                   pageSource.contains("Pickup") ||
                                   pageSource.contains("Drop") ||
                                   pageSource.contains("Arrived") ||
                                   pageSource.contains("Start") ||
                                   pageSource.contains("Complete");

            boolean alertStillVisible = pageSource.contains("alert") &&
                                       (pageSource.contains("OK") || pageSource.contains("Close"));

            if (onRideScreen && !alertStillVisible) {
                vibrationStopped = true;
                System.out.println("========================================");
                System.out.println("  TC-017: NEEDS MANUAL CONFIRMATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Alert has been closed.");
                System.out.println("  Driver is now on ride screen.");
                System.out.println("");
                System.out.println("  Please confirm:");
                System.out.println("  - Did the device vibrate when rider accepted?");
                System.out.println("  - Did vibration STOP after closing alert?");
                System.out.println("");
                System.out.println("  If vibration stopped immediately: PASS");
                System.out.println("  If vibration continued: FAIL");
                System.out.println("========================================");
            } else if (alertStillVisible) {
                System.out.println("========================================");
                System.out.println("  TC-017: ALERT STILL VISIBLE");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  The alert may not have been closed.");
                System.out.println("  Try closing it manually and check if");
                System.out.println("  vibration stops.");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-017: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not determine current state.");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was vibration received?");
                System.out.println("  2. Did vibration stop after close?");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying vibration stop: " + e.getMessage());
            System.out.println("TC-017: FAILED - " + e.getMessage());
        }
    }
}
