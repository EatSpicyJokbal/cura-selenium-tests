package com.cura.homepage;

import org.openqa.selenium.By;

import static com.utilities.GetUtility.getText;

public class LoginPage extends HomePage {
    private final By usernameField = By.xpath("//div[@class='row']//input[@id='txt-username']");
    private final By passwordField = By.xpath("//div[@class='row']//input[@id='txt-password']");
    private final By btnLogin = By.xpath("//div[@class='form-group']//button[@id='btn-login']");
    private final By titlePage = By.xpath("//div[@class='row']//h2[text()='Make Appointment']");
    private final By loginFailed = By.xpath("//div[@class='row']//p[contains(text(),'Login failed')]");

    public void setUsername(String username) {
        set(usernameField,username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public String getH2Text() {
        return getText(titlePage);
    }

    public String loginFailedText() {
        return getText(loginFailed);
    }

    public void clickLogin() {
        click(btnLogin);
    }

}
