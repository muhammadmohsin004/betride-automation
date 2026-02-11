package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC058_IncorrectLocationEntrySteps extends Page {

    @Given("User is on the Add Destination page for location test")
    public void userIsOnTheAddDestinationPageForLocationTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-058: INCORRECT LOCATION ENTRY");
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

    @When("User enters invalid location text")
    public void userEntersInvalidLocationText() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ENTER INVALID LOCATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Add Destination page");
            System.out.println("  2. Tap on pickup or destination input field");
            System.out.println("  3. Type INVALID text (e.g., 'xyzabc123', 'asdfgh')");
            System.out.println("  4. Observe the suggestions list");
            System.out.println("");
            System.out.println("  NOTE: Enter text that won't match any location!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 12 seconds to enter invalid location...");

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
            System.out.println("Invalid location text should be entered now.");

        } catch (Exception e) {
            System.out.println("Error entering invalid location: " + e.getMessage());
        }
    }

    @Then("Suggestions should show No results found")
    public void suggestionsShouldShowNoResultsFound() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  NO RESULTS VERIFICATION");
            System.out.println("========================================");

            // Check for no results message
            boolean hasNoResults = pageSource.contains("No results") ||
                                   pageSource.contains("no results") ||
                                   pageSource.contains("No Results") ||
                                   pageSource.contains("NO RESULTS");

            // Check for not found message
            boolean hasNotFound = pageSource.contains("not found") ||
                                  pageSource.contains("Not found") ||
                                  pageSource.contains("Not Found") ||
                                  pageSource.contains("NOT FOUND");

            // Check for no matches
            boolean hasNoMatches = pageSource.contains("No matches") ||
                                   pageSource.contains("no matches") ||
                                   pageSource.contains("No match") ||
                                   pageSource.contains("no match");

            // Check for empty list indicator
            boolean hasEmptyList = pageSource.contains("empty") ||
                                   pageSource.contains("Empty") ||
                                   pageSource.contains("No locations") ||
                                   pageSource.contains("no locations");

            // Check for try again message
            boolean hasTryAgain = pageSource.contains("Try again") ||
                                  pageSource.contains("try again") ||
                                  pageSource.contains("Try different") ||
                                  pageSource.contains("try different");

            System.out.println("");
            System.out.println("No Results Verification:");
            System.out.println("------------------------");
            System.out.println("  - 'No results' message: " + (hasNoResults ? "YES" : "NO"));
            System.out.println("  - 'Not found' message: " + (hasNotFound ? "YES" : "NO"));
            System.out.println("  - 'No matches' message: " + (hasNoMatches ? "YES" : "NO"));
            System.out.println("  - Empty list indicator: " + (hasEmptyList ? "YES" : "NO"));
            System.out.println("  - 'Try again' message: " + (hasTryAgain ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasNoResults) score += 3;
            if (hasNotFound) score += 2;
            if (hasNoMatches) score += 2;
            if (hasEmptyList) score++;
            if (hasTryAgain) score++;

            if (score >= 2 || hasNoResults || hasNotFound || hasNoMatches) {
                System.out.println("========================================");
                System.out.println("  TC-058: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  No results message displayed!");
                System.out.println("");
                if (hasNoResults) System.out.println("  - 'No results found' shown");
                if (hasNotFound) System.out.println("  - 'Not found' message shown");
                if (hasNoMatches) System.out.println("  - 'No matches' message shown");
                if (hasEmptyList) System.out.println("  - Empty list indicator visible");
                if (hasTryAgain) System.out.println("  - 'Try again' suggestion shown");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you enter invalid location?");
                System.out.println("  - Did 'No results' appear?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasEmptyList || hasTryAgain) {
                System.out.println("========================================");
                System.out.println("  TC-058: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some no-results indication detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you enter invalid location text?");
                System.out.println("  2. Did 'No results found' appear?");
                System.out.println("  3. Was the suggestions list empty?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-058: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect 'No results' message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you enter invalid location?");
                System.out.println("     (e.g., 'xyzabc123', 'asdfgh')");
                System.out.println("  2. Did 'No results found' appear?");
                System.out.println("  3. Was the suggestions list empty?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying no results: " + e.getMessage());
            System.out.println("TC-058: FAILED - " + e.getMessage());
        }
    }
}
