package step_defination.Android;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;
import pages.android.HomePage;

public class HomeSteps extends Page {

    private AndroidKey getAndroidKeyFromDigit(char digit) {
    switch (digit) {
        case '0': return AndroidKey.DIGIT_0;
        case '1': return AndroidKey.DIGIT_1;
        case '2': return AndroidKey.DIGIT_2;
        case '3': return AndroidKey.DIGIT_3;
        case '4': return AndroidKey.DIGIT_4;
        case '5': return AndroidKey.DIGIT_5;
        case '6': return AndroidKey.DIGIT_6;
        case '7': return AndroidKey.DIGIT_7;
        case '8': return AndroidKey.DIGIT_8;
        case '9': return AndroidKey.DIGIT_9;
        default:
            throw new IllegalArgumentException("Invalid digit: " + digit);
    }
}
    @Given("User is on Get Ride Requests screen")
    public void UserIsOnHomePageTitleTestingApp() {
        Assert.assertTrue(getHomePage().getTitle().isDisplayed());
    }

    @Then("User should see home screen")
    public void UsershouldseeHomePageTitleTestingApp() {
        Assert.assertTrue(getHomePage().getTitle().isDisplayed());
    }

    // @And("User taps on تخطي >")
    // public void UserTapsonEmailField() {
    //     Assert.assertTrue(getHomePage().getEmailfield().isDisplayed());
    //     getHomePage().getEmailfield().click();
    // }

@When("User taps on {string}")
public void userTapsOnDynamicElement(String accessibilityId) {
    Assert.assertTrue(getHomePage().getElementByAccessibilityID(accessibilityId).isDisplayed());
    getHomePage().getElementByAccessibilityID(accessibilityId).click();
}

@When("User taps on the {string}")
public void userTapsOntheDynamicElement(String accessibilityId) {
    Assert.assertTrue(getHomePage().getElementBytheAccessibilityID(accessibilityId).isDisplayed());
    getHomePage().getElementBytheAccessibilityID(accessibilityId).click();
}

@When("User taps on Phone Number field")
public void userTapsOnPhoneNumberField() {
    Assert.assertTrue(getHomePage().getPhoneNumberField().isDisplayed());
    getHomePage().getPhoneNumberField().click();
}

@And("User type {string} in Phone Number field")
public void userTypeInPhoneNumberField(String phoneNumber) {
    WebElement phoneField = getHomePage().getPhoneNumberField();
    Assert.assertTrue(phoneField.isDisplayed());
    phoneField.clear();
    phoneField.sendKeys(phoneNumber);
}

@And("User clicks on Accept Agreements and Terms checkbox")
public void userClicksOnAcceptTermsCheckbox() {
    WebElement checkbox = getHomePage().getAcceptTermsCheckbox();
    checkbox.click();
}

// @When("user enter {string} in otp field")
// public void userEnterOtp(String otp) throws InterruptedException {
//     List<AndroidElement> otpFields = getHomePage().getOtpInputFields();

//     assertEquals("Expected 5 OTP input fields", 5, otpFields.size());

//     for (int i = 0; i < otp.length(); i++) {
//         AndroidElement field = otpFields.get(i);
//         assertTrue("OTP field " + i + " is not displayed", field.isDisplayed());

//         field.click();  // Focus each field
//         Thread.sleep(200); // Optional small wait between each input
//         field.clear();  // Optional
//         field.setValue(Character.toString(otp.charAt(i))); // Appium's safer alternative
//     }
// }

@When("user enter {string} in otp field")
public void userEnterOtpWithKeyEvents(String otp) throws InterruptedException {
    AndroidElement otpField = HomePage.getOtpInputField();
    otpField.click(); // Focus the OTP field

    // Press each digit using AndroidKey events
    for (char digit : otp.toCharArray()) {
        AndroidKey key = getAndroidKeyFromDigit(digit);
        AndroidDriverSetup.getAndroidDriver().pressKey(new KeyEvent(key));
        Thread.sleep(300); // Optional delay between key presses
    }
}


@Then("User should see {string}")
public void userShouldSeeDynamicElement(String accessibilityId) {
    Assert.assertTrue(getHomePage().getElementByAccessibilityID(accessibilityId).isDisplayed());
}

@Then("User should taps on {string}")
public void userTapsOnActiveJobs(String element) {
    if (element.equals("Active Jobs")) {
        AndroidElement activeJobs = HomePage.getActiveJobsButton();
        Assert.assertTrue("Active Jobs button is not visible", activeJobs.isDisplayed());
        activeJobs.click();
    }
}

@Then("User should see {string} page")
public void userShouldSeePage(String expectedPage) {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 15);
    AndroidElement activeJobs = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//android.view.View[@content-desc='" + expectedPage + "']")));
    Assert.assertTrue(expectedPage + " page is not visible", activeJobs.isDisplayed());
}
@When("User accepts the ride request")
public void userAcceptsTheRideRequest() {
    AndroidElement acceptButton = HomePage.getAcceptRideButton();
    Assert.assertTrue("Accept Ride button not visible", acceptButton.isDisplayed());
    acceptButton.click();
}

@When("User taps on 'Arrive' button")
public void userTapsOnArrive() {
    AndroidElement arrive = HomePage.getArriveButton();
    Assert.assertTrue("Arrive button not displayed", arrive.isDisplayed());
    arrive.click();
}

@Then("User should see confirmation popup")
public void userShouldSeeConfirmationPopup() {
    AndroidElement yesToggle = HomePage.getYesToggle();
    Assert.assertTrue("Confirmation popup not visible", yesToggle.isDisplayed());
}

@When("User taps on 'Yes' toggle")
public void userTapsOnYes() {
    HomePage.getYesToggle().click();
}

@Then("User should see 'Start Ride' button")
public void userShouldSeeStartRideButton() {
    Assert.assertTrue("Start Ride not visible", HomePage.getStartRideButton().isDisplayed());
}

@When("User taps on 'Start Ride' button")
public void userTapsOnStartRide() {
    HomePage.getStartRideButton().click();
}

@And("User navigates back to the app from Google Maps")
public void userReturnsToApp() throws InterruptedException {
    Thread.sleep(4000); // wait for maps to open
    AndroidDriverSetup.getAndroidDriver().pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
    Thread.sleep(1000);
    AndroidDriverSetup.getAndroidDriver().pressKey(new KeyEvent(AndroidKey.BACK));
}

@Then("User should see 'Ride Started' label")
public void userShouldSeeRideStarted() {
    Assert.assertTrue("Ride Started not displayed", HomePage.getRideStartedLabel().isDisplayed());
}

@When("User taps on 'End Ride' button")
public void userTapsOnEndRide() {
    HomePage.getEndRideButton().click();
}

@Then("User should see 'Rate Rider' page")
public void userShouldSeeRateRiderPage() {
    Assert.assertTrue("Rate Rider screen not visible", HomePage.getRateRiderTitle().isDisplayed());
}

@When("User gives 5 star rating")
public void userGivesFiveStarRating() {
    HomePage.getFiveStarButton().click();
}

@And("User submits the review")
public void userSubmitsTheReview() {
    HomePage.getSubmitReviewButton().click();
}

@When("user taps on profile button")
public void userClicksOnProfileButton() {
    AndroidElement profileButton = HomePage.getProfileButton();
    Assert.assertTrue("Profile button is not displayed", profileButton.isDisplayed());
    profileButton.click();
}

@Then("user should see Alert Message")
public void userShouldSeeAlertMessage() {
    AndroidElement alert = HomePage.getAlertMessageElement();
    Assert.assertTrue("Alert message not displayed", alert.isDisplayed());
}





    @And("User enters {string} in email field")
    public void UserEntersonEmailField(String text) {
        Assert.assertTrue(getHomePage().getEmailfield().isDisplayed());
        getHomePage().getEmailfield().click();  // Click on the email field
        getHomePage().getEmailfield().sendKeys(text);  // Enter the provided text
    }

    @And("User taps on Password field")
    public void UserTapsonPasswordField() {
        Assert.assertTrue(getHomePage().getPasswordfield().isDisplayed());
        getHomePage().getPasswordfield().click();
    }

    @And("User enters {string} in password field")
    public void UserEntersonPasswordField(String text) {
        Assert.assertTrue(getHomePage().getPasswordfield().isDisplayed());
        getHomePage().getPasswordfield().click();  // Click on the email field
        getHomePage().getPasswordfield().sendKeys(text);  // Enter the provided text
    }

    @And("User taps on Signin button")
    public void UserClicksOnSigninBtn() {
        Assert.assertTrue(getHomePage().Signin_btn().isDisplayed());
        getHomePage().Signin_btn().click();
        getHomePage().Signin_btn().click();
    }

    @Then("User should see Select Environment screen")
    public void UserseeEnvScreen() {
        Assert.assertTrue(getHomePage().Env_screen().isDisplayed());
    }

    @When("User taps on Production")
    public void tapsonproduction() {
        Assert.assertTrue(getHomePage().production_btn().isDisplayed());
        getHomePage().production_btn().click();  // Click on the email field
    }

    @And("User taps on Save button")
    public void tapsonsavebtn() {
        Assert.assertTrue(getHomePage().save_btn().isDisplayed());
        getHomePage().save_btn().click();  // Click on the email field
    }

    @Then("User should see welcome screen")
    public void UserIsOnWelcomeScreen() {
        Assert.assertTrue(getHomePage().getWelcomeTitle().isDisplayed());
    }

    @And("User taps on continue button")
    public void UserClicksOnContinueBtn() {
        Assert.assertTrue(getHomePage().Continue_btn().isDisplayed());
        getHomePage().Continue_btn().click();
    }

    @And("User taps on next button")
    public void UserClicksOnnextBtn() {
        Assert.assertTrue(getHomePage().Next_btn().isDisplayed());
        getHomePage().Next_btn().click();
    }

    @Then("User should see Wellness Dashboard")
    public void UserIsOnWellnessDashboard() {
        Assert.assertTrue(getHomePage().Wellness_dashboard().isDisplayed());
    }

    @And("^\\[Home Page\\] Verify the Version Code (.*)$")
    public void verifyTheCode(String versionCode) {
        Assert.assertEquals(getHomePage().getVersionCode().getText(), versionCode, "Verify Version Code");
    }

    @When("User taps on menu button")
    public void UserClicksOnMenuBtn() {
        Assert.assertTrue(getHomePage().Menu_btn().isDisplayed());
        getHomePage().Menu_btn().click();
    }

    @And("User taps on Signout button")
    public void UserClicksOnSignoutBtn() {
        Assert.assertTrue(getHomePage().Signout_btn().isDisplayed());
        getHomePage().Signout_btn().click();
    }
//
//    @And("^\\[Home Page\\] Verify the Version Name (.*)$")
//    public void verifyTheName(String versionName) {
//        Assert.assertEquals(getHomePage().getVersionName().getText(), versionName, "Verify Version Name");
//        getHomePage().getVersionName().isDisplayed();
//    }
//
//    @When("\\[Home Page\\] User tap on Button (.*)$")
//    public void homePageUserTapOnButtonXxx(int button) {
//        getHomePage().getButton(button).click();
//    }
//
//    @Then("[Home Page] Verify the Immediate Update button is visible")
//    public void homePageVerifyTheImmediateUpdateButtonIsVisible() {
//        getHomePage().getImmediateButton().isDisplayed();
//    }
//
//    @When("[Home Page] User tap on Immediate Update Button")
//    public void homePageUserTapOnImmediateUpdateButton() {
//        getHomePage().getImmediateButton().click();
//    }

//    @Then("[Home Page] Verify the three button options")
//    public void updatePageVerifyTheThreeButtonOptions(DataTable dataTable) {
//        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
//        for (Map<String, String> itemData : rows) {
//            if (itemData.containsKey("Button1")) {
//                $(getHomePage().getButton(1)).shouldHave(Condition.exactText(itemData.get("Button1")));
//            }
//            if (itemData.containsKey("Button2")) {
//                $(getHomePage().getButton(2)).shouldHave(Condition.exactText(itemData.get("Button2")));
//            }
//            if (itemData.containsKey("Button3")) {
//                $(getHomePage().getButton(3)).shouldHave(Condition.exactText(itemData.get("Button3")));
//            }
//        }
//    }

//    @Then("\\[Home Page\\] Verify that Result (.*) is displayed$")
//    public void homePageVerifyThatResul1IsVisible(String number) {
//        Assert.assertEquals(getHomePage().getResult().getText(), "RESULT " + number, "Verify Result with Number");
//        getHomePage().backButton();
//    }
//
//    @When("[Home Page] User tap on Flexible Update Button")
//    public void homePageUserTapOnFlexibleUpdateButton() {
//        getHomePage().getFlexibleButton().click();
//    }
//
//    @Then("[Home Page] Verify the Flexible Update button is visible")
//    public void homePageVerifyTheFlexibleUpdateButtonIsVisible() {
//        getHomePage().getFlexibleButton().isDisplayed();
//    }

    @Then("[Home Page] Verify that The App title is displayed on home page")
    public void homePageVerifyThatTheAppTitleIsDisplayedOnHomePage() {
        Assert.assertEquals(getHomePage().getTitleDemoApp().getText(), "The Apvp", "Verify Result");
    }

    @When("^I tap on (.*) tab$")
    public void iTapOnXxxTab(String name) {
        getHomePage().getTabNameDemoApp(name).click();
    }

    @And("I press back button")
    public void iPressBackButton() {
        getHomePage().backButton();
    }

    @When("^I type (.*) in text field on echo box screen$")
    public void iTypeXxxInTextFieldOnEchoBoxScreen(String text) {
        getHomePage().getTextFieldDemoApp().sendKeys(text);
    }

    @When("I tap on save button")
    public void iTapOnSaveButton() {
        getHomePage().getSaveButtonDemoApp().click();
    }

    @Then("^I should see (.*) echoed text on echo box screen$")
    public void iShouldSeeXxxEchoedTextOnEchoBoxScreen(String echo) {
        Assert.assertEquals(getHomePage().getEchoedTextDemoApp(echo).getText(), echo, "Verify Result");
    }

    @When("^I tap on (.*) option$")
    public void iTapOnXxxOption(String option) {
        getHomePage().getOptionDemoApp(option).click();
    }

    @When("^I scroll to (.*) accessibility id$")
    public void iScrollToXxxAccessibilityId(String id) {
        getHomePage().scrollToElementWithAccessibilityId(id);

    }

    @And("I accept popup")
    public void iAcceptPopup() {
        Alert alert = AndroidDriverSetup.getAndroidDriver().switchTo().alert();
        alert.accept();
    }

    @And("I dismiss popup")
    public void iDismissPopup() {
        Alert alert = AndroidDriverSetup.getAndroidDriver().switchTo().alert();
        alert.dismiss();
    }

    @Then("^I should see popup$")
    public void iShouldSeePopup() {
        try {
            // Attempt to switch to the alert
            Alert alert = AndroidDriverSetup.getAndroidDriver().switchTo().alert();
            // If successful, we assume the popup is displayed
            System.out.println("Popup is displayed with message: " + alert.getText());
        } catch (NoAlertPresentException e) {
            // If an exception is caught, it means no popup is present
            throw new AssertionError("Expected a popup, but none was displayed.");
        }
    }

    @And("^I wait (\\d+) seconds$")
    public void iWaitSeconds(int seconds) {
        try {
            // Convert seconds to milliseconds and wait
            Thread.sleep(seconds * 1000L);
            System.out.println("Waited " + seconds + " seconds.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Wait was interrupted.");
        }
    }
}