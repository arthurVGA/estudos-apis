package br.com.artius.api.controller;

import br.com.artius.api.conversao.ConteudoConversor;
import br.com.artius.api.modelo.Conteudo;
import br.com.artius.api.ordenacao.ConteudoOrdenacao;
import br.com.artius.html.GeradorHTML;
import br.com.artius.protocolo.http.ClienteHttp;

import java.util.List;

import static java.util.Collections.reverse;

public class ComicController {
    private final ConteudoConversor conversor;
    private final ClienteHttp clienteHttp;
    private final StringBuilder urlAPI;
    public ComicController() {
        this.conversor = new ConteudoConversor();
        this.clienteHttp = new ClienteHttp();
        this.urlAPI = new StringBuilder("https://gateway.marvel.com:443/v1/public/");
    }

    public void pesquisaSeries(final String apiKey, final String hash) {
        this.urlAPI.append("series?ts=1&apikey=").append(apiKey).append("&hash=").append(hash);
        final String resposta = clienteHttp.enviarRequisicao(urlAPI.toString()).body();
        final List<Conteudo> conteudos = conversor.jsonParaConteudoHQ(resposta);
        reverse(conteudos);

        new GeradorHTML("Marvel Comics").getConteudo(conversor.conteudoToHTML(conteudos));
    }
}
