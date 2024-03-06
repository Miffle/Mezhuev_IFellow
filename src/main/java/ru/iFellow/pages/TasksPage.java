package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TasksPage extends Page {
    private final SelenideElement tasksCountSpan = $x("//div[@class='showing']/child::span");
    private final SelenideElement createNewTaskButton = $x("//a[@id='create_link']");
    private final SelenideElement themeInput = $x("//input[@id='summary']");
    private final SelenideElement descriptionInput = $x("//iframe[@id='mce_0_ifr']");
    private final SelenideElement frameP = $x("//p");
    private final SelenideElement applyFormButton = $x("//input[@id='create-issue-submit']");
    private final SelenideElement successMessage = $x("//div[contains(@class,'aui-message-success')]");
    private String countBeforeCreating;
    private String countAfterCreating;

    public boolean createNewTask() {
        createNewTaskButton.click();
        inputTheme();
        inputDescription();
        applyFormButton.click();
        return successMessage.should(exist).exists();
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

    public void getTotalTaskCountBeforeCreatingStep() {
        this.countBeforeCreating = this.getTotalTaskCount();
    }

    public void createNewTaskStep() {
        Assertions.assertTrue(this.createNewTask());
        refresh();
    }

    public void getTotalTaskCountAfterCreatingStep() {
        this.countAfterCreating = this.getTotalTaskCount();
    }

    public void assertCountBeforeAndAfterStep() {
        Assertions.assertNotEquals(countBeforeCreating, countAfterCreating);

    }
}
