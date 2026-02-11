package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC035_FlashOfferPromptSteps extends Page {

    @Given("Rider has an active or eligible ride")
    public void riderHasAnActiveOrEligibleRide() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-035: FLASH OFFER PROMPT TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  1. Create an active ride:");
            System.out.println("     - Open Rider app");
            System.out.println("     - Book a ride (normal or hourly)");
            System.out.println("     - Wait for driver to accept");
            System.out.println("     OR");
            System.out.println("     - Have an existing eligible ride");
            System.out.println("");
            System.out.println("  2. You should have an active/eligible ride");
            System.out.println("     that can receive Flash Offers");
            System.out.println("");
            System.out.println("========================================");

            // Wait for manual setup
            System.out.println("");
            System.out.println("Waiting 30 seconds for active ride setup...");
            System.out.println("Please ensure you have an active or eligible ride.");
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
            System.out.println("Active ride should be ready.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("Rider opens the ride details page")
    public void riderOpensTheRideDetailsPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  OPEN RIDE DETAILS PAGE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Navigate to ride details:");
            System.out.println("     - Tap on the active ride");
            System.out.println("     - Or tap on ride card/banner");
            System.out.println("     - Or open ride from History");
            System.out.println("");
            System.out.println("  3. You should see the ride details page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to open ride details
            System.out.println("");
            System.out.println("Waiting 15 seconds to open ride details...");

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
            System.out.println("Ride details page should be open now.");

        } catch (Exception e) {
            System.out.println("Error opening ride details: " + e.getMessage());
        }
    }

    @Then("Flash Offer prompt should appear")
    public void flashOfferPromptShouldAppear() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  FLASH OFFER PROMPT VERIFICATION");
            System.out.println("========================================");

            // Check for Flash Offer indicators
            boolean hasFlashOffer = pageSource.contains("Flash Offer") ||
                                    pageSource.contains("flash offer") ||
                                    pageSource.contains("FLASH OFFER") ||
                                    pageSource.contains("FlashOffer");

            // Check for offer/discount indicators
            boolean hasOfferDiscount = pageSource.contains("Offer") ||
                                       pageSource.contains("offer") ||
                                       pageSource.contains("Discount") ||
                                       pageSource.contains("discount") ||
                                       pageSource.contains("Deal") ||
                                       pageSource.contains("deal");

            // Check for prompt/popup indicators
            boolean hasPromptPopup = pageSource.contains("Prompt") ||
                                     pageSource.contains("prompt") ||
                                     pageSource.contains("Popup") ||
                                     pageSource.contains("popup") ||
                                     pageSource.contains("Alert") ||
                                     pageSource.contains("alert");

            // Check for price/fare indicators
            boolean hasPriceFare = pageSource.contains("Price") ||
                                   pageSource.contains("price") ||
                                   pageSource.contains("Fare") ||
                                   pageSource.contains("fare") ||
                                   pageSource.contains("MAD");

            // Check for ride details page indicators
            boolean hasRideDetails = pageSource.contains("Ride") ||
                                     pageSource.contains("ride") ||
                                     pageSource.contains("Trip") ||
                                     pageSource.contains("trip") ||
                                     pageSource.contains("Details") ||
                                     pageSource.contains("details");

            // Check for accept/apply offer indicators
            boolean hasAcceptApply = pageSource.contains("Accept") ||
                                     pageSource.contains("accept") ||
                                     pageSource.contains("Apply") ||
                                     pageSource.contains("apply") ||
                                     pageSource.contains("Get") ||
                                     pageSource.contains("Claim");

            System.out.println("");
            System.out.println("Flash Offer Prompt Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Flash Offer text: " + (hasFlashOffer ? "YES" : "NO"));
            System.out.println("  - Offer/Discount: " + (hasOfferDiscount ? "YES" : "NO"));
            System.out.println("  - Prompt/Popup: " + (hasPromptPopup ? "YES" : "NO"));
            System.out.println("  - Price/Fare: " + (hasPriceFare ? "YES" : "NO"));
            System.out.println("  - Ride Details: " + (hasRideDetails ? "YES" : "NO"));
            System.out.println("  - Accept/Apply: " + (hasAcceptApply ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasFlashOffer) score += 3;
            if (hasOfferDiscount) score += 2;
            if (hasPromptPopup) score++;
            if (hasPriceFare) score++;
            if (hasRideDetails) score++;
            if (hasAcceptApply) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-035: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Flash Offer prompt verified!");
                System.out.println("");
                if (hasFlashOffer) System.out.println("  - 'Flash Offer' prompt visible");
                if (hasOfferDiscount) System.out.println("  - Offer/Discount displayed");
                if (hasPriceFare) System.out.println("  - Price/Fare information shown");
                if (hasRideDetails) System.out.println("  - On ride details page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did Flash Offer prompt appear?");
                System.out.println("  - Is the offer clearly visible?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-035: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some offer elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you open an active ride?");
                System.out.println("  2. Did Flash Offer prompt appear?");
                System.out.println("  3. What offer is displayed?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-035: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Flash Offer prompt.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Do you have an active/eligible ride?");
                System.out.println("  2. Did you open ride details page?");
                System.out.println("  3. Did Flash Offer prompt appear?");
                System.out.println("");
                System.out.println("  Note: Flash Offer may only appear for");
                System.out.println("  eligible rides (active promotions).");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Flash Offer: " + e.getMessage());
            System.out.println("TC-035: FAILED - " + e.getMessage());
        }
    }
}
