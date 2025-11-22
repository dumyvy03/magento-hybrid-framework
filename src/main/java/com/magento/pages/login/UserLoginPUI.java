package com.magento.pages.login;

public class UserLoginPUI {
    public static final String EMAIL_ADDRESS_TEXTBOX = "Css=input#email";

    public static final String PASSWORD_TEXTBOX = "Css=input#pass";

    public static final String LOGIN_BUTTON = "Xpath=//button//span[text()='Login']";

    public static final String EMAIL_ADDRESS_ERROR_MESSAGE = "Css=input#email~div";

    public static final String PASSWORD_ERROR_MESSAGE = "Css=input#pass~div";

    public static final String INVALID_LOGIN_ERROR_MESSAGE = "Xpath=//li[@class='error-msg']//span";
}
