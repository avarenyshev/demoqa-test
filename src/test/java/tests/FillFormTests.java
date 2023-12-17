package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("simple")
class FillFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    void fillFormTests() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открывваем страницу demoqa", () -> {
                    open("https://demoqa.com/automation-practice-form");
                    executeJavaScript("$('#fixedban').remove()");
                    executeJavaScript("$('footer').remove()");
                });
        step("Заполняем форму", () -> {
                    $("#firstName").setValue("Bradd");
                    $("#lastName").setValue("Pitt");
                    $("#userEmail").setValue("brad@pitt.com");
                    $("#genterWrapper").$(byText("Male")).click();
                    $("#userNumber").setValue("1234567890");
                    $("#dateOfBirthInput").click();
                    $(".react-datepicker__year-select").selectOption("1990");
                    $(".react-datepicker__month-select").selectOptionByValue("3");
                    $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();
                    $("#subjectsInput").setValue("Math").pressEnter();
                    $("#hobbiesWrapper").$(byText("Sports")).click();
                    $("#uploadPicture").uploadFromClasspath("123.jpg");
                    $("#currentAddress").setValue("Gogol st.");
                    $("#react-select-3-input").val("Uttar Pradesh").pressEnter();
                    $("#react-select-4-input").val("Agra").pressEnter();
                    $("#submit").pressEnter();
                });
//check
        step("Проверка введенных данных", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").$(byText("Student Name"))
                    .parent().shouldHave(text("Bradd Pitt"));
            $(".table-responsive").$(byText("Student Email"))
                    .parent().shouldHave(text("brad@pitt.com"));
            $(".table-responsive").$(byText("Gender"))
                    .parent().shouldHave(text("Male"));
            $(".table-responsive").$(byText("Mobile"))
                    .parent().shouldHave(text("1234567890"));
            $(".table-responsive").$(byText("Date of Birth"))
                    .parent().shouldHave(text("11 April,1990"));
            $(".table-responsive").$(byText("Subjects"))
                    .parent().shouldHave(text("Math"));
            $(".table-responsive").$(byText("Hobbies"))
                    .parent().shouldHave(text("Sports"));
            $(".table-responsive").$(byText("Picture"))
                    .parent().shouldHave(text("123.jpg"));
            $(".table-responsive").$(byText("Address"))
                    .parent().shouldHave(text("Gogol st."));
            $(".table-responsive").$(byText("State and City"))
                    .parent().shouldHave(text("Uttar Pradesh Agra"));
            $("#closeLargeModal").click();
        });
    }
}

