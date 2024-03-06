package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SprintsPage extends Page {

    private final SelenideElement fixForVersion = $x("//span[@class='shorten']/child::a");
    private final SelenideElement taskStatus = $x("//strong[@title='Статус']/following-sibling::span[@class='value']");

    public String checkFixForVersion() {
        return fixForVersion.shouldBe(visible).getText();
    }

    public String checkTaskStatus() {
        return taskStatus.shouldBe(visible).getText();
    }

}
