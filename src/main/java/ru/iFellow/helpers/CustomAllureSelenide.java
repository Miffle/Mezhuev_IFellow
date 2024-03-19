package ru.iFellow.helpers;

import io.qameta.allure.selenide.AllureSelenide;

public class CustomAllureSelenide extends AllureSelenide {
    public CustomAllureSelenide() {
        super();
        this.screenshots(false);
        this.savePageSource(false);
    }
}
