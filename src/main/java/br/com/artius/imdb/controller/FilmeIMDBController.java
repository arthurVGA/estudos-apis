package br.com.artius.imdb.controller;

import br.com.artius.imdb.conversao.JsonIMDBConversor;
import br.com.artius.imdb.dto.FilmeDTO;
import br.com.artius.html.HTMLGenerator;
import br.com.artius.protocolo.http.ClienteHttp;

import java.util.List;

public class FilmeIMDBController {
    private final JsonIMDBConversor jsonIMDBConversor;
    private final ClienteHttp clienteHttp;
    public FilmeIMDBController() {
        this.jsonIMDBConversor = new JsonIMDBConversor();
        this.clienteHttp = new ClienteHttp();
    }

    public void pesquisaTop250Filmes(final String apiKey) {
        clienteHttp.pesquisaTop250Movies(apiKey);
        List<FilmeDTO> filmesDTO = jsonIMDBConversor.jsonParaFilmesDTO(clienteHttp.enviaRequisicao().body() );

        new HTMLGenerator("Top 250 Filmes")
                .geraHTML(filmesDTO);
    }
}
