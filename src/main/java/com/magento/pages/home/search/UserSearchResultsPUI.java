package com.magento.pages.home.search;

public class UserSearchResultsPUI {
    public static final String PRODUCT_NAME = "Xpath=//a[@class='product-image']/following-sibling::div//a[text()='%s' or contains(text(),'%s')]";

    public static final String PRODUCT_PRICE_TEXT = "Xpath=//a[text()='%s']/parent::h2/following-sibling::div//span[@class='price']";

    public static final String RESULTS_ERROR_MESSAGE = "Css=div.page-title~p";

    public static final String ADD_TO_CART_BUTTON = "Xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button//span[text()='Add to Cart']";
}
