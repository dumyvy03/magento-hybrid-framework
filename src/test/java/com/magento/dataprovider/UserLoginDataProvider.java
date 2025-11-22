package com.magento.dataprovider;

import org.testng.annotations.DataProvider;

public class UserLoginDataProvider {

    @DataProvider(name = "validLogin")
    public Object[][] validLogin() {
        return new Object[][]{
                {"david123@gmail.com", "david1234"},
        };
    }

    @DataProvider(name = "invalidEmailTooltip")
    public Object[][] invalidEmailTooltip() {
        return new Object[][]{
                {"abc.com"},
        };
    }

    @DataProvider(name = "invalidEmail")
    public Object[][] invalidEmail() {
        return new Object[][]{
                {"abc@gmail.com12", "123456"}
        };
    }

    @DataProvider(name = "wrongPassword")
    public Object[][] wrongPassword() {
        return new Object[][]{
                {"valid@gmail.com", "wrong1"},
        };
    }
}
