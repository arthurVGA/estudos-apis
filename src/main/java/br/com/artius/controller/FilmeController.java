package br.com.artius.controller;

import br.com.artius.conversao.FilmeConversor;
import br.com.artius.dto.FilmeDTO;
import br.com.artius.html.HTMLGenerator;
import br.com.artius.modelo.Filme;
import br.com.artius.protocolo.http.ClienteHttp;
import br.com.artius.protocolo.http.HttpRequisicao;

import java.util.List;

public class FilmeController {

    private final FilmeConversor filmeConversor;

    public FilmeController() {
        this.filmeConversor = new FilmeConversor();
    }

    public void getTop250Filmes(final String apiKey) {
        HttpRequisicao requisicao = new HttpRequisicao(apiKey);
        ClienteHttp clienteHttp = new ClienteHttp(requisicao);

        List<FilmeDTO> filmesDTO = filmeConversor.jsonParaFilmesDTO( clienteHttp.enviaRequisicao().body() );
        List<Filme> filmes = filmeConversor.filmesDTOToFilmes(filmesDTO);

        HTMLGenerator gerador = new HTMLGenerator("Top 250 Filmes", filmes);
        gerador.gerarHTML();
    }
}
