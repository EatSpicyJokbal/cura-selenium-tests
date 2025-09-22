package com.utilities;

import org.openqa.selenium.WebDriver;

import com.base.BasePage;

public class Utility {
    public static WebDriver driver;

    public static void  setUtilityDriver() {
        driver = BasePage.driver;
    }

}
