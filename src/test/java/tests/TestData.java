package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en"));


    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            genderRandom = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            dayRandom = String.valueOf(faker.number().numberBetween(1, 28)),
            monthRandom = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            yearRandom = String.valueOf(faker.number().numberBetween(1990, 2005)),
            userEmail = faker.internet().emailAddress(),
            streetAddress = faker.address().streetAddress(),
            subjectRandom = faker.options().option("English", "Math", "Chimestry", "Civics", "Economics", "Commerse"),
            hobbieRandom = faker.options().option("Sports", "Reading", "Music"),
            pictureRandom = faker.options().option("111.jpg", "123.jpg", "222.jpg"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setRandomCity(state);

    public String setRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }


    }

}