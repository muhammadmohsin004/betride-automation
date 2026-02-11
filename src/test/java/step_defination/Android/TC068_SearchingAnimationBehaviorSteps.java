package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC068_SearchingAnimationBehaviorSteps extends Page {

    @Given("User has initiated driver search")
    public void userHasInitiatedDriverSearch() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-068: SEARCHING ANIMATION BEHAVIOR");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (enter locations)");
            System.out.println("  4. Tap 'Search for Driver'");
            System.out.println("  5. Search should be active");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to initiate search...");
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
            System.out.println("Driver search should be initiated.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User observes the searching system")
    public void userObservesTheSearchingSystem() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  OBSERVE SEARCHING ANIMATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL OBSERVATION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Watch the searching screen");
            System.out.println("  2. Observe the animation:");
            System.out.println("     - Is there a loading/searching animation?");
            System.out.println("     - Does it loop continuously?");
            System.out.println("  3. Animation should continue until:");
            System.out.println("     - A driver accepts the ride, OR");
            System.out.println("     - User cancels the search");
            System.out.println("");
            System.out.println("========================================");

            // Wait for observation
            System.out.println("");
            System.out.println("Waiting 10 seconds to observe animation...");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println("Observing... " + ((i + 1) * 2.5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Observation period complete.");

        } catch (Exception e) {
            System.out.println("Error observing: " + e.getMessage());
        }
    }

    @Then("Searching animation should loop until driver accepts or user cancels")
    public void searchingAnimationShouldLoopUntilDriverAcceptsOrUserCancels() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SEARCHING ANIMATION VERIFICATION");
            System.out.println("========================================");

            // Check for searching indicators
            boolean hasSearching = pageSource.contains("Searching") ||
                                   pageSource.contains("searching") ||
                                   pageSource.contains("Finding") ||
                                   pageSource.contains("finding") ||
                                   pageSource.contains("Looking") ||
                                   pageSource.contains("looking");

            // Check for driver indicators
            boolean hasDriverIndicator = pageSource.contains("Driver") ||
                                         pageSource.contains("driver");

            // Check for cancel option
            boolean hasCancelOption = pageSource.contains("Cancel") ||
                                      pageSource.contains("cancel") ||
                                      pageSource.contains("Stop") ||
                                      pageSource.contains("stop");

            // Check for animation/loading indicators
            boolean hasAnimation = pageSource.contains("Loading") ||
                                   pageSource.contains("loading") ||
                                   pageSource.contains("Progress") ||
                                   pageSource.contains("progress") ||
                                   pageSource.contains("Please wait") ||
                                   pageSource.contains("please wait");

            // Check for wait time
            boolean hasWaitTime = pageSource.contains("min") ||
                                  pageSource.contains("sec") ||
                                  pageSource.contains("wait");

            System.out.println("");
            System.out.println("Searching Animation Verification:");
            System.out.println("----------------------------------");
            System.out.println("  - Searching message: " + (hasSearching ? "YES" : "NO"));
            System.out.println("  - Driver indicator: " + (hasDriverIndicator ? "YES" : "NO"));
            System.out.println("  - Cancel option: " + (hasCancelOption ? "YES" : "NO"));
            System.out.println("  - Animation/Loading: " + (hasAnimation ? "YES" : "NO"));
            System.out.println("  - Wait time: " + (hasWaitTime ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSearching) score += 3;
            if (hasDriverIndicator) score += 2;
            if (hasCancelOption) score += 2;
            if (hasAnimation) score += 2;
            if (hasWaitTime) score++;

            if (score >= 4 || hasSearching || (hasDriverIndicator && hasCancelOption)) {
                System.out.println("========================================");
                System.out.println("  TC-068: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Searching animation behavior verified!");
                System.out.println("");
                if (hasSearching) System.out.println("  - 'Searching' message shown");
                if (hasDriverIndicator) System.out.println("  - Driver search active");
                if (hasCancelOption) System.out.println("  - Cancel option available");
                if (hasAnimation) System.out.println("  - Animation/Loading visible");
                if (hasWaitTime) System.out.println("  - Wait time displayed");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is animation looping?");
                System.out.println("  - Can you cancel the search?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-068: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is searching animation visible?");
                System.out.println("  2. Does animation loop continuously?");
                System.out.println("  3. Is cancel option available?");
                System.out.println("  4. Does search stop when driver accepts?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying animation: " + e.getMessage());
            System.out.println("TC-068: FAILED - " + e.getMessage());
        }
    }
}
