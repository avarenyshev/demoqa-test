package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistationPage {
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

    }

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastname"),
            emailUserInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber");



    public RegistationPage setFirstName(String value) {
        $(firstNameInput).setValue(value);

        return this;
    }

    public RegistationPage setLastName(String value) {
        $(lastNameInput).setValue(value);
        return this;
    }
    public RegistationPage setUserEmail (String value) {
        $(emailUserInput).setValue(value);
        return this;
    }
    public RegistationPage setGender (String value) {
        genderWrapper.$(byText("value")).click();
        return this;
    }
    public RegistationPage setUserNuber (String value) {
        $(userNumberInput).setValue(value);
        return this;
}