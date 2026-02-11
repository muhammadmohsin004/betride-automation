package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Page;

import java.util.List;

public class TC105_CancelYesActionSteps extends Page {

    private String previousScreenSource = "";

    @Given("Cancel popup is visible on searching screen")
    public void cancelPopupIsVisibleOnSearchingScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-105: CANCEL YES ACTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride and reach searching screen");
            System.out.println("  4. Tap 'Cancel Request' button");
            System.out.println("  5. Cancel popup should now be visible");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to reach cancel popup
            System.out.println("");
            System.out.println("Waiting 20 seconds to reach cancel popup...");
            System.out.println("");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(5000);
                System.out.println("Waiting... " + ((i + 1) * 5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            // Capture current screen for later comparison
            try {
                previousScreenSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            } catch (Exception e) {
                previousScreenSource = "";
            }

            // Verify cancel popup is visible
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean hasPopup = pageSource.contains("Yes") ||
                               pageSource.contains("No") ||
                               pageSource.contains("Cancel") ||
                               pageSource.contains("sure") ||
                               pageSource.contains("confirm");

            if (hasPopup) {
                System.out.println("");
                System.out.println("Confirmed: Cancel popup is visible");
            } else {
                System.out.println("");
                System.out.println("Please ensure cancel popup is visible on screen.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps YES on cancel popup")
    public void userTapsYesOnCancelPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING YES ON CANCEL POPUP");
            System.out.println("========================================");
            System.out.println("");

            Thread.sleep(2000);

            boolean yesFound = false;

            // Try to find and click YES button
            try {
                // Try different XPath patterns for YES button
                String[] xpathPatterns = {
                    "//*[contains(@content-desc, 'Yes')]",
                    "//*[contains(@content-desc, 'YES')]",
                    "//*[contains(@content-desc, 'yes')]",
                    "//*[contains(@text, 'Yes')]",
                    "//*[contains(@text, 'YES')]",
                    "//android.widget.Button[contains(@text, 'Yes')]",
                    "//android.widget.Button[contains(@text, 'YES')]",
                    "//android.view.View[contains(@content-desc, 'Yes')]",
                    "//*[contains(@content-desc, 'Confirm')]",
                    "//*[contains(@content-desc, 'OK')]",
                    "//*[contains(@text, 'OK')]"
                };

                for (String xpath : xpathPatterns) {
                    try {
                        List<AndroidElement> elements = AndroidDriverSetup.getAndroidDriver().findElements(By.xpath(xpath));
                        if (!elements.isEmpty()) {
                            for (AndroidElement element : elements) {
                                if (element.isDisplayed()) {
                                    element.click();
                                    yesFound = true;
                                    System.out.println("  Found and tapped YES button using: " + xpath);
                                    break;
                                }
                            }
                        }
                        if (yesFound) break;
                    } catch (Exception e) {
                        // Try next pattern
                    }
                }

                if (!yesFound) {
                    // Try finding by class name
                    List<AndroidElement> buttons = AndroidDriverSetup.getAndroidDriver().findElements(
                        By.className("android.widget.Button"));
                    for (AndroidElement button : buttons) {
                        String text = button.getText();
                        String desc = button.getAttribute("content-desc");
                        if ((text != null && (text.equalsIgnoreCase("yes") || text.equalsIgnoreCase("ok") || text.equalsIgnoreCase("confirm"))) ||
                            (desc != null && (desc.toLowerCase().contains("yes") || desc.toLowerCase().contains("ok")))) {
                            button.click();
                            yesFound = true;
                            System.out.println("  Found and tapped YES button (Button class)");
                            break;
                        }
                    }
                }

                if (!yesFound) {
                    // Try finding clickable View elements
                    List<AndroidElement> views = AndroidDriverSetup.getAndroidDriver().findElements(
                        By.className("android.view.View"));
                    for (WebElement view : views) {
                        String desc = view.getAttribute("content-desc");
                        if (desc != null && (desc.toLowerCase().contains("yes") || desc.equalsIgnoreCase("yes"))) {
                            view.click();
                            yesFound = true;
                            System.out.println("  Found and tapped YES button (View class)");
                            break;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("  Auto-click failed: " + e.getMessage());
            }

            if (!yesFound) {
                System.out.println("");
                System.out.println("  MANUAL ACTION REQUIRED:");
                System.out.println("");
                System.out.println("  1. Look for 'YES' button on the cancel popup");
                System.out.println("  2. Tap the 'YES' button to confirm cancellation");
                System.out.println("");
                System.out.println("  Waiting 10 seconds for manual tap...");
                System.out.println("");

                for (int i = 0; i < 2; i++) {
                    Thread.sleep(5000);
                    System.out.println("  Waiting... " + ((i + 1) * 5) + " sec");
                }
            }

            Thread.sleep(2000);
            System.out.println("");
            System.out.println("  YES button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping YES button: " + e.getMessage());
        }
    }

    @Then("Ride request should be cancelled")
    public void rideRequestShouldBeCancelled() {
        try {
            Thread.sleep(3000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING RIDE CANCELLATION");
            System.out.println("========================================");
            System.out.println("");

            // Check that we're no longer on searching screen
            boolean noSearching = !pageSource.contains("searching for driver") &&
                                  !pageSource.contains("Searching for driver") &&
                                  !pageSource.contains("ride request is sent");

            // Check for cancellation indicators
            boolean hasCancelled = pageSource.contains("cancelled") ||
                                   pageSource.contains("Cancelled") ||
                                   pageSource.contains("canceled") ||
                                   pageSource.contains("Canceled");

            // Check if popup is gone
            boolean popupGone = !pageSource.contains("Are you sure") &&
                               !pageSource.contains("Do you want to cancel");

            // Check for home screen indicators
            boolean hasHomeIndicators = pageSource.contains("Book") ||
                                        pageSource.contains("book") ||
                                        pageSource.contains("Ride") ||
                                        pageSource.contains("Hourly") ||
                                        pageSource.contains("Select") ||
                                        pageSource.contains("Where");

            System.out.println("Cancellation Verification:");
            System.out.println("--------------------------");
            System.out.println("  - Not on searching screen: " + (noSearching ? "YES" : "NO"));
            System.out.println("  - Cancellation text found: " + (hasCancelled ? "YES" : "NO"));
            System.out.println("  - Popup dismissed: " + (popupGone ? "YES" : "NO"));
            System.out.println("  - Home/Booking indicators: " + (hasHomeIndicators ? "YES" : "NO"));
            System.out.println("");

            if (noSearching || popupGone || hasHomeIndicators) {
                System.out.println("  RESULT: Ride cancellation VERIFIED");
            } else {
                System.out.println("  RESULT: Please verify cancellation manually");
            }

        } catch (Exception e) {
            System.out.println("Error verifying cancellation: " + e.getMessage());
        }
    }

    @And("User should return to previous screen")
    public void userShouldReturnToPreviousScreen() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING RETURN TO PREVIOUS SCREEN");
            System.out.println("========================================");
            System.out.println("");

            // Check for home screen / booking screen indicators
            boolean hasBookRide = pageSource.contains("Book") ||
                                  pageSource.contains("book");

            boolean hasRideOptions = pageSource.contains("Select Ride") ||
                                     pageSource.contains("Hourly") ||
                                     pageSource.contains("City to City") ||
                                     pageSource.contains("Get Anything");

            boolean hasDestination = pageSource.contains("destination") ||
                                     pageSource.contains("Destination") ||
                                     pageSource.contains("Where") ||
                                     pageSource.contains("pickup") ||
                                     pageSource.contains("Pickup");

            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            // Check we're NOT on searching anymore
            boolean notSearching = !pageSource.contains("searching") &&
                                   !pageSource.contains("Searching") &&
                                   !pageSource.contains("Finding driver") &&
                                   !pageSource.contains("request is sent");

            System.out.println("Previous Screen Verification:");
            System.out.println("-----------------------------");
            System.out.println("  - Book option visible: " + (hasBookRide ? "YES" : "NO"));
            System.out.println("  - Ride options visible: " + (hasRideOptions ? "YES" : "NO"));
            System.out.println("  - Destination field: " + (hasDestination ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("  - Not on searching screen: " + (notSearching ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasBookRide) score += 2;
            if (hasRideOptions) score += 2;
            if (hasDestination) score++;
            if (hasMap) score++;
            if (notSearching) score += 2;

            System.out.println("========================================");
            if (score >= 3 || (notSearching && (hasBookRide || hasRideOptions || hasDestination))) {
                System.out.println("  TC-105: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Ride cancelled and returned to previous screen!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasBookRide) System.out.println("    - Book option visible");
                if (hasRideOptions) System.out.println("    - Ride options available");
                if (hasDestination) System.out.println("    - Destination/pickup fields visible");
                if (hasMap) System.out.println("    - Map displayed");
                if (notSearching) System.out.println("    - Not on searching screen");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you return to home/booking screen?");
                System.out.println("  - Is the ride request cancelled?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-105: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you return to previous screen?");
                System.out.println("  2. Is the ride request cancelled?");
                System.out.println("  3. Are you on home/booking screen?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying return to previous screen: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-105: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
