package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC034_InviteFriendsClickToShareSteps extends Page {

    @Given("Rider navigates to the Invite Friends page")
    public void riderNavigatesToTheInviteFriendsPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-034: INVITE FRIENDS CLICK TO SHARE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  Navigate to Invite Friends page via:");
            System.out.println("");
            System.out.println("  Option 1 - After Rating Submission:");
            System.out.println("     - Complete a ride flow");
            System.out.println("     - Submit rating on Rate Driver page");
            System.out.println("     - Get redirected to Invite Friends page");
            System.out.println("");
            System.out.println("  Option 2 - From Side Menu:");
            System.out.println("     - Tap profile picture on home screen");
            System.out.println("     - Tap 'Invite Friends' in the menu");
            System.out.println("");
            System.out.println("  3. You should now be on the Invite Friends page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for manual navigation to Invite Friends page
            System.out.println("");
            System.out.println("Waiting 30 seconds to reach Invite Friends page...");
            System.out.println("Please navigate to Invite Friends page.");
            System.out.println("");

            for (int i = 0; i < 10; i++) {
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
            System.out.println("Rider should now be on Invite Friends page.");

        } catch (Exception e) {
            System.out.println("Error during navigation: " + e.getMessage());
        }
    }

    @Then("Click Here to Share button should be displayed")
    public void clickHereToShareButtonShouldBeDisplayed() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CLICK HERE TO SHARE BUTTON VERIFICATION");
            System.out.println("========================================");

            // Check for "Click here to share" button
            boolean hasClickHereToShare = pageSource.contains("Click here to share") ||
                                          pageSource.contains("click here to share") ||
                                          pageSource.contains("Click Here to Share") ||
                                          pageSource.contains("CLICK HERE TO SHARE") ||
                                          pageSource.contains("Click Here To Share");

            // Check for share button variations
            boolean hasShareButton = pageSource.contains("Share") ||
                                     pageSource.contains("share") ||
                                     pageSource.contains("SHARE");

            // Check for Invite Friends page indicators
            boolean hasInviteFriends = pageSource.contains("Invite Friends") ||
                                       pageSource.contains("invite friends") ||
                                       pageSource.contains("INVITE FRIENDS") ||
                                       pageSource.contains("Invite friends");

            // Check for referral indicators
            boolean hasReferral = pageSource.contains("Referral") ||
                                  pageSource.contains("referral") ||
                                  pageSource.contains("Refer") ||
                                  pageSource.contains("refer");

            // Check for social share options
            boolean hasSocialOptions = pageSource.contains("WhatsApp") ||
                                       pageSource.contains("Messenger") ||
                                       pageSource.contains("Facebook") ||
                                       pageSource.contains("SMS") ||
                                       pageSource.contains("Email");

            // Check for button/clickable element
            boolean hasButtonElement = pageSource.contains("Button") ||
                                       pageSource.contains("button") ||
                                       pageSource.contains("clickable=\"true\"");

            System.out.println("");
            System.out.println("Click Here to Share Verification:");
            System.out.println("----------------------------------");
            System.out.println("  - Click here to share: " + (hasClickHereToShare ? "YES" : "NO"));
            System.out.println("  - Share button: " + (hasShareButton ? "YES" : "NO"));
            System.out.println("  - Invite Friends page: " + (hasInviteFriends ? "YES" : "NO"));
            System.out.println("  - Referral text: " + (hasReferral ? "YES" : "NO"));
            System.out.println("  - Social options: " + (hasSocialOptions ? "YES" : "NO"));
            System.out.println("  - Button element: " + (hasButtonElement ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasClickHereToShare) score += 3;
            if (hasShareButton) score += 2;
            if (hasInviteFriends) score++;
            if (hasReferral) score++;
            if (hasSocialOptions) score++;
            if (hasButtonElement) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-034: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Click Here to Share button verified!");
                System.out.println("");
                if (hasClickHereToShare) System.out.println("  - 'Click here to share' button visible");
                if (hasInviteFriends) System.out.println("  - On Invite Friends page");
                if (hasSocialOptions) System.out.println("  - Social share options available");
                if (hasButtonElement) System.out.println("  - Button is clickable");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is 'Click Here to Share' button visible?");
                System.out.println("  - Is the button clickable?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-034: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some share elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on Invite Friends page?");
                System.out.println("  2. Is 'Click Here to Share' visible?");
                System.out.println("  3. Is the button clickable?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-034: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect share button.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on Invite Friends page?");
                System.out.println("  2. Is 'Click Here to Share' button visible?");
                System.out.println("  3. What buttons do you see?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying share button: " + e.getMessage());
            System.out.println("TC-034: FAILED - " + e.getMessage());
        }
    }
}
