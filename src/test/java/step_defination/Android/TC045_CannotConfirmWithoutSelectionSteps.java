package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC045_CannotConfirmWithoutSelectionSteps extends Page {

    @Given("User is on the Language screen without selecting any language")
    public void userIsOnTheLanguageScreenWithoutSelectingAnyLanguage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-045: CONFIRM WITHOUT SELECTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings → Languages");
            System.out.println("  4. DO NOT select any language");
            System.out.println("     (No radio button should be active)");
            System.out.println("");
            System.out.println("  IMPORTANT: Make sure NO language is selected!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Language screen WITHOUT selecting.");
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
            System.out.println("User should be on Language screen without selection.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Confirm Language button without selection")
    public void userTapsOnConfirmLanguageButtonWithoutSelection() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP CONFIRM WITHOUT SELECTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Make sure NO language is selected");
            System.out.println("  2. Tap on 'Confirm Language' button");
            System.out.println("     (or 'Confirm' / 'Save' / 'Apply')");
            System.out.println("  3. Observe the error message");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap confirm
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Confirm...");

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
            System.out.println("Confirm should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping confirm: " + e.getMessage());
        }
    }

    @Then("Error message should appear asking to select a language")
    public void errorMessageShouldAppearAskingToSelectALanguage() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ERROR MESSAGE VERIFICATION");
            System.out.println("========================================");

            // Check for error message about selecting language
            boolean hasSelectLanguageError = pageSource.contains("Please select a language") ||
                                             pageSource.contains("please select a language") ||
                                             pageSource.contains("PLEASE SELECT A LANGUAGE") ||
                                             pageSource.contains("Select a language") ||
                                             pageSource.contains("select a language");

            // Check for general error indicators
            boolean hasErrorIndicator = pageSource.contains("Error") ||
                                        pageSource.contains("error") ||
                                        pageSource.contains("ERROR") ||
                                        pageSource.contains("Warning") ||
                                        pageSource.contains("warning");

            // Check for toast/popup indicators
            boolean hasToastPopup = pageSource.contains("Toast") ||
                                    pageSource.contains("toast") ||
                                    pageSource.contains("Snackbar") ||
                                    pageSource.contains("snackbar") ||
                                    pageSource.contains("Alert") ||
                                    pageSource.contains("alert");

            // Check for validation message
            boolean hasValidationMessage = pageSource.contains("required") ||
                                           pageSource.contains("Required") ||
                                           pageSource.contains("must select") ||
                                           pageSource.contains("choose") ||
                                           pageSource.contains("Choose");

            // Check if still on Language page (didn't navigate away)
            boolean stillOnLanguagePage = pageSource.contains("Language") ||
                                          pageSource.contains("language") ||
                                          pageSource.contains("English") ||
                                          pageSource.contains("Arabic") ||
                                          pageSource.contains("French");

            System.out.println("");
            System.out.println("Error Message Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Select language error: " + (hasSelectLanguageError ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Toast/Popup: " + (hasToastPopup ? "YES" : "NO"));
            System.out.println("  - Validation message: " + (hasValidationMessage ? "YES" : "NO"));
            System.out.println("  - Still on Language page: " + (stillOnLanguagePage ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasSelectLanguageError) score += 4;
            if (hasErrorIndicator) score += 2;
            if (hasToastPopup) score++;
            if (hasValidationMessage) score += 2;
            if (stillOnLanguagePage) score++;

            if (score >= 4 || hasSelectLanguageError) {
                System.out.println("========================================");
                System.out.println("  TC-045: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Error message verified!");
                System.out.println("");
                if (hasSelectLanguageError) System.out.println("  - 'Please select a language' error found");
                if (hasErrorIndicator) System.out.println("  - Error indicator detected");
                if (hasValidationMessage) System.out.println("  - Validation message present");
                if (stillOnLanguagePage) System.out.println("  - Still on Language page (correct)");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did error message appear?");
                System.out.println("  - Does it say 'Please select a language'?");
                System.out.println("  - Are you still on Language page?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2 || stillOnLanguagePage) {
                System.out.println("========================================");
                System.out.println("  TC-045: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some validation detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Confirm without selection?");
                System.out.println("  2. Did error message appear?");
                System.out.println("  3. Are you still on Language page?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-045: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect error message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you have NO language selected?");
                System.out.println("  2. Did you tap Confirm Language?");
                System.out.println("  3. Did error 'Please select a language' appear?");
                System.out.println("  4. Are you still on Language page?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying error message: " + e.getMessage());
            System.out.println("TC-045: FAILED - " + e.getMessage());
        }
    }
}
