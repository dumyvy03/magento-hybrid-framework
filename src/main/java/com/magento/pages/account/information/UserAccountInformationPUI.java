package com.magento.pages.account.information;

public class UserAccountInformationPUI {
    public static final String FIRSTNAME_TEXTBOX = "Css=input#firstname";

    public static final String LASTNAME_TEXTBOX = "Css=input#lastname";

    public static final String EMAIL_ADDRESS_TEXTBOX = "Css=input#email";

    public static final String CURRENT_PASSWORD_TEXTBOX = "Css=input#current_password";

    public static final String CHANGE_PASSWORD_CHECKBOX = "Css=input#change_password";

    public static final String NEW_PASSWORD_TEXTBOX = "Css=input#password";

    public static final String CONFIRM_NEW_PASSWORD_TEXTBOX = "Css=input#confirmation";

    public static final String SAVE_BUTTON = "Xpath=//button//span[text()='Save']";

    public static final String FIRSTNAME_REQUIRED_ERROR_MESSAGE = "Css=div#advice-required-entry-firstname";

    public static final String LASTNAME_REQUIRED_ERROR_MESSAGE = "Css=div#advice-required-entry-lastname";

    public static final String EMAIL_ADDRESS_VALIDATION_ERROR_MESSAGE = "Css=div#advice-validate-email-email";

    public static final String CURRENT_REQUIRED_PASSWORD_ERROR_MESSAGE = "Css=div#advice-required-entry-current_password";

    public static final String INVALID_CURRENT_PASSWORD_ERROR_MESSAGE = "Xpath=//li[@class='error-msg']//span";

    public static final String CONFIRM_NEW_PASSWORD_MISMATCH_ERROR_MESSAGE = "Css=div#advice-validate-cpassword-confirmation";

    public static final String NEW_PASSWORD_REQUIRED_ERROR_MESSAGE = "Css=div#advice-required-entry-password";

    public static final String CONFIRM_NEW_PASSWORD_REQUIRED_ERROR_MESSAGE = "Css=div#advice-required-entry-confirmation";
}
