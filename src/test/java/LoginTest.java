import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.iFellow.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginTest extends Webhooks{
    @Test
    public void loginTest(){
        LoginPage loginPage = open("/", LoginPage.class);
        getWebDriver().manage().window().maximize();
        loginPage.insertUsername("AT7", "Qwerty123");
        Assertions.assertFalse(loginPage.checkHeaderLoginButtonExistence());
    }
}
