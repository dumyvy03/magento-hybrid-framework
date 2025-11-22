package com.magento.pages.account.information;

import com.magento.commons.PageGenerator;
import com.magento.pages.account.dashboard.UserAccountDashboardPO;
import com.magento.pages.account.sidebar.UserAccountSidebarPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserAccountInformationPO extends UserAccountSidebarPO {
    private WebDriver driver;

    public UserAccountInformationPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter First Name: {0}")
    public void enterFirstNameTextbox(String newFirstName) {
        waitForElementVisible(driver, UserAccountInformationPUI.FIRSTNAME_TEXTBOX);
        clearTextbox(driver, UserAccountInformationPUI.FIRSTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserAccountInformationPUI.FIRSTNAME_TEXTBOX, newFirstName);
    }

    @Step("Get Last Name value")
    public String getLastName() {
        waitForElementVisible(driver, UserAccountInformationPUI.LASTNAME_TEXTBOX);
        return getAttributeValue(driver, UserAccountInformationPUI.LASTNAME_TEXTBOX, "value");
    }


    @Step("Enter current password: {0}")
    public void enterCurrentPasswordTextbox(String password) {
        waitForElementVisible(driver, UserAccountInformationPUI.CURRENT_PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserAccountInformationPUI.CURRENT_PASSWORD_TEXTBOX, password);
    }

    @Step("Click Save button")
    public void clickSaveButton() {
        waitForElementVisible(driver, UserAccountInformationPUI.SAVE_BUTTON);
        sleep(1);
        clickElement(driver, UserAccountInformationPUI.SAVE_BUTTON);
    }

    @Step("Click the Continue button on the alert")
    public UserAccountDashboardPO clickAlertContinueButtonToDashboard() {
        clickAlertContinueButton();
        return PageGenerator.getUserAccountDashboardPage(driver);
    }

    @Step("Enter Last Name: {0}")
    public void enterLastNameTextbox(String newLastName) {
        waitForElementVisible(driver, UserAccountInformationPUI.LASTNAME_TEXTBOX);
        clearTextbox(driver, UserAccountInformationPUI.LASTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserAccountInformationPUI.LASTNAME_TEXTBOX, newLastName);
    }

    @Step("Get First Name value")
    public String getFirstName() {
        waitForElementVisible(driver, UserAccountInformationPUI.FIRSTNAME_TEXTBOX);
        return getAttributeValue(driver, UserAccountInformationPUI.FIRSTNAME_TEXTBOX, "value");
    }

    @Step("Enter Email Address: {0}")
    public void enterEmailAddressTextbox(String newEmailAddress) {
        waitForElementVisible(driver, UserAccountInformationPUI.EMAIL_ADDRESS_TEXTBOX);
        clearTextbox(driver, UserAccountInformationPUI.EMAIL_ADDRESS_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserAccountInformationPUI.EMAIL_ADDRESS_TEXTBOX, newEmailAddress);
    }

    @Step("Click Change Password checkbox")
    public void clickChangePasswordCheckbox() {
        waitForElementClickable(driver, UserAccountInformationPUI.CHANGE_PASSWORD_CHECKBOX);
        sleep(1);
        checkElement(driver, UserAccountInformationPUI.CHANGE_PASSWORD_CHECKBOX);
    }

    @Step("Enter New Password: {0}")
    public void enterNewPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, UserAccountInformationPUI.NEW_PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserAccountInformationPUI.NEW_PASSWORD_TEXTBOX, newPassword);
    }

    @Step("Enter Confirm New Password: {0}")
    public void enterConfirmNewPasswordTextbox(String confirmNewPassword) {
        waitForElementVisible(driver, UserAccountInformationPUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserAccountInformationPUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmNewPassword);
    }

    @Step("Get First Name required error message")
    public String getFirstNameRequiredErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.FIRSTNAME_REQUIRED_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.FIRSTNAME_REQUIRED_ERROR_MESSAGE);
    }

    @Step("Get Last Name required error message")
    public String getRequiredLastNameRequiredErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.LASTNAME_REQUIRED_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.LASTNAME_REQUIRED_ERROR_MESSAGE);
    }


    @Step("Get invalid email address error message")
    public String getInvalidEmailAddressErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.EMAIL_ADDRESS_VALIDATION_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.EMAIL_ADDRESS_VALIDATION_ERROR_MESSAGE);
    }

    @Step("Get current password required error message")
    public String getCurrentPasswordRequiredErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.CURRENT_REQUIRED_PASSWORD_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.CURRENT_REQUIRED_PASSWORD_ERROR_MESSAGE);
    }

    @Step("Click the Continue button on the alert")
    public void clickAlertContinueButton() {
        waitForAlertVisible(driver);
        sleep(2);
        driver.switchTo().alert().accept();
    }

    @Step("Get invalid current password error message")
    public String getInvalidCurrentPasswordErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.INVALID_CURRENT_PASSWORD_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.INVALID_CURRENT_PASSWORD_ERROR_MESSAGE);
    }

    @Step("Get confirm new password mismatch error message")
    public String getConfirmNewPasswordMismatchErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.CONFIRM_NEW_PASSWORD_MISMATCH_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.CONFIRM_NEW_PASSWORD_MISMATCH_ERROR_MESSAGE);
    }

    @Step("Get required new password error message")
    public String getPasswordRequiredErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.NEW_PASSWORD_REQUIRED_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.NEW_PASSWORD_REQUIRED_ERROR_MESSAGE);
    }

    @Step("Get confirm new password required error message")
    public String getConfirmNewPasswordRequiredErrorMessage() {
        waitForElementVisible(driver, UserAccountInformationPUI.CONFIRM_NEW_PASSWORD_REQUIRED_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountInformationPUI.CONFIRM_NEW_PASSWORD_REQUIRED_ERROR_MESSAGE);
    }

    @Step("Clear First Name")
    public void clearFistNameTextbox() {
        waitForElementVisible(driver, UserAccountInformationPUI.FIRSTNAME_TEXTBOX);
        sleep(1);
        clearTextbox(driver, UserAccountInformationPUI.FIRSTNAME_TEXTBOX);
    }

    @Step("Clear Last Name")
    public void clearLastNameTextbox() {
        waitForElementVisible(driver, UserAccountInformationPUI.LASTNAME_TEXTBOX);
        sleep(1);
        clearTextbox(driver, UserAccountInformationPUI.LASTNAME_TEXTBOX);
    }
}
