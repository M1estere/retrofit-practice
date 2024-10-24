package ru.mirea.solovyev.rickmorty;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class EpisodesClient {

    private static final String BASE_URL = "https://rickandmortyapi.com/api/";

    public static void main(String[] args) throws IOException {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();

        EpisodeService episodeService = client.create(EpisodeService.class);
        fetchEpisodes(episodeService, 1, null);
    }

    private static void fetchEpisodes(EpisodeService episodeService, int page, Episode maxCharactersEpisode) throws IOException {
        Response<Result> response = episodeService.getEpisodes(page).execute();
        if (response.isSuccessful() == false || response.body() == null) {
            System.out.println("Ошибка: " + response.code());
            return;
        }

        Result result = response.body();

        for (Episode episode : result.getResults()) {
            int charactersCount = episode.getCharacters().size();

            if (maxCharactersEpisode == null || charactersCount > maxCharactersEpisode.getCharacters().size()) {
                maxCharactersEpisode = episode;
            }
        }

        if (page < response.body().getInfo().getPages()) {
            fetchEpisodes(episodeService, page + 1, maxCharactersEpisode);
        } else {
            System.out.println(maxCharactersEpisode);
        }
    }

}
