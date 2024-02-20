import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;

public class RunTest {
    @BeforeEach
    public void setUp() {
        Configuration.screenshots = false;
        open("https://habr.com/");
    }

    @Test
    @DisplayName("Проверка активности вкладки \"Моя лента\" habr")
    void onLoadFeedButtonActiveTest() {
        step("Проверка активности вкладки \"Моя лента\" habr", () ->
                $$(className("tm-main-menu__item")).first().shouldHave(cssClass("tm-main-menu__item_active"))
        );
    }

    @Test
    @DisplayName("Проверка перехода на вкладку \"Все потоки\"")
    void articlesButtonTest() {
        step("Нажатие на кнопку \"Все потоки\"", () ->
                $$(className("tm-main-menu__item")).get(1).click());
        step("Проверка ссылки после перехода", () -> webdriver().shouldHave(url("https://habr.com/ru/articles/")));
    }
}
