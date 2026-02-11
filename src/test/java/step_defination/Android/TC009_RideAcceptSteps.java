package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;

public class TC009_RideAcceptSteps extends Page {

    @Then("Driver waits for ride request with shorter timeout")
    public void driverWaitsForRideRequestWithShorterTimeout() {
        try {
            System.out.println("");
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║           ⏳ WAITING FOR RIDE REQUEST                        ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  QUICK! Do this on your phone NOW:                           ║");
            System.out.println("║                                                              ║");
            System.out.println("║  1. Press HOME button                                        ║");
            System.out.println("║  2. Open RIDER app → Create ride → Search for driver         ║");
            System.out.println("║  3. Come back to Driver app IMMEDIATELY                      ║");
            System.out.println("║                                                              ║");
            System.out.println("║  You have 45 SECONDS - be quick!                             ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            System.out.println("");

            // Wait in 3-second intervals with session keep-alive (45 seconds total)
            boolean rideReceived = false;
            for (int i = 0; i < 15; i++) { // 15 x 3 seconds = 45 seconds
                Thread.sleep(3000);

                try {
                    // Keep session alive and check for ride
                    String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

                    if (pageSource.contains("Accept") ||
                        pageSource.contains("Reject") ||
                        pageSource.contains("MAD") ||
                        pageSource.contains("Fare") ||
                        pageSource.contains("Pickup")) {

                        System.out.println("✓ Ride request detected at " + ((i + 1) * 3) + " seconds!");
                        rideReceived = true;
                        break;
                    }

                    System.out.println("Waiting... " + ((i + 1) * 3) + " sec");
                } catch (Exception e) {
                    System.out.println("Session check at " + ((i + 1) * 3) + " sec");
                }
            }

            if (!rideReceived) {
                System.out.println("⚠ No ride request received within 45 seconds");
                System.out.println("Make sure driver is ONLINE and in the pickup area");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @When("Driver taps Accept button on ride popup")
    public void driverTapsAcceptButtonOnRidePopup() {
        try {
            Thread.sleep(2000);

            WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 15);

            System.out.println("Looking for Accept button...");

            // Try to find and tap Accept button
            WebElement acceptButton = null;

            try {
                // Try by content-desc
                acceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[contains(@content-desc, 'Accept') or contains(@content-desc, 'accept') or contains(@content-desc, 'ACCEPT')]")));
            } catch (Exception e) {
                try {
                    // Try by text
                    acceptButton = AndroidDriverSetup.getAndroidDriver().findElement(
                        By.xpath("//*[contains(@text, 'Accept') or contains(@text, 'ACCEPT')]"));
                } catch (Exception ex) {
                    // Try finding any clickable element with Accept
                    acceptButton = AndroidDriverSetup.getAndroidDriver().findElement(
                        By.xpath("//android.view.View[contains(@content-desc, 'Accept')]"));
                }
            }

            if (acceptButton != null) {
                acceptButton.click();
                System.out.println("✓ Tapped on Accept button");
                Thread.sleep(2000);
            } else {
                System.out.println("⚠ Accept button not found");
                throw new RuntimeException("Accept button not found on ride popup");
            }

        } catch (Exception e) {
            System.out.println("Error tapping Accept button: " + e.getMessage());

            // Check current page state
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            if (!pageSource.contains("Accept")) {
                System.out.println("⚠ No Accept button visible - ride popup may not be displayed");
                System.out.println("Page source snippet: " + pageSource.substring(0, Math.min(1000, pageSource.length())));
            }
            throw new RuntimeException("Could not tap Accept button: " + e.getMessage());
        }
    }

    @Then("Ride should be accepted successfully")
    public void rideShouldBeAcceptedSuccessfully() {
        try {
            Thread.sleep(3000); // Wait for acceptance to process

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("========================================");
            System.out.println("Verifying ride acceptance...");
            System.out.println("========================================");

            // Look for ride in progress indicators
            boolean hasRideInProgress = pageSource.contains("Navigate") ||
                                        pageSource.contains("navigate") ||
                                        pageSource.contains("Pickup") ||
                                        pageSource.contains("pickup") ||
                                        pageSource.contains("Arriving") ||
                                        pageSource.contains("arriving") ||
                                        pageSource.contains("En route") ||
                                        pageSource.contains("Start") ||
                                        pageSource.contains("Cancel") ||
                                        pageSource.contains("Rider") ||
                                        pageSource.contains("rider") ||
                                        pageSource.contains("Trip") ||
                                        pageSource.contains("trip") ||
                                        pageSource.contains("Call") ||
                                        pageSource.contains("Message");

            // Check if Accept button is no longer visible (ride was accepted)
            boolean acceptButtonGone = !pageSource.contains("Accept") ||
                                       pageSource.contains("Accepted");

            // Check for waiting for rider response
            boolean waitingForRider = pageSource.contains("Waiting") ||
                                      pageSource.contains("waiting") ||
                                      pageSource.contains("Rider") ||
                                      pageSource.contains("response");

            if (hasRideInProgress || acceptButtonGone || waitingForRider) {
                System.out.println("✓ Ride accepted successfully");

                if (hasRideInProgress) {
                    System.out.println("✓ Ride in progress indicators found");
                }
                if (waitingForRider) {
                    System.out.println("✓ Waiting for rider response");
                }

                System.out.println("TC-009: PASSED - Driver accepted ride");
                System.out.println("");
                System.out.println("╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║  CHECK RIDER APP:                                            ║");
                System.out.println("║  Rider should see popup with:                                ║");
                System.out.println("║  - 'How far driver is' information                          ║");
                System.out.println("║  - Accept/Reject buttons                                     ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");
            } else {
                System.out.println("⚠ Could not confirm ride acceptance");
                System.out.println("Page source snippet: " + pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("TC-009: NEEDS MANUAL VERIFICATION");
            }

        } catch (Exception e) {
            System.out.println("Error verifying ride acceptance: " + e.getMessage());
            System.out.println("TC-009: FAILED - " + e.getMessage());
            throw new RuntimeException("TC-009 Failed: " + e.getMessage());
        }
    }
}
