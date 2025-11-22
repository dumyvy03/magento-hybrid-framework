package com.magento.pages.home.category;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.cart.UserCartPO;
import com.magento.pages.home.search.UserSearchResultsPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserTVCategoryPO extends BasePage {
    private WebDriver driver;

    public UserTVCategoryPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter search: {0}")
    public void enterSearchTextbox(String productName) {
        waitForElementVisible(driver, UserTVCategoryPUI.SEARCH_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserTVCategoryPUI.SEARCH_TEXTBOX, productName);
    }

    @Step("Click Search button")
    public void clickSearchButton() {
        waitForElementClickable(driver, UserTVCategoryPUI.SEARCH_BUTTON);
        clickElement(driver, UserTVCategoryPUI.SEARCH_BUTTON);
    }

    @Step(" the Continue button on the alert")
    public UserSearchResultsPO clickAlertContinueButton() {
        waitForAlertVisible(driver);
        sleep(2);
        driver.switchTo().alert().accept();
        return PageGenerator.getUserSearchResultsPage(driver);
    }

    @Step("Get the product price for '{0}'")
    public String getProductPrice(String productName) {
        waitForElementVisible(driver, UserTVCategoryPUI.PRODUCT_SPECIAL_PRICE_TEXT, productName);
        sleep(1);
        return getElementText(driver, UserTVCategoryPUI.PRODUCT_SPECIAL_PRICE_TEXT, productName);
    }

    @Step("Click Add To Cart button")
    public UserCartPO clickAddToCartButton(String productName) {
        waitForElementClickable(driver, UserTVCategoryPUI.ADD_TO_CART_BUTTON, productName);
        sleep(1);
        clickElement(driver, UserTVCategoryPUI.ADD_TO_CART_BUTTON, productName);
        return PageGenerator.getUserCartPO(driver);
    }
}
