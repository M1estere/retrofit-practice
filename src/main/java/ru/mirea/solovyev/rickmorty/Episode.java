package ru.mirea.solovyev.rickmorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Episode {

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private int id;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String name;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String air_date;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String episode;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<String> characters;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String url;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String created;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAirDate() {
        return air_date;
    }

    public String getEpisode() {
        return episode;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }
}
