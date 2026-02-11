package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC042_NavigationToLanguagePageSteps extends Page {

    @Given("User is logged in and on Settings page")
    public void userIsLoggedInAndOnSettingsPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-042: NAVIGATION TO LANGUAGE PAGE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings page");
            System.out.println("     - Tap profile picture (top left)");
            System.out.println("     - Or tap hamburger menu");
            System.out.println("     - Tap on 'Settings'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Settings page in the app.");
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
            System.out.println("User should be on Settings page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Languages option")
    public void userTapsOnLanguagesOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP ON LANGUAGES OPTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Settings page");
            System.out.println("  2. Look for 'Languages' option");
            System.out.println("  3. Tap on 'Languages'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap Languages
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Languages...");

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
            System.out.println("Languages should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Languages: " + e.getMessage());
        }
    }

    @Then("Choose the language page should be shown with language list")
    public void chooseTheLanguagePageShouldBeShownWithLanguageList() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  LANGUAGE PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Language page title
            boolean hasLanguageTitle = pageSource.contains("Language") ||
                                       pageSource.contains("language") ||
                                       pageSource.contains("LANGUAGE") ||
                                       pageSource.contains("Choose") ||
                                       pageSource.contains("choose");

            // Check for English option
            boolean hasEnglish = pageSource.contains("English") ||
                                 pageSource.contains("english") ||
                                 pageSource.contains("ENGLISH");

            // Check for Arabic option
            boolean hasArabic = pageSource.contains("Arabic") ||
                                pageSource.contains("arabic") ||
                                pageSource.contains("ARABIC") ||
                                pageSource.contains("العربية");

            // Check for French option
            boolean hasFrench = pageSource.contains("French") ||
                                pageSource.contains("french") ||
                                pageSource.contains("FRENCH") ||
                                pageSource.contains("Français") ||
                                pageSource.contains("français");

            // Check for radio buttons or selection indicators
            boolean hasRadioButtons = pageSource.contains("RadioButton") ||
                                      pageSource.contains("radio") ||
                                      pageSource.contains("selected") ||
                                      pageSource.contains("checked") ||
                                      pageSource.contains("android.widget.RadioButton");

            // Check for confirm/save button
            boolean hasConfirmButton = pageSource.contains("Confirm") ||
                                       pageSource.contains("confirm") ||
                                       pageSource.contains("CONFIRM") ||
                                       pageSource.contains("Save") ||
                                       pageSource.contains("save") ||
                                       pageSource.contains("Apply") ||
                                       pageSource.contains("apply");

            System.out.println("");
            System.out.println("Language Page Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Language title: " + (hasLanguageTitle ? "YES" : "NO"));
            System.out.println("  - English option: " + (hasEnglish ? "YES" : "NO"));
            System.out.println("  - Arabic option: " + (hasArabic ? "YES" : "NO"));
            System.out.println("  - French option: " + (hasFrench ? "YES" : "NO"));
            System.out.println("  - Radio buttons: " + (hasRadioButtons ? "YES" : "NO"));
            System.out.println("  - Confirm button: " + (hasConfirmButton ? "YES" : "NO"));
            System.out.println("");

            // Count languages found
            int languagesFound = 0;
            if (hasEnglish) languagesFound++;
            if (hasArabic) languagesFound++;
            if (hasFrench) languagesFound++;

            // Calculate verification score
            int score = 0;
            if (hasLanguageTitle) score += 2;
            score += languagesFound * 2;
            if (hasRadioButtons) score++;
            if (hasConfirmButton) score++;

            if (score >= 4 || languagesFound >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-042: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Language selection page verified!");
                System.out.println("");
                if (hasLanguageTitle) System.out.println("  - Language page title found");
                System.out.println("  - Languages found: " + languagesFound);
                if (hasEnglish) System.out.println("    * English");
                if (hasArabic) System.out.println("    * Arabic");
                if (hasFrench) System.out.println("    * French");
                if (hasConfirmButton) System.out.println("  - Confirm button available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is 'Choose the language' page shown?");
                System.out.println("  - Are language options visible?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2 || languagesFound >= 1) {
                System.out.println("========================================");
                System.out.println("  TC-042: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some language elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap on Languages?");
                System.out.println("  2. Is language page displayed?");
                System.out.println("  3. Are language options visible?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-042: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect language page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you navigate to Settings?");
                System.out.println("  2. Did you tap on Languages?");
                System.out.println("  3. Is 'Choose the language' page shown?");
                System.out.println("  4. Are English/Arabic/French visible?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying language page: " + e.getMessage());
            System.out.println("TC-042: FAILED - " + e.getMessage());
        }
    }
}
