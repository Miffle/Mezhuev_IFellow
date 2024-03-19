package pages;

import hooks.Webhooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.TasksPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TasksPageTest extends Webhooks {
    private TasksPage tasksPage;


    @BeforeEach
    public void openTab() {
        tasksPage = open("projects/TEST/issues?filter=allissues", TasksPage.class);
        getWebDriver().manage().window().maximize();
        if (tasksPage.checkAuthorization()) {
            tasksPage.login(props.getLogin(), props.getPassword());
        }
    }

    @Test
    @DisplayName("Создание новой задачи")
    public void testTaskCreation() {
        tasksPage.getTotalTaskCountBeforeCreatingStep();
        tasksPage.createNewTaskStep();
        tasksPage.getTotalTaskCountAfterCreatingStep();
        tasksPage.assertCountBeforeAndAfterStep();
    }

}
