package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browser = System.getProperty("browser", "safari");
        Configuration.browser = System.getProperty("browser", "mozila");
        Configuration.browserSize = System.getProperty("size","1920x1080");
        Configuration.browserSize = System.getProperty("size","1280x1024");
        Configuration.browserSize = System.getProperty("size","1024x960");
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

//    static void beforeAll() {
//        Configuration.remote = System.getProperty("selenoid", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
//        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
//        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
//    }
    }
}
