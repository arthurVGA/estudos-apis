package br.com.artius.api.controller;

import br.com.artius.api.conversao.ConteudoConversor;
import br.com.artius.api.modelo.Conteudo;
import br.com.artius.api.ordenacao.ConteudoOrdenacao;
import br.com.artius.html.GeradorHTML;
import br.com.artius.protocolo.http.ClienteHttp;

import java.util.List;

import static java.util.Collections.reverse;

public class FilmeController {
    private final ConteudoConversor conversor;
    private final ClienteHttp clienteHttp;
    private final StringBuilder urlAPI;
    public FilmeController() {
        this.conversor = new ConteudoConversor();
        this.clienteHttp = new ClienteHttp();
        this.urlAPI = new StringBuilder("https://imdb-api.com/en/API");
    }

    public void pesquisaTop250Filmes(final String apiKey) {
        this.urlAPI.append("/Top250Movies/").append(apiKey);
        final String resposta = clienteHttp.enviarRequisicao(urlAPI.toString()).body();
        List<Conteudo> conteudos = conversor.jsonParaConteudoFilme(resposta);
        conteudos.sort(new ConteudoOrdenacao());

//        reverse(conteudos);

        final String conteudoHTML =  conversor.conteudoToHTML(conteudos);
        new GeradorHTML("Top 250 Filmes")
                .getConteudo(conteudoHTML);
    }
}
