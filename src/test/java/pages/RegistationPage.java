package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastname"),
            emailUserInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper");




    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        //$(".practice-form-wrapper").shouldHave(text("Student Registration"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;

    }

    public RegistationPage setFirstName(String value) {
        (firstNameInput).setValue(value);

        return this;
    }

    public RegistationPage setLastName(String value) {
        (lastNameInput).setValue(value);
        return this;
    }

    public RegistationPage setUserEmail(String value) {
        (emailUserInput).setValue(value);
        return this;
    }

    public RegistationPage setGender(String value) {
        genderWrapper.$(byText("value")).click();
        return this;
    }

    public RegistationPage setUserNuber(String value) {
        (userNumberInput).setValue(value);
        return this;
    }

    public RegistationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistationPage setSubjects(String value) {
        (subjectsInput).setValue(value).pressEnter();
        return this;
    }
    public RegistationPage setHobbies(String value) {
        (hobbiesWrapper).$(byText("value")).click();
        return this;
    }

    public RegistationPage setPicture(String)

    public RegistationPage checkResult(String key, String value) {
        (".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }




}