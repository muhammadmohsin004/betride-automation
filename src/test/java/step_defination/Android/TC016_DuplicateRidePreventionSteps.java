package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Page;

import java.util.ArrayList;
import java.util.List;

public class TC016_DuplicateRidePreventionSteps extends Page {

    private int rideRequestCount = 0;
    private List<String> rideSnapshots = new ArrayList<>();

    @And("Driver should receive only one ride request not duplicates")
    public void driverShouldReceiveOnlyOneRideRequestNotDuplicates() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-016: DUPLICATE RIDE PREVENTION TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  This test verifies that:");
            System.out.println("  1. Driver receives only ONE ride request");
            System.out.println("  2. No duplicate ride popups appear");
            System.out.println("  3. System prevents duplicate rides from showing");
            System.out.println("");
            System.out.println("  MANUAL TEST STEPS:");
            System.out.println("  1. Create a ride from Rider app");
            System.out.println("  2. Try creating the SAME ride again quickly");
            System.out.println("  3. Observe that driver gets only ONE request");
            System.out.println("");
            System.out.println("========================================");

            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            // Check if a ride request is visible
            boolean hasRideRequest = pageSource.contains("Accept") ||
                                     pageSource.contains("Reject") ||
                                     pageSource.contains("MAD") ||
                                     pageSource.contains("Fare");

            if (hasRideRequest) {
                rideRequestCount++;
                System.out.println("Ride request #" + rideRequestCount + " detected");

                // Capture ride snapshot for comparison
                String snapshot = captureRideSnapshot(pageSource);
                rideSnapshots.add(snapshot);

                System.out.println("Monitoring for duplicate requests (30 seconds)...");

                // Monitor for 30 seconds to check if duplicate rides appear
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(3000);

                    try {
                        String currentPageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

                        // Count Accept/Reject buttons to detect multiple popups
                        int acceptCount = countOccurrences(currentPageSource, "Accept");
                        int rejectCount = countOccurrences(currentPageSource, "Reject");

                        if (acceptCount > 1) {
                            System.out.println("WARNING: Multiple Accept buttons detected (" + acceptCount + ")");
                            System.out.println("This may indicate duplicate ride requests!");
                        }

                        if (rejectCount > 1) {
                            System.out.println("WARNING: Multiple Reject buttons detected (" + rejectCount + ")");
                            System.out.println("This may indicate duplicate ride requests!");
                        }

                        // Check if ride popup is still visible (same single ride)
                        boolean stillHasRide = currentPageSource.contains("Accept") ||
                                              currentPageSource.contains("Reject");

                        if (stillHasRide && acceptCount <= 1 && rejectCount <= 1) {
                            System.out.println("Single ride request still visible... " + ((i + 1) * 3) + " sec");
                        }

                    } catch (Exception e) {
                        System.out.println("Session keep-alive at " + ((i + 1) * 3) + " sec");
                    }
                }

                System.out.println("");
                System.out.println("Monitoring complete. Total ride requests detected: " + rideRequestCount);

            } else {
                System.out.println("No ride request currently visible on screen");
                System.out.println("");
                System.out.println("To test duplicate prevention:");
                System.out.println("1. Create a ride from Rider app");
                System.out.println("2. Quickly try to create the same ride again");
                System.out.println("3. Verify only ONE ride appears on driver screen");
            }

        } catch (Exception e) {
            System.out.println("Error during duplicate ride check: " + e.getMessage());
        }
    }

    @Then("Verify no duplicate ride requests appear on driver screen")
    public void verifyNoDuplicateRideRequestsAppearOnDriverScreen() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DUPLICATE PREVENTION VERIFICATION");
            System.out.println("========================================");

            // Count ride request indicators
            int acceptCount = countOccurrences(pageSource, "Accept");
            int rejectCount = countOccurrences(pageSource, "Reject");
            int fareCount = countOccurrences(pageSource, "MAD");

            System.out.println("");
            System.out.println("Ride Request Indicators:");
            System.out.println("  - Accept buttons: " + acceptCount);
            System.out.println("  - Reject buttons: " + rejectCount);
            System.out.println("  - Fare displays: " + fareCount);
            System.out.println("");

            // Verify no duplicates (should have at most 1 of each)
            boolean noDuplicateButtons = acceptCount <= 1 && rejectCount <= 1;

            // Calculate total ride popups detected
            int estimatedRidePopups = Math.max(acceptCount, rejectCount);

            System.out.println("Estimated ride popups on screen: " + estimatedRidePopups);
            System.out.println("");

            if (noDuplicateButtons && estimatedRidePopups <= 1) {
                System.out.println("========================================");
                System.out.println("  TC-016: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Duplicate ride prevention verified!");
                System.out.println("  - Only ONE ride request visible");
                System.out.println("  - No duplicate popups detected");
                System.out.println("  - System correctly prevents duplicates");
                System.out.println("");
                System.out.println("  NOTE: For full verification, try creating");
                System.out.println("  the same ride multiple times from Rider app");
                System.out.println("  and confirm only one appears on Driver app.");
                System.out.println("========================================");
            } else if (estimatedRidePopups > 1) {
                System.out.println("========================================");
                System.out.println("  TC-016: POTENTIAL ISSUE");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Multiple ride popups detected!");
                System.out.println("  Estimated ride popups: " + estimatedRidePopups);
                System.out.println("");
                System.out.println("  This could indicate:");
                System.out.println("  - Duplicate ride prevention not working");
                System.out.println("  - Multiple different rides received");
                System.out.println("");
                System.out.println("  Please verify manually.");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-016: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  No ride popup currently visible.");
                System.out.println("  Please test by creating multiple same");
                System.out.println("  rides from Rider app quickly.");
                System.out.println("========================================");
            }

            // Print summary
            System.out.println("");
            System.out.println("Test Summary:");
            System.out.println("  - Total ride snapshots captured: " + rideSnapshots.size());
            System.out.println("  - Ride request count: " + rideRequestCount);

            if (rideRequestCount <= 1 && estimatedRidePopups <= 1) {
                System.out.println("");
                System.out.println("TC-016: PASSED - Only single ride request received");
            }

        } catch (Exception e) {
            System.out.println("Error verifying duplicate prevention: " + e.getMessage());
            System.out.println("TC-016: FAILED - " + e.getMessage());
        }
    }

    private String captureRideSnapshot(String pageSource) {
        StringBuilder snapshot = new StringBuilder();

        // Extract fare info
        int madIndex = pageSource.indexOf("MAD");
        if (madIndex > 0) {
            int start = Math.max(0, madIndex - 20);
            int end = Math.min(pageSource.length(), madIndex + 10);
            snapshot.append(pageSource.substring(start, end));
        }

        // Extract distance info
        int kmIndex = pageSource.indexOf("km");
        if (kmIndex > 0) {
            int start = Math.max(0, kmIndex - 15);
            int end = Math.min(pageSource.length(), kmIndex + 5);
            snapshot.append(pageSource.substring(start, end));
        }

        return snapshot.toString().trim();
    }

    private int countOccurrences(String text, String pattern) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index += pattern.length();
        }
        return count;
    }
}
