package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class TestData {
    TestData testData = new TestData();
    Faker faker = new Faker(new Locale("es"));

    public void setFaker () {
    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String userEmail = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
    String dateOfBirth = String.valueOf(faker.date().birthday());
    String currentAdress = faker.address().streetAddress();
    }

//Faker faker = new Faker();



}