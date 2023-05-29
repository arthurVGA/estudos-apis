package br.com.artius;

import br.com.artius.conversao.Conversor;
import br.com.artius.dto.FilmeDTO;
import br.com.artius.modelo.Filme;
import br.com.artius.protocolo.http.ClienteHttp;
import br.com.artius.protocolo.http.HttpRequisicao;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conversor conversor = new Conversor();

        HttpRequisicao requisicao;
        ClienteHttp clienteHttp;

        System.out.println("API Key: ");
        final String key = sc.nextLine();

        requisicao = new HttpRequisicao(key);
        clienteHttp = new ClienteHttp(requisicao);

        List<FilmeDTO> filmesDTO = conversor.jsonParaFilmesDTO( clienteHttp.enviaRequisicao().body() );
        List<Filme> filmes = conversor.filmesDTOToFilmes(filmesDTO);
        System.out.println("Response: ");
        for (Filme filme : filmes)
            System.out.println("Rank: " + filme.rank() + ", Rating: " + filme.rating() + ", Título: " + filme.titulo() + ", Ano: " + filme.year());

        sc.close();
    }
}
