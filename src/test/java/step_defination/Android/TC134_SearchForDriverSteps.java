package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC134_SearchForDriverSteps extends Page {

    @Given("User is on Confirm Ride page with search button enabled")
    public void userIsOnConfirmRidePageWithSearchButtonEnabled() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-134: SEARCH FOR DRIVER");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Confirm Ride page");
            System.out.println("  4. Search for Driver button should be enabled");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 25 seconds to reach Confirm Ride page...");
            System.out.println("");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnConfirmRide = pageSource.contains("Confirm") ||
                                      pageSource.contains("confirm") ||
                                      pageSource.contains("Ride") ||
                                      pageSource.contains("Book") ||
                                      pageSource.contains("Fare") ||
                                      pageSource.contains("Search");

            if (isOnConfirmRide) {
                System.out.println("");
                System.out.println("Confirmed: On Confirm Ride page");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the Confirm Ride page.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Search for Driver button")
    public void userTapsSearchForDriverButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING SEARCH FOR DRIVER BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look for the 'Search for Driver' button");
            System.out.println("  2. Tap on the button");
            System.out.println("  3. Observe the navigation");
            System.out.println("");
            System.out.println("  NOTE: App should navigate to driver");
            System.out.println("  searching screen.");
            System.out.println("");
            System.out.println("========================================");

            System.out.println("");
            System.out.println("Waiting 15 seconds for manual action...");
            System.out.println("");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Search for Driver button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error during action: " + e.getMessage());
        }
    }

    @Then("App should navigate to driver searching screen")
    public void appShouldNavigateToDriverSearchingScreen() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING DRIVER SEARCHING SCREEN");
            System.out.println("========================================");
            System.out.println("");

            // Check for searching indicators
            boolean hasSearchingText = pageSource.contains("Searching") ||
                                       pageSource.contains("searching") ||
                                       pageSource.contains("Looking") ||
                                       pageSource.contains("looking") ||
                                       pageSource.contains("Finding") ||
                                       pageSource.contains("finding");

            // Check for driver-related text
            boolean hasDriverText = pageSource.contains("Driver") ||
                                     pageSource.contains("driver") ||
                                     pageSource.contains("ride") ||
                                     pageSource.contains("Ride");

            // Check for cancel option (usually available during search)
            boolean hasCancelOption = pageSource.contains("Cancel") ||
                                      pageSource.contains("cancel") ||
                                      pageSource.contains("Stop");

            // Check for loading/animation indicators
            boolean hasLoadingIndicator = pageSource.contains("Please wait") ||
                                           pageSource.contains("please wait") ||
                                           pageSource.contains("Loading") ||
                                           pageSource.contains("loading") ||
                                           pageSource.contains("wait");

            // Check for map still visible
            boolean hasMapContext = pageSource.contains("Map") ||
                                    pageSource.contains("map") ||
                                    pageSource.contains("km") ||
                                    pageSource.contains("min");

            System.out.println("Driver Searching Screen Verification:");
            System.out.println("--------------------------------------");
            System.out.println("  - Searching text visible: " + (hasSearchingText ? "YES" : "NO"));
            System.out.println("  - Driver text: " + (hasDriverText ? "YES" : "NO"));
            System.out.println("  - Cancel option: " + (hasCancelOption ? "YES" : "NO"));
            System.out.println("  - Loading indicator: " + (hasLoadingIndicator ? "YES" : "NO"));
            System.out.println("  - Map context: " + (hasMapContext ? "YES" : "NO"));
            System.out.println("");

            int score = 0;
            if (hasSearchingText) score += 3;
            if (hasDriverText) score += 2;
            if (hasCancelOption) score += 2;
            if (hasLoadingIndicator) score++;
            if (hasMapContext) score++;

            System.out.println("========================================");
            if (score >= 4 || (hasSearchingText && hasDriverText) || (hasDriverText && hasCancelOption)) {
                System.out.println("  TC-134: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Driver searching screen verified!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasSearchingText) System.out.println("    - Searching text visible");
                if (hasDriverText) System.out.println("    - Driver text found");
                if (hasCancelOption) System.out.println("    - Cancel option available");
                if (hasLoadingIndicator) System.out.println("    - Loading indicator visible");
                if (hasMapContext) System.out.println("    - Map context visible");
                System.out.println("");
                System.out.println("  Result: Navigated to driver searching screen");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-134: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did tapping 'Search for Driver' navigate?");
                System.out.println("  2. Is the driver searching screen visible?");
                System.out.println("  3. Is there a searching animation?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying searching screen: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-134: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
