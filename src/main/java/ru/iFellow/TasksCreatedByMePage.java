package ru.iFellow;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

//https://edujira.ifellow.ru/
public class TasksCreatedByMePage extends Page {
    private final SelenideElement lastCreatedTask = $x("//ol[@class='issue-list']/li[1]/a");
    private final SelenideElement inWorkButton = $x("//a[@id='action_id_21']");
    private final SelenideElement businessProcessButton = $x("//a[@id='opsbar-transitions_more']");
    private final SelenideElement completeButton = $x("//aui-item-link[@id='action_id_31']");
    private final SelenideElement status = $x("//span[@id='status-val']/span");

    public void openLastCreatedTask() {
        lastCreatedTask.shouldBe(visible).click();
    }

    public void setInWorkStatus() {
        inWorkButton.shouldBe(visible).click();
        refresh();
    }

    public void setCompleteStatus() {
        businessProcessButton.shouldBe(visible).click();
        completeButton.shouldBe(visible).click();
        refresh();
    }

    public String getStatus() {
        return status.getText();
    }


}
