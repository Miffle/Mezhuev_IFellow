package pages;

import hooks.Webhooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.SprintsPage;
import ru.iFellow.properties.Props;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SprintsPageTest extends Webhooks {
    private SprintsPage sprintsPage;

    @BeforeEach
    public void openTab() {
        sprintsPage = open("secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=detail&selectedIssue=TEST-21966", SprintsPage.class);
        getWebDriver().manage().window().maximize();
        if (sprintsPage.checkAuthorization()) {
            sprintsPage.login(Props.PROPS.login(), Props.PROPS.password());
        }
    }

    @Test
    @DisplayName("Проверка поля 'Исправить в версиях'")
    public void testFixFor() {
        sprintsPage.checkFixForVersion("Version 2.0");
    }

    @Test
    @DisplayName("Проверка статуса задачи")
    public void testStatus() {
        sprintsPage.checkTaskStatus("СДЕЛАТЬ");
    }
}
