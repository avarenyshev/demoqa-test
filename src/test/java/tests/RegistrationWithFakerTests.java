package tests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistationPage;

import java.util.Locale;

public class RegistrationWithFakerTests extends TestBase {

    RegistationPage registationPage = new RegistationPage();

    @Test
    void fillFormTests() {
        Faker faker = new Faker(new Locale("es"));
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
                .setStateAndCity("Uttar Pradesh", "Agra")
                .pressEnter();
        //check
        registationPage.checkResult("Student Name", "Bradd Pitt")
                .checkResult("Student Email", "brad@pitt.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "11 April,1990")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "123.jpg")
                .checkResult("Address", "Gogol st.")
                .checkResult("State and City", "Uttar Pradesh Agra");

    }

    @Test
    void minDateInput() {
        registationPage.openPage()
                .setFirstName("Bradd")
                .setLastName("Pitt")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("11", "April", "1990")
                .pressEnter();
//check
        registationPage.checkResult("Student Name", "Bradd Pitt")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "11 April,1990");


    }

    @Test
    void negativeTest() {
        registationPage.openPage()
                .pressEnter()
                //check
                .negCheck();



    }
}


