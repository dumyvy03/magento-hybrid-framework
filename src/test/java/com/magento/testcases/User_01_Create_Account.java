package com.magento.testcases;

import com.magento.commons.BaseTest;
import com.magento.commons.PageGenerator;
import com.magento.dataprovider.UserRegisterDataProvider;
import com.magento.pages.account.dashboard.UserAccountDashboardPO;
import com.magento.pages.home.UserHomePO;
import com.magento.pages.register.UserCreateAccountPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_01_Create_Account extends BaseTest {
    private UserCreateAccountPO userCreateAccountPage;

    @Parameters({"browsers", "userUrl"})
    @BeforeMethod
    public void beforeMethod(String browser, String userUrl) {
        WebDriver driver = getDriver(browser, userUrl);
        UserHomePO userHomePage = PageGenerator.getUserHomePO(driver);
        userHomePage.clickMyAccountLink();
        userCreateAccountPage = userHomePage.clickRegisterLink();
    }

    @Test(dataProvider = "validAccount", dataProviderClass = UserRegisterDataProvider.class)
    public void TC_01_Create_Account_With_Valid_Info(String firstName, String lastName, String emailAddress, String password) {
        userCreateAccountPage.enterFirstNameTextbox(firstName);
        userCreateAccountPage.enterLastNameTextbox(lastName);
        userCreateAccountPage.enterEmailAddressTextbox(emailAddress);
        userCreateAccountPage.enterPasswordTextbox(password);
        userCreateAccountPage.enterConfirmPasswordTextbox(password);

        userCreateAccountPage.clickRegisterButton();

        UserAccountDashboardPO userAccountDashboardPage = userCreateAccountPage.clickAlertContinueButton();

        Assert.assertEquals(userAccountDashboardPage.getSuccessMessage(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(userAccountDashboardPage.getAccountFullName(), firstName + " " + lastName);
        Assert.assertEquals(userAccountDashboardPage.getAccountEmail(), emailAddress);
    }

    @Test
    public void TC_02_Create_Account_With_Empty_Required_Fields() {
        userCreateAccountPage.clickRegisterButton();

        Assert.assertEquals(userCreateAccountPage.getFirstNameErrorMessage(), "This is a required field.");
        Assert.assertEquals(userCreateAccountPage.getLastNameErrorMessage(), "This is a required field.");
        Assert.assertEquals(userCreateAccountPage.getEmailAddressErrorMessage(), "This is a required field.");
        Assert.assertEquals(userCreateAccountPage.getPasswordErrorMessage(), "This is a required field.");
        Assert.assertEquals(userCreateAccountPage.getConfirmPasswordErrorMessage(), "This is a required field.");
    }

    @Test(dataProvider = "invalidEmailTooltip", dataProviderClass = UserRegisterDataProvider.class)
    public void TC_03_Create_Account_With_Invalid_Email_Tooltip(String emailAddress) {
        userCreateAccountPage.enterEmailAddressTextbox(emailAddress);

        userCreateAccountPage.clickRegisterButton();

        Assert.assertEquals(userCreateAccountPage.getEmailValidationMessage(), "Please enter an email address.");
    }

    @Test(dataProvider = "invalidEmail", dataProviderClass = UserRegisterDataProvider.class)
    public void TC_04_Create_Account_With_Invalid_Email(String firstName, String lastName, String emailAddress, String password) {
        userCreateAccountPage.enterFirstNameTextbox(firstName);
        userCreateAccountPage.enterLastNameTextbox(lastName);
        userCreateAccountPage.enterEmailAddressTextbox(emailAddress);
        userCreateAccountPage.enterPasswordTextbox(password);
        userCreateAccountPage.enterConfirmPasswordTextbox(password);

        userCreateAccountPage.clickRegisterButton();

        Assert.assertEquals(userCreateAccountPage.getEmailAddressErrorMessage(),
                "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(dataProvider = "mismatchPassword", dataProviderClass = UserRegisterDataProvider.class)
    public void TC_05_Create_Account_With_Mismatch_Password(String firstName, String lastName, String emailAddress,
                                                            String password, String confirmPassword) {
        userCreateAccountPage.enterFirstNameTextbox(firstName);
        userCreateAccountPage.enterLastNameTextbox(lastName);
        userCreateAccountPage.enterEmailAddressTextbox(emailAddress);
        userCreateAccountPage.enterPasswordTextbox(password);
        userCreateAccountPage.enterConfirmPasswordTextbox(confirmPassword);

        userCreateAccountPage.clickRegisterButton();

        Assert.assertEquals(userCreateAccountPage.getConfirmPasswordErrorMessage(), "Please make sure your passwords match.");
    }

    @Test(dataProvider = "shortPassword", dataProviderClass = UserRegisterDataProvider.class)
    public void TC_06_Create_Account_With_Short_Password(String firstName, String lastName, String emailAddress, String password) {
        userCreateAccountPage.enterFirstNameTextbox(firstName);
        userCreateAccountPage.enterLastNameTextbox(lastName);
        userCreateAccountPage.enterEmailAddressTextbox(emailAddress);
        userCreateAccountPage.enterPasswordTextbox(password);
        userCreateAccountPage.enterConfirmPasswordTextbox(password);

        userCreateAccountPage.clickRegisterButton();

        Assert.assertEquals(userCreateAccountPage.getPasswordErrorMessage(),
                "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @AfterMethod
    public void afterMethod() {
        quitDriver();
    }
}
