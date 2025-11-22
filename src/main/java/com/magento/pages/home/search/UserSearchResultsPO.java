package com.magento.pages.home.search;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.cart.UserCartPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserSearchResultsPO extends BasePage {
    private WebDriver driver;

    public UserSearchResultsPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get error message from search results")
    public String getErrorMessage() {
        waitForElementVisible(driver, UserSearchResultsPUI.RESULTS_ERROR_MESSAGE);
        sleep(1);
        return getElementText(driver, UserSearchResultsPUI.RESULTS_ERROR_MESSAGE);
    }

    @Step("Verify product '{0}' is displayed")
    public boolean isProductDisplayed(String productName) {
        waitListForElementsVisible(driver, UserSearchResultsPUI.PRODUCT_NAME, productName, productName);
        List<WebElement> elements = getElements(driver, UserSearchResultsPUI.PRODUCT_NAME, productName, productName);
        sleep(2);
        return !elements.isEmpty();
    }

    @Step("Get the product price for '{0}'")
    public String getProductPrice(String productName) {
        waitForElementVisible(driver, UserSearchResultsPUI.PRODUCT_PRICE_TEXT, productName);
        sleep(1);
        return getElementText(driver, UserSearchResultsPUI.PRODUCT_PRICE_TEXT, productName);

    }

    @Step("Click Add To Cart button")
    public UserCartPO clickAddToCartButton(String productName) {
        waitForElementClickable(driver, UserSearchResultsPUI.ADD_TO_CART_BUTTON, productName);
        sleep(1);
        clickElement(driver, UserSearchResultsPUI.ADD_TO_CART_BUTTON, productName);
        return PageGenerator.getUserCartPO(driver);
    }
}
