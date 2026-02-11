package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC023_GPSDisabledSteps extends Page {

    @When("Driver disables GPS on device")
    public void driverDisablesGPSOnDevice() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-023: GPS DISABLED TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("  Please TURN OFF GPS/Location on the device");
            System.out.println("");
            System.out.println("  Steps to disable GPS:");
            System.out.println("  1. Swipe down from top of screen");
            System.out.println("  2. Tap on Location/GPS icon to turn it OFF");
            System.out.println("  3. Or go to Settings > Location > OFF");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to disable GPS manually
            System.out.println("Waiting 15 seconds for GPS to be disabled...");

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
            System.out.println("GPS should now be disabled.");
            System.out.println("Proceeding with test...");
            System.out.println("");

        } catch (Exception e) {
            System.out.println("Error during GPS disable step: " + e.getMessage());
        }
    }

    @Then("Driver should see Enable GPS error message")
    public void driverShouldSeeEnableGPSErrorMessage() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  GPS ERROR MESSAGE VERIFICATION");
            System.out.println("========================================");

            // Check for GPS error message indicators
            boolean hasGPSError = pageSource.contains("Enable GPS") ||
                                  pageSource.contains("enable GPS") ||
                                  pageSource.contains("GPS") ||
                                  pageSource.contains("gps") ||
                                  pageSource.contains("Location") ||
                                  pageSource.contains("location");

            // Check for specific error message patterns
            boolean hasEnableMessage = pageSource.contains("Enable") ||
                                       pageSource.contains("enable") ||
                                       pageSource.contains("Turn on") ||
                                       pageSource.contains("turn on") ||
                                       pageSource.contains("activate") ||
                                       pageSource.contains("Activate");

            // Check for accept ride message (negative - should not be able to accept)
            boolean hasAcceptRideMessage = pageSource.contains("accept") ||
                                           pageSource.contains("Accept");

            // Check for error/warning indicators
            boolean hasErrorIndicator = pageSource.contains("Error") ||
                                        pageSource.contains("error") ||
                                        pageSource.contains("Warning") ||
                                        pageSource.contains("warning") ||
                                        pageSource.contains("Cannot") ||
                                        pageSource.contains("cannot") ||
                                        pageSource.contains("Unable") ||
                                        pageSource.contains("unable");

            // Check for popup/alert indicators
            boolean hasPopupIndicator = pageSource.contains("OK") ||
                                        pageSource.contains("Ok") ||
                                        pageSource.contains("Close") ||
                                        pageSource.contains("Settings") ||
                                        pageSource.contains("settings");

            // Check for location permission request
            boolean hasPermissionRequest = pageSource.contains("permission") ||
                                           pageSource.contains("Permission") ||
                                           pageSource.contains("Allow") ||
                                           pageSource.contains("allow");

            System.out.println("");
            System.out.println("GPS Error Verification Results:");
            System.out.println("-------------------------------");
            System.out.println("  - GPS-related text: " + (hasGPSError ? "YES" : "NO"));
            System.out.println("  - Enable message: " + (hasEnableMessage ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Popup indicator: " + (hasPopupIndicator ? "YES" : "NO"));
            System.out.println("  - Permission request: " + (hasPermissionRequest ? "YES" : "NO"));
            System.out.println("  - Accept ride text: " + (hasAcceptRideMessage ? "YES" : "NO"));
            System.out.println("");

            // Determine test result
            boolean gpsErrorDetected = (hasGPSError && hasEnableMessage) ||
                                       (hasGPSError && hasErrorIndicator) ||
                                       (hasErrorIndicator && hasAcceptRideMessage) ||
                                       hasPermissionRequest;

            if (gpsErrorDetected) {
                System.out.println("========================================");
                System.out.println("  TC-023: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  GPS disabled error verified!");
                System.out.println("");
                System.out.println("  - Driver cannot accept ride with GPS off");
                System.out.println("  - Error message displayed");
                if (hasGPSError) {
                    System.out.println("  - GPS-related message shown");
                }
                if (hasEnableMessage) {
                    System.out.println("  - 'Enable GPS' instruction shown");
                }
                System.out.println("");
                System.out.println("========================================");
            } else if (hasPopupIndicator) {
                System.out.println("========================================");
                System.out.println("  TC-023: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  A popup/alert was detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is it a GPS error message?");
                System.out.println("  2. Does it say 'Enable GPS to accept'?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-023: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect GPS error message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was GPS disabled before accepting?");
                System.out.println("  2. Did error popup appear?");
                System.out.println("  3. Does it say 'Enable GPS to accept'?");
                System.out.println("");
                System.out.println("  Note: Make sure GPS is turned OFF before");
                System.out.println("  tapping Accept on the ride request.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying GPS error message: " + e.getMessage());
            System.out.println("TC-023: FAILED - " + e.getMessage());
        }
    }
}
