package testhomepage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import base.BaseTest;

public class testLogin extends BaseTest {

    @Test
    public void testSuccessfultLogin() {
        String username = "John Doe";
        String password = "ThisIsNotAPassword";
        var loginPage = homePage.clickMakeAppointment();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        
        String actualResult = "Make Appointment";
        String expectedResult = loginPage.getH2Text();
        assertEquals(actualResult, expectedResult, "Actual and Expected Result doesn't match");
    }

    @Test
    public void testFailedLogin() {
        String username = "IncorrectUser";
        String password = "IncorrectPassword";
        var loginPage = homePage.clickMakeAppointment();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        
        String Result = loginPage.loginFailedText();
        assertTrue(Result.contains("Login failed"), "Actual and Expected Result doesn't match");
    }

}
