package pages.android;

import pages.Page;

public class UpdatePage {

    private String LOGIN_WITH_EMAIL_XPATH = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView";
    private String LOGIN_WITH_SSO_XPATH = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView";
    private String EMAIL_FIELD_XPATH = "//android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText";
    private String PASSWORD_FIELD_XPATH = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText";
    private String LOGIN_BUTTON_XPATH = "//android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView";
    private String RESET_PASSWORD_BUTTON_XPATH = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup";

    public UpdatePage(Page page) {
    }

//    public WebElement getLoginWithEmail() { return waitForElement(AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(LOGIN_WITH_EMAIL_XPATH)));}
//    public WebElement getLoginWithSSO() {return waitForElement(AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(LOGIN_WITH_SSO_XPATH)));}
//    public WebElement getEmailField() { return waitForElement(AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(EMAIL_FIELD_XPATH)));}
//    public WebElement getPasswordField() { return waitForElement(AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(PASSWORD_FIELD_XPATH)));}
//    public WebElement getLoginButton() { return waitForElement(AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(LOGIN_BUTTON_XPATH)));}
//    public WebElement getResetPasswordButton() { return waitForElement(AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(RESET_PASSWORD_BUTTON_XPATH)));}
}