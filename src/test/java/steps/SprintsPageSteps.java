package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.SprintsPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SprintsPageSteps {
    private SprintsPage sprintsPage;

    @Дано("Открываю страницу спринта")
    public void openTab() {
        sprintsPage = open("secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=detail&selectedIssue=TEST-21966", SprintsPage.class);
        getWebDriver().manage().window().maximize();
        if (sprintsPage.checkAuthorization()) {
            sprintsPage.login("AT7", "Qwerty123");
        }
    }

    @Тогда("Поле \"Исправить в версиях\" должно быть {string}")
    public void testFixFor(String version) {
        Assertions.assertEquals(version, sprintsPage.checkFixForVersion());
    }

    @Тогда("Статус задачи должен быть {string}")
    public void testStatus(String status) {
        Assertions.assertEquals(status, sprintsPage.checkTaskStatus());
    }
}
