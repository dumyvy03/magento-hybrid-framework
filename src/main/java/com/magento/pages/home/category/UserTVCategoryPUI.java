package com.magento.pages.home.category;

public class UserTVCategoryPUI {
    public static final String SEARCH_TEXTBOX = "Css=input#search";

    public static final String SEARCH_BUTTON = "Css=button.search-button";

    public static final String PRODUCT_SPECIAL_PRICE_TEXT = "Xpath=//a[text()='%s']/parent::h2/" +
            "following-sibling::div[@class='price-box']//p[@class='special-price']//span[@class='price']";

    public static final String ADD_TO_CART_BUTTON = "Xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button";
}
