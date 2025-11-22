package com.magento.commons;

import com.magento.enums.BrowserList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;

    private void initDriver(String browser, String userUrl) {
        BrowserList browserList = BrowserList.valueOf(browser.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(userUrl);
    }

    protected WebDriver getDriver(String browser, String userUrl) {
        if (driver == null) {
            initDriver(browser, userUrl);
        }
        return driver;
    }

    public static WebDriver getCurrentDriver() {
        return driver;
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
