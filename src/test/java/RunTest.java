import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

public class RunTest {
    @BeforeEach
    public void setUp() {
        Configuration.screenshots = false;
        open("https://ifellow.ru/");
        getWebDriver().manage().window().maximize();
    }

    @Test
    @DisplayName("Проверка перехода по кнопке \"Карьера\"")
    void careerButtonTest() {
        step("Нажатие на кнопку \"Карьера\"", () -> {
            ElementsCollection elements = $$(className("header__menu-link"));
            elements.findBy(text("Карьера")).click();
        });
        step("Проверка ссылки после перехода", () -> webdriver().shouldHave(url("https://ifellow.ru/career/")));
    }

    @Test
    @DisplayName("Проверка ввода почты для рассылки")
    void emailInputTest() {
        step("Вставка неправильной почты в поле ввода", () -> $(id("mailingEmail")).append("miffle1337mail.com"));
        step("Нажатие на кнопку \"Подписаться\"", () -> $(className("footer__mailing-button")).click());
        step("Проверка появления ошибки", () -> $(id("mailingEmail")).shouldHave(cssClass("is-error")));
    }
}
