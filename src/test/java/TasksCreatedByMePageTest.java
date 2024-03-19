import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.TasksCreatedByMePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TasksCreatedByMePageTest extends Webhooks {
    private TasksCreatedByMePage tasksCreatedByMePage;

    @BeforeEach
    public void openTab() {
        tasksCreatedByMePage = open("projects/TEST/issues?filter=reportedbyme", TasksCreatedByMePage.class);
        getWebDriver().manage().window().maximize();
        if (tasksCreatedByMePage.checkAuthorization()) {
            tasksCreatedByMePage.login(props.getLogin(), props.getPassword());
        }
    }

    @Test
    @DisplayName("Изменение статуса нового теста")
    public void clickOnAllStatuses() {
        tasksCreatedByMePage.openLastCreatedTask();
        tasksCreatedByMePage.setInWorkStatus("В РАБОТЕ");
        tasksCreatedByMePage.setExecutedStatus("РЕШЕННЫЕ");
        tasksCreatedByMePage.setCompleteStatus("ГОТОВО");
    }
}
