package br.com.artius.conversao;

import br.com.artius.dto.FilmeDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class ImdbJsonConversor {
    private final Gson gson;

    public ImdbJsonConversor() {
        this.gson = new Gson();
    }

    public List<FilmeDTO> jsonParaFilmesDTO(final String json) {
        final JsonArray items = gson.fromJson(json, JsonObject.class).getAsJsonArray("items");

        return items.asList()
                .stream()
                .map(jsonElement -> new FilmeDTO(
                        jsonElement.getAsJsonObject().get("rank").getAsString(),
                        jsonElement.getAsJsonObject().get("title").getAsString(),
                        jsonElement.getAsJsonObject().get("year").getAsString(),
                        jsonElement.getAsJsonObject().get("imDbRating").getAsString(),
                        jsonElement.getAsJsonObject().get("image").getAsString())
                )
                .toList();
    }
}
