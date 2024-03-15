package testClasses;

import hooks.WebHooks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.iFellow.steps.CreateUserSteps;

public class CreateUserTest extends WebHooks {
    private static final CreateUserSteps createUserSteps = new CreateUserSteps();
    private static String[] gottenInfo;

    @BeforeAll
    static void sendRequestAndGetResponseInfo() {
        createUserSteps.readJsonFile();
        createUserSteps.prepareReqBody();
        gottenInfo = createUserSteps.sendRequest("https://reqres.in", "/api/users", 201);
    }

    @Test
    void testName() {
        createUserSteps.assertName(gottenInfo[0]);
    }
    @Test
    void testJob() {
        createUserSteps.assertJob(gottenInfo[1]);
    }
}
