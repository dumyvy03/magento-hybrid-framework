package com.magento.pages.cart;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.home.category.UserMobileCategoryPO;
import com.magento.pages.home.category.UserTVCategoryPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserCartPO extends BasePage {
    private WebDriver driver;

    public UserCartPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify success message is displayed")
    public boolean isSuccessMessageDisplayed() {
        waitForElementVisible(driver, UserCartPUI.SUCCESS_MESSAGE);
        sleep(1);
        return isElementDisplayed(driver, UserCartPUI.SUCCESS_MESSAGE);
    }

    @Step("Verify product '{0}' is displayed")
    public boolean isProductDisplayed(String productName) {
        waitForElementVisible(driver, UserCartPUI.PRODUCT_TEXT, productName);
        sleep(1);
        return isElementDisplayed(driver, UserCartPUI.PRODUCT_TEXT, productName);
    }

    @Step("Get product price for '{0}'")
    public String getProductPrice(String productName) {
        waitForElementVisible(driver, UserCartPUI.PRODUCT_PRICE_TEXT, productName);
        sleep(1);
        return getElementText(driver, UserCartPUI.PRODUCT_PRICE_TEXT, productName);
    }

    @Step("Get quantity of product '{0}'")
    public String getQuantity(String productName) {
        waitForElementVisible(driver, UserCartPUI.QUANTITY, productName);
        sleep(1);
        return getAttributeValue(driver, UserCartPUI.QUANTITY, "value", productName);
    }

    @Step("Get subtotal of product '{0}'")
    public String getSubtotal(String productName) {
        waitForElementVisible(driver, UserCartPUI.SUBTOTAL_TEXT, productName);
        sleep(1);
        return getElementText(driver, UserCartPUI.SUBTOTAL_TEXT, productName);
    }

    @Step("click Mobile link")
    public UserMobileCategoryPO clickMobileLink() {
        waitForElementClickable(driver, UserCartPUI.MOBILE_LINK);
        sleep(1);
        clickElement(driver, UserCartPUI.MOBILE_LINK);
        return PageGenerator.getUserMobileCategoryPage(driver);
    }

    @Step("Click TV link")
    public UserTVCategoryPO clickTVLink() {
        waitForElementClickable(driver, UserCartPUI.TV_LINK);
        sleep(1);
        clickElement(driver, UserCartPUI.TV_LINK);
        return PageGenerator.getUserTVCategoryPage(driver);
    }

    @Step("Click Quantity ")
    public void clickQuantityTextbox(String productName) {
        waitForElementClickable(driver, UserCartPUI.QUANTITY, productName);
        sleep(1);
        clickElement(driver, UserCartPUI.QUANTITY, productName);
    }

    @Step("Enter quantity {0} for product {1}")
    public void enterQuantityTextbox(String quantity, String productName) {
        waitForElementVisible(driver, UserCartPUI.QUANTITY, productName);
        sleep(1);
        clearTextbox(driver, UserCartPUI.QUANTITY, productName);
        sendKeysElement(driver, UserCartPUI.QUANTITY, quantity, productName);
    }

    @Step("Click Update button")
    public void clickUpdateButton(String productName) {
        waitForElementClickable(driver, UserCartPUI.UPDATE_BUTTON, productName);
        sleep(1);
        clickElement(driver, UserCartPUI.UPDATE_BUTTON, productName);
    }

    @Step("Click the Continue button on the alert")
    public void clickAlertContinueButton() {
        waitForAlertVisible(driver);
        sleep(2);
        driver.switchTo().alert().accept();
    }

    @Step("Get empty cart message")
    public String getEmptyCartMessage() {
        waitForElementVisible(driver, UserCartPUI.EMPTY_MESSAGE);
        sleep(2);
        return getElementText(driver, UserCartPUI.EMPTY_MESSAGE);
    }

    @Step("Get validation message for quantity of product '{0}'")
    public String getQuantityValidationMessage(String productName) {
        waitForElementVisible(driver, UserCartPUI.QUANTITY, productName);
        sleep(1);
        return getElementValidationMessage(driver, UserCartPUI.QUANTITY, productName);
    }

    @Step("Click Continue Shopping button")
    public UserMobileCategoryPO clickContinueShoppingButton() {
        waitForElementClickable(driver, UserCartPUI.CONTINUE_SHOPPING_BUTTON);
        sleep(1);
        clickElement(driver, UserCartPUI.CONTINUE_SHOPPING_BUTTON);
        return PageGenerator.getUserMobileCategoryPage(driver);
    }

    @Step("Click Mini Cart")
    public void clickMiniCart() {
        waitForElementClickable(driver, UserCartPUI.MINI_CART_LINK);
        sleep(1);
        clickElement(driver, UserCartPUI.MINI_CART_LINK);
    }
}
