package tests;
import org.junit.jupiter.api.Test;
import pages.RegistationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistationPage registationPage = new RegistationPage();
    TestData testData = new TestData();

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


