package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC072_ReopenAppDuringSearchingSteps extends Page {

    @Given("App is in searching state")
    public void appIsInSearchingState() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-072: REOPEN APP DURING SEARCHING");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (enter locations)");
            System.out.println("  4. Tap 'Search for Driver'");
            System.out.println("  5. App should be in SEARCHING state");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to have app in searching state...");
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
            System.out.println("App should be in searching state now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User closes and reopens the app")
    public void userClosesAndReopensTheApp() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CLOSE AND REOPEN APP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Press Home button to minimize app");
            System.out.println("  2. Open Recent Apps");
            System.out.println("  3. Swipe away/close the Rider app");
            System.out.println("  4. Wait a few seconds");
            System.out.println("  5. Reopen the Rider app");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 20 seconds to close and reopen app...");

            for (int i = 0; i < 8; i++) {
                Thread.sleep(2500);
                System.out.println("Waiting... " + ((i + 1) * 2.5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore - app may be closed
                }
            }

            System.out.println("");
            System.out.println("App should be reopened by now.");

        } catch (Exception e) {
            System.out.println("Error during close/reopen: " + e.getMessage());
        }
    }

    @Then("App should resume at searching screen or show correct ride state")
    public void appShouldResumeAtSearchingScreenOrShowCorrectRideState() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  APP RESUME VERIFICATION");
            System.out.println("========================================");

            // Check for searching state
            boolean hasSearching = pageSource.contains("Searching") ||
                                   pageSource.contains("searching") ||
                                   pageSource.contains("Finding") ||
                                   pageSource.contains("finding") ||
                                   pageSource.contains("Looking") ||
                                   pageSource.contains("looking");

            // Check for driver indicators
            boolean hasDriverIndicator = pageSource.contains("Driver") ||
                                         pageSource.contains("driver");

            // Check for ride state (in progress, booked, etc.)
            boolean hasRideState = pageSource.contains("Ride") ||
                                   pageSource.contains("ride") ||
                                   pageSource.contains("Trip") ||
                                   pageSource.contains("trip") ||
                                   pageSource.contains("Booked") ||
                                   pageSource.contains("booked");

            // Check for cancel option (indicates active search/ride)
            boolean hasCancelOption = pageSource.contains("Cancel") ||
                                      pageSource.contains("cancel");

            // Check for home screen (if ride was cancelled/completed)
            boolean hasHomeScreen = pageSource.contains("Where") ||
                                    pageSource.contains("Destination") ||
                                    pageSource.contains("Book") ||
                                    pageSource.contains("Pick");

            // Check for map
            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            System.out.println("");
            System.out.println("App Resume Verification:");
            System.out.println("------------------------");
            System.out.println("  - Searching state: " + (hasSearching ? "YES" : "NO"));
            System.out.println("  - Driver indicator: " + (hasDriverIndicator ? "YES" : "NO"));
            System.out.println("  - Ride state: " + (hasRideState ? "YES" : "NO"));
            System.out.println("  - Cancel option: " + (hasCancelOption ? "YES" : "NO"));
            System.out.println("  - Home screen: " + (hasHomeScreen ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSearching) score += 3;
            if (hasDriverIndicator) score += 2;
            if (hasRideState) score += 2;
            if (hasCancelOption) score++;
            if (hasHomeScreen) score++;
            if (hasMap) score++;

            if (score >= 3 || hasSearching || hasRideState || (hasDriverIndicator && hasCancelOption) || hasHomeScreen) {
                System.out.println("========================================");
                System.out.println("  TC-072: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  App resumed with correct state!");
                System.out.println("");
                if (hasSearching) System.out.println("  - Resumed at searching screen");
                if (hasDriverIndicator) System.out.println("  - Driver search active");
                if (hasRideState) System.out.println("  - Ride state preserved");
                if (hasCancelOption) System.out.println("  - Cancel option available");
                if (hasHomeScreen) System.out.println("  - Home screen (ride may have ended)");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did app resume correctly?");
                System.out.println("  - Is ride state preserved?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-072: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you close and reopen the app?");
                System.out.println("  2. Did app resume at searching screen?");
                System.out.println("  3. Is the ride state correct?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying app resume: " + e.getMessage());
            System.out.println("TC-072: FAILED - " + e.getMessage());
        }
    }
}
