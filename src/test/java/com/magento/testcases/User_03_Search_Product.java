package com.magento.testcases;

import com.magento.commons.BaseTest;
import com.magento.commons.PageGenerator;
import com.magento.dataprovider.UserSearchDataProvider;
import com.magento.pages.home.category.UserTVCategoryPO;
import com.magento.pages.home.search.UserSearchResultsPO;
import com.magento.pages.home.category.UserMobileCategoryPO;
import com.magento.pages.home.UserHomePO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class User_03_Search_Product extends BaseTest {
    private UserHomePO userHomePage;
    private UserSearchResultsPO searchResultsPage;

    @Parameters({"browsers", "userUrl"})
    @BeforeMethod
    public void beforeMethod(String browser, String userUrl) {
        WebDriver driver = getDriver(browser, userUrl);
        userHomePage = PageGenerator.getUserHomePO(driver);
    }

    @Test(dataProvider = "productFullName", dataProviderClass = UserSearchDataProvider.class)
    public void TC_01_Search_Product_By_Full_Name(String productName) {
        userHomePage.enterSearchTextbox(productName);

        userHomePage.clickSearchButton();

        searchResultsPage = userHomePage.clickAlertContinueButton();

        Assert.assertTrue(searchResultsPage.isProductDisplayed(productName));
    }

    @Test(dataProvider = "productNamePart", dataProviderClass = UserSearchDataProvider.class)
    public void TC_02_Search_Product_By_Partial_Name(String productName) {
        userHomePage.enterSearchTextbox(productName);

        userHomePage.clickSearchButton();

        searchResultsPage = userHomePage.clickAlertContinueButton();

        Assert.assertTrue(searchResultsPage.isProductDisplayed(productName));

    }

    @Test(dataProvider = "invalidProductName", dataProviderClass = UserSearchDataProvider.class)
    public void TC_03_Search_Product_With_Special_Characters(String productName) {
        userHomePage.enterSearchTextbox(productName);

        userHomePage.clickSearchButton();

        searchResultsPage = userHomePage.clickAlertContinueButton();

        Assert.assertEquals(searchResultsPage.getErrorMessage(), "Your search returns no results.");
    }

    @Test(dataProvider = "mobileProductName", dataProviderClass = UserSearchDataProvider.class)
    public void TC_04_Search_Product_In_Mobile_Category(String productName) {
        UserMobileCategoryPO mobilePage = userHomePage.clickMobileLink();

        mobilePage.enterSearchTextbox(productName);

        mobilePage.clickSearchButton();

        searchResultsPage = mobilePage.clickAlertContinueButton();

        Assert.assertTrue(searchResultsPage.isProductDisplayed(productName));
    }

    @Test(dataProvider = "tvProductName", dataProviderClass = UserSearchDataProvider.class)
    public void TC_05_Search_Product_In_TV_Category(String productName) {
        UserTVCategoryPO tvPage = userHomePage.clickTVLink();

        tvPage.enterSearchTextbox(productName);

        tvPage.clickSearchButton();

        searchResultsPage = tvPage.clickAlertContinueButton();

        Assert.assertTrue(searchResultsPage.isProductDisplayed(productName));
    }


    @AfterMethod
    public void afterMethod() {
        quitDriver();
    }

}
