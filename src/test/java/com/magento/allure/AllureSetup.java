package com.magento.allure;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AllureSetup {
    @BeforeSuite
    public void beforeTest() {
        AllureUtils.cleanResults();
    }

    @AfterSuite
    public void afterTest() {
        AllureUtils.createEnvironmentFile();
    }
}
