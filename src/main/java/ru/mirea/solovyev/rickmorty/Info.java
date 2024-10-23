package ru.mirea.solovyev.rickmorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private int count;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private int pages;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String next;

    @JsonProperty
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String prev;

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

    public String getNext() {
        return next;
    }

    public String getPrev() {
        return prev;
    }
}
