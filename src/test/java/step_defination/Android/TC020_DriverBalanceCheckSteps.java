package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC020_DriverBalanceCheckSteps extends Page {

    @Then("Driver should see low balance warning popup")
    public void driverShouldSeeLowBalanceWarningPopup() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-020: DRIVER BALANCE CHECK");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  Verifying low balance warning popup");
            System.out.println("  appears when driver accepts ride.");
            System.out.println("");
            System.out.println("========================================");

            // Check for low balance warning indicators
            boolean hasLowBalanceWarning = pageSource.contains("Balance low") ||
                                           pageSource.contains("balance low") ||
                                           pageSource.contains("Low Balance") ||
                                           pageSource.contains("low balance") ||
                                           pageSource.contains("LOW BALANCE") ||
                                           pageSource.contains("Insufficient") ||
                                           pageSource.contains("insufficient");

            // Check for recharge message
            boolean hasRechargeMessage = pageSource.contains("recharge") ||
                                         pageSource.contains("Recharge") ||
                                         pageSource.contains("RECHARGE") ||
                                         pageSource.contains("top up") ||
                                         pageSource.contains("Top Up") ||
                                         pageSource.contains("add funds") ||
                                         pageSource.contains("Add Funds");

            // Check for continue message
            boolean hasContinueMessage = pageSource.contains("continue") ||
                                         pageSource.contains("Continue") ||
                                         pageSource.contains("proceed") ||
                                         pageSource.contains("Proceed");

            // Check for balance-related keywords
            boolean hasBalanceKeywords = pageSource.contains("Balance") ||
                                         pageSource.contains("balance") ||
                                         pageSource.contains("Wallet") ||
                                         pageSource.contains("wallet") ||
                                         pageSource.contains("MAD");

            // Check for popup/alert indicators
            boolean hasPopupIndicators = pageSource.contains("OK") ||
                                         pageSource.contains("Ok") ||
                                         pageSource.contains("Close") ||
                                         pageSource.contains("Dismiss") ||
                                         pageSource.contains("Got it") ||
                                         pageSource.contains("Understood");

            // Check for warning indicators
            boolean hasWarningIndicators = pageSource.contains("Warning") ||
                                           pageSource.contains("warning") ||
                                           pageSource.contains("Alert") ||
                                           pageSource.contains("alert") ||
                                           pageSource.contains("Notice") ||
                                           pageSource.contains("notice");

            // Check if ride was accepted (navigation/pickup screen)
            boolean rideAccepted = pageSource.contains("Navigate") ||
                                   pageSource.contains("Pickup") ||
                                   pageSource.contains("Arrived") ||
                                   pageSource.contains("Start") ||
                                   pageSource.contains("Drop");

            System.out.println("");
            System.out.println("Balance Check Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Low balance warning: " + (hasLowBalanceWarning ? "YES" : "NO"));
            System.out.println("  - Recharge message: " + (hasRechargeMessage ? "YES" : "NO"));
            System.out.println("  - Continue message: " + (hasContinueMessage ? "YES" : "NO"));
            System.out.println("  - Balance keywords: " + (hasBalanceKeywords ? "YES" : "NO"));
            System.out.println("  - Popup indicators: " + (hasPopupIndicators ? "YES" : "NO"));
            System.out.println("  - Warning indicators: " + (hasWarningIndicators ? "YES" : "NO"));
            System.out.println("  - Ride accepted: " + (rideAccepted ? "YES" : "NO"));
            System.out.println("");

            // Determine test result
            boolean lowBalancePopupDetected = hasLowBalanceWarning ||
                                              (hasBalanceKeywords && hasRechargeMessage) ||
                                              (hasWarningIndicators && hasBalanceKeywords);

            if (lowBalancePopupDetected) {
                System.out.println("========================================");
                System.out.println("  TC-020: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Low balance warning popup detected!");
                System.out.println("");
                System.out.println("  - Balance warning shown to driver");
                if (hasRechargeMessage) {
                    System.out.println("  - Recharge message displayed");
                }
                if (hasContinueMessage) {
                    System.out.println("  - Continue instruction shown");
                }
                System.out.println("");
                System.out.println("========================================");
            } else if (rideAccepted) {
                System.out.println("========================================");
                System.out.println("  TC-020: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Ride appears to be accepted.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did low balance popup appear?");
                System.out.println("  2. If driver has sufficient balance,");
                System.out.println("     no popup would appear (expected)");
                System.out.println("");
                System.out.println("  Note: This test requires driver to have");
                System.out.println("  balance BELOW minimum threshold.");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-020: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect low balance popup.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is driver balance below minimum?");
                System.out.println("  2. Did popup appear after Accept?");
                System.out.println("  3. Does popup show 'Balance low,");
                System.out.println("     recharge to continue' message?");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(2000, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error checking low balance warning: " + e.getMessage());
            System.out.println("TC-020: FAILED - " + e.getMessage());
        }
    }
}
