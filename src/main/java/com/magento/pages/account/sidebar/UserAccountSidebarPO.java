package com.magento.pages.account.sidebar;

import com.magento.commons.BasePage;
import com.magento.commons.PageGenerator;
import com.magento.pages.account.information.UserAccountInformationPO;
import org.openqa.selenium.WebDriver;

public class UserAccountSidebarPO extends BasePage {
    private WebDriver driver;

    public UserAccountSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserAccountInformationPO openAccountInformationLink() {
        waitForElementClickable(driver, UserAccountSidebarPUI.ACCOUNT_INFORMATION_LINK);
        sleep(2);
        clickElement(driver, UserAccountSidebarPUI.ACCOUNT_INFORMATION_LINK);
        return PageGenerator.getUserAccountInformationPO(driver);
    }
}
