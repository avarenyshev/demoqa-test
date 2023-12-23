package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import helpers.Attach;
import org.junit.jupiter.api.*;
import pages.RegistationPage;
import static io.qameta.allure.Allure.step;
//import static com.codeborne.selenide.logevents.SelenideLogger.step;


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
        Attach.addVideo();
    }

    @Test
    @DisplayName("Проверка формы регистрации")
    void fillFormTests() {
        step("Open page demoqa", () -> {
            registationPage.openPage();
        });
        step("Fill form", () -> {
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
        step("Verify model ", () -> {
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
        step("Open page demoqa", () -> {
            registationPage.openPage();
        });
        step("Fill minimal value form", () -> {
            registationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.genderRandom)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                    .pressEnter();
        });
//check
        step("Verify model", () -> {
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
