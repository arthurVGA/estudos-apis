package br.com.artius.api.controller;

import br.com.artius.api.conversao.ComicConversor;
import br.com.artius.html.GeradorHTML;
import br.com.artius.protocolo.http.ClienteHttp;

import java.time.Instant;
import java.time.ZoneOffset;

public class ComicController {
    private final ComicConversor comicConversor;
    private final ClienteHttp clienteHttp;
    private final String urlAPI;
    public ComicController() {
        this.comicConversor = new ComicConversor();
        this.clienteHttp = new ClienteHttp();
        this.urlAPI = "https://gateway.marvel.com:443/v1/public/";
    }

    public void pesquisaSeries(final String apiKey, final String hash) {
        final String requestURL = this.urlAPI + "series?ts=1&apikey=" + apiKey + "&hash=" + hash;
        final String resposta = clienteHttp.enviarRequisicao(requestURL).body();
        System.out.println(resposta);
        final String conteudoHTML = comicConversor
                .jsonParaComics(resposta)
                .comicsToComicsVM()
                .comicsVMToConteudoHTML();
        new GeradorHTML("Marvel Comics").getConteudo(conteudoHTML);
    }
}
