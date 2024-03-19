import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.SprintsPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SprintsPageTest extends Webhooks {
    private SprintsPage sprintsPage;

    @BeforeEach
    public void openTab() {
        sprintsPage = open("secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=detail&selectedIssue=TEST-21966", SprintsPage.class);
        getWebDriver().manage().window().maximize();
        if (sprintsPage.checkAuthorization()) {
            sprintsPage.login(props.getLogin(), props.getPassword());
        }
    }

    @Test
    @DisplayName("Проверка поля 'Исправить в версиях'")
    public void testFixFor() {
        sprintsPage.checkFixForVersion("Version 1.0");
    }

    @Test
    @DisplayName("Проверка статуса задачи")
    public void testStatus() {
        sprintsPage.checkTaskStatus("СДЕЛАТЬ");
    }
}
