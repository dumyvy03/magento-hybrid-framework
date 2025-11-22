package com.magento.pages.login;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.account.dashboard.UserAccountDashboardPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Email Address: {0}")
    public void enterEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPUI.EMAIL_ADDRESS_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserLoginPUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    @Step("Enter Password: {0}")
    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPUI.PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserLoginPUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click the Login button")
    public void clickLoginButton() {
        waitForElementClickable(driver, UserLoginPUI.LOGIN_BUTTON);
        clickElement(driver, UserLoginPUI.LOGIN_BUTTON);
    }

    @Step("Click Continue button on alert to go to Dashboard")
    public UserAccountDashboardPO clickAlertContinueButtonToDashboard() {
        clickAlertContinueButton();
        return PageGenerator.getUserAccountDashboardPage(driver);
    }

    @Step("Click the Continue button on the alert")
    public void clickAlertContinueButton() {
        waitForAlertVisible(driver);
        driver.switchTo().alert().accept();
    }

    @Step("Get the tooltip validation message for email")
    public String getEmailValidationMessage() {
        waitForElementVisible(driver, UserLoginPUI.EMAIL_ADDRESS_TEXTBOX);
        sleep(2);
        return getElementValidationMessage(driver, UserLoginPUI.EMAIL_ADDRESS_TEXTBOX);
    }

    @Step("Get error message for Email")
    public String getEmailAddressErrorMessage() {
        waitForElementVisible(driver, UserLoginPUI.EMAIL_ADDRESS_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserLoginPUI.EMAIL_ADDRESS_ERROR_MESSAGE);
    }

    @Step("Get error message for Password")
    public String getPasswordErrorMessage() {
        waitForElementVisible(driver, UserLoginPUI.PASSWORD_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserLoginPUI.PASSWORD_ERROR_MESSAGE);
    }

    @Step("Get invalid login error message")
    public String getInvalidLoginMessage() {
        waitForElementVisible(driver, UserLoginPUI.INVALID_LOGIN_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserLoginPUI.INVALID_LOGIN_ERROR_MESSAGE);
    }


}
