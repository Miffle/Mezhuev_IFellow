package ru.iFellow.steps;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.given;

public class CreateUserSteps {
    private JSONObject reqBody;

    public void readJsonFile() {
        try {
            reqBody = new JSONObject(Files.readAllBytes(Path.of("src/test/resources/paren.json")));
        } catch (IOException e) {
            System.out.println("Не могу прочитать файл");
        }
    }

    public void prepareReqBody() {
        reqBody.put("name", "Tomato");
        reqBody.put("job", "Eat maket");
    }

    public JSONObject getReqBody() {
        return reqBody;
    }

    /**
     * Отправляет запрос и возвращает массив с двумя элементами.
     *
     * @param baseUrl    неизменяемая ссылка
     * @param postUrl    ссылка для доступа к API
     * @param statusCode ожидаемый статус ответа
     * @return массив. 0 - name, 1 - job
     */
    public String[] sendRequest(String baseUrl, String postUrl, int statusCode) {
        Response response = given()
                .header("Content-type", "application/json")
                .header("charset", "utf-8")
                .baseUri(baseUrl)
                .body(getReqBody().toString())
                .when()
                .post(postUrl)
                .then()
                .statusCode(statusCode)
                .extract().response();
        return new String[]{response.body().path("name"), response.body().path("job")};

    }

    public void assertName(String respName) {
        Assertions.assertEquals(reqBody.get("name").toString(), respName);

    }

    public void assertJob(String respJob) {
        Assertions.assertEquals(reqBody.get("job").toString(), respJob);

    }
}
