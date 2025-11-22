package com.magento.pages.register;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.account.dashboard.UserAccountDashboardPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserCreateAccountPO extends BasePage {
    private WebDriver driver;

    public UserCreateAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter First Name: {0}")
    public void enterFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserCreateAccountPUI.FIRSTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserCreateAccountPUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter Last Name: {0}")
    public void enterLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserCreateAccountPUI.LASTNAME_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserCreateAccountPUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter Email Address: {0}")
    public void enterEmailAddressTextbox(String emailAddress) {
        waitForElementVisible(driver, UserCreateAccountPUI.EMAIL_ADDRESS_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserCreateAccountPUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    @Step("Enter Password: {0}")
    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, UserCreateAccountPUI.PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserCreateAccountPUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter Confirm Password: {0}")
    public void enterConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, UserCreateAccountPUI.CONFIRM_PASSWORD_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserCreateAccountPUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    @Step("Click the Register button")
    public void clickRegisterButton() {
        waitForElementClickable(driver, UserCreateAccountPUI.REGISTER_BUTTON);
        clickElement(driver, UserCreateAccountPUI.REGISTER_BUTTON);
    }

    @Step("Get error message for First Name")
    public String getFirstNameErrorMessage() {
        waitForElementVisible(driver, UserCreateAccountPUI.FIRSTNAME_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserCreateAccountPUI.FIRSTNAME_ERROR_MESSAGE);
    }

    @Step("Get error message for Last Name")
    public String getLastNameErrorMessage() {
        waitForElementVisible(driver, UserCreateAccountPUI.LASTNAME_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserCreateAccountPUI.LASTNAME_ERROR_MESSAGE);
    }

    @Step("Get error message for Email")
    public String getEmailAddressErrorMessage() {
        waitForElementVisible(driver, UserCreateAccountPUI.EMAIL_ADDRESS_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserCreateAccountPUI.EMAIL_ADDRESS_ERROR_MESSAGE);
    }

    @Step("Get error message for Password")
    public String getPasswordErrorMessage() {
        waitForElementVisible(driver, UserCreateAccountPUI.PASSWORD_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserCreateAccountPUI.PASSWORD_ERROR_MESSAGE);
    }

    @Step("Get error message for Confirm Password")
    public String getConfirmPasswordErrorMessage() {
        waitForElementVisible(driver, UserCreateAccountPUI.CONFIRMATION_PASSWORD_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserCreateAccountPUI.CONFIRMATION_PASSWORD_ERROR_MESSAGE);
    }

    @Step("Get the tooltip validation message for email")
    public String getEmailValidationMessage() {
        waitForElementVisible(driver, UserCreateAccountPUI.EMAIL_ADDRESS_TEXTBOX);
        sleep(2);
        return getElementValidationMessage(driver, UserCreateAccountPUI.EMAIL_ADDRESS_TEXTBOX);
    }

    @Step("Click the Continue button on the alert")
    public UserAccountDashboardPO clickAlertContinueButton() {
        waitForAlertVisible(driver);
        driver.switchTo().alert().accept();
        return PageGenerator.getUserAccountDashboardPage(driver);
    }
}
