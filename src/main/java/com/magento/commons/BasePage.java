package com.magento.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    /* ================================================
       1. LOCATORS
       ================================================= */
    private String formatLocator(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    private By getByLocator(String locatorExpression) {
        String[] locators = locatorExpression.split("=", 2);
        String locatorType = locators[0].trim().toLowerCase();
        String locatorValue = locators[1].trim();
        return switch (locatorType) {
            case "xpath" -> By.xpath(locatorValue);
            case "css" -> By.cssSelector(locatorValue);
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "classname" -> By.className(locatorValue);
            default -> throw new IllegalArgumentException("Invalid locator expression");
        };
    }

    public WebElement getElement(WebDriver driver, String locatorExpression) {
        return driver.findElement(getByLocator(locatorExpression));
    }


    public List<WebElement> getElements(WebDriver driver, String locatorExpression) {
        return driver.findElements(getByLocator(locatorExpression));
    }

    public List<WebElement> getElements(WebDriver driver, String locatorExpression, String... params) {
        return driver.findElements(getByLocator(formatLocator(locatorExpression, params)));
    }

    /* ================================================
      2. ELEMENT ACTIONS (click, type, select...)
      ================================================= */
    public void clickElement(WebDriver driver, String locatorExpression) {
        getElement(driver, locatorExpression).click();
    }

    public void clickElement(WebDriver driver, String locatorExpression, String... params) {
        getElement(driver, formatLocator(locatorExpression, params)).click();
    }

    public void clearTextbox(WebDriver driver, String locatorExpression) {
        getElement(driver, locatorExpression).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public void clearTextbox(WebDriver driver, String locatorExpression, String... params) {
        getElement(driver, formatLocator(locatorExpression, params)).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public void sendKeysElement(WebDriver driver, String locatorExpression, String value) {
        getElement(driver, locatorExpression).sendKeys(value);
    }

    public void sendKeysElement(WebDriver driver, String locatorExpression, String value, String... params) {
        getElement(driver, formatLocator(locatorExpression, params)).sendKeys(value);
    }

    public void checkElement(WebDriver driver, String locatorExpression) {
        if (!getElement(driver, locatorExpression).isSelected()) {
            getElement(driver, locatorExpression).click();
        }
    }

    /* ================================================
       3. GETTERS (text, attribute, size, css, etc.)
       ================================================= */
    public String getAttributeValue(WebDriver driver, String locatorExpression, String attributeName) {
        return getElement(driver, locatorExpression).getAttribute(attributeName);
    }

    public String getAttributeValue(WebDriver driver, String locatorExpression, String attributeName, String... params) {
        return getElement(driver, formatLocator(locatorExpression, params)).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locatorExpression) {
        return getElement(driver, locatorExpression).getText();
    }

    public String getElementText(WebDriver driver, String locatorExpression, String... params) {
        return getElement(driver, formatLocator(locatorExpression, params)).getText();
    }

    public String getElementValidationMessage(WebDriver driver, String locatorExpression) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", getElement(driver, locatorExpression));
    }

    public String getElementValidationMessage(WebDriver driver, String locatorExpression, String... params) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",
                getElement(driver, formatLocator(locatorExpression, params)));
    }

    public boolean isElementDisplayed(WebDriver driver, String locatorExpression) {
        return getElement(driver, locatorExpression).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locatorExpression, String... params) {
        return getElement(driver, formatLocator(locatorExpression, params)).isDisplayed();
    }

    /* ================================================
      6. WAIT HANDLERS
      ================================================= */
    public void waitForElementVisible(WebDriver driver, String locatorExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorExpression)));
    }

    public void waitForElementVisible(WebDriver driver, String locatorExpression, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(formatLocator(locatorExpression, params))));
    }

    public void waitListForElementsVisible(WebDriver driver, String locatorExpression, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(formatLocator(locatorExpression, params))));
    }

    public void waitForElementClickable(WebDriver driver, String locatorExpression) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locatorExpression)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorExpression, String... params) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(formatLocator(locatorExpression, params))));
    }


    public void waitForAlertVisible(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
    }

    /* ================================================
        8. TIME METHODS
        ================================================= */
    public void sleep(long timeoutSeconds) {
        try {
            Thread.sleep(timeoutSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
