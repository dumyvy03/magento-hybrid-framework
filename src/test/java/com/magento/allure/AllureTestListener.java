package com.magento.allure;

import com.magento.commons.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Allure.step("Start test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTest.getCurrentDriver();
        if (driver != null) {
            Allure.addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)),
                    ".png"
            );
        }

    }

}
