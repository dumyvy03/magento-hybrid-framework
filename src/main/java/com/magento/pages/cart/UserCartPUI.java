package com.magento.pages.cart;

public class UserCartPUI {
    public static final String SUCCESS_MESSAGE = "Xpath=//li[@class='success-msg']//span";

    public static final String PRODUCT_TEXT = "Xpath=//h2[@class='product-name']/a[text()='%s']";

    public static final String PRODUCT_PRICE_TEXT = "Xpath=//a[text()='%s']/ancestor::td[@class='product-cart-info']" +
            "/following-sibling::td[@class='product-cart-price']//span[@class='price']";

    public static final String QUANTITY = "Xpath=//a[text()='%s']/ancestor::td[@class='product-cart-info']" +
            "/following-sibling::td[@class='product-cart-actions']/input";

    public static final String SUBTOTAL_TEXT = "Xpath=//a[text()='%s']/ancestor::td[@class='product-cart-info']" +
            "/following-sibling::td[@class='product-cart-total']//span[@class='price']";

    public static final String MOBILE_LINK = "Xpath=//a[text()='Mobile']";

    public static final String TV_LINK = "Xpath=//a[text()='TV']";

    public static final String UPDATE_BUTTON = "Xpath=//a[text()='%s']/ancestor::td[@class='product-cart-info']" +
            "/following-sibling::td[@class='product-cart-actions']/button";

    public static final String EMPTY_MESSAGE = "Xpath=//div[@class='cart-empty']/p[1]";

    public static final String CONTINUE_SHOPPING_BUTTON = "Css=button.btn-continue";

    public static final String MINI_CART_LINK = "Css=div.header-minicart>a";
}
