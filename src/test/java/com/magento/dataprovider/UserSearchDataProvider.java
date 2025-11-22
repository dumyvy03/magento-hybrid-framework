package com.magento.dataprovider;

import org.testng.annotations.DataProvider;

public class UserSearchDataProvider {

    @DataProvider(name = "productFullName")
    public Object[][] productFullName() {
        return new Object[][]{
                {"Sony Xperia"}
        };
    }

    @DataProvider(name = "productNamePart")
    public Object[][] productNamePart() {
        return new Object[][]{
                {"Sony"}
        };
    }

    @DataProvider(name = "invalidProductName")
    public Object[][] invalidProductName() {
        return new Object[][]{
                {"@#$%^&*"},
        };
    }

    @DataProvider(name = "mobileProductName")
    public Object[][] mobileProductName() {
        return new Object[][]{
                {"Samsung Galaxy"}
        };
    }

    @DataProvider(name = "tvProductName")
    public Object[][] tvProductName() {
        return new Object[][]{
                {"LG"}
        };
    }
}
