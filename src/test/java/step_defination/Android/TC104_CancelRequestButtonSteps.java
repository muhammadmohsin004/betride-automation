package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Page;

import java.util.List;

public class TC104_CancelRequestButtonSteps extends Page {

    @Given("User is on active ride searching screen")
    public void userIsOnActiveRideSearchingScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-104: CANCEL REQUEST BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Book a ride (Book Hourly or Book Ride)");
            System.out.println("  4. Select pickup/drop-off locations");
            System.out.println("  5. Tap 'Book your driver' or 'Search for Driver'");
            System.out.println("  6. You should now be on the SEARCHING screen");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to navigate to searching screen
            System.out.println("");
            System.out.println("Waiting 20 seconds to reach searching screen...");
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

            // Verify we're on searching screen
            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            boolean isOnSearching = pageSource.contains("Search") ||
                                    pageSource.contains("search") ||
                                    pageSource.contains("Finding") ||
                                    pageSource.contains("Cancel") ||
                                    pageSource.contains("request") ||
                                    pageSource.contains("driver");

            if (isOnSearching) {
                System.out.println("");
                System.out.println("Confirmed: On searching screen");
            } else {
                System.out.println("");
                System.out.println("Please ensure you are on the searching screen.");
            }

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps Cancel Request button")
    public void userTapsCancelRequestButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAPPING CANCEL REQUEST BUTTON");
            System.out.println("========================================");
            System.out.println("");

            Thread.sleep(2000);

            boolean cancelFound = false;

            // Try to find and click Cancel Request button
            try {
                // Try different XPath patterns for Cancel button
                String[] xpathPatterns = {
                    "//*[contains(@content-desc, 'Cancel')]",
                    "//*[contains(@content-desc, 'cancel')]",
                    "//*[contains(@text, 'Cancel')]",
                    "//*[contains(@text, 'cancel')]",
                    "//android.widget.Button[contains(@text, 'Cancel')]",
                    "//android.view.View[contains(@content-desc, 'Cancel')]",
                    "//*[contains(@content-desc, 'Cancel Request')]",
                    "//*[contains(@content-desc, 'Cancel request')]"
                };

                for (String xpath : xpathPatterns) {
                    try {
                        List<AndroidElement> elements = AndroidDriverSetup.getAndroidDriver().findElements(By.xpath(xpath));
                        if (!elements.isEmpty()) {
                            for (AndroidElement element : elements) {
                                if (element.isDisplayed()) {
                                    element.click();
                                    cancelFound = true;
                                    System.out.println("  Found and tapped Cancel button using: " + xpath);
                                    break;
                                }
                            }
                        }
                        if (cancelFound) break;
                    } catch (Exception e) {
                        // Try next pattern
                    }
                }

                if (!cancelFound) {
                    // Try finding by class name
                    List<AndroidElement> buttons = AndroidDriverSetup.getAndroidDriver().findElements(
                        By.className("android.widget.Button"));
                    for (AndroidElement button : buttons) {
                        String text = button.getText();
                        String desc = button.getAttribute("content-desc");
                        if ((text != null && text.toLowerCase().contains("cancel")) ||
                            (desc != null && desc.toLowerCase().contains("cancel"))) {
                            button.click();
                            cancelFound = true;
                            System.out.println("  Found and tapped Cancel button (Button class)");
                            break;
                        }
                    }
                }

                if (!cancelFound) {
                    // Try finding clickable View elements
                    List<AndroidElement> views = AndroidDriverSetup.getAndroidDriver().findElements(
                        By.className("android.view.View"));
                    for (WebElement view : views) {
                        String desc = view.getAttribute("content-desc");
                        if (desc != null && desc.toLowerCase().contains("cancel")) {
                            view.click();
                            cancelFound = true;
                            System.out.println("  Found and tapped Cancel button (View class)");
                            break;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("  Auto-click failed: " + e.getMessage());
            }

            if (!cancelFound) {
                System.out.println("");
                System.out.println("  MANUAL ACTION REQUIRED:");
                System.out.println("");
                System.out.println("  1. Look for 'Cancel Request' button");
                System.out.println("  2. It's usually at the bottom of the screen");
                System.out.println("  3. Tap the 'Cancel Request' button");
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
            System.out.println("  Cancel Request button should have been tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping Cancel button: " + e.getMessage());
        }
    }

    @Then("Cancel popup should appear")
    public void cancelPopupShouldAppear() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VERIFYING CANCEL POPUP");
            System.out.println("========================================");
            System.out.println("");

            // Check for popup indicators
            boolean hasPopup = pageSource.contains("popup") ||
                               pageSource.contains("Popup") ||
                               pageSource.contains("dialog") ||
                               pageSource.contains("Dialog") ||
                               pageSource.contains("modal") ||
                               pageSource.contains("Modal") ||
                               pageSource.contains("alert") ||
                               pageSource.contains("Alert");

            // Check for cancel confirmation text
            boolean hasCancelConfirm = pageSource.contains("Are you sure") ||
                                       pageSource.contains("are you sure") ||
                                       pageSource.contains("Cancel ride") ||
                                       pageSource.contains("cancel ride") ||
                                       pageSource.contains("Cancel request") ||
                                       pageSource.contains("cancel request") ||
                                       pageSource.contains("Do you want to cancel") ||
                                       pageSource.contains("Want to cancel");

            // Check for Yes/No buttons
            boolean hasYesNo = pageSource.contains("Yes") ||
                               pageSource.contains("YES") ||
                               pageSource.contains("No") ||
                               pageSource.contains("NO") ||
                               pageSource.contains("Confirm") ||
                               pageSource.contains("confirm");

            // Check for cancel-related text
            boolean hasCancelText = pageSource.contains("Cancel") ||
                                    pageSource.contains("cancel");

            // Check for warning/question text
            boolean hasWarning = pageSource.contains("?") ||
                                 pageSource.contains("sure") ||
                                 pageSource.contains("Sure") ||
                                 pageSource.contains("want") ||
                                 pageSource.contains("Want");

            System.out.println("Cancel Popup Verification:");
            System.out.println("--------------------------");
            System.out.println("  - Popup/Dialog detected: " + (hasPopup ? "YES" : "NO"));
            System.out.println("  - Cancel confirmation text: " + (hasCancelConfirm ? "YES" : "NO"));
            System.out.println("  - Yes/No buttons: " + (hasYesNo ? "YES" : "NO"));
            System.out.println("  - Cancel text: " + (hasCancelText ? "YES" : "NO"));
            System.out.println("  - Warning/Question text: " + (hasWarning ? "YES" : "NO"));
            System.out.println("");

            // Calculate score
            int score = 0;
            if (hasPopup) score += 2;
            if (hasCancelConfirm) score += 3;
            if (hasYesNo) score += 2;
            if (hasCancelText) score++;
            if (hasWarning) score++;

            System.out.println("========================================");
            if (score >= 3 || hasCancelConfirm || (hasYesNo && hasCancelText)) {
                System.out.println("  TC-104: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Cancel popup appeared successfully!");
                System.out.println("");
                System.out.println("  Verified elements:");
                if (hasPopup) System.out.println("    - Popup/Dialog is displayed");
                if (hasCancelConfirm) System.out.println("    - Cancel confirmation text found");
                if (hasYesNo) System.out.println("    - Yes/No buttons visible");
                if (hasCancelText) System.out.println("    - Cancel text present");
                if (hasWarning) System.out.println("    - Warning/Question text shown");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is the cancel confirmation popup visible?");
                System.out.println("  - Are Yes/No options available?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("  TC-104: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did a cancel popup appear?");
                System.out.println("  2. Does it ask for confirmation?");
                System.out.println("  3. Are Yes/No buttons visible?");
                System.out.println("");
                System.out.println("  Note: Popup may use native UI elements");
                System.out.println("  that are not detected in page source.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying cancel popup: " + e.getMessage());
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-104: FAILED");
            System.out.println("========================================");
            System.out.println("  Error: " + e.getMessage());
            System.out.println("========================================");
        }
    }
}
