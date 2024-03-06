package webhooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeStep;

public class Webhooks {
    @BeforeStep
    public static void initBrowser() {
        Configuration.screenshots = false;
        Configuration.baseUrl = "https://edujira.ifellow.ru/";
    }
}
