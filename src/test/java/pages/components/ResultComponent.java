package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
        public void checkTableResult(String key, String value) {
            $(".table-responsive").$(byText(key)).parent()
                    .shouldHave(text(value));
        }
    }
