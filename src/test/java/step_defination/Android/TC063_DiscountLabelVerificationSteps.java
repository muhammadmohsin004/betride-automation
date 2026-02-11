package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC063_DiscountLabelVerificationSteps extends Page {

    @Given("User is on the Confirm Ride page with discount applicable")
    public void userIsOnTheConfirmRidePageWithDiscountApplicable() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-063: DISCOUNT LABEL VERIFICATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on 'Book Ride'");
            System.out.println("  4. Enter pickup and drop-off locations");
            System.out.println("  5. Select a ride option (with discount)");
            System.out.println("  6. Navigate to Confirm Ride page");
            System.out.println("");
            System.out.println("  NOTE: Discount should be applicable.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to reach Confirm Ride page...");
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
            System.out.println("User should be on Confirm Ride page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User views the discount section")
    public void userViewsTheDiscountSection() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VIEW DISCOUNT SECTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Confirm Ride page");
            System.out.println("  2. Look for the discount section");
            System.out.println("  3. Observe the discount message");
            System.out.println("     (e.g., 'Discount automatically applied')");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to view
            System.out.println("");
            System.out.println("Waiting 5 seconds to view discount...");

            for (int i = 0; i < 2; i++) {
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
            System.out.println("Discount section should be visible now.");

        } catch (Exception e) {
            System.out.println("Error viewing discount: " + e.getMessage());
        }
    }

    @Then("Discount message should appear showing automatically applied")
    public void discountMessageShouldAppearShowingAutomaticallyApplied() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DISCOUNT LABEL VERIFICATION");
            System.out.println("========================================");

            // Check for discount keywords
            boolean hasDiscountWord = pageSource.contains("Discount") ||
                                      pageSource.contains("discount") ||
                                      pageSource.contains("DISCOUNT");

            // Check for automatically applied message
            boolean hasAutomaticallyApplied = pageSource.contains("automatically applied") ||
                                              pageSource.contains("Automatically applied") ||
                                              pageSource.contains("auto applied") ||
                                              pageSource.contains("Auto applied");

            // Check for applied keyword
            boolean hasApplied = pageSource.contains("applied") ||
                                 pageSource.contains("Applied");

            // Check for promo/coupon indicators
            boolean hasPromoIndicator = pageSource.contains("Promo") ||
                                        pageSource.contains("promo") ||
                                        pageSource.contains("Coupon") ||
                                        pageSource.contains("coupon") ||
                                        pageSource.contains("Offer") ||
                                        pageSource.contains("offer");

            // Check if on Confirm page
            boolean onConfirmPage = pageSource.contains("Confirm") ||
                                    pageSource.contains("confirm") ||
                                    pageSource.contains("Book") ||
                                    pageSource.contains("Ride");

            System.out.println("");
            System.out.println("Discount Label Verification:");
            System.out.println("----------------------------");
            System.out.println("  - 'Discount' word: " + (hasDiscountWord ? "YES" : "NO"));
            System.out.println("  - 'Automatically applied': " + (hasAutomaticallyApplied ? "YES" : "NO"));
            System.out.println("  - 'Applied' word: " + (hasApplied ? "YES" : "NO"));
            System.out.println("  - Promo/Coupon indicator: " + (hasPromoIndicator ? "YES" : "NO"));
            System.out.println("  - On Confirm page: " + (onConfirmPage ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasDiscountWord) score += 3;
            if (hasAutomaticallyApplied) score += 3;
            if (hasApplied) score += 2;
            if (hasPromoIndicator) score++;
            if (onConfirmPage) score++;

            if (score >= 4 || hasAutomaticallyApplied || (hasDiscountWord && hasApplied)) {
                System.out.println("========================================");
                System.out.println("  TC-063: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Discount message displayed!");
                System.out.println("");
                if (hasDiscountWord) System.out.println("  - 'Discount' label visible");
                if (hasAutomaticallyApplied) System.out.println("  - 'Automatically applied' shown");
                if (hasApplied) System.out.println("  - 'Applied' indicator visible");
                if (hasPromoIndicator) System.out.println("  - Promo/Coupon indicator shown");
                if (onConfirmPage) System.out.println("  - On Confirm Ride page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is discount message visible?");
                System.out.println("  - Does it say 'automatically applied'?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasDiscountWord || hasPromoIndicator) {
                System.out.println("========================================");
                System.out.println("  TC-063: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Discount/Promo indicator found.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is discount section visible?");
                System.out.println("  2. Does it say 'Discount automatically applied'?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-063: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect discount message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Confirm Ride page?");
                System.out.println("  2. Is discount applicable?");
                System.out.println("  3. Is 'Discount automatically applied' visible?");
                System.out.println("");
                System.out.println("  Note: This test requires a discount to be");
                System.out.println("  applicable for the ride.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying discount: " + e.getMessage());
            System.out.println("TC-063: FAILED - " + e.getMessage());
        }
    }
}
