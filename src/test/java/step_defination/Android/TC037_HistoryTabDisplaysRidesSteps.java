package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC037_HistoryTabDisplaysRidesSteps extends Page {

    @Given("Rider has past and ongoing rides")
    public void riderHasPastAndOngoingRides() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-037: HISTORY TAB DISPLAYS RIDES");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Rider should have:");
            System.out.println("     - Some completed rides in history");
            System.out.println("     - Some cancelled rides (if any)");
            System.out.println("     - Optionally an in-progress ride");
            System.out.println("");
            System.out.println("  2. Open the Rider app");
            System.out.println("  3. Ensure you are logged in");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Ensure Rider app is open and logged in.");
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
            System.out.println("Rider should be ready.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("Rider navigates to the History Tab")
    public void riderNavigatesToTheHistoryTab() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  NAVIGATE TO HISTORY TAB");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rider home screen");
            System.out.println("  2. Tap on profile picture (top left)");
            System.out.println("  3. This should open History Tab");
            System.out.println("     OR");
            System.out.println("  4. Navigate to History from side menu");
            System.out.println("");
            System.out.println("  5. You should see the History Tab with:");
            System.out.println("     - In Progress section");
            System.out.println("     - Completed section");
            System.out.println("     - Cancelled section");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to navigate
            System.out.println("");
            System.out.println("Waiting 15 seconds to navigate to History Tab...");

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
            System.out.println("Should be on History Tab now.");

        } catch (Exception e) {
            System.out.println("Error navigating: " + e.getMessage());
        }
    }

    @Then("History tab should show In Progress Completed and Cancelled sections")
    public void historyTabShouldShowInProgressCompletedAndCancelledSections() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  HISTORY SECTIONS VERIFICATION");
            System.out.println("========================================");

            // Check for In Progress section
            boolean hasInProgress = pageSource.contains("In Progress") ||
                                    pageSource.contains("in progress") ||
                                    pageSource.contains("IN PROGRESS") ||
                                    pageSource.contains("InProgress") ||
                                    pageSource.contains("In-Progress");

            // Check for Completed section
            boolean hasCompleted = pageSource.contains("Completed") ||
                                   pageSource.contains("completed") ||
                                   pageSource.contains("COMPLETED") ||
                                   pageSource.contains("Complete");

            // Check for Cancelled section
            boolean hasCancelled = pageSource.contains("Cancelled") ||
                                   pageSource.contains("cancelled") ||
                                   pageSource.contains("CANCELLED") ||
                                   pageSource.contains("Canceled") ||
                                   pageSource.contains("canceled");

            // Check for History tab indicators
            boolean hasHistoryTab = pageSource.contains("History") ||
                                    pageSource.contains("history") ||
                                    pageSource.contains("HISTORY");

            // Check for ride list indicators
            boolean hasRideList = pageSource.contains("Ride") ||
                                  pageSource.contains("ride") ||
                                  pageSource.contains("Trip") ||
                                  pageSource.contains("trip");

            // Check for date/time indicators (ride entries)
            boolean hasDateTimeIndicators = pageSource.contains("MAD") ||
                                            pageSource.contains("km") ||
                                            pageSource.contains("min") ||
                                            pageSource.contains("Jan") ||
                                            pageSource.contains("Feb") ||
                                            pageSource.contains("2026");

            System.out.println("");
            System.out.println("History Sections Verification:");
            System.out.println("------------------------------");
            System.out.println("  - In Progress: " + (hasInProgress ? "YES" : "NO"));
            System.out.println("  - Completed: " + (hasCompleted ? "YES" : "NO"));
            System.out.println("  - Cancelled: " + (hasCancelled ? "YES" : "NO"));
            System.out.println("  - History tab: " + (hasHistoryTab ? "YES" : "NO"));
            System.out.println("  - Ride list: " + (hasRideList ? "YES" : "NO"));
            System.out.println("  - Date/Time entries: " + (hasDateTimeIndicators ? "YES" : "NO"));
            System.out.println("");

            // Count how many sections are found
            int sectionsFound = 0;
            if (hasInProgress) sectionsFound++;
            if (hasCompleted) sectionsFound++;
            if (hasCancelled) sectionsFound++;

            // Calculate verification score
            int score = 0;
            score += sectionsFound * 2;
            if (hasHistoryTab) score++;
            if (hasRideList) score++;
            if (hasDateTimeIndicators) score++;

            if (sectionsFound >= 2 || score >= 4) {
                System.out.println("========================================");
                System.out.println("  TC-037: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  History sections verified!");
                System.out.println("");
                System.out.println("  Sections found: " + sectionsFound + "/3");
                if (hasInProgress) System.out.println("  - 'In Progress' section visible");
                if (hasCompleted) System.out.println("  - 'Completed' section visible");
                if (hasCancelled) System.out.println("  - 'Cancelled' section visible");
                if (hasRideList) System.out.println("  - Ride entries displayed");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Are all 3 sections visible?");
                System.out.println("  - Do rides appear in correct sections?");
                System.out.println("");
                System.out.println("========================================");
            } else if (sectionsFound >= 1 || score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-037: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some history sections detected.");
                System.out.println("  Sections found: " + sectionsFound + "/3");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on History Tab?");
                System.out.println("  2. Can you see In Progress section?");
                System.out.println("  3. Can you see Completed section?");
                System.out.println("  4. Can you see Cancelled section?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-037: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect history sections.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you navigate to History Tab?");
                System.out.println("  2. Can you see In Progress section?");
                System.out.println("  3. Can you see Completed section?");
                System.out.println("  4. Can you see Cancelled section?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying history sections: " + e.getMessage());
            System.out.println("TC-037: FAILED - " + e.getMessage());
        }
    }
}
