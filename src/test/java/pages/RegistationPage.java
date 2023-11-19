package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class RegistationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailUserInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            downloadPicture = $("#uploadPicture"),
            currentAdressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            putSubit = $("#submit");




    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent tableComponent = new ResultComponent();

    public RegistationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
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
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistationPage setUserNumber(String value) {
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
        (hobbiesWrapper).$(byText(value)).click();
        return this;
    }

    public RegistationPage setPicture(String fileName) {
        (downloadPicture).uploadFromClasspath(fileName);
        return this;
    }

    public RegistationPage setCurrentAdress(String value) {
        (currentAdressInput).setValue(value);
        return this;
    }

    public RegistationPage setStateAndCity(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistationPage pressEnter() {
        putSubit.pressEnter();
        return this;
    }

    public RegistationPage checkResult(String key, String value) {
        tableComponent.checkTableResult(key, value);
        return this;
    }

    public RegistationPage negCheck() {
        firstNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        lastNameInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        userNumberInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;

    }

}




