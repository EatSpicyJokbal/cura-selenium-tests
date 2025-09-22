package com.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetUtility extends Utility {

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static int getMonthNumber(String monthName) {
        switch (monthName.toLowerCase()) {
            case "january" -> { return 1;}
            case "february" -> { return 2;}
            case "march" -> { return 3;}
            case "april" -> { return 4;}
            case "may" -> { return 5;}
            case "june" -> { return 6;}
            case "july" -> { return 7;}
            case "august" -> { return 8;}
            case "september" -> { return 9;}
            case "october" -> { return 10;}
            case "november" -> { return 11;}
            case "december" -> { return 12;}
            default -> throw new IllegalArgumentException("Invalid month name: " + monthName);
        }
    }

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

}
