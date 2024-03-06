package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;

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

    public void openLastCreatedTask() {
        lastCreatedTask.shouldBe(visible).click();
    }

    public void setInWorkStatus() {
        inWorkButton.shouldBe(visible).click();
        status.shouldHave(text("В РАБОТЕ"));
    }

    public void setCompleteStatus() {
        businessProcessButton.shouldBe(visible).click();
        completeButton.shouldBe(visible).click();
        status.shouldHave(text("ГОТОВО"));
    }

    public void setExecutedStatus() {
        businessProcessButton.shouldBe(visible).click();
        executedButton.shouldBe(visible).click();
        confirmExecutedButton.shouldBe(visible).click();
        status.shouldHave(text("РЕШЕННЫЕ"));
    }

    public String getStatus() {
        refresh();
        return status.getText();
    }

}
