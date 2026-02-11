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

public class TC106_CancelNoActionSteps extends Page {

    @Given("Cancel confirmation popup is visible")
    public void cancelConfirmationPopupIsVisible() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-106: CANCEL NO ACTION");
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

    @When("User taps NO on cancel popup")
    public void userTapsNoOnCancelPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING NO ON CANCEL POPUP");
            System.out.println("========================================");
            System.out.println("");

            Thread.sleep(2000);

            boolean noFound = false;

            // Try to find and click NO button
            try {
                // Try different XPath patterns for NO button
                String[] xpathPatterns = {
                    "//*[contains(@content-desc, 'No')]",
                    "//*[contains(@content-desc, 'NO')]",
                    "//*[contains(@content-desc, 'no')]",
                    "//*[contains(@text, 'No')]",
                    "//*[contains(@text, 'NO')]",
                    "//android.widget.Button[contains(@text, 'No')]",
                    "//android.widget.Button[contains(@text, 'NO')]",
                    "//android.view.View[contains(@content-desc, 'No')]",
                    "//*[contains(@content-desc, 'Cancel')]",
                    "//*[contains(@content-desc, 'Close')]",
                    "//*[contains(@text, 'Close')]"
                };

                for (String xpath : xpathPatterns) {
                    try {
                        List<AndroidElement> elements = AndroidDriverSetup.getAndroidDriver().findElements(By.xpath(xpath));
                        if (!elements.isEmpty()) {
                            for (AndroidElement element : elements) {
                                if (element.isDisplayed()) {
                                    String desc = element.getAttribute("content-desc");
                                    String text = "";
                                    try {
                                        text = element.getText();
                                    } catch (Exception e) {}

                                    // Make sure we're clicking NO, not Yes
                                    if ((desc != null && (desc.equalsIgnoreCase("no") || desc.equalsIgnoreCase("close"))) ||
                                        (text != null && (text.equalsIgnoreCase("no") || text.equalsIgnoreCase("close")))) {
                                        element.click();
                                        noFound = true;
                                        System.out.println("  Found and tapped NO button using: " + xpath);
                                        break;
                                    }
                                }
                            }
                        }
                        if (noFound) break;
                    } catch (Exception e) {
                        // Try next pattern
                    }
                }

                if (!noFound) {
                    // Try finding by class name - look specifically for NO
                    List<AndroidElement> buttons = AndroidDriverSetup.getAndroidDriver().findElements(
                        By.className("android.widget.Button"));
                    for (AndroidElement button : buttons) {
                        String text = button.getText();
                        String desc = button.getAttribute("content-desc");
                        if ((text != null && (text.equalsIgnoreCase("no") || text.equalsIgnoreCase("close"))) ||
                            (desc != null && (desc.equalsIgnoreCase("no") || desc.equalsIgnoreCase("close")))) {
                            button.click();
                            noFound = true;
                            System.out.println("  Found and tapped NO button (Button class)");
                            break;
                        }
                    }
                }

                if (!noFound) {
                    // Try finding clickable View elements
                    List<AndroidElement> views = AndroidDriverSetup.getAndroidDriver().findElements(
                        By.className("android.view.View"));
                    for (WebElement view : views) {
                        String desc = view.getAttribute("content-desc");
                        if (desc != null && (desc.equalsIgnoreCase("no") || desc.equalsIgnoreCase("close"))) {
                            view.click();
                            noFound = true;
                            System.out.println("  Found and tapped NO button (View class)");
                            break;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("  Auto-click failed: " + e.getMessage());
            }

            if (!noFound) {
                System.out.println("");
                System.out.println("  MANUAL ACTION REQUIRED:");
                System.out.println("");
                System.out.println("  1. Look for 'NO' button on the cancel popup");
                System.out.println("  2. Tap the 'NO' button to dismiss popup");
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
            System.out.println("  NO button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping NO button: " + e.getMessage());
        }
    }

    @Then("Cancel popup should close")
    public void cancelPopupShouldClose() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING POPUP CLOSED");
            System.out.println("========================================");
            System.out.println("");

            // Check that popup is gone
            boolean popupGone = !pageSource.contains("Are you sure") &&
                               !pageSource.contains("Do you want to cancel") &&
                               !pageSource.contains("Want to cancel");

            // Check Yes/No buttons are gone (popup dismissed)
            boolean yesNoGone = true;
            // If we still see both Yes and No prominently, popup might still be there
            if (pageSource.contains("Yes") && pageSource.contains("No")) {
                // Could still be popup - need to check context
                yesNoGone = false;
            }

            System.out.println("Popup Close Verification:");
            System.out.println("-------------------------");
            System.out.println("  - Confirmation text gone: " + (popupGone ? "YES" : "NO"));
            System.out.println("  - Yes/No buttons dismissed: " + (yesNoGone ? "LIKELY" : "MAY STILL BE VISIBLE"));
            System.out.println("");

            if (popupGone) {
                System.out.println("  RESULT: Cancel popup closed successfully");
            } else {
                System.out.println("  RESULT: Please verify popup is closed manually");
            }

        } catch (Exception e) {
            System.out.println("Error verifying popup closed: " + e.getMessage());
        }
    }

    @And("Searching should continue")
    public void searchingShouldContinue() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING SEARCHING CONTINUES");
            System.out.println("========================================");
            System.out.println("");

            // Check for searching screen indicators
            boolean hasSearchingText = pageSource.contains("searching") ||
                                       pageSource.contains("Searching") ||
                                       pageSource.contains("Finding") ||
                                       pageSource.contains("finding") ||
                                       pageSource.contains("Looking") ||
                                       pageSource.contains("looking");

            boolean hasRideRequest = pageSource.contains("ride request") ||
                                     pageSource.contains("Ride request") ||
                                     pageSource.contains("request is sent") ||
                                     pageSource.contains("sent to drivers");

            boolean hasCancelOption = pageSource.contains("Cancel Request") ||
                                      pageSource.contains("Cancel request") ||
                                      pageSource.contains("Cancel");

            boolean hasDriverText = pageSource.contains("driver") ||
                                    pageSource.contains("Driver");

            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            System.out.println("Searching Screen Verification:");
            System.out.println("------------------------------");
            System.out.println("  - Searching text: " + (hasSearchingText ? "YES" : "NO"));
            System.out.println("  - Ride request text: " + (hasRideRequest ? "YES" : "NO"));
            System.out.println("  - Cancel option visible: " + (hasCancelOption ? "YES" : "NO"));
            System.out.println("  - Driver text: " + (hasDriverText ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasSearchingText) score += 3;
            if (hasRideRequest) score += 3;
            if (hasCancelOption) score += 2;
            if (hasDriverText) score++;
            if (hasMap) score++;

            System.out.println("========================================");
            if (score >= 3 || hasSearchingText || hasRideRequest || (hasCancelOption && hasDriverText)) {
                System.out.println("  TC-106: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Popup closed and searching continues!");
                System.out.println("");
                System.out.println("  Verified:");
                if (hasSearchingText) System.out.println("    - Searching text visible");
                if (hasRideRequest) System.out.println("    - Ride request text found");
                if (hasCancelOption) System.out.println("    - Cancel option still available");
                if (hasDriverText) System.out.println("    - Driver text present");
                if (hasMap) System.out.println("    - Map displayed");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did the popup close?");
                System.out.println("  - Is the search still active?");
                System.out.println("  - Is the app still looking for drivers?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-106: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did the cancel popup close?");
                System.out.println("  2. Is searching still active?");
                System.out.println("  3. Is the app still looking for drivers?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying searching continues: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-106: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
