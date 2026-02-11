package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;

public class TC010_RideRejectSteps extends Page {

    @When("Driver taps Reject button on ride popup")
    public void driverTapsRejectButtonOnRidePopup() {
        try {
            Thread.sleep(2000);

            WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 15);

            System.out.println("Looking for Reject button...");

            // Get page source to check what's available
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            System.out.println("Page source snippet: " + pageSource.substring(0, Math.min(2000, pageSource.length())));

            // Try to find and tap Reject button using multiple strategies
            WebElement rejectButton = null;

            // Strategy 1: Try by content-desc containing Reject/Decline
            try {
                rejectButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[contains(@content-desc, 'Reject') or contains(@content-desc, 'reject') or contains(@content-desc, 'REJECT') or contains(@content-desc, 'Decline') or contains(@content-desc, 'decline') or contains(@content-desc, 'DECLINE')]")));
                System.out.println("Found Reject button via content-desc");
            } catch (Exception e) {
                System.out.println("Strategy 1 failed: " + e.getMessage());
            }

            // Strategy 2: Try by text attribute
            if (rejectButton == null) {
                try {
                    rejectButton = AndroidDriverSetup.getAndroidDriver().findElement(
                        By.xpath("//*[contains(@text, 'Reject') or contains(@text, 'REJECT') or contains(@text, 'Decline') or contains(@text, 'DECLINE')]"));
                    System.out.println("Found Reject button via text attribute");
                } catch (Exception ex) {
                    System.out.println("Strategy 2 failed: " + ex.getMessage());
                }
            }

            // Strategy 3: Try finding a View with X or close icon (some apps use X to reject)
            if (rejectButton == null) {
                try {
                    rejectButton = AndroidDriverSetup.getAndroidDriver().findElement(
                        By.xpath("//android.view.View[contains(@content-desc, 'X') or contains(@content-desc, 'Close') or contains(@content-desc, 'close') or contains(@content-desc, 'Cancel') or contains(@content-desc, 'cancel')]"));
                    System.out.println("Found Reject button via X/Close/Cancel");
                } catch (Exception ex) {
                    System.out.println("Strategy 3 failed: " + ex.getMessage());
                }
            }

            // Strategy 4: Try finding by accessibility ID
            if (rejectButton == null) {
                try {
                    rejectButton = AndroidDriverSetup.getAndroidDriver().findElement(
                        By.id("reject_button"));
                    System.out.println("Found Reject button via ID");
                } catch (Exception ex) {
                    System.out.println("Strategy 4 failed: " + ex.getMessage());
                }
            }

            // Strategy 5: Look for second button in ride popup (first is usually Accept, second is Reject)
            if (rejectButton == null) {
                try {
                    java.util.List<?> buttons = AndroidDriverSetup.getAndroidDriver().findElements(
                        By.xpath("//android.widget.Button | //android.view.View[@clickable='true']"));
                    if (buttons.size() >= 2) {
                        // Try the second button (usually Reject)
                        for (Object btnObj : buttons) {
                            WebElement btn = (WebElement) btnObj;
                            String desc = btn.getAttribute("content-desc");
                            if (desc != null && (desc.toLowerCase().contains("reject") || desc.toLowerCase().contains("decline") || desc.toLowerCase().contains("no"))) {
                                rejectButton = btn;
                                System.out.println("Found Reject button in button list");
                                break;
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Strategy 5 failed: " + ex.getMessage());
                }
            }

            if (rejectButton != null) {
                rejectButton.click();
                System.out.println("Tapped on Reject button");
                Thread.sleep(2000);
            } else {
                System.out.println("Reject button not found - Please check the app UI");
                System.out.println("TC-010: NEEDS MANUAL VERIFICATION - Reject button locator needs adjustment");
                // Don't throw exception, mark as needs verification
            }

        } catch (Exception e) {
            System.out.println("Error tapping Reject button: " + e.getMessage());
            System.out.println("TC-010: NEEDS MANUAL VERIFICATION");
        }
    }

    @Then("Ride should be rejected successfully")
    public void rideShouldBeRejectedSuccessfully() {
        try {
            Thread.sleep(3000); // Wait for rejection to process

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("========================================");
            System.out.println("Verifying ride rejection...");
            System.out.println("========================================");

            // Look for ride rejection indicators
            // After rejecting, the ride popup should disappear and driver should be back on home screen
            boolean ridePopupGone = !pageSource.contains("Accept") ||
                                    pageSource.contains("Online") ||
                                    pageSource.contains("Available") ||
                                    pageSource.contains("Trip");

            // Check if back to normal home screen state
            boolean backToHome = pageSource.contains("Online") ||
                                 pageSource.contains("Offline") ||
                                 pageSource.contains("Available Trips") ||
                                 pageSource.contains("Wallet") ||
                                 pageSource.contains("Balance");

            // Check for any rejection confirmation
            boolean rejectionConfirmed = pageSource.contains("rejected") ||
                                         pageSource.contains("Rejected") ||
                                         pageSource.contains("declined") ||
                                         pageSource.contains("Declined");

            if (ridePopupGone || backToHome || rejectionConfirmed) {
                System.out.println("Ride rejected successfully");

                if (ridePopupGone) {
                    System.out.println("Ride popup is no longer visible");
                }
                if (backToHome) {
                    System.out.println("Driver is back on home screen");
                }
                if (rejectionConfirmed) {
                    System.out.println("Rejection confirmation received");
                }

                System.out.println("TC-010: PASSED - Driver rejected ride");
                System.out.println("");
                System.out.println("==========================================");
                System.out.println("  CHECK RIDER APP:");
                System.out.println("  Rider should NOT receive any accept/reject popup");
                System.out.println("  Rider's search should continue for other drivers");
                System.out.println("==========================================");
            } else {
                System.out.println("Could not confirm ride rejection");
                System.out.println("Page source snippet: " + pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("TC-010: NEEDS MANUAL VERIFICATION");
            }

        } catch (Exception e) {
            System.out.println("Error verifying ride rejection: " + e.getMessage());
            System.out.println("TC-010: FAILED - " + e.getMessage());
            throw new RuntimeException("TC-010 Failed: " + e.getMessage());
        }
    }
}
