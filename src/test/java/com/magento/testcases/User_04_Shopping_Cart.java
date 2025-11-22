package com.magento.testcases;

import com.magento.commons.BaseTest;
import com.magento.commons.PageGenerator;
import com.magento.dataprovider.UserAddToCartDataProvider;
import com.magento.pages.cart.UserCartPO;
import com.magento.pages.home.UserHomePO;
import com.magento.pages.home.category.UserMobileCategoryPO;
import com.magento.pages.home.category.UserTVCategoryPO;
import com.magento.pages.home.search.UserSearchResultsPO;
import com.magento.pages.productdetail.UserProductDetailPO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_04_Shopping_Cart extends BaseTest {
    private UserHomePO userHomePage;
    private UserCartPO userCartPage;
    private UserMobileCategoryPO userMobileCategoryPage;
    private UserTVCategoryPO userTVCategoryPage;
    private double productPrice;

    @Parameters({"browsers", "userUrl"})
    @BeforeMethod
    public void beforeMethod(String browser, String userUrl) {
        WebDriver driver = getDriver(browser, userUrl);
        userHomePage = PageGenerator.getUserHomePO(driver);
    }

    @Test(dataProvider = "productAndQuantity", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_01_Add_To_Cart_From_Product_Details(String productName, String quantity) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        UserProductDetailPO userProductDetailPage = userMobileCategoryPage.clickProductLink(productName);

        userProductDetailPage.enterQuantityTextbox(quantity);

        productPrice = Double.parseDouble(userProductDetailPage.getProductPrice().replace("$", ""));

        double expectedSubtotal = productPrice * Double.parseDouble(quantity);

        userProductDetailPage.clickAddToCartButton();

        userCartPage = userProductDetailPage.clickAlertContinueButton();

        Assert.assertTrue(userCartPage.isSuccessMessageDisplayed());
        Assert.assertTrue(userCartPage.isProductDisplayed(productName));
        Assert.assertEquals(Double.parseDouble(userCartPage.getProductPrice(productName).replace("$", "")), productPrice);
        Assert.assertEquals(userCartPage.getQuantity(productName), quantity);
        Assert.assertEquals(Double.parseDouble(userCartPage.getSubtotal(productName).replace("$", "")), expectedSubtotal);
    }

    @Test(dataProvider = "productName", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_02_Add_To_Cart_From_Search_Results(String productName) {
        userHomePage.enterSearchTextbox(productName);

        userHomePage.clickSearchButton();

        UserSearchResultsPO userSearchResultsPage = userHomePage.clickAlertContinueButton();

        productPrice = Double.parseDouble(userSearchResultsPage.getProductPrice(productName).replace("$", ""));

        userCartPage = userSearchResultsPage.clickAddToCartButton(productName);

        Assert.assertTrue(userCartPage.isSuccessMessageDisplayed());
        Assert.assertTrue(userCartPage.isProductDisplayed(productName));
        Assert.assertEquals(Double.parseDouble(userCartPage.getProductPrice(productName).replace("$", "")), productPrice);
        Assert.assertEquals(userCartPage.getQuantity(productName), "1");
        Assert.assertEquals(Double.parseDouble(userCartPage.getSubtotal(productName).replace("$", "")), productPrice);
    }

    @Test(dataProvider = "mobileProduct", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_03_Add_To_Cart_From_Mobile_Category(String productName) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        productPrice = Double.parseDouble(userMobileCategoryPage.getProductPrice(productName).replace("$", ""));

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        Assert.assertTrue(userCartPage.isSuccessMessageDisplayed());
        Assert.assertTrue(userCartPage.isProductDisplayed(productName));
        Assert.assertEquals(Double.parseDouble(userCartPage.getProductPrice(productName).replace("$", "")), productPrice);
        Assert.assertEquals(userCartPage.getQuantity(productName), "1");
        Assert.assertEquals(Double.parseDouble(userCartPage.getSubtotal(productName).replace("$", "")), productPrice);
    }

    @Test(dataProvider = "tvProduct", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_04_Add_To_Cart_From_TV_Category(String productName) {
        userTVCategoryPage = userHomePage.clickTVLink();

        productPrice = Double.parseDouble(userTVCategoryPage.getProductPrice(productName).replace("$", ""));

        userCartPage = userTVCategoryPage.clickAddToCartButton(productName);

        Assert.assertTrue(userCartPage.isSuccessMessageDisplayed());
        Assert.assertTrue(userCartPage.isProductDisplayed(productName));
        Assert.assertEquals(Double.parseDouble(userCartPage.getProductPrice(productName).replace("$", "")), productPrice);
        Assert.assertEquals(userCartPage.getQuantity(productName), "1");
        Assert.assertEquals(Double.parseDouble(userCartPage.getSubtotal(productName).replace("$", "")), productPrice);
    }

    @Test(dataProvider = "productName", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_05_Add_Same_Product_Twice(String productName) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        productPrice = Double.parseDouble(userMobileCategoryPage.getProductPrice(productName).replace("$", ""));

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        userMobileCategoryPage = userCartPage.clickMobileLink();

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        Assert.assertTrue(userCartPage.isSuccessMessageDisplayed());
        Assert.assertTrue(userCartPage.isProductDisplayed(productName));
        Assert.assertEquals(Double.parseDouble(userCartPage.getProductPrice(productName).replace("$", "")), productPrice);
        Assert.assertEquals(userCartPage.getQuantity(productName), "2");
        Assert.assertEquals(Double.parseDouble(userCartPage.getSubtotal(productName).replace("$", "")), productPrice * 2);
    }

    @Test(dataProvider = "twoProducts", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_06_Add_Multiple_Different_Products(String productName1, String productName2) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName1);

        userTVCategoryPage = userCartPage.clickTVLink();

        userCartPage = userTVCategoryPage.clickAddToCartButton(productName2);

        Assert.assertTrue(userCartPage.isProductDisplayed(productName1));
        Assert.assertTrue(userCartPage.isProductDisplayed(productName2));
    }

    @Test(dataProvider = "updateQuantity", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_07_Update_Product_Quantity_In_Cart(String productName, String quantity) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        userCartPage.clickQuantityTextbox(productName);

        userCartPage.enterQuantityTextbox(quantity, productName);

        userCartPage.clickUpdateButton(productName);

        userCartPage.clickAlertContinueButton();

        Assert.assertEquals(userCartPage.getQuantity(productName), quantity);
    }

    @Test(dataProvider = "productName", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_08_Update_Quantity_To_Zero_In_Cart(String productName) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        userCartPage.clickQuantityTextbox(productName);

        userCartPage.enterQuantityTextbox("0", productName);

        userCartPage.clickUpdateButton(productName);

        userCartPage.clickAlertContinueButton();

        Assert.assertEquals(userCartPage.getEmptyCartMessage(), "You have no items in your shopping cart.");
    }

    @Test(dataProvider = "invalidQuantity", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_09_Update_Quantity_With_Invalid_Character_In_Cart(String productName, String invalidInput) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        userCartPage.clickQuantityTextbox(productName);

        userCartPage.enterQuantityTextbox(invalidInput, productName);

        userCartPage.clickUpdateButton(productName);

        Assert.assertEquals(userCartPage.getQuantityValidationMessage(productName), "Please match the requested format: Qty.");
    }

    @Test(dataProvider = "productName", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_10_Continue_Shopping_After_Add_To_Cart(String productName) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        userMobileCategoryPage = userCartPage.clickContinueShoppingButton();

        Assert.assertEquals(userMobileCategoryPage.getTitlePage(), "MOBILE");
    }

    @Test(dataProvider = "productName", dataProviderClass = UserAddToCartDataProvider.class)
    public void TC_11_Verify_Product_In_MiniCart(String productName) {
        userMobileCategoryPage = userHomePage.clickMobileLink();

        productPrice = Double.parseDouble(userMobileCategoryPage.getProductPrice(productName).replace("$", ""));

        userCartPage = userMobileCategoryPage.clickAddToCartButton(productName);

        userCartPage.clickMiniCart();

        Assert.assertTrue(userCartPage.isProductDisplayed(productName));
        Assert.assertEquals(Double.parseDouble(userCartPage.getProductPrice(productName).replace("$", "")), productPrice);
    }

    @AfterMethod
    public void afterMethod() {
        quitDriver();
    }
}
