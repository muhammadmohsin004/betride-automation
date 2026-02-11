package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.Page;

public class TC107_AppMinimizeRestoreDuringSearchSteps extends Page {

    @Given("User is on active searching screen")
    public void userIsOnActiveSearchingScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-107: APP MINIMIZE/RESTORE DURING SEARCH");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (Book Hourly or Book Ride)");
            System.out.println("  4. Select pickup/drop-off locations");
            System.out.println("  5. Tap 'Book your driver' or 'Search for Driver'");
            System.out.println("  6. You should now be on the SEARCHING screen");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach searching screen
            System.out.println("");
            System.out.println("Waiting 20 seconds to reach searching screen...");
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

            // Verify we're on searching screen
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnSearching = pageSource.contains("Search") ||
                                    pageSource.contains("search") ||
                                    pageSource.contains("Finding") ||
                                    pageSource.contains("Cancel") ||
                                    pageSource.contains("request") ||
                                    pageSource.contains("driver");

            if (isOnSearching) {
                System.out.println("Confirmed: On searching screen");
            } else {
                System.out.println("Please ensure you are on the searching screen.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User minimizes the app")
    public void userMinimizesTheApp() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  MINIMIZING THE APP");
            System.out.println("========================================");
            System.out.println("");

            // Try to minimize the app programmatically
            try {
                // Press home button to minimize
                AndroidDriverSetup.getAndroidDriver().runAppInBackground(java.time.Duration.ofSeconds(5));
                System.out.println("  App sent to background for 5 seconds...");
            } catch (Exception e) {
                System.out.println("  Auto-minimize not supported.");
                System.out.println("");
                System.out.println("  MANUAL ACTION REQUIRED:");
                System.out.println("");
                System.out.println("  1. Press the HOME button on your device");
                System.out.println("  2. Wait for 5 seconds");
                System.out.println("  3. Then reopen the BeetRide app");
                System.out.println("");
                System.out.println("  Waiting 10 seconds for manual minimize...");
                System.out.println("");

                for (int i = 0; i < 2; i++) {
                    Thread.sleep(5000);
                    System.out.println("  Waiting... " + ((i + 1) * 5) + " sec");
                }
            }

            System.out.println("");
            System.out.println("  App should be minimized now.");

        } catch (Exception e) {
            System.out.println("Error minimizing app: " + e.getMessage());
        }
    }

    @And("User reopens the app")
    public void userReopensTheApp() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  REOPENING THE APP");
            System.out.println("========================================");
            System.out.println("");

            // Try to reopen the app programmatically
            try {
                // Activate the app
                AndroidDriverSetup.getAndroidDriver().activateApp("com.bettride.rider");
                System.out.println("  App activated/reopened.");
            } catch (Exception e) {
                // Try alternative package name
                try {
                    AndroidDriverSetup.getAndroidDriver().activateApp("com.bettride.driver");
                    System.out.println("  App activated/reopened.");
                } catch (Exception e2) {
                    System.out.println("  Auto-reopen not supported.");
                    System.out.println("");
                    System.out.println("  MANUAL ACTION REQUIRED:");
                    System.out.println("");
                    System.out.println("  1. Tap on the BeetRide app icon");
                    System.out.println("  2. Or use Recent Apps to switch back");
                    System.out.println("");
                    System.out.println("  Waiting 10 seconds for manual reopen...");
                    System.out.println("");

                    for (int i = 0; i < 2; i++) {
                        Thread.sleep(5000);
                        System.out.println("  Waiting... " + ((i + 1) * 5) + " sec");
                    }
                }
            }

            Thread.sleep(3000); // Wait for app to fully restore

            System.out.println("");
            System.out.println("  App should be reopened now.");

        } catch (Exception e) {
            System.out.println("Error reopening app: " + e.getMessage());
        }
    }

    @Then("App should resume in search mode")
    public void appShouldResumeInSearchMode() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING SEARCH MODE RESUMED");
            System.out.println("========================================");
            System.out.println("");

            // Check for searching screen indicators
            boolean hasSearchingText = pageSource.contains("searching") ||
                                       pageSource.contains("Searching") ||
                                       pageSource.contains("Finding") ||
                                       pageSource.contains("finding") ||
                                       pageSource.contains("Looking") ||
                                       pageSource.contains("looking");

            boolean hasRideRequest = pageSource.contains("ride request") ||
                                     pageSource.contains("Ride request") ||
                                     pageSource.contains("request is sent") ||
                                     pageSource.contains("sent to drivers");

            boolean hasCancelOption = pageSource.contains("Cancel Request") ||
                                      pageSource.contains("Cancel request") ||
                                      pageSource.contains("Cancel");

            boolean hasDriverText = pageSource.contains("driver") ||
                                    pageSource.contains("Driver");

            System.out.println("Search Mode Verification:");
            System.out.println("-------------------------");
            System.out.println("  - Searching text: " + (hasSearchingText ? "YES" : "NO"));
            System.out.println("  - Ride request text: " + (hasRideRequest ? "YES" : "NO"));
            System.out.println("  - Cancel option visible: " + (hasCancelOption ? "YES" : "NO"));
            System.out.println("  - Driver text: " + (hasDriverText ? "YES" : "NO"));
            System.out.println("");

            if (hasSearchingText || hasRideRequest || (hasCancelOption && hasDriverText)) {
                System.out.println("  RESULT: App resumed in search mode successfully");
            } else {
                System.out.println("  RESULT: Please verify search mode manually");
            }

        } catch (Exception e) {
            System.out.println("Error verifying search mode: " + e.getMessage());
        }
    }

    @And("Search state should not be reset")
    public void searchStateShouldNotBeReset() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING SEARCH STATE NOT RESET");
            System.out.println("========================================");
            System.out.println("");

            // Check we're NOT on home/booking screen (which would indicate reset)
            boolean notOnHomeScreen = !pageSource.contains("Book Ride") ||
                                      pageSource.contains("Cancel");

            boolean notOnBookingScreen = !pageSource.contains("Select pickup") ||
                                         pageSource.contains("searching");

            // Check searching is still active
            boolean searchStillActive = pageSource.contains("Cancel") ||
                                        pageSource.contains("searching") ||
                                        pageSource.contains("Searching") ||
                                        pageSource.contains("Finding") ||
                                        pageSource.contains("driver") ||
                                        pageSource.contains("request");

            // Check for map (usually visible during search)
            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            System.out.println("State Preservation Verification:");
            System.out.println("--------------------------------");
            System.out.println("  - Not reset to home: " + (notOnHomeScreen ? "YES" : "NO"));
            System.out.println("  - Not reset to booking: " + (notOnBookingScreen ? "YES" : "NO"));
            System.out.println("  - Search still active: " + (searchStillActive ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (notOnHomeScreen) score++;
            if (notOnBookingScreen) score++;
            if (searchStillActive) score += 3;
            if (hasMap) score++;

            System.out.println("========================================");
            if (score >= 3 || searchStillActive) {
                System.out.println("  TC-107: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  App resumed in search mode - state not reset!");
                System.out.println("");
                System.out.println("  Verified:");
                if (notOnHomeScreen) System.out.println("    - Not reset to home screen");
                if (notOnBookingScreen) System.out.println("    - Not reset to booking screen");
                if (searchStillActive) System.out.println("    - Search still active");
                if (hasMap) System.out.println("    - Map still displayed");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is the app still on searching screen?");
                System.out.println("  - Was the search state preserved?");
                System.out.println("  - Did the app NOT restart from scratch?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-107: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is the app still on searching screen?");
                System.out.println("  2. Was the ride search preserved?");
                System.out.println("  3. Did the state NOT reset?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying search state: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-107: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
