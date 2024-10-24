package ru.mirea.solovyev.rickmorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty("info")
    private Info info;

    @JsonProperty("results")
    List<Episode> results;

    public List<Episode> getResults() {
        return results;
    }

    public Info getInfo() {
        return info;
    }

}
