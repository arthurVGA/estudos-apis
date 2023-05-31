package br.com.artius.controller;

import br.com.artius.conversao.ImdbJsonConversor;
import br.com.artius.dto.FilmeDTO;
import br.com.artius.html.HTMLGenerator;
import br.com.artius.protocolo.http.ClienteHttp;

import java.util.List;

public class FilmeController {
    private final ImdbJsonConversor imdbJsonConversor;
    private final ClienteHttp clienteHttp;
    public FilmeController() {
        this.imdbJsonConversor = new ImdbJsonConversor();
        this.clienteHttp = new ClienteHttp();
    }

    public void pesquisaTop250Filmes(final String apiKey) {
        clienteHttp.pesquisaTop250Movies(apiKey);
        List<FilmeDTO> filmesDTO = imdbJsonConversor.jsonParaFilmesDTO(clienteHttp.enviaRequisicao().body() );

        new HTMLGenerator("Top 250 Filmes")
                .geraHTML(filmesDTO);
    }
}
