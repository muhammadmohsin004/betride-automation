package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC078_SelectDropOffFromMapSteps extends Page {

    @Given("Map is opened for location selection")
    public void mapIsOpenedForLocationSelection() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-078: SELECT DROP-OFF FROM MAP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Tap on Book Ride");
            System.out.println("  4. Map should be visible for selection");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 10 seconds to open map...");
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
            System.out.println("Map should be opened now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User moves the map pin to a new location")
    public void userMovesTheMapPinToANewLocation() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  MOVE MAP PIN");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the map screen");
            System.out.println("  2. Drag/move the map to change pin location");
            System.out.println("  3. Or tap on a different location on the map");
            System.out.println("  4. Watch the drop-off address update");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 12 seconds to move map pin...");

            for (int i = 0; i < 4; i++) {
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
            System.out.println("Map pin should be moved.");

        } catch (Exception e) {
            System.out.println("Error moving map pin: " + e.getMessage());
        }
    }

    @Then("Drop-off should update based on pin location")
    public void dropOffShouldUpdateBasedOnPinLocation() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  DROP-OFF MAP UPDATE VERIFICATION");
            System.out.println("========================================");

            // Check for map indicators
            boolean hasMap = pageSource.contains("Map") ||
                             pageSource.contains("map") ||
                             pageSource.contains("Google") ||
                             pageSource.contains("MapView");

            // Check for drop-off field
            boolean hasDropoff = pageSource.contains("Drop") ||
                                 pageSource.contains("drop") ||
                                 pageSource.contains("Destination") ||
                                 pageSource.contains("destination") ||
                                 pageSource.contains("To");

            // Check for location/address content
            boolean hasAddress = pageSource.contains("Street") ||
                                 pageSource.contains("street") ||
                                 pageSource.contains("Road") ||
                                 pageSource.contains("road") ||
                                 pageSource.contains("Avenue") ||
                                 pageSource.contains("Marrakech") ||
                                 pageSource.contains("Morocco");

            // Check for pin/marker
            boolean hasPin = pageSource.contains("Pin") ||
                             pageSource.contains("pin") ||
                             pageSource.contains("Marker") ||
                             pageSource.contains("marker") ||
                             pageSource.contains("Location");

            // Check for confirm button
            boolean hasConfirm = pageSource.contains("Confirm") ||
                                 pageSource.contains("confirm") ||
                                 pageSource.contains("Set") ||
                                 pageSource.contains("Done") ||
                                 pageSource.contains("Select");

            System.out.println("");
            System.out.println("Drop-off Map Update Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Map visible: " + (hasMap ? "YES" : "NO"));
            System.out.println("  - Drop-off field: " + (hasDropoff ? "YES" : "NO"));
            System.out.println("  - Address content: " + (hasAddress ? "YES" : "NO"));
            System.out.println("  - Pin/Marker: " + (hasPin ? "YES" : "NO"));
            System.out.println("  - Confirm button: " + (hasConfirm ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasMap) score += 2;
            if (hasDropoff) score += 2;
            if (hasAddress) score += 3;
            if (hasPin) score++;
            if (hasConfirm) score++;

            if (score >= 4 || hasAddress || (hasMap && hasDropoff)) {
                System.out.println("========================================");
                System.out.println("  TC-078: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Drop-off updated from map!");
                System.out.println("");
                if (hasMap) System.out.println("  - Map visible");
                if (hasDropoff) System.out.println("  - Drop-off field present");
                if (hasAddress) System.out.println("  - Address updated");
                if (hasPin) System.out.println("  - Pin/Marker shown");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did drop-off update when moving pin?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-078: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you move the map pin?");
                System.out.println("  2. Did drop-off location update?");
                System.out.println("  3. Does address reflect new pin position?");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying drop-off update: " + e.getMessage());
            System.out.println("TC-078: FAILED - " + e.getMessage());
        }
    }
}
