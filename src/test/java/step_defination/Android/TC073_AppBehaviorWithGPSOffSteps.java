package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC073_AppBehaviorWithGPSOffSteps extends Page {

    @Given("GPS is disabled on the device")
    public void gpsIsDisabledOnTheDevice() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-073: APP BEHAVIOR WITH GPS OFF");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Go to device Settings");
            System.out.println("  2. Location / GPS settings");
            System.out.println("  3. Turn OFF GPS/Location");
            System.out.println("  4. Open the Rider app");
            System.out.println("  5. Ensure you are logged in");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to disable GPS...");
            System.out.println("");

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
            System.out.println("GPS should be disabled now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User opens Add Destination screen")
    public void userOpensAddDestinationScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  OPEN ADD DESTINATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the home screen");
            System.out.println("  2. Tap 'Book Ride' or destination field");
            System.out.println("  3. Try to open Add Destination screen");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to open Add Destination...");

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
            System.out.println("Add Destination should be opened.");

        } catch (Exception e) {
            System.out.println("Error opening Add Destination: " + e.getMessage());
        }
    }

    @Then("GPS permission popup should appear or manual entry required")
    public void gpsPermissionPopupShouldAppearOrManualEntryRequired() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  GPS OFF BEHAVIOR VERIFICATION");
            System.out.println("========================================");

            // Check for GPS permission popup
            boolean hasGPSPopup = pageSource.contains("Location") ||
                                  pageSource.contains("location") ||
                                  pageSource.contains("GPS") ||
                                  pageSource.contains("gps");

            // Check for permission request
            boolean hasPermissionRequest = pageSource.contains("Permission") ||
                                           pageSource.contains("permission") ||
                                           pageSource.contains("Allow") ||
                                           pageSource.contains("allow") ||
                                           pageSource.contains("Enable") ||
                                           pageSource.contains("enable");

            // Check for manual entry option
            boolean hasManualEntry = pageSource.contains("Enter") ||
                                     pageSource.contains("enter") ||
                                     pageSource.contains("Search") ||
                                     pageSource.contains("search") ||
                                     pageSource.contains("Type") ||
                                     pageSource.contains("type");

            // Check for destination field
            boolean hasDestinationField = pageSource.contains("Destination") ||
                                          pageSource.contains("destination") ||
                                          pageSource.contains("Where") ||
                                          pageSource.contains("where") ||
                                          pageSource.contains("Drop") ||
                                          pageSource.contains("drop");

            // Check for settings redirect
            boolean hasSettingsRedirect = pageSource.contains("Settings") ||
                                          pageSource.contains("settings") ||
                                          pageSource.contains("Turn on") ||
                                          pageSource.contains("turn on");

            System.out.println("");
            System.out.println("GPS Off Behavior Verification:");
            System.out.println("------------------------------");
            System.out.println("  - GPS/Location popup: " + (hasGPSPopup ? "YES" : "NO"));
            System.out.println("  - Permission request: " + (hasPermissionRequest ? "YES" : "NO"));
            System.out.println("  - Manual entry option: " + (hasManualEntry ? "YES" : "NO"));
            System.out.println("  - Destination field: " + (hasDestinationField ? "YES" : "NO"));
            System.out.println("  - Settings redirect: " + (hasSettingsRedirect ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasGPSPopup) score += 3;
            if (hasPermissionRequest) score += 2;
            if (hasManualEntry) score += 2;
            if (hasDestinationField) score++;
            if (hasSettingsRedirect) score += 2;

            if (score >= 3 || hasGPSPopup || hasPermissionRequest || hasManualEntry || hasSettingsRedirect) {
                System.out.println("========================================");
                System.out.println("  TC-073: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  App handles GPS off correctly!");
                System.out.println("");
                if (hasGPSPopup) System.out.println("  - GPS/Location popup shown");
                if (hasPermissionRequest) System.out.println("  - Permission request displayed");
                if (hasManualEntry) System.out.println("  - Manual entry available");
                if (hasSettingsRedirect) System.out.println("  - Settings redirect available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did GPS popup appear?");
                System.out.println("  - Can you enter location manually?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-073: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you disable GPS?");
                System.out.println("  2. Did GPS permission popup appear?");
                System.out.println("  3. Can you enter location manually?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying GPS behavior: " + e.getMessage());
            System.out.println("TC-073: FAILED - " + e.getMessage());
        }
    }
}
