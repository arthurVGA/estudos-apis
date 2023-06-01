package br.com.artius.api.conversao;

import br.com.artius.api.modelo.Filme;
import br.com.artius.api.vm.FilmeVM;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class FilmeConversor {
    private List<Filme> filmes;
    private List<FilmeVM> filmesVM;

    public FilmeConversor jsonParaFilmes(final String json) {
        final Gson gson = new Gson();
        final JsonArray items = gson.fromJson(json, JsonObject.class).getAsJsonArray("items");

        this.filmes = items.asList()
                        .stream()
                        .map(jsonElement -> new Filme(
                                jsonElement.getAsJsonObject().get("rank").getAsString(),
                                jsonElement.getAsJsonObject().get("title").getAsString(),
                                jsonElement.getAsJsonObject().get("year").getAsString(),
                                jsonElement.getAsJsonObject().get("imDbRating").getAsString(),
                                jsonElement.getAsJsonObject().get("image").getAsString())
                        )
                        .toList();
        return this;
    }

    public FilmeConversor filmesToFilmesVM() {
        this.filmesVM = filmes.stream()
                            .map(FilmeVM::new)
                            .toList();
        return this;
    }

    public String filmesVMToConteudoHTML() {
        final StringBuilder conteudo = new StringBuilder();
        for (FilmeVM filme: filmesVM)
            conteudo.append(filme.toString());

        return conteudo.toString();
    }
}
