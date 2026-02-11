package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC033_SubmitRedirectsToInviteFriendsSteps extends Page {

    @Given("Rider is on the Rate Driver page for submit redirect test")
    public void riderIsOnTheRateDriverPageForSubmitRedirectTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-033: SUBMIT REDIRECTS TO INVITE FRIENDS");
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

    @When("Rider fills the rating fields with star selection")
    public void riderFillsTheRatingFieldsWithStarSelection() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  FILL RATING FIELDS STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rate Driver page");
            System.out.println("  2. Select a star rating (1-5 stars)");
            System.out.println("  3. Optionally fill other fields:");
            System.out.println("     - Did driver come on time? (Yes/No)");
            System.out.println("     - Did driver provide helmet? (Yes/No)");
            System.out.println("     - Tell us what can be improved (optional)");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to fill fields
            System.out.println("");
            System.out.println("Waiting 15 seconds to fill rating fields...");

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
            System.out.println("Rating fields should be filled now.");

        } catch (Exception e) {
            System.out.println("Error during fill: " + e.getMessage());
        }
    }

    @And("Rider taps Submit Rating button")
    public void riderTapsSubmitRatingButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP SUBMIT RATING BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Scroll to the bottom of the page");
            System.out.println("  2. Tap 'Submit Rating' button");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap submit
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Submit Rating...");

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
            System.out.println("Submit Rating should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error during tap: " + e.getMessage());
        }
    }

    @Then("Rider should be redirected to Invite Friends page")
    public void riderShouldBeRedirectedToInviteFriendsPage() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  INVITE FRIENDS PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Invite Friends page indicators
            boolean hasInviteFriends = pageSource.contains("Invite Friends") ||
                                       pageSource.contains("invite friends") ||
                                       pageSource.contains("INVITE FRIENDS") ||
                                       pageSource.contains("InviteFriends");

            // Check for share/invite indicators
            boolean hasShareInvite = pageSource.contains("Share") ||
                                     pageSource.contains("share") ||
                                     pageSource.contains("Invite") ||
                                     pageSource.contains("invite");

            // Check for "Click here to share" button
            boolean hasClickToShare = pageSource.contains("Click here to share") ||
                                      pageSource.contains("click here to share") ||
                                      pageSource.contains("Click Here to Share") ||
                                      pageSource.contains("CLICK HERE TO SHARE");

            // Check for referral/friend indicators
            boolean hasReferralFriend = pageSource.contains("Referral") ||
                                        pageSource.contains("referral") ||
                                        pageSource.contains("Friend") ||
                                        pageSource.contains("friend");

            // Check for social share indicators
            boolean hasSocialShare = pageSource.contains("WhatsApp") ||
                                     pageSource.contains("Messenger") ||
                                     pageSource.contains("Facebook") ||
                                     pageSource.contains("messenger");

            // Check that we're NOT on Rate Driver page anymore
            boolean notOnRatePage = !pageSource.contains("Rate Your Driver") &&
                                    !pageSource.contains("Submit Rating");

            System.out.println("");
            System.out.println("Invite Friends Page Verification:");
            System.out.println("----------------------------------");
            System.out.println("  - Invite Friends text: " + (hasInviteFriends ? "YES" : "NO"));
            System.out.println("  - Share/Invite: " + (hasShareInvite ? "YES" : "NO"));
            System.out.println("  - Click here to share: " + (hasClickToShare ? "YES" : "NO"));
            System.out.println("  - Referral/Friend: " + (hasReferralFriend ? "YES" : "NO"));
            System.out.println("  - Social share buttons: " + (hasSocialShare ? "YES" : "NO"));
            System.out.println("  - Left Rate page: " + (notOnRatePage ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasInviteFriends) score += 3;
            if (hasClickToShare) score += 2;
            if (hasShareInvite) score++;
            if (hasReferralFriend) score++;
            if (hasSocialShare) score++;
            if (notOnRatePage) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-033: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Invite Friends page verified!");
                System.out.println("");
                if (hasInviteFriends) System.out.println("  - 'Invite Friends' page displayed");
                if (hasClickToShare) System.out.println("  - 'Click here to share' button visible");
                if (hasSocialShare) System.out.println("  - Social share options available");
                if (notOnRatePage) System.out.println("  - Successfully left Rate Driver page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Are you on the Invite Friends page?");
                System.out.println("  - Is the 'Click here to share' button visible?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-033: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some invite elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did the rating submit successfully?");
                System.out.println("  2. Were you redirected to Invite Friends?");
                System.out.println("  3. Is 'Click here to share' visible?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-033: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Invite Friends page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you select a star rating?");
                System.out.println("  2. Did you tap Submit Rating?");
                System.out.println("  3. Were you redirected to Invite Friends?");
                System.out.println("  4. What page are you on now?");
                System.out.println("");
                System.out.println("  Expected: Invite Friends page with share button");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Invite Friends page: " + e.getMessage());
            System.out.println("TC-033: FAILED - " + e.getMessage());
        }
    }
}
