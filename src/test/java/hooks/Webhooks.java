package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import ru.iFellow.helpers.CustomAllureSelenide;

public class Webhooks {

    @BeforeAll
    public static void initBrowser() {
        SelenideLogger.addListener("CustomAllureSelenide", new CustomAllureSelenide());
        Configuration.baseUrl = "https://edujira.ifellow.ru/";
    }
}
