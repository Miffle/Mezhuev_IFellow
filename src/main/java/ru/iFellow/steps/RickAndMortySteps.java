package ru.iFellow.steps;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import ru.iFellow.models.CartoonCharacter;
import ru.iFellow.models.LastCharacter;
import ru.iFellow.models.Morty;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class RickAndMortySteps {
    private final Morty morty = new Morty();
    private ArrayList<String> allCharactersInEpisode;
    private final LastCharacter lastCharacter = new LastCharacter();

    public void getInfoAboutCharacters(String baseUri, int statusCode) {
        getInformationAboutMorty(baseUri, statusCode);
        getInfoAboutLastEpisodeWithMorty(statusCode);
        getInformationAboutLastCharacter(statusCode);
    }

    public void getInformationAboutMorty(String baseUri, int statusCode) {
        Response response = given()
                .baseUri(baseUri)
                .get()
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract().response();
        fillInfoAboutCharacter(morty, response);
        morty.setAllEpisodesWithMorty(response.body().path("episode"));
    }

    public void getInfoAboutLastEpisodeWithMorty(int statusCode) {
        Response response = given()
                .baseUri(morty.getLastMortyEpisodeUri())
                .get()
                .then()
                .statusCode(statusCode)
                .extract().response();
        allCharactersInEpisode = response.body().path("characters");
    }

    public void getInformationAboutLastCharacter(int statusCode) {
        Response response = given()
                .baseUri(allCharactersInEpisode.get(allCharactersInEpisode.size() - 1))
                .get()
                .then()
                .statusCode(statusCode)
                .extract().response();
        fillInfoAboutCharacter(lastCharacter, response);
    }

    private void fillInfoAboutCharacter(CartoonCharacter character, Response response) {
        character.setLocation(response.body().path("location.name"));
        character.setSpecies(response.body().path("species"));
    }

    public void assertLocation() {
        Assertions.assertNotEquals(morty.getLocation(), lastCharacter.getLocation(), "Персонажи находятся в одной локациях");
    }

    public void assertSpecies() {
        Assertions.assertEquals(morty.getSpecies(), lastCharacter.getSpecies(), "Персонажи разной расы");
    }
}
