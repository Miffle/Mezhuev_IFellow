import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.iFellow.ProjectPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProjectPageTest extends Webhooks {
    @Test
    public void testSeleniumTask(){
        ProjectPage projectPage = open("", ProjectPage.class);
        getWebDriver().manage().window().maximize();
        Assertions.assertEquals("Version 2.0", projectPage.checkTestSeleniumTask());
    }
}
