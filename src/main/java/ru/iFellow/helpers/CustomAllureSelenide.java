package ru.iFellow.helpers;

import io.qameta.allure.selenide.AllureSelenide;

public class CustomAllureSelenide extends AllureSelenide {
    @Override
    public AllureSelenide screenshots(boolean saveScreenshots) {
        return super.screenshots(true);
    }

    @Override
    public AllureSelenide savePageSource(boolean saveScreenshots) {
        return super.savePageSource(true);
    }
}
