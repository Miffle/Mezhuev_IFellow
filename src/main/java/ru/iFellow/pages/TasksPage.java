package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TasksPage extends Page {
    private final SelenideElement tasksCountSpan = $x("//div[@class='showing']/child::span").as("Количество задач");
    private final SelenideElement createNewTaskButton = $x("//a[@id='create_link']").as("Кнопка создания нового задачи");
    private final SelenideElement themeInput = $x("//input[@id='summary']").as("Поле для ввода темы задачи");
    private final SelenideElement descriptionInput = $x("//iframe[@id='mce_0_ifr']").as("Фрейм описания");
    private final SelenideElement frameP = $x("//p").as("Поле ввода описания задачи");
    private final SelenideElement applyFormButton = $x("//input[@id='create-issue-submit']").as("Кнопка подтверждения создания");
    private final SelenideElement successMessage = $x("//div[contains(@class,'aui-message-success')]").as("Уведомление об успешном создании задачи");
    private String countBeforeCreating;
    private String countAfterCreating;

    @Step("Проверка появления сообщения об успешном создании задачи")
    public void createNewTaskStep() {
        createNewTaskButton.click();
        inputTheme();
        inputDescription();
        applyFormButton.click();
        successMessage.should(exist);
    }

    @Step("Получение количества всех задач до создания новой")
    public void getTotalTaskCountBeforeCreatingStep() {
        countBeforeCreating = getTotalTaskCount();
    }

    @Step("Получение количества всех задач после создания новой")
    public void getTotalTaskCountAfterCreatingStep() {
        refresh();
        countAfterCreating = getTotalTaskCount();
    }

    @Step("Проверка изменения общего количества задач после создания новой")
    public void assertCountBeforeAndAfterStep() {

        Assertions.assertNotEquals(countBeforeCreating, countAfterCreating);

    }

    private void inputTheme() {
        themeInput.sendKeys("IDK");
    }

    private void inputDescription() {
        switchTo().frame(descriptionInput);
        frameP.setValue("IDK2");
        switchTo().defaultContent();
    }

    public String getTotalTaskCount() {
        return tasksCountSpan.shouldBe(visible).getText().split(" ")[2];
    }
}
