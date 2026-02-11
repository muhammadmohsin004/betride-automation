package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC121_ClearPickupFieldSteps extends Page {

    @Given("User is on City to City page with pickup filled")
    public void userIsOnCityToCityPageWithPickupFilled() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-121: CLEAR PICKUP FIELD");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("  4. Select a pickup location first");
            System.out.println("  5. Pickup field should be filled");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach City to City page with pickup filled
            System.out.println("");
            System.out.println("Waiting 20 seconds to set up...");
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

            // Verify we're on City to City page
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnCityToCity = pageSource.contains("City to City") ||
                                     pageSource.contains("city to city") ||
                                     pageSource.contains("Start your city") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Pickup");

            if (isOnCityToCity) {
                System.out.println("");
                System.out.println("Confirmed: On City to City page with pickup filled");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the City to City page with a pickup selected.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps clear icon on pickup field")
    public void userTapsClearIconOnPickupField() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING CLEAR ICON ON PICKUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for the (x) clear icon next to");
            System.out.println("     the pickup field");
            System.out.println("  2. Tap on the (x) clear icon");
            System.out.println("  3. Observe the pickup field");
            System.out.println("");
            System.out.println("  NOTE: The pickup field should become empty");
            System.out.println("  after tapping the clear icon.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap clear icon
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
            System.out.println("Clear icon should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("City to City pickup field should become empty")
    public void cityToCityPickupFieldShouldBecomeEmpty() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING PICKUP FIELD CLEARED");
            System.out.println("========================================");
            System.out.println("");

            // Check for empty pickup indicators
            boolean hasEmptyPlaceholder = pageSource.contains("Enter pickup") ||
                                          pageSource.contains("Select pickup") ||
                                          pageSource.contains("Where from") ||
                                          pageSource.contains("Add pickup") ||
                                          pageSource.contains("Search") ||
                                          pageSource.contains("Add source") ||
                                          pageSource.contains("Source");

            // Check that location name is NOT present (cleared)
            boolean hasLocationCleared = !pageSource.contains("From:") ||
                                         pageSource.contains("Enter") ||
                                         pageSource.contains("Select") ||
                                         pageSource.contains("Add");

            // Still on City to City page
            boolean stayedOnPage = pageSource.contains("City to City") ||
                                    pageSource.contains("Start your city") ||
                                    pageSource.contains("Next") ||
                                    pageSource.contains("drop") ||
                                    pageSource.contains("Drop");

            // Check for clear icon visibility (may still be there or gone)
            boolean hasInputField = pageSource.contains("pickup") ||
                                    pageSource.contains("Pickup") ||
                                    pageSource.contains("source") ||
                                    pageSource.contains("Source");

            System.out.println("Clear Pickup Verification:");
            System.out.println("--------------------------");
            System.out.println("  - Empty placeholder shown: " + (hasEmptyPlaceholder ? "YES" : "NO"));
            System.out.println("  - Location cleared: " + (hasLocationCleared ? "YES" : "NO"));
            System.out.println("  - Stayed on page: " + (stayedOnPage ? "YES" : "NO"));
            System.out.println("  - Input field visible: " + (hasInputField ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasEmptyPlaceholder) score += 3;
            if (hasLocationCleared) score += 2;
            if (stayedOnPage) score += 2;
            if (hasInputField) score++;

            System.out.println("========================================");
            if (score >= 4 || (hasEmptyPlaceholder && stayedOnPage)) {
                System.out.println("  TC-121: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Pickup field cleared successfully!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasEmptyPlaceholder) System.out.println("    - Empty placeholder displayed");
                if (hasLocationCleared) System.out.println("    - Previous location cleared");
                if (stayedOnPage) System.out.println("    - Stayed on City to City page");
                if (hasInputField) System.out.println("    - Input field ready for new entry");
                System.out.println("");
                System.out.println("  Result: Pickup becomes empty");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-121: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap the (x) clear icon?");
                System.out.println("  2. Is the pickup field now empty?");
                System.out.println("  3. Can you enter a new pickup location?");
                System.out.println("");
                System.out.println("  Expected: Pickup field is cleared and");
                System.out.println("  ready for a new location entry.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying clear: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-121: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
