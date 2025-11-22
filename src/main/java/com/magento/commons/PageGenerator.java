package com.magento.commons;

import com.magento.pages.account.dashboard.UserAccountDashboardPO;
import com.magento.pages.account.information.UserAccountInformationPO;
import com.magento.pages.cart.UserCartPO;
import com.magento.pages.home.UserHomePO;
import com.magento.pages.home.category.UserMobileCategoryPO;
import com.magento.pages.home.category.UserTVCategoryPO;
import com.magento.pages.home.search.UserSearchResultsPO;
import com.magento.pages.login.UserLoginPO;
import com.magento.pages.productdetail.UserProductDetailPO;
import com.magento.pages.register.UserCreateAccountPO;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static UserHomePO getUserHomePO(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserCreateAccountPO getUserCreateAccountPage(WebDriver driver) {
        return new UserCreateAccountPO(driver);
    }

    public static UserAccountDashboardPO getUserAccountDashboardPage(WebDriver driver) {
        return new UserAccountDashboardPO(driver);
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }

    public static UserMobileCategoryPO getUserMobileCategoryPage(WebDriver driver) {
        return new UserMobileCategoryPO(driver);
    }

    public static UserTVCategoryPO getUserTVCategoryPage(WebDriver driver) {
        return new UserTVCategoryPO(driver);
    }

    public static UserSearchResultsPO getUserSearchResultsPage(WebDriver driver) {
        return new UserSearchResultsPO(driver);
    }

    public static UserProductDetailPO getUserProductDetailPage(WebDriver driver) {
        return new UserProductDetailPO(driver);
    }

    public static UserCartPO getUserCartPO(WebDriver driver) {
        return new UserCartPO(driver);
    }

    public static UserAccountInformationPO getUserAccountInformationPO(WebDriver driver) {
        return new UserAccountInformationPO(driver);
    }
}
