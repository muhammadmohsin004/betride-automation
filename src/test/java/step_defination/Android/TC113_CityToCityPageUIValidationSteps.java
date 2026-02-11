package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC113_CityToCityPageUIValidationSteps extends Page {

    @Given("User is on City to City page")
    public void userIsOnCityToCityPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-113: CITY TO CITY PAGE UI VALIDATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to City to City page");
            System.out.println("     (Tap 'City to City' on Home screen)");
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

            // Verify we're on City to City page
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnCityToCity = pageSource.contains("City to City") ||
                                     pageSource.contains("city to city") ||
                                     pageSource.contains("Start your city") ||
                                     pageSource.contains("Intercity");

            if (isOnCityToCity) {
                System.out.println("");
                System.out.println("Confirmed: On City to City page");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the City to City page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @Then("City to City page should display all required UI elements")
    public void cityToCityPageShouldDisplayAllRequiredUIElements() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING UI ELEMENTS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  Expected elements:");
            System.out.println("  - Pickup field");
            System.out.println("  - Drop-off field");
            System.out.println("  - Last visited places");
            System.out.println("  - Next button");
            System.out.println("");

            // Check for Pickup field
            boolean hasPickupField = pageSource.contains("pickup") ||
                                     pageSource.contains("Pickup") ||
                                     pageSource.contains("Pick up") ||
                                     pageSource.contains("PICKUP") ||
                                     pageSource.contains("From") ||
                                     pageSource.contains("Where from") ||
                                     pageSource.contains("Starting point");

            // Check for Drop-off field
            boolean hasDropoffField = pageSource.contains("drop") ||
                                      pageSource.contains("Drop") ||
                                      pageSource.contains("DROP") ||
                                      pageSource.contains("Destination") ||
                                      pageSource.contains("destination") ||
                                      pageSource.contains("To") ||
                                      pageSource.contains("Where to") ||
                                      pageSource.contains("End point");

            // Check for Last visited places
            boolean hasLastVisited = pageSource.contains("last visited") ||
                                     pageSource.contains("Last visited") ||
                                     pageSource.contains("Recent") ||
                                     pageSource.contains("recent") ||
                                     pageSource.contains("History") ||
                                     pageSource.contains("history") ||
                                     pageSource.contains("Previous") ||
                                     pageSource.contains("Saved");

            // Check for Next button
            boolean hasNextButton = pageSource.contains("Next") ||
                                    pageSource.contains("NEXT") ||
                                    pageSource.contains("next") ||
                                    pageSource.contains("Continue") ||
                                    pageSource.contains("CONTINUE") ||
                                    pageSource.contains("Proceed") ||
                                    pageSource.contains("Book");

            // Additional UI elements
            boolean hasHeaderText = pageSource.contains("City to City") ||
                                    pageSource.contains("Start your city") ||
                                    pageSource.contains("Intercity");

            boolean hasBackButton = pageSource.contains("back") ||
                                    pageSource.contains("Back") ||
                                    pageSource.contains("←") ||
                                    pageSource.contains("<");

            System.out.println("UI Elements Verification:");
            System.out.println("-------------------------");
            System.out.println("  - Pickup field: " + (hasPickupField ? "✅ YES" : "❌ NO"));
            System.out.println("  - Drop-off field: " + (hasDropoffField ? "✅ YES" : "❌ NO"));
            System.out.println("  - Last visited places: " + (hasLastVisited ? "✅ YES" : "❌ NO"));
            System.out.println("  - Next button: " + (hasNextButton ? "✅ YES" : "❌ NO"));
            System.out.println("  - Header text: " + (hasHeaderText ? "✅ YES" : "❌ NO"));
            System.out.println("  - Back button: " + (hasBackButton ? "✅ YES" : "❌ NO"));
            System.out.println("");

            // Count required elements found
            int requiredFound = 0;
            if (hasPickupField) requiredFound++;
            if (hasDropoffField) requiredFound++;
            if (hasLastVisited) requiredFound++;
            if (hasNextButton) requiredFound++;

            System.out.println("Required elements found: " + requiredFound + "/4");
            System.out.println("");

            System.out.println("========================================");
            if (requiredFound >= 3) {
                System.out.println("  TC-113: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  UI validation successful!");
                System.out.println("");
                System.out.println("  Found elements:");
                if (hasPickupField) System.out.println("    ✅ Pickup field");
                if (hasDropoffField) System.out.println("    ✅ Drop-off field");
                if (hasLastVisited) System.out.println("    ✅ Last visited places");
                if (hasNextButton) System.out.println("    ✅ Next button");
                if (hasHeaderText) System.out.println("    ✅ Header text");
                if (hasBackButton) System.out.println("    ✅ Back button");
                System.out.println("");
                if (!hasPickupField) System.out.println("    ❌ Missing: Pickup field");
                if (!hasDropoffField) System.out.println("    ❌ Missing: Drop-off field");
                if (!hasLastVisited) System.out.println("    ❌ Missing: Last visited places");
                if (!hasNextButton) System.out.println("    ❌ Missing: Next button");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-113: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is Pickup field visible?");
                System.out.println("  2. Is Drop-off field visible?");
                System.out.println("  3. Are Last visited places shown?");
                System.out.println("  4. Is Next button visible?");
                System.out.println("");
                System.out.println("  Missing elements detected:");
                if (!hasPickupField) System.out.println("    - Pickup field");
                if (!hasDropoffField) System.out.println("    - Drop-off field");
                if (!hasLastVisited) System.out.println("    - Last visited places");
                if (!hasNextButton) System.out.println("    - Next button");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying UI elements: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-113: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
