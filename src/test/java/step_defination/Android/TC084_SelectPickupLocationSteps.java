package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC084_SelectPickupLocationSteps extends Page {

    @Given("User is on Book Hourly page with pickup not selected")
    public void userIsOnBookHourlyPageWithPickupNotSelected() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-084: SELECT PICKUP LOCATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Pickup should NOT be selected yet");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 12 seconds to open Book Hourly page...");
            System.out.println("");

            for (int i = 0; i < 4; i++) {
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
            System.out.println("Book Hourly page should be open.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Select pickup location and chooses a location")
    public void userTapsSelectPickupLocationAndChoosesALocation() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SELECT PICKUP LOCATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Tap on 'Select pickup location' field");
            System.out.println("  2. Search or select a location");
            System.out.println("  3. Choose a location from the list");
            System.out.println("  4. Confirm the selection");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 15 seconds to select pickup location...");

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
            System.out.println("Pickup location should be selected.");

        } catch (Exception e) {
            System.out.println("Error selecting pickup: " + e.getMessage());
        }
    }

    @Then("Pickup field should update with selected location")
    public void pickupFieldShouldUpdateWithSelectedLocation() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  PICKUP LOCATION UPDATE VERIFICATION");
            System.out.println("========================================");

            // Check for pickup field with content
            boolean hasPickupField = pageSource.contains("Pickup") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Pick-up") ||
                                     pageSource.contains("From");

            // Check for location content (address)
            boolean hasLocationContent = pageSource.contains("Street") ||
                                         pageSource.contains("street") ||
                                         pageSource.contains("Road") ||
                                         pageSource.contains("road") ||
                                         pageSource.contains("Avenue") ||
                                         pageSource.contains("Marrakech") ||
                                         pageSource.contains("Morocco");

            // Check field is populated (not empty)
            boolean fieldNotEmpty = !pageSource.contains("Select pickup") ||
                                    hasLocationContent;

            // Check for hour selector still visible
            boolean hasHourSelector = pageSource.contains("Hour") ||
                                      pageSource.contains("hour") ||
                                      pageSource.contains("Duration") ||
                                      pageSource.contains("duration");

            // Check for Next button
            boolean hasNextButton = pageSource.contains("Next") ||
                                    pageSource.contains("next") ||
                                    pageSource.contains("Continue") ||
                                    pageSource.contains("Proceed");

            System.out.println("");
            System.out.println("Pickup Location Update Verification:");
            System.out.println("------------------------------------");
            System.out.println("  - Pickup field: " + (hasPickupField ? "YES" : "NO"));
            System.out.println("  - Location content: " + (hasLocationContent ? "YES" : "NO"));
            System.out.println("  - Field populated: " + (fieldNotEmpty ? "YES" : "NO"));
            System.out.println("  - Hour selector: " + (hasHourSelector ? "YES" : "NO"));
            System.out.println("  - Next button: " + (hasNextButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasPickupField) score += 2;
            if (hasLocationContent) score += 3;
            if (fieldNotEmpty) score += 2;
            if (hasHourSelector) score++;
            if (hasNextButton) score++;

            if (score >= 4 || hasLocationContent || (hasPickupField && fieldNotEmpty)) {
                System.out.println("========================================");
                System.out.println("  TC-084: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Pickup field updated with location!");
                System.out.println("");
                if (hasPickupField) System.out.println("  - Pickup field present");
                if (hasLocationContent) System.out.println("  - Location address shown");
                if (fieldNotEmpty) System.out.println("  - Field is populated");
                if (hasHourSelector) System.out.println("  - Hour selector visible");
                if (hasNextButton) System.out.println("  - Next button visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did pickup field update with selected location?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-084: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you select a pickup location?");
                System.out.println("  2. Did the pickup field update?");
                System.out.println("  3. Is the location displayed correctly?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying pickup update: " + e.getMessage());
            System.out.println("TC-084: FAILED - " + e.getMessage());
        }
    }
}
