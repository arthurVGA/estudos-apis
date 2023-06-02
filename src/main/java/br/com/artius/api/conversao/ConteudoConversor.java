package br.com.artius.api.conversao;

import br.com.artius.api.modelo.Conteudo;
import br.com.artius.api.ordenacao.ConteudoOrdenacao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.stream.Collectors;

public class ConteudoConversor {
    public List<Conteudo> jsonParaConteudoFilme(final String json) {
        final Gson gson = new Gson();
        final JsonArray items = gson.fromJson(json, JsonObject.class).getAsJsonArray("items");

        return items.asList()
                        .stream()
                        .map(this::jsonParaConteudoFilme)
                        .collect(Collectors.toList());
    }

    public List<Conteudo> jsonParaConteudoHQ(final String json) {
        final Gson gson = new Gson();
        final JsonArray items = gson.fromJson(json, JsonObject.class).getAsJsonObject("data").getAsJsonArray("results");

        return items.asList()
                .stream()
                .map(this::jsonParaConteudoHQ)
                .sorted(new ConteudoOrdenacao())
                .toList();
    }
    public Conteudo jsonParaConteudoFilme(final JsonElement jsonElement) {
        return new Conteudo(
                jsonElement.getAsJsonObject().get("image").getAsString(),
                jsonElement.getAsJsonObject().get("title").getAsString(),
                jsonElement.getAsJsonObject().get("year").getAsString(),
                jsonElement.getAsJsonObject().get("imDbRating").getAsString());
    }
    public Conteudo jsonParaConteudoHQ(final JsonElement jsonElement) {
        return new Conteudo(
                jsonElement.getAsJsonObject().get("thumbnail").getAsJsonObject().get("path").getAsString(),
                jsonElement.getAsJsonObject().get("title").getAsString(),
                jsonElement.getAsJsonObject().get("startYear").getAsString(),
                jsonElement.getAsJsonObject().get("rating").getAsString());
    }


    public String conteudoToHTML(final List<Conteudo> conteudos) {
        final StringBuilder conteudo = new StringBuilder();

        for (Conteudo filme: conteudos)
            conteudo.append(filme.toString());

        return conteudo.toString();
    }
}
