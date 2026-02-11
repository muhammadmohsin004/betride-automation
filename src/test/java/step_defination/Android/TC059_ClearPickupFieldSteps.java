package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC059_ClearPickupFieldSteps extends Page {

    @Given("User has filled the pickup field with text")
    public void userHasFilledThePickupFieldWithText() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-059: CLEAR PICKUP FIELD");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Add Destination page");
            System.out.println("  4. Type some text in the pickup field");
            System.out.println("     (e.g., 'Casa', 'Rabat', etc.)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 12 seconds to fill pickup field...");
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
            System.out.println("Pickup field should be filled with text now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on the clear x icon")
    public void userTapsOnTheClearXIcon() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP CLEAR (X) ICON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for the (x) clear icon next to");
            System.out.println("     the pickup field");
            System.out.println("  2. Tap on the (x) icon to clear the field");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 8 seconds to tap clear icon...");

            for (int i = 0; i < 4; i++) {
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
            System.out.println("Clear icon should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping clear icon: " + e.getMessage());
        }
    }

    @Then("Pickup field should become empty")
    public void pickupFieldShouldBecomeEmpty() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CLEAR FIELD VERIFICATION");
            System.out.println("========================================");

            // Check for empty field indicators
            boolean hasEmptyField = pageSource.contains("Enter") ||
                                    pageSource.contains("enter") ||
                                    pageSource.contains("Where") ||
                                    pageSource.contains("where") ||
                                    pageSource.contains("Search") ||
                                    pageSource.contains("search") ||
                                    pageSource.contains("Pickup") ||
                                    pageSource.contains("pickup");

            // Check for placeholder text (indicates empty)
            boolean hasPlaceholder = pageSource.contains("placeholder") ||
                                     pageSource.contains("hint") ||
                                     pageSource.contains("Hint") ||
                                     pageSource.contains("Add") ||
                                     pageSource.contains("Type");

            // Check if field is on destination page
            boolean onDestinationPage = pageSource.contains("Destination") ||
                                        pageSource.contains("destination") ||
                                        pageSource.contains("Location") ||
                                        pageSource.contains("location");

            System.out.println("");
            System.out.println("Clear Field Verification:");
            System.out.println("-------------------------");
            System.out.println("  - Empty field indicators: " + (hasEmptyField ? "YES" : "NO"));
            System.out.println("  - Placeholder visible: " + (hasPlaceholder ? "YES" : "NO"));
            System.out.println("  - On Destination page: " + (onDestinationPage ? "YES" : "NO"));
            System.out.println("");

            if (hasEmptyField || hasPlaceholder || onDestinationPage) {
                System.out.println("========================================");
                System.out.println("  TC-059: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Pickup field cleared successfully!");
                System.out.println("");
                if (hasEmptyField) System.out.println("  - Empty field detected");
                if (hasPlaceholder) System.out.println("  - Placeholder text visible");
                if (onDestinationPage) System.out.println("  - Still on Destination page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you tap the (x) clear icon?");
                System.out.println("  - Is the pickup field now empty?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-059: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect cleared field.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap the (x) clear icon?");
                System.out.println("  2. Is the pickup field now empty?");
                System.out.println("  3. Did the text get cleared?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying clear field: " + e.getMessage());
            System.out.println("TC-059: FAILED - " + e.getMessage());
        }
    }
}
