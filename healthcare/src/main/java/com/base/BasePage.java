package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;
    
    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }
    
}
