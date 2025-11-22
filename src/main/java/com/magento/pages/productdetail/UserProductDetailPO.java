package com.magento.pages.productdetail;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.cart.UserCartPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserProductDetailPO extends BasePage {
    private WebDriver driver;

    public UserProductDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get the product price ")
    public String getProductPrice() {
        waitForElementVisible(driver, UserProductDetailPUI.PRODUCT_PRICE_TEXT);
        return getElementText(driver, UserProductDetailPUI.PRODUCT_PRICE_TEXT);
    }

    @Step("Enter Quantity: {0}")
    public void enterQuantityTextbox(String quantity) {
        waitForElementVisible(driver, UserProductDetailPUI.QUANTITY_TEXTBOX);
        sleep(1);
        clearTextbox(driver, UserProductDetailPUI.QUANTITY_TEXTBOX);
        sendKeysElement(driver, UserProductDetailPUI.QUANTITY_TEXTBOX, quantity);
    }

    @Step("Click Add To Cart button")
    public void clickAddToCartButton() {
        waitForElementClickable(driver, UserProductDetailPUI.ADD_TO_CART_BUTTON);
        clickElement(driver, UserProductDetailPUI.ADD_TO_CART_BUTTON);
    }

    @Step("Click the Continue button on the alert")
    public UserCartPO clickAlertContinueButton() {
        waitForAlertVisible(driver);
        sleep(2);
        driver.switchTo().alert().accept();
        return PageGenerator.getUserCartPO(driver);
    }
}
