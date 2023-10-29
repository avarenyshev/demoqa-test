import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
    @Test
    void formtests() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Bradd");
        $("#lastName").setValue("Pitt");
        $("#userEmail").setValue("brad@pitt.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $("[]").setValue("").pressEnter();
        $("[]").setValue("").pressEnter();
        $("[]").setValue("").pressEnter();
        $("[]").setValue("").pressEnter();
        $("[]").setValue("").pressEnter();
        $("[]").setValue("").pressEnter();
        $("#search").shouldHave(text("https://ru.selenide.org"));
    }
}



