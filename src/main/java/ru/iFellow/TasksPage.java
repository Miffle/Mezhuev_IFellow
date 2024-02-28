package ru.iFellow;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public class TasksPage extends Page {
    private final SelenideElement tasksCountSpan = $x("//div[@class='showing']/child::span");
    private final SelenideElement createNewTaskButton = $x("//a[@id='create_link']");
    private final SelenideElement themeInput = $x("//input[@id='summary']");
    private final SelenideElement descriptionInput = $x("//div[@id='description-wiki-edit']/textarea[@id='description']");
    private final SelenideElement applyFormButton = $x("//input[@id='create-issue-submit']");
    private final SelenideElement successMessage = $x("//div[contains(@class,'aui-message-success')]");

    public boolean createNewTask() {
        createNewTaskButton.click();
        themeInput.sendKeys("IDK");
        descriptionInput.sendKeys("IDK2");
        applyFormButton.click();
        return successMessage.should(exist).exists();
    }


    public String getTotalTaskCount() {
        return tasksCountSpan.shouldBe(visible).getText().split(" ")[2];
    }
}
