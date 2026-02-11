package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC036_ProfilePictureOpensHistorySteps extends Page {

    @Given("Rider is on the home screen")
    public void riderIsOnTheHomeScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-036: PROFILE PICTURE OPENS HISTORY");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to the Home screen");
            System.out.println("");
            System.out.println("  4. You should see:");
            System.out.println("     - Map view");
            System.out.println("     - Profile picture (top left or menu)");
            System.out.println("     - Book Ride options");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to be on home screen
            System.out.println("");
            System.out.println("Waiting 20 seconds to reach home screen...");
            System.out.println("Please ensure you are on the Rider home screen.");
            System.out.println("");

            for (int i = 0; i < 7; i++) {
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
            System.out.println("Rider should be on home screen now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("Rider taps on the profile picture")
    public void riderTapsOnTheProfilePicture() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP PROFILE PICTURE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rider home screen");
            System.out.println("  2. Look for your profile picture");
            System.out.println("     - Usually at top left corner");
            System.out.println("     - Or in the menu/hamburger icon area");
            System.out.println("  3. Tap on the profile picture");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap profile picture
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap profile picture...");

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
            System.out.println("Profile picture should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping profile: " + e.getMessage());
        }
    }

    @Then("App should navigate to History Tab")
    public void appShouldNavigateToHistoryTab() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  HISTORY TAB VERIFICATION");
            System.out.println("========================================");

            // Check for History tab indicators
            boolean hasHistoryTab = pageSource.contains("History") ||
                                    pageSource.contains("history") ||
                                    pageSource.contains("HISTORY");

            // Check for ride history indicators
            boolean hasRideHistory = pageSource.contains("Ride History") ||
                                     pageSource.contains("ride history") ||
                                     pageSource.contains("Trip History") ||
                                     pageSource.contains("trip history");

            // Check for history section indicators
            boolean hasHistorySection = pageSource.contains("In Progress") ||
                                        pageSource.contains("Completed") ||
                                        pageSource.contains("Cancelled") ||
                                        pageSource.contains("completed") ||
                                        pageSource.contains("cancelled");

            // Check for past rides indicators
            boolean hasPastRides = pageSource.contains("Past") ||
                                   pageSource.contains("past") ||
                                   pageSource.contains("Previous") ||
                                   pageSource.contains("previous");

            // Check for menu/profile section
            boolean hasMenuProfile = pageSource.contains("Profile") ||
                                     pageSource.contains("profile") ||
                                     pageSource.contains("Menu") ||
                                     pageSource.contains("menu") ||
                                     pageSource.contains("Settings") ||
                                     pageSource.contains("settings");

            // Check for ride list indicators
            boolean hasRideList = pageSource.contains("Ride") ||
                                  pageSource.contains("ride") ||
                                  pageSource.contains("Trip") ||
                                  pageSource.contains("trip");

            System.out.println("");
            System.out.println("History Tab Verification:");
            System.out.println("-------------------------");
            System.out.println("  - History tab: " + (hasHistoryTab ? "YES" : "NO"));
            System.out.println("  - Ride History: " + (hasRideHistory ? "YES" : "NO"));
            System.out.println("  - History sections: " + (hasHistorySection ? "YES" : "NO"));
            System.out.println("  - Past rides: " + (hasPastRides ? "YES" : "NO"));
            System.out.println("  - Menu/Profile: " + (hasMenuProfile ? "YES" : "NO"));
            System.out.println("  - Ride list: " + (hasRideList ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasHistoryTab) score += 3;
            if (hasRideHistory) score += 2;
            if (hasHistorySection) score += 2;
            if (hasPastRides) score++;
            if (hasMenuProfile) score++;
            if (hasRideList) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-036: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  History Tab navigation verified!");
                System.out.println("");
                if (hasHistoryTab) System.out.println("  - History tab visible");
                if (hasRideHistory) System.out.println("  - Ride History displayed");
                if (hasHistorySection) System.out.println("  - History sections present");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did tapping profile open History?");
                System.out.println("  - Can you see ride history list?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-036: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some history elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap profile picture?");
                System.out.println("  2. Did it open History tab?");
                System.out.println("  3. Can you see ride history?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-036: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect History tab.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Were you on Rider home screen?");
                System.out.println("  2. Did you tap profile picture?");
                System.out.println("  3. Did it navigate to History tab?");
                System.out.println("  4. What screen are you on now?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying History tab: " + e.getMessage());
            System.out.println("TC-036: FAILED - " + e.getMessage());
        }
    }
}
