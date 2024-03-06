package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.pages.TasksCreatedByMePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TasksCreatedByMeSteps {
    private TasksCreatedByMePage tasksCreatedByMePage;

    @Дано("Страница тестов созданных мной")
    public void openTab() {
        tasksCreatedByMePage = open("projects/TEST/issues?filter=reportedbyme", TasksCreatedByMePage.class);
        getWebDriver().manage().window().maximize();
        if (tasksCreatedByMePage.checkAuthorization()) {
            tasksCreatedByMePage.login("AT7", "Qwerty123");
        }

    }

    @Тогда("Смена статуса на В РАБОТЕ")
    public void setInWorkStatusTest() {
        tasksCreatedByMePage.openLastCreatedTask();
        tasksCreatedByMePage.setInWorkStatus();
        Assertions.assertEquals("В РАБОТЕ", tasksCreatedByMePage.getStatus());
    }

    @Тогда("Смена статуса на РЕШЕННЫЕ")
    public void setExecutedStatusTest() {
        tasksCreatedByMePage.openLastCreatedTask();
        tasksCreatedByMePage.setExecutedStatus();
        Assertions.assertEquals("РЕШЕННЫЕ", tasksCreatedByMePage.getStatus());
    }

    @Тогда("Смена статуса на ГОТОВО")
    public void setCompleteStatusTest() {
        tasksCreatedByMePage.openLastCreatedTask();
        tasksCreatedByMePage.setCompleteStatus();
        Assertions.assertEquals("ГОТОВО", tasksCreatedByMePage.getStatus());
    }
}
