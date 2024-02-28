import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.TasksCreatedByMePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TasksCreatedByMePageTest extends Webhooks {
    private TasksCreatedByMePage tasksCreatedByMePage;

    @BeforeEach
    public void openTab() {
        tasksCreatedByMePage = open("projects/TEST/issues?filter=reportedbyme", TasksCreatedByMePage.class);
        getWebDriver().manage().window().maximize();
        if (tasksCreatedByMePage.checkAuthorization()) {
            tasksCreatedByMePage.login("AT7", "Qwerty123");
        }
    }

    @Test
    @DisplayName("Изменение статуса нового теста")
    public void clickOnAllStatuses() {
        openLastCreatedTaskStep();
        setInWorkStatusStep();
        setExecutedStatusStep();
        setCompleteStatusStep();
    }

    @Step("Открытие последнего созданного мной теста")
    public void openLastCreatedTaskStep() {
        tasksCreatedByMePage.openLastCreatedTask();
    }

    @Step("Установка статуса 'В РАБОТЕ'")
    public void setInWorkStatusStep() {
        tasksCreatedByMePage.setInWorkStatus();
        Assertions.assertEquals("В РАБОТЕ", tasksCreatedByMePage.getStatus());
    }
    @Step("Установка статуса 'ИСПОЛНЕНО'")
    public void setExecutedStatusStep() {
        tasksCreatedByMePage.setExecutedStatus();
        Assertions.assertEquals("РЕШЕННЫЕ", tasksCreatedByMePage.getStatus());
    }

    @Step("Установка статуса 'ГОТОВО'")
    public void setCompleteStatusStep() {
        tasksCreatedByMePage.setCompleteStatus();
        Assertions.assertEquals("ГОТОВО", tasksCreatedByMePage.getStatus());
    }
}
