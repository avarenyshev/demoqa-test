package tests;

import com.github.javafaker.Faker;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistationPage;

import static io.qameta.allure.Allure.step;

@Tag("faker")
public class RegistrationWithFakerTests extends TestBase {

    RegistationPage registationPage = new RegistationPage();
    TestData testData = new TestData();
    Faker faker = new Faker();
    @AfterEach
    void addAttacments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
    }
    @Test
    @DisplayName("Проверка формы регистрации")
    void fillFormTests() {
        step("Открывваем страницу demoqa", () -> {
            registationPage.openPage();
        });
        step("Заполняем форму", () -> {
            registationPage.setFirstName(testData.firstName)
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
        });
        //check
        step("Проверка введенных данных", () -> {
            registationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.genderRandom)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.dayRandom + " " + testData.monthRandom + "," + testData.yearRandom)
                    .checkResult("Subjects", testData.subjectRandom)
                    .checkResult("Hobbies", testData.hobbieRandom)
                    .checkResult("Picture", testData.pictureRandom)
                    .checkResult("Address", testData.streetAddress)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });
    }

    @Test
    @DisplayName("Проверка регистрации с минимальными данными")
    void minDateInput() {
        step("Открывваем страницу demoqa", () -> {
            registationPage.openPage();
        });
        step("Заполняем форму минимальным объёмом данных", () -> {
            registationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.genderRandom)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                    .pressEnter();
        });
//check
        step("Проверка введенных данных", () -> {
            registationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.genderRandom)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.dayRandom + " " + testData.monthRandom + "," + testData.yearRandom);

        });
    }

    @Test
    @DisplayName("Проерка невозможности регистрации без данных")
    void negativeTest() {
        step("Открывваем страницу demoqa", () -> {
            registationPage.openPage();
        });
        step("Отправляем форму регистрации без данных", () -> {
            registationPage.pressEnter();
        });
        //check
        step("Проверка валидации", () -> {
            registationPage.negCheck();
        });


    }

}
