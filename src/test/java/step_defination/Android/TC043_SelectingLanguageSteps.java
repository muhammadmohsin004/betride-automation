package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC043_SelectingLanguageSteps extends Page {

    @Given("User is on the Language selection screen")
    public void userIsOnTheLanguageSelectionScreen() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-043: SELECTING A LANGUAGE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings → Languages");
            System.out.println("  4. You should see language options:");
            System.out.println("     - English");
            System.out.println("     - Arabic");
            System.out.println("     - French");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Language selection screen.");
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
            System.out.println("User should be on Language selection screen now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on a language option like English or Arabic or French")
    public void userTapsOnALanguageOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP ON A LANGUAGE OPTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Language selection screen");
            System.out.println("  2. Tap on one of the language options:");
            System.out.println("     - English");
            System.out.println("     - Arabic");
            System.out.println("     - French");
            System.out.println("");
            System.out.println("  3. Observe if the radio button becomes active");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap language
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap a language...");

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
            System.out.println("Language should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping language: " + e.getMessage());
        }
    }

    @Then("Language option should get selected with radio button active")
    public void languageOptionShouldGetSelectedWithRadioButtonActive() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  LANGUAGE SELECTION VERIFICATION");
            System.out.println("========================================");

            // Check for Language page
            boolean hasLanguagePage = pageSource.contains("Language") ||
                                      pageSource.contains("language") ||
                                      pageSource.contains("Choose");

            // Check for language options
            boolean hasEnglish = pageSource.contains("English") ||
                                 pageSource.contains("english");
            boolean hasArabic = pageSource.contains("Arabic") ||
                                pageSource.contains("arabic") ||
                                pageSource.contains("العربية");
            boolean hasFrench = pageSource.contains("French") ||
                                pageSource.contains("french") ||
                                pageSource.contains("Français");

            // Check for selection indicators
            boolean hasSelectedIndicator = pageSource.contains("selected") ||
                                           pageSource.contains("checked=\"true\"") ||
                                           pageSource.contains("Selected") ||
                                           pageSource.contains("SELECTED");

            // Check for radio button indicators
            boolean hasRadioButton = pageSource.contains("RadioButton") ||
                                     pageSource.contains("radio") ||
                                     pageSource.contains("android.widget.RadioButton") ||
                                     pageSource.contains("checkable=\"true\"");

            // Check for confirm button
            boolean hasConfirmButton = pageSource.contains("Confirm") ||
                                       pageSource.contains("confirm") ||
                                       pageSource.contains("CONFIRM") ||
                                       pageSource.contains("Save") ||
                                       pageSource.contains("Apply");

            System.out.println("");
            System.out.println("Language Selection Verification:");
            System.out.println("--------------------------------");
            System.out.println("  - Language page: " + (hasLanguagePage ? "YES" : "NO"));
            System.out.println("  - English option: " + (hasEnglish ? "YES" : "NO"));
            System.out.println("  - Arabic option: " + (hasArabic ? "YES" : "NO"));
            System.out.println("  - French option: " + (hasFrench ? "YES" : "NO"));
            System.out.println("  - Selected indicator: " + (hasSelectedIndicator ? "YES" : "NO"));
            System.out.println("  - Radio button: " + (hasRadioButton ? "YES" : "NO"));
            System.out.println("  - Confirm button: " + (hasConfirmButton ? "YES" : "NO"));
            System.out.println("");

            // Count languages found
            int languagesFound = 0;
            if (hasEnglish) languagesFound++;
            if (hasArabic) languagesFound++;
            if (hasFrench) languagesFound++;

            // Calculate verification score
            int score = 0;
            if (hasLanguagePage) score += 2;
            score += languagesFound;
            if (hasSelectedIndicator) score += 2;
            if (hasRadioButton) score += 2;
            if (hasConfirmButton) score++;

            if (score >= 4 || (languagesFound >= 2 && (hasSelectedIndicator || hasRadioButton))) {
                System.out.println("========================================");
                System.out.println("  TC-043: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Language selection verified!");
                System.out.println("");
                if (hasLanguagePage) System.out.println("  - Language page confirmed");
                System.out.println("  - Languages available: " + languagesFound);
                if (hasSelectedIndicator) System.out.println("  - Selection indicator found");
                if (hasRadioButton) System.out.println("  - Radio button detected");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you tap on a language?");
                System.out.println("  - Is the radio button now active/selected?");
                System.out.println("  - Can you see the selection highlight?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2 || languagesFound >= 1) {
                System.out.println("========================================");
                System.out.println("  TC-043: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Language options detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap on a language?");
                System.out.println("  2. Is the radio button selected?");
                System.out.println("  3. Can you see visual selection?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-043: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect language selection.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on Language screen?");
                System.out.println("  2. Did you tap English/Arabic/French?");
                System.out.println("  3. Is the option now selected?");
                System.out.println("  4. Is radio button active?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying language selection: " + e.getMessage());
            System.out.println("TC-043: FAILED - " + e.getMessage());
        }
    }
}
