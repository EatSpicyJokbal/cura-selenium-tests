package com.cura.homepage;

import org.openqa.selenium.By;

import com.base.BasePage;
import static com.utilities.WaitUtility.fluentWaitUntilVisible;

public class HomePage extends BasePage {
    private final By appointmentPage = By.xpath("//header[@id='top']//a[text()='Make Appointment']");

    public LoginPage clickMakeAppointment() {
        fluentWaitUntilVisible(appointmentPage, 5);
        click(appointmentPage);
        return new LoginPage();
    }
}
