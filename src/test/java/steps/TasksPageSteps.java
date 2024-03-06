package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.TasksPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TasksPageSteps {
    private TasksPage tasksPage;

    @Дано("Страница задач")
    public void openTab() {
        tasksPage = open("projects/TEST/issues?filter=allissues", TasksPage.class);
        getWebDriver().manage().window().maximize();
        if (tasksPage.checkAuthorization()) {
            tasksPage.login("AT7", "Qwerty123");
        }
    }

    @Также("Возьмём количество задач до создания теста")
    public void getTasksCountBefore() {
        tasksPage.getTotalTaskCountBeforeCreatingStep();
    }

    @Тогда("Создадим новую задачу")
    public void createNewTask() {
        tasksPage.createNewTaskStep();
    }

    @И("Получим количество задач после создания теста")
    public void getTasksCountAfter() {
        tasksPage.getTotalTaskCountAfterCreatingStep();
    }

    @Тогда("Сравним количество до и после создания")
    public void assertCounts() {
        tasksPage.assertCountBeforeAndAfterStep();
    }
}

