package com.magento.pages.account.dashboard;

import com.magento.pages.account.sidebar.UserAccountSidebarPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class UserAccountDashboardPO extends UserAccountSidebarPO {
    private WebDriver driver;

    public UserAccountDashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get full contact information text and split from 'Contact Information'")
    private String[] getContactInformationText() {
        waitForElementVisible(driver, UserAccountDashboardPUI.CONTACT_INFORMATION);
        sleep(1);
        return getElementText(driver, UserAccountDashboardPUI.CONTACT_INFORMATION).split("\n");
    }


    @Step("Get success message text displayed after registration")
    public String getSuccessMessage() {
        waitForElementVisible(driver, UserAccountDashboardPUI.SUCCESS_MESSAGE);
        sleep(1);
        return getElementText(driver, UserAccountDashboardPUI.SUCCESS_MESSAGE);
    }

    @Step("Get account full name from Contact Information")
    public String getAccountFullName() {
        return getContactInformationText()[0].trim();
    }

    @Step("Get account email address from Contact Information")
    public String getAccountEmail() {
        return getContactInformationText()[1].trim();
    }

}
