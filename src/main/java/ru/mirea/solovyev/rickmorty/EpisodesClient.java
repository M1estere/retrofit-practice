package ru.mirea.solovyev.rickmorty;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class EpisodesClient {

    public static void main(String[] args) throws IOException {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();

        EpisodeService episodeService = client.create(EpisodeService.class);

        Response<Result> response = episodeService.getEpisodes(1).execute();
        if (response.isSuccessful() == false || response.body() == null) {
            System.out.println("Ошибка: " + response.code());
            return;
        }

        Result result = response.body();

        Episode maxCharactersEpisode = null;
        int maxCharacters = 0;
        for (Episode episode : result.getResults()) {
            int charactersCount = episode.getCharacters().size();

            if (charactersCount > maxCharacters) {
                maxCharacters = charactersCount;
                maxCharactersEpisode = episode;
            }
        }

        System.out.println("Max characters: " + maxCharacters);
        System.out.println("Episode title: " + maxCharactersEpisode.getName());
    }

}
