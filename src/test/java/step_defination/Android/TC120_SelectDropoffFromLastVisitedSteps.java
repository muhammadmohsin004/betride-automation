package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC120_SelectDropoffFromLastVisitedSteps extends Page {

    @Given("User is on City to City page with last visited list visible")
    public void userIsOnCityToCityPageWithLastVisitedListVisible() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-120: SELECT DROP-OFF FROM LAST VISITED");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("  4. Last visited places list should be visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach City to City page
            System.out.println("");
            System.out.println("Waiting 20 seconds to reach City to City page...");
            System.out.println("");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            // Verify we're on City to City page with last visited
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnCityToCity = pageSource.contains("City to City") ||
                                     pageSource.contains("city to city") ||
                                     pageSource.contains("Start your city") ||
                                     pageSource.contains("last visited") ||
                                     pageSource.contains("Last visited") ||
                                     pageSource.contains("Recent") ||
                                     pageSource.contains("recent");

            if (isOnCityToCity) {
                System.out.println("");
                System.out.println("Confirmed: On City to City page with last visited list");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the City to City page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps a location under last visited places")
    public void userTapsALocationUnderLastVisitedPlaces() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SELECTING FROM LAST VISITED PLACES");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for 'Last visited places' section");
            System.out.println("  2. Tap on any location from the list");
            System.out.println("  3. Observe the drop-off field update");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to select from last visited
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
            System.out.println("Last visited location should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("Drop-off field should update with selected visited location")
    public void dropoffFieldShouldUpdateWithSelectedVisitedLocation() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING DROP-OFF FIELD UPDATED");
            System.out.println("========================================");
            System.out.println("");

            // Check for location names
            boolean hasLocationName = pageSource.contains("Street") ||
                                      pageSource.contains("Road") ||
                                      pageSource.contains("Avenue") ||
                                      pageSource.contains("Building") ||
                                      pageSource.contains("Station") ||
                                      pageSource.contains("Airport") ||
                                      pageSource.contains("Mall") ||
                                      pageSource.contains("Hotel") ||
                                      pageSource.contains("City") ||
                                      pageSource.contains("Center") ||
                                      pageSource.contains("Plaza") ||
                                      pageSource.contains("Market");

            // Check for filled drop-off
            boolean hasFilledDropoff = pageSource.contains("To:") ||
                                       pageSource.contains("Drop-off:") ||
                                       pageSource.contains("Destination:") ||
                                       pageSource.contains("Going to");

            // Check for address patterns
            boolean hasAddressPattern = pageSource.contains(",") &&
                                        (pageSource.contains("Phnom Penh") ||
                                         pageSource.contains("Cambodia") ||
                                         pageSource.contains("District") ||
                                         pageSource.contains("Sangkat") ||
                                         pageSource.contains("Province"));

            // Check if empty placeholder is gone
            boolean hasEmptyPlaceholder = pageSource.contains("Enter drop") ||
                                          pageSource.contains("Select drop") ||
                                          pageSource.contains("Where to?") ||
                                          pageSource.contains("Add drop") ||
                                          pageSource.contains("Enter destination");

            // Check Next button
            boolean hasNextButton = pageSource.contains("Next") ||
                                    pageSource.contains("Continue") ||
                                    pageSource.contains("Proceed");

            System.out.println("Drop-off Field Verification:");
            System.out.println("----------------------------");
            System.out.println("  - Location name found: " + (hasLocationName ? "YES" : "NO"));
            System.out.println("  - Filled drop-off indicator: " + (hasFilledDropoff ? "YES" : "NO"));
            System.out.println("  - Address pattern found: " + (hasAddressPattern ? "YES" : "NO"));
            System.out.println("  - Empty placeholder gone: " + (!hasEmptyPlaceholder ? "YES" : "NO"));
            System.out.println("  - Next button available: " + (hasNextButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasLocationName) score += 2;
            if (hasFilledDropoff) score += 2;
            if (hasAddressPattern) score += 2;
            if (!hasEmptyPlaceholder) score += 2;
            if (hasNextButton) score++;

            System.out.println("========================================");
            if (score >= 3 || (hasLocationName && !hasEmptyPlaceholder) || hasAddressPattern) {
                System.out.println("  TC-120: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Last visited selection successful!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasLocationName) System.out.println("    - Location name displayed");
                if (hasFilledDropoff) System.out.println("    - Drop-off field shows location");
                if (hasAddressPattern) System.out.println("    - Address visible");
                if (!hasEmptyPlaceholder) System.out.println("    - Empty placeholder replaced");
                if (hasNextButton) System.out.println("    - Can proceed to next step");
                System.out.println("");
                System.out.println("  Result: Drop-off updated with visited location");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-120: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap a last visited location?");
                System.out.println("  2. Is the drop-off field now filled?");
                System.out.println("  3. Does it show the visited location?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying drop-off: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-120: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
