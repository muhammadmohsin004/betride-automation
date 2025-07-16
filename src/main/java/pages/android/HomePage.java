package pages.android;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.Page;

public class HomePage {

    private String titleAccessibilityID = "التالي";
    private static final String phoneNumberFieldXPath = "//android.widget.EditText";
    private static final String acceptTermsCheckboxXPath = "//android.widget.CheckBox";

private static final String otpContainerXPath = 
"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]";
private static final String otpFieldXPath = "//android.widget.EditText";
private static final String profileButtonXPath = "//android.widget.ImageView";
private static final String alertMessageXPath = "//android.widget.ImageView[@content-desc=\"ALERT\nAre you sure to want to Logout\"]";
private static final String activeJobsXPath = "//android.view.View[@content-desc=\"Active Jobs\"]";
private static final String acceptRideXPath = "//android.view.View[@content-desc=\"Accept 30.00\"]";
private static final String arriveXPath = "//android.view.View[@content-desc='Arrive']";
private static final String yesToggleXPath = "//android.view.View[@content-desc='Yes']";
private static final String startRideXPath = "//android.view.View[@content-desc='Start Ride']";
private static final String rideStartedXPath = "//android.view.View[@content-desc='Ride Started']";
private static final String endRideXPath = "//android.view.View[@content-desc='End Ride']";
private static final String rateRiderXPath = "//android.view.View[@content-desc='Rate Rider']";
private static final String fiveStarXPath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[5]";
private static final String submitReviewButtonXPath = "//android.widget.Button[@content-desc='Submit']";


    private String emailAccessibilityID = "SignInScreen:EmailInput:email";
    private String passwordAccessibilityID = "SignInScreen:PasswordInput:password";
    private String signinbtnAccessibilityID = "SignInScreen:SignInButtonText:signinbuttontext";
    private String ContinuebtnAccessibilityID = "WelcomeScreen:OnContinueButtonText:oncontinuebuttontext";
    private String NextbtnXpath = "//android.widget.TextView[@text='NEXT']";
    private String Envscreen_title_xpath = "//android.widget.TextView[@text='Select Environment']";
    private String Production_title_xpath = "//android.widget.TextView[@text='Production']";
    private String savebtn_xpath = "//android.widget.TextView[@text='Save']";
    private String WelcomeTitle = "WelcomeScreen:AppLogo:logo";
    private String Dashboard_accessbilityID = "NewHomeScreen:SeniorName:seniorname";
    private String MenubtnXpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup";
    private String signoutbtnAccessibilityID = "SideMenu:LogOutEvent:logout";


    private String immediateButtonID = "com.meritnation.store.testingapp:id/btn1";
    private String flexibleButtonID = "com.meritnation.store.testingapp:id/btn2";
    private String versionCodeID = "com.meritnation.store.testingapp:id/ver_code";
    private String versionNameID = "com.meritnation.store.testingapp:id/ver_name";
    private String resultText = "com.meritnation.store.testingapp:id/txt";
    private String getTitle = "//android.widget.TextView[@text='The App']";
    private String TextFieldDemoApp = "messageInput";
    private String getSaveButton = "//android.view.ViewGroup[@content-desc='messageSaveBtn']/android.widget.TextView";


    public HomePage(Page page) {
    }

    public WebElement getElementByAccessibilityID(String accessibilityId) {
    return AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(accessibilityId);
}

 public WebElement getElementBytheAccessibilityID(String accessibilityId) {
    AndroidDriver<?> driver = AndroidDriverSetup.getAndroidDriver();

    try {
        // Try finding the element directly
        return driver.findElement(MobileBy.AccessibilityId(accessibilityId));
    } catch (Exception e) {
        System.out.println("Element '" + accessibilityId + "' not immediately visible. Performing swipe up from 'Work Documents'...");

        // Step 1: Find the anchor element
        WebElement anchor = driver.findElement(By.xpath("//android.view.View[@content-desc='Work Documents']"));
        Point location = anchor.getLocation();
        Dimension size = anchor.getSize();

        int startX = location.getX() + size.getWidth() / 2;
        int startY = location.getY() + size.getHeight() / 2;
        int endY = startY - 800; // Increased scroll distance

        // Step 2: Perform tap-hold swipe up
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(100))); // Slight hold for realism
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));

        // Step 3: Try finding the element again after scroll
        return driver.findElement(MobileBy.AccessibilityId(accessibilityId));
    }
}


public static WebElement getPhoneNumberField() {
    return AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(phoneNumberFieldXPath));
}


public static WebElement getAcceptTermsCheckbox() {
    return AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(acceptTermsCheckboxXPath));
}

public static AndroidElement getOtpContainer() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otpContainerXPath)));
}

public static AndroidElement getOtpInputField() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otpFieldXPath)));
}

public static AndroidElement getProfileButton() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(profileButtonXPath)));
}


public static AndroidElement getAlertMessageElement() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(alertMessageXPath)));
}


public static AndroidElement getActiveJobsButton() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(activeJobsXPath)));
}


public static AndroidElement getAcceptRideButton() {
    return waitAndGetElement(By.xpath(acceptRideXPath));
}

public static AndroidElement getArriveButton() {
    return waitAndGetElement(By.xpath(arriveXPath));
}

public static AndroidElement getYesToggle() {
    return waitAndGetElement(By.xpath(yesToggleXPath));
}

public static AndroidElement getStartRideButton() {
    return waitAndGetElement(By.xpath(startRideXPath));
}

public static AndroidElement getRideStartedLabel() {
    return waitAndGetElement(By.xpath(rideStartedXPath));
}

public static AndroidElement getEndRideButton() {
    return waitAndGetElement(By.xpath(endRideXPath));
}

public static AndroidElement getRateRiderTitle() {
    return waitAndGetElement(By.xpath(rateRiderXPath));
}

public static AndroidElement getFiveStarButton() {
    return waitAndGetElement(By.xpath(fiveStarXPath));
}

public static AndroidElement getSubmitReviewButton() {
    return waitAndGetElement(By.xpath(submitReviewButtonXPath));
}

private static AndroidElement waitAndGetElement(By locator) {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 15);
    return (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
}










    public WebElement getTitle() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(titleAccessibilityID));
    }

    public WebElement getWelcomeTitle() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(WelcomeTitle));
    }

    public WebElement getEmailfield() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(emailAccessibilityID));
    }

    public WebElement getPasswordfield() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(passwordAccessibilityID));
    }

    public WebElement Signin_btn() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(signinbtnAccessibilityID));
    }

    public WebElement Continue_btn() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(ContinuebtnAccessibilityID));
    }

    public WebElement Next_btn() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByXPath(NextbtnXpath));
    }

    public WebElement Menu_btn() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByXPath(MenubtnXpath));
    }

    public WebElement Env_screen() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByXPath(Envscreen_title_xpath));
    }

    public WebElement production_btn() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByXPath(Production_title_xpath));
    }

    public WebElement save_btn() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByXPath(savebtn_xpath));
    }

    public WebElement Wellness_dashboard() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(Dashboard_accessbilityID));
    }

    public WebElement Signout_btn() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(signoutbtnAccessibilityID));
    }

    public WebElement getVersionCode() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(versionCodeID)));
    }

    public WebElement getVersionName() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(versionNameID)));
    }

    public WebElement getButton(int num) {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id("com.meritnation.store.testingapp:id/btn" + num)));
    }

    public WebElement getImmediateButton() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(immediateButtonID)));
    }

    public WebElement getFlexibleButton() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(flexibleButtonID)));
    }

    public WebElement getResult() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.id(resultText)));
    }

    public void backButton() {
        AndroidDriverSetup.getAndroidDriver().navigate().back();
    }

    public WebElement getTitleDemoApp() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(getTitle)));
    }

    public WebElement getTabNameDemoApp(String name) {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(name));
    }

    public WebElement getTextFieldDemoApp() {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(TextFieldDemoApp));
    }

    public WebElement getSaveButtonDemoApp() {
        return (AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(getSaveButton)));
    }

    public WebElement getEchoedTextDemoApp(String echo) {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(echo));
    }

    public WebElement getOptionDemoApp(String option) {
        return (AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(option));
    }

    public void scrollToElementWithAccessibilityId(String accessibilityId) {
        String uiAutomatorString = String.format("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"%s\"))", accessibilityId);
        AndroidDriverSetup.getAndroidDriver().findElement(MobileBy.AndroidUIAutomator(uiAutomatorString));
    }
}
