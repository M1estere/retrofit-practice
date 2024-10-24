package ru.mirea.solovyev.rickmorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    @JsonProperty("count")
    private int count;

    @JsonProperty("pages")
    private int pages;

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

}
