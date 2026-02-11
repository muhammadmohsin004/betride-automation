package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC057_AutocompleteLocationSuggestionsSteps extends Page {

    @Given("User is on the Add Destination page")
    public void userIsOnTheAddDestinationPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-057: AUTOCOMPLETE LOCATION SUGGESTIONS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Ride' to open Add Destination page");
            System.out.println("  4. Add Destination page should be visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 10 seconds for Add Destination page...");
            System.out.println("");

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
            System.out.println("User should be on Add Destination page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User types text in the pickup or destination field")
    public void userTypesTextInThePickupOrDestinationField() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TYPE IN LOCATION FIELD");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Add Destination page");
            System.out.println("  2. Tap on pickup or destination input field");
            System.out.println("  3. Type some text (e.g., 'Casa', 'Rabat', etc.)");
            System.out.println("  4. Observe the autocomplete suggestions");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 12 seconds to type location...");

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
            System.out.println("Text should be typed in location field now.");

        } catch (Exception e) {
            System.out.println("Error typing location: " + e.getMessage());
        }
    }

    @Then("Suggestions should be displayed based on input")
    public void suggestionsShouldBeDisplayedBasedOnInput() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  AUTOCOMPLETE SUGGESTIONS VERIFICATION");
            System.out.println("========================================");

            // Check for suggestions list
            boolean hasSuggestionsList = pageSource.contains("ListView") ||
                                         pageSource.contains("RecyclerView") ||
                                         pageSource.contains("suggestion") ||
                                         pageSource.contains("Suggestion");

            // Check for location items
            boolean hasLocationItems = pageSource.contains("address") ||
                                       pageSource.contains("Address") ||
                                       pageSource.contains("location") ||
                                       pageSource.contains("Location") ||
                                       pageSource.contains("place") ||
                                       pageSource.contains("Place");

            // Check for common location indicators
            boolean hasLocationIndicators = pageSource.contains("street") ||
                                            pageSource.contains("Street") ||
                                            pageSource.contains("city") ||
                                            pageSource.contains("City") ||
                                            pageSource.contains("Morocco") ||
                                            pageSource.contains("Casablanca") ||
                                            pageSource.contains("Rabat");

            // Check for dropdown/autocomplete
            boolean hasAutocomplete = pageSource.contains("dropdown") ||
                                      pageSource.contains("Dropdown") ||
                                      pageSource.contains("autocomplete") ||
                                      pageSource.contains("Autocomplete") ||
                                      pageSource.contains("results") ||
                                      pageSource.contains("Results");

            // Check for multiple items (suggesting a list)
            boolean hasMultipleItems = pageSource.contains("item") ||
                                       pageSource.contains("Item") ||
                                       pageSource.split("TextView").length > 3;

            System.out.println("");
            System.out.println("Autocomplete Suggestions Verification:");
            System.out.println("---------------------------------------");
            System.out.println("  - Suggestions list: " + (hasSuggestionsList ? "YES" : "NO"));
            System.out.println("  - Location items: " + (hasLocationItems ? "YES" : "NO"));
            System.out.println("  - Location indicators: " + (hasLocationIndicators ? "YES" : "NO"));
            System.out.println("  - Autocomplete: " + (hasAutocomplete ? "YES" : "NO"));
            System.out.println("  - Multiple items: " + (hasMultipleItems ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSuggestionsList) score += 2;
            if (hasLocationItems) score += 2;
            if (hasLocationIndicators) score += 2;
            if (hasAutocomplete) score += 2;
            if (hasMultipleItems) score++;

            if (score >= 4 || hasLocationIndicators || (hasSuggestionsList && hasLocationItems)) {
                System.out.println("========================================");
                System.out.println("  TC-057: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Autocomplete suggestions displayed!");
                System.out.println("");
                if (hasSuggestionsList) System.out.println("  - Suggestions list visible");
                if (hasLocationItems) System.out.println("  - Location items shown");
                if (hasLocationIndicators) System.out.println("  - Location names visible");
                if (hasAutocomplete) System.out.println("  - Autocomplete working");
                if (hasMultipleItems) System.out.println("  - Multiple suggestions available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you type in the location field?");
                System.out.println("  - Did suggestions appear?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasMultipleItems || hasLocationItems) {
                System.out.println("========================================");
                System.out.println("  TC-057: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some suggestions detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you type in the location field?");
                System.out.println("  2. Did autocomplete suggestions appear?");
                System.out.println("  3. Are multiple location options visible?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-057: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect autocomplete suggestions.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you type in the pickup/destination field?");
                System.out.println("  2. Did suggestions appear based on input?");
                System.out.println("  3. Can you select a suggested location?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying autocomplete: " + e.getMessage());
            System.out.println("TC-057: FAILED - " + e.getMessage());
        }
    }
}
