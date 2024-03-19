package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SprintsPage extends Page {

    private final SelenideElement fixForVersion = $x("//span[@class='shorten']/child::a");
    private final SelenideElement taskStatus = $x("//strong[@title='Статус']/following-sibling::span[@class='value']");

    @Step("Проверка поля 'Исправить в версиях'. Ожидаемый результат {version}")
    public void checkFixForVersion(String version) {
        fixForVersion.shouldBe(visible).shouldHave(text(version));
    }

    @Step("Проверка статуса задачи. Ожидаемый результат {status}")
    public void checkTaskStatus(String status) {
        taskStatus.shouldBe(visible).shouldHave(text(status));
    }

}
