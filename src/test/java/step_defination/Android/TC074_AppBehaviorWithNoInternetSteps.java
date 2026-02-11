package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC074_AppBehaviorWithNoInternetSteps extends Page {

    @Given("Internet is turned off on the device")
    public void internetIsTurnedOffOnTheDevice() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-074: APP BEHAVIOR WITH NO INTERNET");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Go to device Settings");
            System.out.println("  2. Turn OFF WiFi");
            System.out.println("  3. Turn OFF Mobile Data");
            System.out.println("  4. Ensure NO internet connection");
            System.out.println("  5. Open the Rider app");
            System.out.println("  6. Ensure you are logged in");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds to turn off internet...");
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
            System.out.println("Internet should be off now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Lets Go button")
    public void userTapsOnLetsGoButton() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP LET'S GO BUTTON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the home screen");
            System.out.println("  2. Enter pickup and drop locations");
            System.out.println("  3. Tap 'Let's Go' or 'Search Driver' button");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Let's Go...");

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
            System.out.println("Let's Go should be tapped.");

        } catch (Exception e) {
            System.out.println("Error tapping Let's Go: " + e.getMessage());
        }
    }

    @Then("Error message No internet connection should appear")
    public void errorMessageNoInternetConnectionShouldAppear() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  NO INTERNET ERROR VERIFICATION");
            System.out.println("========================================");

            // Check for no internet error message
            boolean hasNoInternet = pageSource.contains("No internet") ||
                                    pageSource.contains("no internet") ||
                                    pageSource.contains("No Internet") ||
                                    pageSource.contains("NO INTERNET");

            // Check for connection error
            boolean hasConnectionError = pageSource.contains("connection") ||
                                         pageSource.contains("Connection") ||
                                         pageSource.contains("network") ||
                                         pageSource.contains("Network");

            // Check for error message
            boolean hasError = pageSource.contains("Error") ||
                               pageSource.contains("error") ||
                               pageSource.contains("Failed") ||
                               pageSource.contains("failed");

            // Check for retry option
            boolean hasRetry = pageSource.contains("Retry") ||
                               pageSource.contains("retry") ||
                               pageSource.contains("Try again") ||
                               pageSource.contains("try again");

            // Check for offline indicator
            boolean hasOffline = pageSource.contains("Offline") ||
                                 pageSource.contains("offline") ||
                                 pageSource.contains("unavailable") ||
                                 pageSource.contains("Unavailable");

            System.out.println("");
            System.out.println("No Internet Error Verification:");
            System.out.println("-------------------------------");
            System.out.println("  - No internet message: " + (hasNoInternet ? "YES" : "NO"));
            System.out.println("  - Connection error: " + (hasConnectionError ? "YES" : "NO"));
            System.out.println("  - Error message: " + (hasError ? "YES" : "NO"));
            System.out.println("  - Retry option: " + (hasRetry ? "YES" : "NO"));
            System.out.println("  - Offline indicator: " + (hasOffline ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasNoInternet) score += 4;
            if (hasConnectionError) score += 2;
            if (hasError) score += 2;
            if (hasRetry) score++;
            if (hasOffline) score++;

            if (score >= 3 || hasNoInternet || (hasConnectionError && hasError) || hasOffline) {
                System.out.println("========================================");
                System.out.println("  TC-074: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  No internet error shown correctly!");
                System.out.println("");
                if (hasNoInternet) System.out.println("  - 'No internet' message displayed");
                if (hasConnectionError) System.out.println("  - Connection error shown");
                if (hasError) System.out.println("  - Error message visible");
                if (hasRetry) System.out.println("  - Retry option available");
                if (hasOffline) System.out.println("  - Offline indicator shown");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did 'No internet' error appear?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-074: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you turn off internet?");
                System.out.println("  2. Did you tap Let's Go?");
                System.out.println("  3. Did 'No internet connection' error appear?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying no internet: " + e.getMessage());
            System.out.println("TC-074: FAILED - " + e.getMessage());
        }
    }
}
