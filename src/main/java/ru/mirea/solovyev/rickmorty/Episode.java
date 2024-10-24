package ru.mirea.solovyev.rickmorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("characters")
    private List<String> characters;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCharacters() {
        return characters;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nTitle: %s\nCharacters: %d", id, name, characters.size());
    }
}
