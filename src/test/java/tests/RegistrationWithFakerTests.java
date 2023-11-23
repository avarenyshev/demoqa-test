package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistationPage;

public class RegistrationWithFakerTests extends TestBase {

    RegistationPage registationPage = new RegistationPage();
    TestData testData = new TestData();
    Faker faker = new Faker();

    @Test
    void fillFormTests() {
        registationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.genderRandom)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .setSubjects(testData.subjectRandom)
                .setHobbies(testData.hobbieRandom)
                .setPicture(testData.pictureRandom)
                .setCurrentAdress(testData.streetAddress)
                .setStateAndCity(testData.state, testData.city)
                .pressEnter();
        //check
        registationPage.checkResult("Student Name", testData.firstName + " "+ testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.genderRandom)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dayRandom + " " + testData.monthRandom +","+testData.yearRandom)
                .checkResult("Subjects", testData.subjectRandom)
                .checkResult("Hobbies", testData.hobbieRandom)
                .checkResult("Picture", testData.pictureRandom)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.state+ " "+testData.city);
    }

    @Test
    void minDateInput() {
        registationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.genderRandom)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .pressEnter();
//check
        registationPage.checkResult("Student Name", testData.firstName + " "+ testData.lastName)
                .checkResult("Gender", testData.genderRandom)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dayRandom + " " + testData.monthRandom+ "," +testData.yearRandom);


    }

    @Test
    void negativeTest() {
        registationPage.openPage()
                .pressEnter()
                //check
                .negCheck();


    }

}
