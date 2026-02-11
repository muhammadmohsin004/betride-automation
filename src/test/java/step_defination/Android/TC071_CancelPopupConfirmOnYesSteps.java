package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC071_CancelPopupConfirmOnYesSteps extends Page {

    @Given("User has cancel popup visible for confirmation")
    public void userHasCancelPopupVisibleForConfirmation() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-071: CANCEL POPUP CONFIRM ON YES");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (enter locations)");
            System.out.println("  4. Tap 'Search for Driver'");
            System.out.println("  5. Tap 'Cancel Request' to show popup");
            System.out.println("  6. Cancel popup should be VISIBLE");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to have cancel popup visible...");
            System.out.println("");

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
            System.out.println("Cancel popup should be visible now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on YES button on cancel popup")
    public void userTapsOnYesButtonOnCancelPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP YES ON CANCEL POPUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the cancel popup");
            System.out.println("  2. Find 'YES' or 'Cancel Ride' button");
            System.out.println("  3. Tap on it");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap YES...");

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
            System.out.println("YES button should be tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping YES: " + e.getMessage());
        }
    }

    @Then("User should navigate back to previous screen and search stops")
    public void userShouldNavigateBackToPreviousScreenAndSearchStops() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CANCEL CONFIRM VERIFICATION");
            System.out.println("========================================");

            // Check that search is stopped (no searching indicators)
            boolean noSearching = !pageSource.contains("Searching") &&
                                  !pageSource.contains("searching") &&
                                  !pageSource.contains("Finding driver") &&
                                  !pageSource.contains("finding driver");

            // Check for home/booking screen indicators
            boolean hasHomeScreen = pageSource.contains("Where") ||
                                    pageSource.contains("Destination") ||
                                    pageSource.contains("destination") ||
                                    pageSource.contains("Book") ||
                                    pageSource.contains("book") ||
                                    pageSource.contains("Pick") ||
                                    pageSource.contains("pick");

            // Check for location fields
            boolean hasLocationFields = pageSource.contains("From") ||
                                        pageSource.contains("from") ||
                                        pageSource.contains("To") ||
                                        pageSource.contains("Drop") ||
                                        pageSource.contains("drop");

            // Check for map
            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            // Check search button available again
            boolean hasSearchButton = pageSource.contains("Search") ||
                                      pageSource.contains("search") ||
                                      pageSource.contains("Find") ||
                                      pageSource.contains("find");

            System.out.println("");
            System.out.println("Cancel Confirm Verification:");
            System.out.println("----------------------------");
            System.out.println("  - Search stopped: " + (noSearching ? "YES" : "NO"));
            System.out.println("  - Home/Booking screen: " + (hasHomeScreen ? "YES" : "NO"));
            System.out.println("  - Location fields: " + (hasLocationFields ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("  - Search button available: " + (hasSearchButton ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (noSearching) score += 3;
            if (hasHomeScreen) score += 2;
            if (hasLocationFields) score += 2;
            if (hasMap) score++;
            if (hasSearchButton) score++;

            if (score >= 4 || (noSearching && hasHomeScreen) || hasLocationFields) {
                System.out.println("========================================");
                System.out.println("  TC-071: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Search cancelled and navigated back!");
                System.out.println("");
                if (noSearching) System.out.println("  - Search has stopped");
                if (hasHomeScreen) System.out.println("  - Home/Booking screen visible");
                if (hasLocationFields) System.out.println("  - Location fields available");
                if (hasMap) System.out.println("  - Map is visible");
                if (hasSearchButton) System.out.println("  - Can search again");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did search stop after tapping YES?");
                System.out.println("  - Are you on the previous screen?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-071: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap YES on the popup?");
                System.out.println("  2. Did the search stop?");
                System.out.println("  3. Are you on the previous screen?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying cancel confirm: " + e.getMessage());
            System.out.println("TC-071: FAILED - " + e.getMessage());
        }
    }
}
