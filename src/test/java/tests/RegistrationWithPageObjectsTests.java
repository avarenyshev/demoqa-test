package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistationPage registationPage = new RegistationPage();

    @Test
    void fillFormTests() {
        registationPage.openPage()
                .setFirstName("Bradd")
                .setLastName("Pitt")
                .setUserEmail("brad@pitt.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("11", "April", "1990")
                .setSubjects("Math")
                .setHobbies("Sports")
                .setPicture("123.jpg")
                .setCurrentAdress("Gogol st.")
                .setStateAndCity("Uttar Pradesh", "Agra");
                //.setCity("Agra");
        $("#submit").pressEnter();
//check
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        //registrationPage.checkFormAppears()

        //registrationPage.checkResult("Full name", "Bradd Pitt");
    }
}

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
