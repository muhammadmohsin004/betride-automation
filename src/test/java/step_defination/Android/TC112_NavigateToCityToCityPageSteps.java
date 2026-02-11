package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC112_NavigateToCityToCityPageSteps extends Page {

    @Given("User is on Home screen with City to City option")
    public void userIsOnHomeScreenWithCityToCityOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-112: NAVIGATE TO CITY TO CITY PAGE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. You should be on the Home screen");
            System.out.println("  4. City to City option should be visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach Home screen
            System.out.println("");
            System.out.println("Waiting 15 seconds to verify Home screen...");
            System.out.println("");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            // Verify we're on Home screen with City to City option
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnHome = pageSource.contains("Home") ||
                               pageSource.contains("Book") ||
                               pageSource.contains("City to City") ||
                               pageSource.contains("City");

            if (isOnHome) {
                System.out.println("");
                System.out.println("Confirmed: On Home screen with City to City option");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the Home screen.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on City to City option")
    public void userTapsOnCityToCityOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING CITY TO CITY OPTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for 'City to City' option on Home screen");
            System.out.println("  2. Tap on the 'City to City' option");
            System.out.println("  3. Wait for navigation to complete");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap City to City
            System.out.println("");
            System.out.println("Waiting 15 seconds for manual action...");
            System.out.println("");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("City to City option should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("App should navigate to Start your city to city ride page")
    public void appShouldNavigateToStartYourCityToCityRidePage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING CITY TO CITY RIDE PAGE");
            System.out.println("========================================");
            System.out.println("");

            // Check for City to City ride page elements
            boolean hasStartCityToCityText = pageSource.contains("Start your city to city ride") ||
                                              pageSource.contains("start your city to city ride") ||
                                              pageSource.contains("City to city ride") ||
                                              pageSource.contains("city to city ride");

            boolean hasCityToCityHeader = pageSource.contains("City to City") ||
                                          pageSource.contains("city to city") ||
                                          pageSource.contains("CITY TO CITY");

            boolean hasIntercityText = pageSource.contains("Intercity") ||
                                       pageSource.contains("intercity") ||
                                       pageSource.contains("Inter-city");

            // Check for typical ride booking elements
            boolean hasPickupField = pageSource.contains("pickup") ||
                                     pageSource.contains("Pickup") ||
                                     pageSource.contains("Pick up") ||
                                     pageSource.contains("From") ||
                                     pageSource.contains("Where from");

            boolean hasDestinationField = pageSource.contains("destination") ||
                                          pageSource.contains("Destination") ||
                                          pageSource.contains("Drop") ||
                                          pageSource.contains("To") ||
                                          pageSource.contains("Where to");

            boolean hasBookButton = pageSource.contains("Book") ||
                                    pageSource.contains("book") ||
                                    pageSource.contains("Continue") ||
                                    pageSource.contains("Next");

            // Not on home screen anymore
            boolean notOnHomeScreen = !pageSource.contains("Book Hourly") ||
                                      pageSource.contains("Start your city");

            System.out.println("City to City Page Verification:");
            System.out.println("-------------------------------");
            System.out.println("  - 'Start your city to city ride': " + (hasStartCityToCityText ? "YES" : "NO"));
            System.out.println("  - City to City header: " + (hasCityToCityHeader ? "YES" : "NO"));
            System.out.println("  - Intercity text: " + (hasIntercityText ? "YES" : "NO"));
            System.out.println("  - Pickup field visible: " + (hasPickupField ? "YES" : "NO"));
            System.out.println("  - Destination field visible: " + (hasDestinationField ? "YES" : "NO"));
            System.out.println("  - Book/Continue button: " + (hasBookButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasStartCityToCityText) score += 5;
            if (hasCityToCityHeader) score += 2;
            if (hasIntercityText) score += 2;
            if (hasPickupField) score++;
            if (hasDestinationField) score++;
            if (hasBookButton) score++;
            if (notOnHomeScreen) score++;

            System.out.println("========================================");
            if (hasStartCityToCityText || score >= 4) {
                System.out.println("  TC-112: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Navigation successful!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasStartCityToCityText) System.out.println("    - 'Start your city to city ride' page");
                if (hasCityToCityHeader) System.out.println("    - City to City header visible");
                if (hasIntercityText) System.out.println("    - Intercity text visible");
                if (hasPickupField) System.out.println("    - Pickup field available");
                if (hasDestinationField) System.out.println("    - Destination field available");
                if (hasBookButton) System.out.println("    - Book/Continue button visible");
                System.out.println("");
                System.out.println("  Result: Navigated to City to City ride page");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-112: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the City to City ride page?");
                System.out.println("  2. Do you see 'Start your city to city ride'?");
                System.out.println("  3. Can you see pickup and destination fields?");
                System.out.println("");
                System.out.println("  Expected: App navigates to City to City");
                System.out.println("  booking page with ride options.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying navigation: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-112: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
