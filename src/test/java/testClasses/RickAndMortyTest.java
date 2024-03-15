package testClasses;

import hooks.WebHooks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.iFellow.steps.RickAndMortySteps;

public class RickAndMortyTest extends WebHooks {
    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();

    @BeforeAll
    static void getAllInfo() {
        rickAndMortySteps.getInfoAboutCharacters("https://rickandmortyapi.com/api/character/2", 200);
    }


    @Test
    void locationTest() {
        rickAndMortySteps.assertLocation();
    }

    @Test
    void speciesTest() {
        rickAndMortySteps.assertSpecies();
    }
}
