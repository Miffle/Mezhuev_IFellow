package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import ru.iFellow.helpers.CustomAllureSelenide;
import ru.iFellow.properties.Props;

import static org.junit.platform.commons.util.StringUtils.isNotBlank;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class Webhooks {
    @BeforeAll
    public static void initBrowser() {
        String path = Props.PROPS.getChromedriverLocation();
        if (isNotBlank(path)) {
            System.setProperty(CHROME_DRIVER_EXE_PROPERTY, path);
        }
        SelenideLogger.addListener("CustomAllureSelenide", new CustomAllureSelenide());
        Configuration.baseUrl = Props.PROPS.getBaseUrl();
    }
}
