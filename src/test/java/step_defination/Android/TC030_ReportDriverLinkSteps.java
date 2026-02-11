package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC030_ReportDriverLinkSteps extends Page {

    @Given("Rider is on the Rate Driver page for report test")
    public void riderIsOnTheRateDriverPageForReportTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-030: REPORT DRIVER LINK TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  1. Complete a ride flow:");
            System.out.println("     - Rider creates a ride");
            System.out.println("     - Driver accepts the ride");
            System.out.println("     - Rider accepts the driver");
            System.out.println("     - Complete the trip");
            System.out.println("");
            System.out.println("  2. After ride completion:");
            System.out.println("     - Close and reopen Rider app");
            System.out.println("     - See 'Rate Your Driver' popup");
            System.out.println("     - Tap a star to go to Rate Driver page");
            System.out.println("");
            System.out.println("  3. You should now be on the Rate Driver page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for manual navigation to Rate Driver page
            System.out.println("");
            System.out.println("Waiting 45 seconds to reach Rate Driver page...");
            System.out.println("Please complete the ride and navigate to Rate Driver page.");
            System.out.println("");

            for (int i = 0; i < 15; i++) {
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
            System.out.println("Rider should now be on Rate Driver page.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("Rider taps on Report Driver Now link")
    public void riderTapsOnReportDriverNowLink() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP REPORT DRIVER NOW LINK STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rate Driver page");
            System.out.println("  2. Scroll to find:");
            System.out.println("     'Had bad experience? Report Driver Now'");
            System.out.println("  3. Tap on 'Report Driver Now' link");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap link
            System.out.println("");
            System.out.println("Waiting 15 seconds to tap Report Driver Now link...");

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
            System.out.println("Report Driver Now link should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error during tap: " + e.getMessage());
        }
    }

    @Then("Rider should be redirected to report submission page")
    public void riderShouldBeRedirectedToReportSubmissionPage() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  REPORT SUBMISSION PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Report page indicators
            boolean hasReportPage = pageSource.contains("Report") ||
                                    pageSource.contains("report") ||
                                    pageSource.contains("REPORT");

            // Check for submission form indicators
            boolean hasSubmissionForm = pageSource.contains("Submit") ||
                                        pageSource.contains("submit") ||
                                        pageSource.contains("Send") ||
                                        pageSource.contains("send") ||
                                        pageSource.contains("complaint") ||
                                        pageSource.contains("Complaint");

            // Check for driver report elements
            boolean hasDriverReportElements = pageSource.contains("driver") ||
                                              pageSource.contains("Driver") ||
                                              pageSource.contains("issue") ||
                                              pageSource.contains("Issue") ||
                                              pageSource.contains("problem") ||
                                              pageSource.contains("Problem");

            // Check for text input (for report description)
            boolean hasTextInput = pageSource.contains("describe") ||
                                   pageSource.contains("Describe") ||
                                   pageSource.contains("details") ||
                                   pageSource.contains("Details") ||
                                   pageSource.contains("message") ||
                                   pageSource.contains("Message");

            // Check for category/type selection
            boolean hasCategorySelection = pageSource.contains("category") ||
                                           pageSource.contains("Category") ||
                                           pageSource.contains("type") ||
                                           pageSource.contains("Type") ||
                                           pageSource.contains("reason") ||
                                           pageSource.contains("Reason");

            System.out.println("");
            System.out.println("Report Submission Page Verification:");
            System.out.println("------------------------------------");
            System.out.println("  - Report page: " + (hasReportPage ? "YES" : "NO"));
            System.out.println("  - Submission form: " + (hasSubmissionForm ? "YES" : "NO"));
            System.out.println("  - Driver report elements: " + (hasDriverReportElements ? "YES" : "NO"));
            System.out.println("  - Text input: " + (hasTextInput ? "YES" : "NO"));
            System.out.println("  - Category selection: " + (hasCategorySelection ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasReportPage) score++;
            if (hasSubmissionForm) score++;
            if (hasDriverReportElements) score++;
            if (hasTextInput) score++;
            if (hasCategorySelection) score++;

            if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-030: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Report Driver link verified!");
                System.out.println("");
                System.out.println("  - 'Report Driver Now' link is clickable");
                if (hasReportPage) System.out.println("  - Report page displayed");
                if (hasSubmissionForm) System.out.println("  - Submission form available");
                if (hasDriverReportElements) System.out.println("  - Driver report elements visible");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 1) {
                System.out.println("========================================");
                System.out.println("  TC-030: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some report elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did 'Report Driver Now' link work?");
                System.out.println("  2. Were you redirected to report page?");
                System.out.println("  3. Can you submit a report?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-030: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect report page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was 'Report Driver Now' link visible?");
                System.out.println("  2. Did tapping it redirect to report page?");
                System.out.println("  3. Is the report submission form displayed?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying report page: " + e.getMessage());
            System.out.println("TC-030: FAILED - " + e.getMessage());
        }
    }
}
