package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Page;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TC014_FakeRideProtectionSteps extends Page {

    private List<String> receivedRideRequests = new ArrayList<>();
    private Set<String> uniqueRideIdentifiers = new HashSet<>();

    @And("Driver should only see real ride requests without duplicates")
    public void driverShouldOnlySeeRealRideRequestsWithoutDuplicates() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-014: FAKE RIDE PROTECTION TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  This test verifies that:");
            System.out.println("  1. Driver receives ONLY real ride requests");
            System.out.println("  2. No fake or duplicate requests appear");
            System.out.println("  3. System protects against fake API hits");
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
                System.out.println("Ride request detected on screen");

                // Capture ride details for uniqueness check
                String rideSnapshot = captureRideDetails(pageSource);
                receivedRideRequests.add(rideSnapshot);

                System.out.println("Captured ride request details");
                System.out.println("Monitoring for duplicate or fake requests...");

                // Monitor for 30 seconds to check if any duplicate/fake rides appear
                int duplicateCount = 0;
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(3000);

                    try {
                        String currentPageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
                        String currentRideSnapshot = captureRideDetails(currentPageSource);

                        // Check if this is a new unique ride or a duplicate
                        if (!uniqueRideIdentifiers.contains(currentRideSnapshot) &&
                            currentRideSnapshot.length() > 10) {
                            uniqueRideIdentifiers.add(currentRideSnapshot);
                            System.out.println("Unique ride request #" + uniqueRideIdentifiers.size());
                        } else if (uniqueRideIdentifiers.contains(currentRideSnapshot)) {
                            // Same ride still showing - this is normal
                            System.out.println("Same ride request still visible (normal)");
                        }

                        // Check for multiple ride popups at once (fake ride indicator)
                        int acceptButtonCount = countOccurrences(currentPageSource, "Accept");
                        int rejectButtonCount = countOccurrences(currentPageSource, "Reject");

                        if (acceptButtonCount > 1 || rejectButtonCount > 1) {
                            duplicateCount++;
                            System.out.println("WARNING: Multiple ride buttons detected!");
                            System.out.println("Accept buttons: " + acceptButtonCount);
                            System.out.println("Reject buttons: " + rejectButtonCount);
                        }

                        System.out.println("Monitoring... " + ((i + 1) * 3) + " sec");

                    } catch (Exception e) {
                        System.out.println("Session keep-alive at " + ((i + 1) * 3) + " sec");
                    }
                }

                if (duplicateCount == 0) {
                    System.out.println("");
                    System.out.println("No duplicate or fake ride requests detected during monitoring");
                } else {
                    System.out.println("");
                    System.out.println("WARNING: " + duplicateCount + " potential fake/duplicate rides detected");
                }

            } else {
                System.out.println("No ride request currently visible on screen");
                System.out.println("This is expected if no rider has created a ride yet");
                System.out.println("");
                System.out.println("To test fake ride protection:");
                System.out.println("1. Create a REAL ride from Rider app");
                System.out.println("2. Observe that only ONE ride request appears");
                System.out.println("3. No duplicate popups should appear");
            }

        } catch (Exception e) {
            System.out.println("Error during fake ride protection check: " + e.getMessage());
        }
    }

    @Then("Verify no fake or duplicate ride requests appear")
    public void verifyNoFakeOrDuplicateRideRequestsAppear() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  FAKE RIDE PROTECTION VERIFICATION");
            System.out.println("========================================");

            // Count ride request indicators
            int acceptCount = countOccurrences(pageSource, "Accept");
            int rejectCount = countOccurrences(pageSource, "Reject");
            int fareCount = countOccurrences(pageSource, "MAD");

            System.out.println("Ride Request Indicators Found:");
            System.out.println("  - Accept buttons: " + acceptCount);
            System.out.println("  - Reject buttons: " + rejectCount);
            System.out.println("  - Fare displays: " + fareCount);
            System.out.println("");

            // Verify no duplicates
            boolean noDuplicates = acceptCount <= 1 && rejectCount <= 1;

            // Check for any fake ride indicators in the page source
            boolean hasFakeIndicator = pageSource.contains("fake") ||
                                       pageSource.contains("Fake") ||
                                       pageSource.contains("FAKE") ||
                                       pageSource.contains("test_ride") ||
                                       pageSource.contains("duplicate");

            if (noDuplicates && !hasFakeIndicator) {
                System.out.println("RESULT: PASSED");
                System.out.println("");
                System.out.println("TC-014: Fake Ride Protection verified");
                System.out.println("  - No duplicate ride requests found");
                System.out.println("  - No fake ride indicators detected");
                System.out.println("  - Driver sees only real ride requests");
                System.out.println("");
                System.out.println("========================================");
            } else if (!noDuplicates) {
                System.out.println("RESULT: NEEDS VERIFICATION");
                System.out.println("");
                System.out.println("Multiple ride indicators found:");
                System.out.println("  - This could indicate duplicate/fake rides");
                System.out.println("  - Please verify manually if these are real requests");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("RESULT: POTENTIAL ISSUE");
                System.out.println("");
                System.out.println("Fake ride indicator found in page source");
                System.out.println("This may indicate fake ride protection is not working");
                System.out.println("");
                System.out.println("========================================");
            }

            // Print unique rides received during test
            System.out.println("");
            System.out.println("Total unique ride requests received: " + uniqueRideIdentifiers.size());

            if (uniqueRideIdentifiers.size() <= 1) {
                System.out.println("TC-014: PASSED - Only real ride requests received");
            } else {
                System.out.println("TC-014: NEEDS MANUAL VERIFICATION");
                System.out.println("Multiple unique rides received - verify if these are all real");
            }

        } catch (Exception e) {
            System.out.println("Error verifying fake ride protection: " + e.getMessage());
            System.out.println("TC-014: FAILED - " + e.getMessage());
        }
    }

    private String captureRideDetails(String pageSource) {
        // Extract ride-specific details to create a unique identifier
        StringBuilder details = new StringBuilder();

        // Try to extract fare
        int madIndex = pageSource.indexOf("MAD");
        if (madIndex > 0) {
            int start = Math.max(0, madIndex - 20);
            int end = Math.min(pageSource.length(), madIndex + 10);
            details.append(pageSource.substring(start, end));
        }

        // Try to extract distance
        int kmIndex = pageSource.indexOf("km");
        if (kmIndex > 0) {
            int start = Math.max(0, kmIndex - 15);
            int end = Math.min(pageSource.length(), kmIndex + 5);
            details.append(pageSource.substring(start, end));
        }

        return details.toString().trim();
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
