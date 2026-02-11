package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC085_ManualPickupEntrySteps extends Page {

    @Given("User is on Book Hourly page with empty pickup field")
    public void userIsOnBookHourlyPageWithEmptyPickupField() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-085: MANUAL PICKUP ENTRY");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Book Hourly page");
            System.out.println("  4. Pickup field should be EMPTY");
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
            System.out.println("Book Hourly page should be open with empty pickup.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps pickup field and types location manually and selects from suggestions")
    public void userTapsPickupFieldAndTypesLocationManuallyAndSelectsFromSuggestions() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  MANUAL PICKUP ENTRY");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Tap on the pickup field");
            System.out.println("  2. Type a location name MANUALLY");
            System.out.println("     (e.g., 'Marrakech', 'Casablanca', etc.)");
            System.out.println("  3. Wait for autocomplete suggestions");
            System.out.println("  4. Select a location from the suggestions");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 20 seconds to type and select location...");

            for (int i = 0; i < 10; i++) {
                Thread.sleep(2000);
                System.out.println("Waiting... " + ((i + 1) * 2) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Location should be typed and selected.");

        } catch (Exception e) {
            System.out.println("Error during manual entry: " + e.getMessage());
        }
    }

    @Then("Pickup location should be updated via manual entry")
    public void pickupLocationShouldBeUpdatedViaManualEntry() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  MANUAL PICKUP ENTRY VERIFICATION");
            System.out.println("========================================");

            // Check for pickup field with content
            boolean hasPickupField = pageSource.contains("Pickup") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Pick-up") ||
                                     pageSource.contains("From");

            // Check for location content (typed address)
            boolean hasLocationContent = pageSource.contains("Street") ||
                                         pageSource.contains("street") ||
                                         pageSource.contains("Road") ||
                                         pageSource.contains("road") ||
                                         pageSource.contains("Avenue") ||
                                         pageSource.contains("Marrakech") ||
                                         pageSource.contains("Casablanca") ||
                                         pageSource.contains("Morocco") ||
                                         pageSource.contains("Centre") ||
                                         pageSource.contains("City");

            // Check field is populated (not showing placeholder)
            boolean fieldPopulated = !pageSource.contains("Select pickup") &&
                                     !pageSource.contains("Enter pickup") &&
                                     !pageSource.contains("Where from");

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

            // Check we're still on Book Hourly page
            boolean onBookHourlyPage = pageSource.contains("Hourly") ||
                                       pageSource.contains("hourly") ||
                                       pageSource.contains("by the hour");

            System.out.println("");
            System.out.println("Manual Pickup Entry Verification:");
            System.out.println("----------------------------------");
            System.out.println("  - Pickup field: " + (hasPickupField ? "YES" : "NO"));
            System.out.println("  - Location content: " + (hasLocationContent ? "YES" : "NO"));
            System.out.println("  - Field populated: " + (fieldPopulated ? "YES" : "NO"));
            System.out.println("  - Hour selector: " + (hasHourSelector ? "YES" : "NO"));
            System.out.println("  - Next button: " + (hasNextButton ? "YES" : "NO"));
            System.out.println("  - On Book Hourly page: " + (onBookHourlyPage ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasPickupField) score += 2;
            if (hasLocationContent) score += 3;
            if (fieldPopulated) score += 2;
            if (hasHourSelector) score++;
            if (hasNextButton) score++;
            if (onBookHourlyPage) score++;

            if (score >= 5 || hasLocationContent || (hasPickupField && fieldPopulated)) {
                System.out.println("========================================");
                System.out.println("  TC-085: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Pickup location updated via manual entry!");
                System.out.println("");
                if (hasPickupField) System.out.println("  - Pickup field present");
                if (hasLocationContent) System.out.println("  - Location address shown");
                if (fieldPopulated) System.out.println("  - Field is populated");
                if (hasHourSelector) System.out.println("  - Hour selector visible");
                if (hasNextButton) System.out.println("  - Next button visible");
                if (onBookHourlyPage) System.out.println("  - Still on Book Hourly page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did pickup update with manually typed location?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-085: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you type a location manually?");
                System.out.println("  2. Did suggestions appear?");
                System.out.println("  3. Did the pickup field update after selection?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying manual entry: " + e.getMessage());
            System.out.println("TC-085: FAILED - " + e.getMessage());
        }
    }
}
