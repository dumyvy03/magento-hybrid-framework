package com.magento.dataprovider;

import org.testng.annotations.DataProvider;

public class UserRegisterDataProvider {
    @DataProvider(name = "validAccount")
    public Object[][] validAccount() {
        return new Object[][]{
                {"John", "Doe", "john" + System.currentTimeMillis() + "@test.com", "12345678"}
        };
    }

    @DataProvider(name = "invalidEmailTooltip")
    public Object[][] invalidEmailTooltip() {
        return new Object[][]{
                {"john" + System.currentTimeMillis() + ".com"},
        };
    }

    @DataProvider(name = "invalidEmail")
    public Object[][] invalidEmail() {
        return new Object[][]{
                {"John", "Doe", "john" + System.currentTimeMillis() + "@test.com123", "12345678"}
        };
    }

    @DataProvider(name = "mismatchPassword")
    public Object[][] mismatchPassword() {
        return new Object[][]{
                {"John", "Doe", "john" + System.currentTimeMillis() + "@test.com", "12345678", "87654321"}
        };
    }

    @DataProvider(name = "shortPassword")
    public Object[][] shortPassword() {
        return new Object[][]{
                {"John", "Doe", "john" + System.currentTimeMillis() + "@test.com", "1234"},
        };
    }
}
