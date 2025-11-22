package com.magento.pages.home.category;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.cart.UserCartPO;
import com.magento.pages.home.search.UserSearchResultsPO;
import com.magento.pages.productdetail.UserProductDetailPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserMobileCategoryPO extends BasePage {
    private WebDriver driver;

    public UserMobileCategoryPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter search: {0}")
    public void enterSearchTextbox(String productName) {
        waitForElementVisible(driver, UserMobileCategoryPUI.SEARCH_TEXTBOX);
        sleep(1);
        sendKeysElement(driver, UserMobileCategoryPUI.SEARCH_TEXTBOX, productName);
    }

    @Step("Click Search button")
    public void clickSearchButton() {
        waitForElementClickable(driver, UserMobileCategoryPUI.SEARCH_BUTTON);
        clickElement(driver, UserMobileCategoryPUI.SEARCH_BUTTON);
    }

    @Step(" the Continue button on the alert")
    public UserSearchResultsPO clickAlertContinueButton() {
        waitForAlertVisible(driver);
        sleep(2);
        driver.switchTo().alert().accept();
        return PageGenerator.getUserSearchResultsPage(driver);
    }

    @Step("Click Product link")
    public UserProductDetailPO clickProductLink(String productName) {
        waitForElementClickable(driver, UserMobileCategoryPUI.PRODUCT_LINK, productName);
        sleep(1);
        clickElement(driver, UserMobileCategoryPUI.PRODUCT_LINK, productName);
        return PageGenerator.getUserProductDetailPage(driver);
    }

    @Step("Get the product price for '{0}'")
    public String getProductPrice(String productName) {
        waitForElementVisible(driver, UserMobileCategoryPUI.PRODUCT_PRICE_TEXT, productName);
        sleep(1);
        return getElementText(driver, UserMobileCategoryPUI.PRODUCT_PRICE_TEXT, productName);
    }

    @Step("Click Add To Cart button")
    public UserCartPO clickAddToCartButton(String productName) {
        waitForElementClickable(driver, UserMobileCategoryPUI.ADD_TO_CART_BUTTON, productName);
        sleep(1);
        clickElement(driver, UserMobileCategoryPUI.ADD_TO_CART_BUTTON, productName);
        return PageGenerator.getUserCartPO(driver);
    }

    @Step("Get the title text of Mobile Category page")
    public String getTitlePage() {
        waitForElementVisible(driver, UserMobileCategoryPUI.TITLE_PAGE);
        sleep(1);
        return getElementText(driver, UserMobileCategoryPUI.TITLE_PAGE);
    }
}
