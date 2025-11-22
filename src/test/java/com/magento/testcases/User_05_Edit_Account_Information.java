package com.magento.testcases;

import com.magento.commons.BaseTest;
import com.magento.commons.PageGenerator;
import com.magento.dataprovider.UserEditAccountDataProvider;
import com.magento.pages.account.dashboard.UserAccountDashboardPO;
import com.magento.pages.account.information.UserAccountInformationPO;
import com.magento.pages.home.UserHomePO;
import com.magento.pages.login.UserLoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_05_Edit_Account_Information extends BaseTest {
    private UserHomePO userHomePage;
    private UserAccountDashboardPO userAccountDashboardPage;
    private UserAccountInformationPO userAccountInformationPage;
    private UserLoginPO userLoginPage;

    @Parameters({"browsers", "userUrl"})
    @BeforeMethod
    public void beforeMethod(String browser, String userUrl) {
        WebDriver driver = getDriver(browser, userUrl);
        userHomePage = PageGenerator.getUserHomePO(driver);
    }

    @Test(dataProvider = "validFirstName", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_01_Edit_Account_With_Valid_First_Name(String emailAddress, String password, String newFirstName) {
        userHomePage.clickMyAccountLink();

        userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterFirstNameTextbox(newFirstName);

        String lastName = userAccountInformationPage.getLastName();

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickSaveButton();

        userAccountDashboardPage = userAccountInformationPage.clickAlertContinueButtonToDashboard();

        Assert.assertEquals(userAccountDashboardPage.getSuccessMessage(), "The account information has been saved.");

        Assert.assertEquals(userAccountDashboardPage.getAccountFullName(), newFirstName + " " + lastName);
    }

    @Test(dataProvider = "validLastName", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_02_Edit_Account_With_Valid_Last_Name(String emailAddress, String password, String newLastName) {
        userHomePage.clickMyAccountLink();

        userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterLastNameTextbox(newLastName);

        String firstName = userAccountInformationPage.getFirstName();

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickSaveButton();

        userAccountDashboardPage = userAccountInformationPage.clickAlertContinueButtonToDashboard();

        Assert.assertEquals(userAccountDashboardPage.getSuccessMessage(), "The account information has been saved.");

        Assert.assertEquals(userAccountDashboardPage.getAccountFullName(), firstName + " " + newLastName);
    }

    @Test(dataProvider = "validEmail", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_03_Edit_Account_With_Valid_Email(String emailAddress, String password, String newEmailAddress) {
        userHomePage.clickMyAccountLink();

        userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterEmailAddressTextbox(newEmailAddress);

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickSaveButton();

        userAccountDashboardPage = userAccountInformationPage.clickAlertContinueButtonToDashboard();

        Assert.assertEquals(userAccountDashboardPage.getSuccessMessage(), "The account information has been saved.");

        Assert.assertEquals(userAccountDashboardPage.getAccountEmail(), newEmailAddress);
    }

    @Test(dataProvider = "changePassword", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_04_Edit_Account_With_Change_Password(String emailAddress, String password, String newPassword) {
        userHomePage.clickMyAccountLink();

        UserLoginPO userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickChangePasswordCheckbox();

        userAccountInformationPage.enterNewPasswordTextbox(newPassword);

        userAccountInformationPage.enterConfirmNewPasswordTextbox(newPassword);

        userAccountInformationPage.clickSaveButton();

        userAccountDashboardPage = userAccountInformationPage.clickAlertContinueButtonToDashboard();

        Assert.assertEquals(userAccountDashboardPage.getSuccessMessage(), "The account information has been saved.");
    }

    @Test(dataProvider = "emptyRequiredFields", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_05_Edit_Account_With_Empty_Required_Fields(String emailAddress, String password) {
        userHomePage.clickMyAccountLink();

        UserLoginPO userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.clearFistNameTextbox();

        userAccountInformationPage.clearLastNameTextbox();

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickSaveButton();

        Assert.assertEquals(userAccountInformationPage.getFirstNameRequiredErrorMessage(), "This is a required field.");
        Assert.assertEquals(userAccountInformationPage.getRequiredLastNameRequiredErrorMessage(), "This is a required field.");
    }

    @Test(dataProvider = "invalidEmailFormat", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_06_Edit_Account_With_Invalid_Email_Format(String emailAddress, String password, String newEmailAddress) {
        userHomePage.clickMyAccountLink();

        userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterEmailAddressTextbox(newEmailAddress);

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickSaveButton();

        Assert.assertEquals(userAccountInformationPage.getInvalidEmailAddressErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(dataProvider = "emptyRequiredFields", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_07_Edit_Account_Without_Current_Password(String emailAddress, String password) {
        userHomePage.clickMyAccountLink();

        userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.clickSaveButton();

        Assert.assertEquals(userAccountInformationPage.getCurrentPasswordRequiredErrorMessage(), "This is a required field.");
    }

    @Test(dataProvider = "wrongCurrentPassword", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_08_Edit_Account_With_Wrong_Current_Password(String emailAddress, String password, String currentPassword) {
        userHomePage.clickMyAccountLink();

        userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterCurrentPasswordTextbox(currentPassword);

        userAccountInformationPage.clickSaveButton();

        userAccountInformationPage.clickAlertContinueButton();

        Assert.assertEquals(userAccountInformationPage.getInvalidCurrentPasswordErrorMessage(), "Invalid current password");
    }

    @Test(dataProvider = "mismatchNewPassword", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_09_Edit_Account_Change_Password_With_Mismatch_Confirmation(String emailAddress, String password, String newPassword, String confirmNewPassword) {
        userHomePage.clickMyAccountLink();

        UserLoginPO userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickChangePasswordCheckbox();

        userAccountInformationPage.enterNewPasswordTextbox(newPassword);

        userAccountInformationPage.enterConfirmNewPasswordTextbox(confirmNewPassword);

        userAccountInformationPage.clickSaveButton();

        Assert.assertEquals(userAccountInformationPage.getConfirmNewPasswordMismatchErrorMessage(), "Please make sure your passwords match.");
    }

    @Test(dataProvider = "emptyRequiredFields", dataProviderClass = UserEditAccountDataProvider.class)
    public void TC_10_Edit_Account_With_Empty_New_Password(String emailAddress, String password) {
        userHomePage.clickMyAccountLink();

        UserLoginPO userLoginPage = userHomePage.clickLoginLink();

        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        userAccountInformationPage = userAccountDashboardPage.openAccountInformationLink();

        userAccountInformationPage.enterCurrentPasswordTextbox(password);

        userAccountInformationPage.clickChangePasswordCheckbox();

        userAccountInformationPage.clickSaveButton();

        Assert.assertEquals(userAccountInformationPage.getPasswordRequiredErrorMessage(), "This is a required field.");
        Assert.assertEquals(userAccountInformationPage.getConfirmNewPasswordRequiredErrorMessage(), "This is a required field.");
    }

    @AfterMethod
    public void afterMethod() {
        quitDriver();
    }
}
