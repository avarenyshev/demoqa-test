package pages.components;

import pages.RegistationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDateOfBirth (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();

    }
}
