package com.magento.testcases;

import com.magento.commons.BaseTest;
import com.magento.commons.PageGenerator;
import com.magento.dataprovider.UserLoginDataProvider;
import com.magento.pages.account.dashboard.UserAccountDashboardPO;
import com.magento.pages.home.UserHomePO;
import com.magento.pages.login.UserLoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_02_Login extends BaseTest {
    private UserLoginPO userLoginPage;

    @Parameters({"browsers", "userUrl"})
    @BeforeMethod
    public void beforeMethod(String browser, String userUrl) {
        WebDriver driver = getDriver(browser, userUrl);
        UserHomePO userHomePage = PageGenerator.getUserHomePO(driver);
        userHomePage.clickMyAccountLink();
        userLoginPage = userHomePage.clickLoginLink();
    }

    @Test(dataProvider = "validLogin", dataProviderClass = UserLoginDataProvider.class)
    public void TC_01_Login_With_Valid_Info(String emailAddress, String password) {
        userLoginPage.enterEmailAddressTextbox(emailAddress);
        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        UserAccountDashboardPO userAccountDashboardPage = userLoginPage.clickAlertContinueButtonToDashboard();

        Assert.assertEquals(userAccountDashboardPage.getAccountEmail(), emailAddress);
    }

    @Test
    public void TC_02_Login_With_Empty_Email_And_Password() {
        userLoginPage.clickLoginButton();

        Assert.assertEquals(userLoginPage.getEmailAddressErrorMessage(), "This is a required field.");
        Assert.assertEquals(userLoginPage.getPasswordErrorMessage(), "This is a required field.");
    }

    @Test(dataProvider = "invalidEmailTooltip", dataProviderClass = UserLoginDataProvider.class)
    public void TC_03_Login_With_Invalid_Email_Tooltip(String emailAddress) {
        userLoginPage.enterEmailAddressTextbox(emailAddress);

        userLoginPage.clickLoginButton();

        Assert.assertEquals(userLoginPage.getEmailValidationMessage(), "Please enter an email address.");
    }

    @Test(dataProvider = "invalidEmail", dataProviderClass = UserLoginDataProvider.class)
    public void TC_04_Login_With_Invalid_Email(String emailAddress, String password) {
        userLoginPage.enterEmailAddressTextbox(emailAddress);
        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        Assert.assertEquals(userLoginPage.getEmailAddressErrorMessage(),
                "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(dataProvider = "wrongPassword", dataProviderClass = UserLoginDataProvider.class)
    public void TC_05_Login_With_Wrong_Password(String emailAddress, String password) {
        userLoginPage.enterEmailAddressTextbox(emailAddress);
        userLoginPage.enterPasswordTextbox(password);

        userLoginPage.clickLoginButton();

        userLoginPage.clickAlertContinueButton();

        Assert.assertEquals(userLoginPage.getInvalidLoginMessage(), "Invalid login or password.");
    }

    @AfterMethod
    public void afterMethod() {
        quitDriver();
    }
}
