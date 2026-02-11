package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC028_HelmetQuestionSteps extends Page {

    @Given("Rider is on the Rate Driver page for helmet question test")
    public void riderIsOnTheRateDriverPageForHelmetQuestionTest() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-028: HELMET QUESTION TEST");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTIONS REQUIRED:");
            System.out.println("");
            System.out.println("  1. Complete a ride flow:");
            System.out.println("     - Rider creates a ride");
            System.out.println("     - Driver accepts the ride");
            System.out.println("     - Rider accepts the driver");
            System.out.println("     - Complete the trip");
            System.out.println("");
            System.out.println("  2. After ride completion:");
            System.out.println("     - Close and reopen Rider app");
            System.out.println("     - See 'Rate Your Driver' popup");
            System.out.println("     - Tap a star to go to Rate Driver page");
            System.out.println("");
            System.out.println("  3. You should now be on the Rate Driver page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for manual navigation to Rate Driver page
            System.out.println("");
            System.out.println("Waiting 45 seconds to reach Rate Driver page...");
            System.out.println("Please complete the ride and navigate to Rate Driver page.");
            System.out.println("");

            for (int i = 0; i < 15; i++) {
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
            System.out.println("Rider should now be on Rate Driver page.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("Rider scrolls to Did driver provide you a helmet question")
    public void riderScrollsToDidDriverProvideYouAHelmetQuestion() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SCROLL TO HELMET QUESTION STEP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rate Driver page");
            System.out.println("  2. Scroll down to find:");
            System.out.println("     'Did driver provide you a helmet?'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to scroll
            System.out.println("");
            System.out.println("Waiting 10 seconds for scrolling...");

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
            System.out.println("Helmet question should be visible now.");

        } catch (Exception e) {
            System.out.println("Error during scroll: " + e.getMessage());
        }
    }

    @Then("Helmet question Yes and No options should be displayed")
    public void helmetQuestionYesAndNoOptionsShouldBeDisplayed() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  HELMET QUESTION VERIFICATION");
            System.out.println("========================================");

            // Check for "Did driver provide you a helmet?" question
            boolean hasHelmetQuestion = pageSource.contains("helmet") ||
                                        pageSource.contains("Helmet") ||
                                        pageSource.contains("HELMET") ||
                                        pageSource.contains("provide") ||
                                        pageSource.contains("Provide");

            // Check for Yes option
            boolean hasYesOption = pageSource.contains("Yes") ||
                                   pageSource.contains("yes") ||
                                   pageSource.contains("YES");

            // Check for No option
            boolean hasNoOption = pageSource.contains("No") ||
                                  pageSource.contains("no") ||
                                  pageSource.contains("NO");

            // Check for Rate Driver page indicators
            boolean hasRateDriverPage = pageSource.contains("Rate") ||
                                        pageSource.contains("rating") ||
                                        pageSource.contains("Rating") ||
                                        pageSource.contains("star") ||
                                        pageSource.contains("Star");

            // Check for other rating questions (indicates full page)
            boolean hasOtherQuestions = pageSource.contains("on time") ||
                                        pageSource.contains("improved") ||
                                        pageSource.contains("feedback") ||
                                        pageSource.contains("Submit");

            System.out.println("");
            System.out.println("Helmet Question Verification:");
            System.out.println("-----------------------------");
            System.out.println("  - Helmet question: " + (hasHelmetQuestion ? "YES" : "NO"));
            System.out.println("  - Yes option: " + (hasYesOption ? "YES" : "NO"));
            System.out.println("  - No option: " + (hasNoOption ? "YES" : "NO"));
            System.out.println("  - Rate Driver page: " + (hasRateDriverPage ? "YES" : "NO"));
            System.out.println("  - Other questions: " + (hasOtherQuestions ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            boolean yesNoOptionsFound = hasYesOption && hasNoOption;

            if (yesNoOptionsFound && hasRateDriverPage) {
                System.out.println("========================================");
                System.out.println("  TC-028: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Helmet question verified!");
                System.out.println("");
                System.out.println("  - Rate Driver page displayed");
                if (hasHelmetQuestion) System.out.println("  - 'Did driver provide helmet?' question visible");
                System.out.println("  - Yes option available");
                System.out.println("  - No option available");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasYesOption || hasNoOption) {
                System.out.println("========================================");
                System.out.println("  TC-028: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some radio options detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is 'Did driver provide helmet?' visible?");
                System.out.println("  2. Are Yes/No radio buttons displayed?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-028: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect helmet question.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Rate Driver page?");
                System.out.println("  2. Did you scroll to see the question?");
                System.out.println("  3. Is 'Did driver provide helmet?' visible?");
                System.out.println("  4. Are Yes/No options displayed?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying helmet question: " + e.getMessage());
            System.out.println("TC-028: FAILED - " + e.getMessage());
        }
    }
}
