import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class RegistrationWithPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void fillFormTests() {
//        open("https://demoqa.com/automation-practice-form");
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
        registrationPage.open()

        //$("#firstName").setValue("Bradd");
        registrationPage.setFirstName("Bradd")

        $("#lastName").setValue("Pitt");
        $("#userEmail").setValue("brad@pitt.com");

 //       $("#genterWrapper").$(byText("Male")).click();
        registrationPage.setGender("Male")

        $("#userNumber").setValue("1234567890");

//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__year-select").selectOption("1990");
//        $(".react-datepicker__month-select").selectOptionByValue("3");
//        $(".react-datepicker__day--011:not(.react-datepicker__day--outside-month)").click();
        registrationPage.setBirthday("11", "April", "1990")

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("123.jpg");
        $("#currentAddress").setValue("Gogol st.");
        $("#react-select-3-input").val("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").val("Agra").pressEnter();
        $("#submit").pressEnter();
//check
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkFormAppears()

//        $(".table-responsive").$(byText("Student Name"))
//                .parent().shouldHave(text("Bradd Pitt"));
//        $(".table-responsive").$(byText("Student Email"))
//                .parent().shouldHave(text("brad@pitt.com"));
//        $(".table-responsive").$(byText("Gender"))
//                .parent().shouldHave(text("Male"));
//        $(".table-responsive").$(byText("Mobile"))
//                .parent().shouldHave(text("1234567890"));
//        $(".table-responsive").$(byText("Date of Birth"))
//                .parent().shouldHave(text("11 April,1990"));
//        $(".table-responsive").$(byText("Subjects"))
//                .parent().shouldHave(text("Math"));
//        $(".table-responsive").$(byText("Hobbies"))
//                .parent().shouldHave(text("Sports"));
//        $(".table-responsive").$(byText("Picture"))
//                .parent().shouldHave(text("123.jpg"));
//        $(".table-responsive").$(byText("Address"))
//                .parent().shouldHave(text("Gogol st."));
//        $(".table-responsive").$(byText("State and City"))
//                .parent().shouldHave(text("Uttar Pradesh Agra"));
//        $("#closeLargeModal").click();
        registrationPage.checkResult("Full name", "Bradd Pitt");
    }
}

