package br.com.artius.imdb.conversao;

import br.com.artius.imdb.dto.FilmeDTO;
import br.com.artius.html.modelo.Card;

import java.util.List;

public class FilmeIMDBConversor {

    public List<Card> filmesToCards(final List<FilmeDTO> filmes) {
        return filmes.stream()
                        .map(this::filmeToCard)
                        .toList();
    }
    public Card filmeToCard(final FilmeDTO filme) {
        return new Card(filme);
    }
}
