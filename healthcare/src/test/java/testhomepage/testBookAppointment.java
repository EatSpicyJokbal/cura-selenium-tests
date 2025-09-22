package testhomepage;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.cura.homepage.MakeAppointment;

import base.BaseTest;

public class testBookAppointment extends BaseTest {

    @Test
    public void bookAppointmentPageTest() {
        LocalDate targetDate = LocalDate.of(2025, 8, 22);
        String username = "John Doe";
        String password = "ThisIsNotAPassword";
        String comment = "Constipation and diarrhea";

        var loginPage = homePage.clickMakeAppointment();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        var makeAppointmentPage = new MakeAppointment();
        
        makeAppointmentPage.setSelectFacility(1);
        makeAppointmentPage.clickCheckboxHospitalReadmission();
        makeAppointmentPage.clickRadioMedicAid();
        makeAppointmentPage.selectDate(targetDate);
        makeAppointmentPage.setTxtCommentBox(comment);
        makeAppointmentPage.clickSubmitButton();

        String actualVisitDate = makeAppointmentPage.getVisitDate();
        String expectedVisitDate = "22/08/2025";
        assertEquals(actualVisitDate, expectedVisitDate, "Actual and Expected Visit Date doesn't match");
    }
}
