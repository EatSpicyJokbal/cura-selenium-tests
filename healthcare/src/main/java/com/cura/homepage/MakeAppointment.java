package com.cura.homepage;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.utilities.DropDownUtility.selectByIndex;
import static com.utilities.GetUtility.findElements;
import static com.utilities.GetUtility.getMonthNumber;
import static com.utilities.GetUtility.getText;
import static com.utilities.WaitUtility.fluentWaitUntilVisible;

public class MakeAppointment extends HomePage {
    private final By selectFacility = By.xpath("//div[@class='form-group']//select[@id='combo_facility']");
    private final By chkHospitalReadmission = By.xpath("//div[@class='form-group']//input[@id='chk_hospotal_readmission']");
    private final By radioMedicAid = By.xpath("//div[@class='form-group']//input[@id='radio_program_medicaid']");
    private final By datePicker = By.xpath("//div[@class='form-group']//input[@id='txt_visit_date']");
    private final By datePickerPrev = By.xpath("//div[@class='datepicker-days']//th[@class='prev']");
    private final By datePickerNext = By.xpath("//div[@class='datepicker-days']//th[@class='next']");
    private final By datePickerSwitch = By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']");
    private final By datePickerDay = By.xpath("//div[@class='datepicker-days']//td[@class='day']");
    private final By txtCommentBox = By.xpath("//div[@class='form-group']//textarea[@id='txt_comment']");
    private final By btnBookAppointment = By.xpath("//div[@class='form-group']//button[@id='btn-book-appointment']");

    private final By visitDate = By.xpath("//div[@class='row']//p[@id='visit_date']");

    
    public void setSelectFacility(int index) {
        fluentWaitUntilVisible(selectFacility, 10);
        selectByIndex(selectFacility, index);
    }

    public void clickCheckboxHospitalReadmission() {
        click(chkHospitalReadmission);
    }

    public void clickRadioMedicAid() {
        click(radioMedicAid);
    }

    public void setTxtCommentBox(String text) {
        set(txtCommentBox, text);
    }

    public void clickSubmitButton() {
        click(btnBookAppointment);
    }

    private void clickDay(int day) {
        List<WebElement> days = findElements(datePickerDay);
        for (WebElement d : days) {
            if (d.getText().trim().equals(String.valueOf(day))
                && !d.getAttribute("class").contains("old")
                && !d.getAttribute("class").contains("new")) {
                    d.click();
                    break;
            }
        }
    }

    public void selectDate(LocalDate date){
        click(datePicker);
        int month = date.getMonthValue();
        int year = date.getYear();
        int day = date.getDayOfMonth();
        while (true) {
            String currentMonthYear = getText(datePickerSwitch);
            String[] parts = currentMonthYear.split(" ");
            int currentMonth = getMonthNumber(parts[0]);
            int currentYear = Integer.parseInt(parts[1]);

            if (currentYear < year || (currentYear == year && currentMonth < month)) {
                click(datePickerNext);
            } else if (currentYear > year || (currentYear == year && currentMonth > month)) {
                click(datePickerPrev);
            } else {
                clickDay(day);
                break;
            }
        }
    }

    public String getVisitDate() {
        fluentWaitUntilVisible(visitDate, 10);
        return getText(visitDate);
    }

}
