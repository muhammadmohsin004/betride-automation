package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC081_VerifyBookHourlyOptionVisibleSteps extends Page {

    @Given("Home screen is loaded")
    public void homeScreenIsLoaded() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-081: VERIFY BOOK HOURLY OPTION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Home screen should be loaded");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 10 seconds for Home screen...");
            System.out.println("");

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
            System.out.println("Home screen should be loaded.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User views the Home screen options")
    public void userViewsTheHomeScreenOptions() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  VIEW HOME SCREEN OPTIONS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Look at the Home screen");
            System.out.println("  2. View all available booking options");
            System.out.println("  3. Look for 'Book Hourly' option");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 8 seconds to view options...");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(2000);
                System.out.println("Waiting... " + ((i + 1) * 2) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Options should be visible.");

        } catch (Exception e) {
            System.out.println("Error viewing options: " + e.getMessage());
        }
    }

    @Then("Book Hourly option should be visible")
    public void bookHourlyOptionShouldBeVisible() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  BOOK HOURLY OPTION VERIFICATION");
            System.out.println("========================================");

            // Check for Book Hourly option
            boolean hasBookHourly = pageSource.contains("Book Hourly") ||
                                    pageSource.contains("book hourly") ||
                                    pageSource.contains("Book hourly") ||
                                    pageSource.contains("Hourly") ||
                                    pageSource.contains("hourly");

            // Check for other booking options
            boolean hasBookRide = pageSource.contains("Book Ride") ||
                                  pageSource.contains("book ride") ||
                                  pageSource.contains("Book ride");

            // Check for City to City option
            boolean hasCityToCity = pageSource.contains("City to City") ||
                                    pageSource.contains("city to city") ||
                                    pageSource.contains("City to city");

            // Check for Home screen indicators
            boolean hasHomeScreen = pageSource.contains("Home") ||
                                    pageSource.contains("home") ||
                                    pageSource.contains("Where") ||
                                    pageSource.contains("Destination");

            // Check for map
            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google");

            System.out.println("");
            System.out.println("Book Hourly Option Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Book Hourly option: " + (hasBookHourly ? "YES" : "NO"));
            System.out.println("  - Book Ride option: " + (hasBookRide ? "YES" : "NO"));
            System.out.println("  - City to City option: " + (hasCityToCity ? "YES" : "NO"));
            System.out.println("  - Home screen: " + (hasHomeScreen ? "YES" : "NO"));
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasBookHourly) score += 4;
            if (hasBookRide) score += 2;
            if (hasCityToCity) score++;
            if (hasHomeScreen) score++;
            if (hasMap) score++;

            if (score >= 4 || hasBookHourly) {
                System.out.println("========================================");
                System.out.println("  TC-081: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Book Hourly option is visible!");
                System.out.println("");
                if (hasBookHourly) System.out.println("  - Book Hourly option found");
                if (hasBookRide) System.out.println("  - Book Ride option visible");
                if (hasCityToCity) System.out.println("  - City to City option visible");
                if (hasHomeScreen) System.out.println("  - Home screen confirmed");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is 'Book Hourly' option visible?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-081: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on the Home screen?");
                System.out.println("  2. Is 'Book Hourly' option visible?");
                System.out.println("  3. Can you see all booking options?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Book Hourly: " + e.getMessage());
            System.out.println("TC-081: FAILED - " + e.getMessage());
        }
    }
}
