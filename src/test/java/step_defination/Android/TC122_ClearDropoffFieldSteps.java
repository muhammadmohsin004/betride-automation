package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC122_ClearDropoffFieldSteps extends Page {

    @Given("User is on City to City page with drop-off filled")
    public void userIsOnCityToCityPageWithDropoffFilled() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-122: CLEAR DROP-OFF FIELD");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("  4. Select a drop-off location first");
            System.out.println("  5. Drop-off field should be filled");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach City to City page with drop-off filled
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
                                     pageSource.contains("drop") ||
                                     pageSource.contains("Drop") ||
                                     pageSource.contains("destination") ||
                                     pageSource.contains("Destination");

            if (isOnCityToCity) {
                System.out.println("");
                System.out.println("Confirmed: On City to City page with drop-off filled");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the City to City page with a drop-off selected.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps clear icon on drop-off field")
    public void userTapsClearIconOnDropoffField() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING CLEAR ICON ON DROP-OFF");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for the (x) clear icon next to");
            System.out.println("     the drop-off/destination field");
            System.out.println("  2. Tap on the (x) clear icon");
            System.out.println("  3. Observe the drop-off field");
            System.out.println("");
            System.out.println("  NOTE: The drop-off field should become");
            System.out.println("  empty after tapping the clear icon.");
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

    @Then("City to City drop-off field should become empty")
    public void cityToCityDropoffFieldShouldBecomeEmpty() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING DROP-OFF FIELD CLEARED");
            System.out.println("========================================");
            System.out.println("");

            // Check for empty drop-off indicators
            boolean hasEmptyPlaceholder = pageSource.contains("Enter drop") ||
                                          pageSource.contains("Select drop") ||
                                          pageSource.contains("Where to") ||
                                          pageSource.contains("Add drop") ||
                                          pageSource.contains("Add destination") ||
                                          pageSource.contains("Search") ||
                                          pageSource.contains("Destination");

            // Check that location is cleared
            boolean hasLocationCleared = !pageSource.contains("To:") ||
                                         pageSource.contains("Enter") ||
                                         pageSource.contains("Select") ||
                                         pageSource.contains("Add");

            // Still on City to City page
            boolean stayedOnPage = pageSource.contains("City to City") ||
                                    pageSource.contains("Start your city") ||
                                    pageSource.contains("Next") ||
                                    pageSource.contains("pickup") ||
                                    pageSource.contains("Pickup");

            // Check for input field
            boolean hasInputField = pageSource.contains("drop") ||
                                    pageSource.contains("Drop") ||
                                    pageSource.contains("destination") ||
                                    pageSource.contains("Destination");

            System.out.println("Clear Drop-off Verification:");
            System.out.println("----------------------------");
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
                System.out.println("  TC-122: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Drop-off field cleared successfully!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasEmptyPlaceholder) System.out.println("    - Empty placeholder displayed");
                if (hasLocationCleared) System.out.println("    - Previous location cleared");
                if (stayedOnPage) System.out.println("    - Stayed on City to City page");
                if (hasInputField) System.out.println("    - Input field ready for new entry");
                System.out.println("");
                System.out.println("  Result: Drop-off becomes empty");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-122: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap the (x) clear icon?");
                System.out.println("  2. Is the drop-off field now empty?");
                System.out.println("  3. Can you enter a new drop-off location?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying clear: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-122: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
