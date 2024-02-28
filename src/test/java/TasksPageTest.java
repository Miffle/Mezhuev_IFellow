import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.iFellow.TasksPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TasksPageTest extends Webhooks {
    private TasksPage tasksPage;
    private String countBeforeCreating;
    private String countAfterCreating;

    @BeforeEach
    public void openTab() {
        tasksPage = open("projects/TEST/issues?filter=allissues", TasksPage.class);
        getWebDriver().manage().window().maximize();
        if (tasksPage.checkAuthorization()) {
            tasksPage.login("AT7", "Qwerty123");
        }
    }

    @Test
    public void testTaskCreation() {
        getTotalTaskCountBeforeCreatingStep();
        createNewTaskStep();
        getTotalTaskCountAfterCreatingStep();
        assertCountBeforeAndAfterStep();
    }

    @Step("Получение количества всех задач до создания новой")
    public void getTotalTaskCountBeforeCreatingStep() {
        countBeforeCreating = tasksPage.getTotalTaskCount();
    }

    @Step("Проверка появления сообщения об успешном создании задачи")
    public void createNewTaskStep() {
        Assertions.assertTrue(tasksPage.createNewTask());
        refresh();
    }

    @Step("Получение количества всех задач после создания новой")
    public void getTotalTaskCountAfterCreatingStep() {
        countAfterCreating = tasksPage.getTotalTaskCount();
    }

    @Step("Проверка изменения общего количества задач после создания новой")
    public void assertCountBeforeAndAfterStep() {
        Assertions.assertNotEquals(countBeforeCreating, countAfterCreating);

    }
}
