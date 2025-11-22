package com.magento.pages.home;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.home.category.UserMobileCategoryPO;
import com.magento.pages.home.category.UserTVCategoryPO;
import com.magento.pages.home.search.UserSearchResultsPO;
import com.magento.pages.login.UserLoginPO;
import com.magento.pages.register.UserCreateAccountPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("clicks the My Account link")
    public void clickMyAccountLink() {
        waitForElementClickable(driver, UserHomePUI.ACCOUNT_LINK);
        sleep(1);
        clickElement(driver, UserHomePUI.ACCOUNT_LINK);
    }

    @Step("clicks the Register link")
    public UserCreateAccountPO clickRegisterLink() {
        waitForElementClickable(driver, UserHomePUI.REGISTER_LINK);
        clickElement(driver, UserHomePUI.REGISTER_LINK);
        return PageGenerator.getUserCreateAccountPage(driver);
    }

    @Step("Click Login link")
    public UserLoginPO clickLoginLink() {
        waitForElementClickable(driver, UserHomePUI.LOGIN_LINK);
        clickElement(driver, UserHomePUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    @Step("Enter Search: {0}")
    public void enterSearchTextbox(String productName) {
        waitForElementVisible(driver, UserHomePUI.SEARCH_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserHomePUI.SEARCH_TEXTBOX, productName);
    }

    @Step("Click Search button")
    public void clickSearchButton() {
        waitForElementClickable(driver, UserHomePUI.SEARCH_BUTTON);
        clickElement(driver, UserHomePUI.SEARCH_BUTTON);
    }

    @Step("Click the Continue button on the alert")
    public UserSearchResultsPO clickAlertContinueButton() {
        waitForAlertVisible(driver);
        sleep(2);
        driver.switchTo().alert().accept();
        return PageGenerator.getUserSearchResultsPage(driver);
    }

    @Step("Click Mobile link")
    public UserMobileCategoryPO clickMobileLink() {
        waitForElementClickable(driver, UserHomePUI.MOBILE_LINK);
        clickElement(driver, UserHomePUI.MOBILE_LINK);
        return PageGenerator.getUserMobileCategoryPage(driver);
    }

    @Step("Click TV link")
    public UserTVCategoryPO clickTVLink() {
        waitForElementClickable(driver, UserHomePUI.TV_LINK);
        clickElement(driver, UserHomePUI.TV_LINK);
        return PageGenerator.getUserTVCategoryPage(driver);
    }
}
