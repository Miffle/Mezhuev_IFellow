package ru.iFellow;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

// url =
public class ProjectPage {
    private final SelenideElement tasksButton = $x("//span[@title='Задачи']");
    private final SelenideElement tasksCountSpan = $x("//div[@class='showing']/child::span");
    private final SelenideElement testSeleniumTask = $x("//div[@class='ghx-summary' and @title='TestSelenium']");
    private final SelenideElement fixForeVersion = $x("//span[@class='shorten']/child::a");
    private final SelenideElement projectsButton = $x("//a[@href='/browse/TEST']");
    private final SelenideElement testProjectsButton = $x("//a[@id='admin_main_proj_link_lnk']");

    public String checkTestSeleniumTask() {
        projectsButton.shouldBe(visible).click();
        testProjectsButton.shouldBe(visible).click();
        testSeleniumTask.shouldBe(visible).click();
        return fixForeVersion.shouldBe(visible).getText();
    }
}
