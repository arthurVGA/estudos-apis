package br.com.artius.api.conversao;

import br.com.artius.api.modelo.Comic;
import br.com.artius.api.vm.ComicVM;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class ComicConversor {
    private List<Comic> comics;
    private List<ComicVM> comicsVM;

    public ComicConversor jsonParaComics(final String json) {
        final Gson gson = new Gson();
        final JsonArray items = gson.fromJson(json, JsonObject.class).getAsJsonObject("data").getAsJsonArray("results");

        this.comics = items.asList()
                            .stream()
                            .map(jsonElement -> new Comic(
                                    jsonElement.getAsJsonObject().get("title").getAsString(),
                                    jsonElement.getAsJsonObject().get("startYear").getAsInt(),
                                    jsonElement.getAsJsonObject().get("endYear").getAsInt(),
                                    jsonElement.getAsJsonObject().get("type").getAsString())
                            )
                            .toList();
        return this;
    }

    public ComicConversor comicsToComicsVM() {
        this.comicsVM = comics.stream()
                                .map(ComicVM::new)
                                .toList();
        return this;
    }

    public String comicsVMToConteudoHTML() {
        final StringBuilder conteudo = new StringBuilder();
        for (ComicVM comicVM: comicsVM)
            conteudo.append(comicVM.toString());

        return conteudo.toString();
    }
}
