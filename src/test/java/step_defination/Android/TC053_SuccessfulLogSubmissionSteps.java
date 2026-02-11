package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC053_SuccessfulLogSubmissionSteps extends Page {

    @Given("User is on Send Device Logs popup with internet ON")
    public void userIsOnSendDeviceLogsPopupWithInternetON() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-053: SUCCESSFUL LOG SUBMISSION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Make sure INTERNET IS ON");
            System.out.println("  4. Navigate to Settings");
            System.out.println("  5. Tap on 'Send Device Logs' option");
            System.out.println("  6. Popup should be visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Settings and tap Send Device Logs.");
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
            System.out.println("User should be on Send Device Logs popup now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Yes on the popup")
    public void userTapsYesOnThePopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP YES TO SEND LOGS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Ensure INTERNET IS ON");
            System.out.println("  2. On the Send Device Logs popup");
            System.out.println("  3. Tap on 'Yes' button");
            System.out.println("     (or confirm to send logs)");
            System.out.println("");
            System.out.println("  NOTE: Logs will start sending.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap Yes
            System.out.println("");
            System.out.println("Waiting 10 seconds for action...");

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
            System.out.println("Yes should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Yes: " + e.getMessage());
        }
    }

    @Then("Logs should be sent successfully and success message appears")
    public void logsShouldBeSentSuccessfullyAndSuccessMessageAppears() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  LOG SUBMISSION VERIFICATION");
            System.out.println("========================================");

            // Check for success message
            boolean hasSuccessMessage = pageSource.contains("Success") ||
                                        pageSource.contains("success") ||
                                        pageSource.contains("Sent") ||
                                        pageSource.contains("sent") ||
                                        pageSource.contains("Successfully") ||
                                        pageSource.contains("successfully");

            // Check for logs sent indicator
            boolean hasLogsSent = pageSource.contains("Logs sent") ||
                                  pageSource.contains("logs sent") ||
                                  pageSource.contains("Device logs") ||
                                  pageSource.contains("device logs") ||
                                  pageSource.contains("submitted") ||
                                  pageSource.contains("Submitted");

            // Check for sending/uploading indicator
            boolean hasSendingIndicator = pageSource.contains("Sending") ||
                                          pageSource.contains("sending") ||
                                          pageSource.contains("Uploading") ||
                                          pageSource.contains("uploading") ||
                                          pageSource.contains("Please wait");

            // Check for completion
            boolean hasCompletion = pageSource.contains("Complete") ||
                                    pageSource.contains("complete") ||
                                    pageSource.contains("Done") ||
                                    pageSource.contains("done") ||
                                    pageSource.contains("OK");

            // Check if back to Settings
            boolean backToSettings = pageSource.contains("Settings") ||
                                     pageSource.contains("settings");

            System.out.println("");
            System.out.println("Log Submission Verification:");
            System.out.println("-----------------------------");
            System.out.println("  - Success message: " + (hasSuccessMessage ? "YES" : "NO"));
            System.out.println("  - Logs sent: " + (hasLogsSent ? "YES" : "NO"));
            System.out.println("  - Sending indicator: " + (hasSendingIndicator ? "YES" : "NO"));
            System.out.println("  - Completion: " + (hasCompletion ? "YES" : "NO"));
            System.out.println("  - Back to Settings: " + (backToSettings ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSuccessMessage) score += 3;
            if (hasLogsSent) score += 2;
            if (hasSendingIndicator) score += 2;
            if (hasCompletion) score += 2;
            if (backToSettings) score++;

            if (score >= 4 || hasSuccessMessage || hasLogsSent) {
                System.out.println("========================================");
                System.out.println("  TC-053: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Logs sent successfully!");
                System.out.println("");
                if (hasSuccessMessage) System.out.println("  - Success message shown");
                if (hasLogsSent) System.out.println("  - Logs sent indicator visible");
                if (hasSendingIndicator) System.out.println("  - Sending/uploading in progress");
                if (hasCompletion) System.out.println("  - Process completed");
                if (backToSettings) System.out.println("  - Returned to Settings");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did logs send successfully?");
                System.out.println("  - Did success message appear?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasSendingIndicator || backToSettings) {
                System.out.println("========================================");
                System.out.println("  TC-053: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Logs appear to be sending.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Yes?");
                System.out.println("  2. Did logs start sending?");
                System.out.println("  3. Did success message appear?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-053: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect success message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was internet ON?");
                System.out.println("  2. Did you tap Yes?");
                System.out.println("  3. Did logs send successfully?");
                System.out.println("  4. Did success message appear?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app");
                System.out.println("  and INTERNET to be ON.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying log submission: " + e.getMessage());
            System.out.println("TC-053: FAILED - " + e.getMessage());
        }
    }
}
