import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.SprintsPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class SprintsPageTest extends Webhooks {
    private SprintsPage sprintsPage;

    @BeforeEach
    public void openTab() {
        sprintsPage = open("secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=detail&selectedIssue=TEST-21966", SprintsPage.class);
        getWebDriver().manage().window().maximize();
        if (sprintsPage.checkAuthorization()) {
            sprintsPage.login("AT7", "Qwerty123");
        }
    }

    @Test
    @DisplayName("Проверка поля 'Исправить в версиях'")
    public void testFixFor() {
        step("Проверка поля 'Исправить в версиях'", () -> Assertions.assertEquals("Version 2.0", sprintsPage.checkFixForVersion()));
    }

    @Test
    @DisplayName("Проверка статуса задачи. Ожидаемый результат 'СДЕЛАТЬ'")
    public void testStatus() {
        step("Проверка статуса задачи. Ожидаемый результат 'СДЕЛАТЬ'", () -> Assertions.assertEquals("СДЕЛАТЬ", sprintsPage.checkTaskStatus()));
    }
}
