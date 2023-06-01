package br.com.artius.api.controller;

import br.com.artius.api.conversao.FilmeConversor;
import br.com.artius.html.GeradorHTML;
import br.com.artius.protocolo.http.ClienteHttp;

public class FilmeController {
    private final FilmeConversor filmeConversor;
    private final ClienteHttp clienteHttp;
    private final String urlAPI;
    public FilmeController() {
        this.filmeConversor = new FilmeConversor();
        this.clienteHttp = new ClienteHttp();
        this.urlAPI = "https://imdb-api.com/en/API";
    }

    public void pesquisaTop250Filmes(final String apiKey) {
        final String resposta = clienteHttp.enviarRequisicao(this.urlAPI + "/Top250Movies/" + apiKey).body();
        final String conteudoHTML = filmeConversor.jsonParaFilmes(resposta)
                                                    .filmesToFilmesVM()
                                                    .filmesVMToConteudoHTML();

        new GeradorHTML("Top 250 Filmes")
                .getConteudo(conteudoHTML);
    }
}
