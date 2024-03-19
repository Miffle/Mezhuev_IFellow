package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class TasksCreatedByMePage extends Page {
    private final SelenideElement lastCreatedTask = $x("//ol[@class='issue-list']/li[1]/a");
    private final SelenideElement inWorkButton = $x("//a[@id='action_id_21']");
    private final SelenideElement businessProcessButton = $x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement completeButton = $x("//aui-item-link[@id='action_id_31']");
    private final SelenideElement executedButton = $x("//aui-item-link[@id='action_id_51']");
    private final SelenideElement confirmExecutedButton = $x("//input[@id='issue-workflow-transition-submit']");
    private final SelenideElement status = $x("//span[@id='status-val']/span");

    @Step("Открытие последнего созданного мной теста")
    public void openLastCreatedTask() {
        lastCreatedTask.shouldBe(visible).click();
    }

    @Step("Установка статуса 'В РАБОТЕ'. Ожидаемый результат {newStatus}")
    public void setInWorkStatus(String newStatus) {
        inWorkButton.shouldBe(visible).click();
        status.shouldHave(text(newStatus));
    }

    @Step("Установка статуса 'ГОТОВО'. Ожидаемый результат {newStatus}")
    public void setCompleteStatus(String newStatus) {
        businessProcessButton.shouldBe(visible).click();
        completeButton.shouldBe(visible).click();
        status.shouldHave(text(newStatus));
    }

    @Step("Установка статуса 'РЕШЕННЫЕ'. Ожидаемый результат {newStatus}")
    public void setExecutedStatus(String newStatus) {
        businessProcessButton.shouldBe(visible).click();
        executedButton.shouldBe(visible).click();
        confirmExecutedButton.shouldBe(visible).click();
        status.shouldHave(text(newStatus));
    }

    public String getStatus() {
        refresh();
        return status.getText();
    }


}
