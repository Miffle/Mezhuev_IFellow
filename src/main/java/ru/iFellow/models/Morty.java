package ru.iFellow.models;

import java.util.ArrayList;

public class Morty extends CartoonCharacter{
    private ArrayList<String> allEpisodesWithMorty = new ArrayList<>();
    private String lastMortyEpisodeUri;

    public void setAllEpisodesWithMorty(ArrayList<String> allEpisodesWithMorty) {
        this.allEpisodesWithMorty = allEpisodesWithMorty;
        this.setLastMortyEpisodeUri();
    }
    private void setLastMortyEpisodeUri(){
        lastMortyEpisodeUri = allEpisodesWithMorty.get(allEpisodesWithMorty.size()-1);
    }

    public String getLastMortyEpisodeUri() {
        return lastMortyEpisodeUri;
    }

    @Override
    public String toString() {
        return "Morty{" +
                "lastMortyEpisodeUri='" + lastMortyEpisodeUri + '\'' +
                "} " + super.toString();
    }
}
