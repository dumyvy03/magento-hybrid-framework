package com.magento.pages.home.category;

public class UserMobileCategoryPUI {
    public static final String SEARCH_TEXTBOX = "Css=input#search";

    public static final String SEARCH_BUTTON = "Css=button.search-button";

    public static final String PRODUCT_LINK = "Xpath=//a[@class='product-image']/following-sibling::div//a[text()='%s']";

    public static final String PRODUCT_PRICE_TEXT = "Xpath=//a[text()='%s']/parent::h2/" +
            "following-sibling::div[@class='price-box']//span[@class='price']";

    public static final String ADD_TO_CART_BUTTON = "Xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']/button";

    public static final String TITLE_PAGE = "Css=div.page-title>h1";
}
