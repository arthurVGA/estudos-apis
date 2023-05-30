package br.com.artius.conversao;

import br.com.artius.dto.FilmeDTO;
import br.com.artius.html.CardHTML;
import br.com.artius.modelo.Filme;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.stream.Collectors;

public class FilmeConversor {
    private final Gson gson;

    public FilmeConversor() {
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

    public List<Filme> filmesDTOToFilmes(List<FilmeDTO> filmesDTO) {
        return filmesDTO.stream()
                        .map(this::filmesDTOToFilmes)
                        .collect(Collectors.toList());
    }
    public Filme filmesDTOToFilmes(final FilmeDTO filmesDTO) {
        return new Filme(filmesDTO);
    }

    public List<CardHTML> filmesToCards(final List<Filme> filmes) {
        return filmes.stream()
                        .map(this::filmeToCard)
                        .toList();
    }
    public CardHTML filmeToCard(final Filme filme) {
        return new CardHTML(filme);
    }
}
