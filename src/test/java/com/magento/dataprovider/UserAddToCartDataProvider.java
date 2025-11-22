package com.magento.dataprovider;

import org.testng.annotations.DataProvider;

public class UserAddToCartDataProvider {
    @DataProvider(name = "productName")
    public Object[][] productNames() {
        return new Object[][]{
                {"Sony Xperia"}
        };
    }

    @DataProvider(name = "productAndQuantity")
    public Object[][] productAndQuantity() {
        return new Object[][]{
                {"Sony Xperia", "2"}
        };
    }

    @DataProvider(name = "mobileProduct")
    public Object[][] mobileProduct() {
        return new Object[][]{
                {"Sony Xperia"},
        };
    }

    @DataProvider(name = "tvProduct")
    public Object[][] tvProduct() {
        return new Object[][]{
                {"LG LCD"},
        };
    }

    @DataProvider(name = "twoProducts")
    public Object[][] twoProducts() {
        return new Object[][]{
                {"Sony Xperia", "LG LCD"},
        };
    }

    @DataProvider(name = "updateQuantity")
    public Object[][] updateQuantity() {
        return new Object[][]{
                {"Sony Xperia", "5"}
        };
    }

    @DataProvider(name = "invalidQuantity")
    public Object[][] invalidQuantity() {
        return new Object[][]{
                {"Sony Xperia", "abc"}
        };
    }
}
