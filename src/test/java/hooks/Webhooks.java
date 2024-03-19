package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import ru.iFellow.helpers.CustomAllureSelenide;
import ru.iFellow.properties.Props;

public class Webhooks {
    protected final Props props = new Props();

    @BeforeAll
    public static void initBrowser() {
        SelenideLogger.addListener("CustomAllureSelenide", new CustomAllureSelenide());
        Configuration.baseUrl = "https://edujira.ifellow.ru/";
    }
}
