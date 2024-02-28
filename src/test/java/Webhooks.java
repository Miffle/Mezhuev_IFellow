import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class Webhooks {
    @BeforeAll
    public static void initBrowser(){
        Configuration.screenshots = false;
        Configuration.baseUrl = "https://edujira.ifellow.ru/";
    }
}
