import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {
//$("[for='gender-radio-2']").click();

    @BeforeAll
    static void beforeAll() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.browserSize = "1920x1080";
    Configuration.holdBrowserOpen = true;
}

   // $("#genterWrapper").$(byText("Male")).click();
    @Test
    void formtests() {
        open("https://demoqa.com/automation-practice-form");
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
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("123.jpg");
        $("#currentAddress").setValue("Gogol st.");
        $("#stateCity-label").scrollTo();
        $("#react-select-3-input").val("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").val("Agra").pressEnter();
        $("#submit").pressEnter();


        $(".table-responsive").shouldHave(
                text("Bradd Pitt"),
                text("brad@pitt.com"),
                text("Male"),
                text("1234567890"),
                text("11 April,1990"),
                text("Math"),
                text("Sports"),
                text("123.jpg"),
                text("Gogol st."),
                text("Uttar Pradesh Agra")
        );
    }
}

//selectOptionByValue("11")

