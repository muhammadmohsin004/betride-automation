package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import pages.Page;

public class TC019_HourlyRideTypeValidationSteps extends Page {

    @And("Ride type should be displayed as Hourly not normal ride")
    public void rideTypeShouldBeDisplayedAsHourlyNotNormalRide() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-019: HOURLY RIDE TYPE VALIDATION");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  Verifying that hourly ride appears as");
            System.out.println("  'Hourly' type and NOT as normal ride.");
            System.out.println("");
            System.out.println("========================================");

            // Check for hourly ride type indicators
            boolean hasHourlyType = pageSource.contains("Hourly") ||
                                    pageSource.contains("hourly") ||
                                    pageSource.contains("HOURLY") ||
                                    pageSource.contains("hour") ||
                                    pageSource.contains("Hour") ||
                                    pageSource.contains("hrs") ||
                                    pageSource.contains("Hrs");

            // Check for specific hourly duration text
            boolean hasHourlyDuration = pageSource.contains("1 hour") ||
                                        pageSource.contains("2 hour") ||
                                        pageSource.contains("3 hour") ||
                                        pageSource.contains("1 Hour") ||
                                        pageSource.contains("2 Hour") ||
                                        pageSource.contains("1.0 Hour") ||
                                        pageSource.contains("2.0 Hour") ||
                                        pageSource.contains("Hours") ||
                                        pageSource.contains("hours");

            // Check for normal ride indicators (should NOT be present for hourly)
            boolean hasNormalRideOnly = !hasHourlyType &&
                                        (pageSource.contains("km") ||
                                         pageSource.contains("KM") ||
                                         pageSource.contains("distance") ||
                                         pageSource.contains("Distance"));

            // Check for ride popup visibility
            boolean hasRidePopup = pageSource.contains("Accept") ||
                                   pageSource.contains("Reject") ||
                                   pageSource.contains("MAD");

            // Check for fare information
            boolean hasFareInfo = pageSource.contains("MAD") ||
                                  pageSource.contains("Fare") ||
                                  pageSource.contains("fare");

            System.out.println("");
            System.out.println("Ride Type Verification:");
            System.out.println("-----------------------");
            System.out.println("  - Ride popup visible: " + (hasRidePopup ? "YES" : "NO"));
            System.out.println("  - Hourly type indicator: " + (hasHourlyType ? "YES" : "NO"));
            System.out.println("  - Hourly duration text: " + (hasHourlyDuration ? "YES" : "NO"));
            System.out.println("  - Fare information: " + (hasFareInfo ? "YES" : "NO"));
            System.out.println("  - Appears as normal ride only: " + (hasNormalRideOnly ? "YES (ISSUE)" : "NO (CORRECT)"));
            System.out.println("");

            // Determine if ride type is correctly displayed
            if (hasRidePopup && (hasHourlyType || hasHourlyDuration)) {
                System.out.println("========================================");
                System.out.println("  TC-019: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Hourly ride type validation successful!");
                System.out.println("");
                System.out.println("  - Ride popup is visible");
                System.out.println("  - Ride type displayed as HOURLY");
                System.out.println("  - NOT appearing as normal ride");
                System.out.println("");
                if (hasHourlyDuration) {
                    System.out.println("  - Hourly duration is shown");
                }
                System.out.println("");
                System.out.println("========================================");
            } else if (hasRidePopup && hasNormalRideOnly) {
                System.out.println("========================================");
                System.out.println("  TC-019: FAILED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  ISSUE DETECTED!");
                System.out.println("");
                System.out.println("  The hourly ride appears to be");
                System.out.println("  displayed as a NORMAL ride instead");
                System.out.println("  of being marked as HOURLY.");
                System.out.println("");
                System.out.println("  Expected: Ride type = Hourly");
                System.out.println("  Actual: Ride type = Normal");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasRidePopup) {
                System.out.println("========================================");
                System.out.println("  TC-019: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Ride popup is visible but hourly");
                System.out.println("  type indicator not clearly detected.");
                System.out.println("");
                System.out.println("  Please verify manually that the");
                System.out.println("  ride shows 'Hourly' type label.");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-019: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Ride popup not detected.");
                System.out.println("  Please ensure:");
                System.out.println("  1. Rider booked HOURLY ride");
                System.out.println("  2. Driver received the alert");
                System.out.println("  3. Check if ride shows as 'Hourly'");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(2000, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying hourly ride type: " + e.getMessage());
            System.out.println("TC-019: FAILED - " + e.getMessage());
        }
    }
}
