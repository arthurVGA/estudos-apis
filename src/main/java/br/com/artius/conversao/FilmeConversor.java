package br.com.artius.conversao;

import br.com.artius.dto.FilmeDTO;
import br.com.artius.html.CardHTML;

import java.util.List;

public class FilmeConversor {

    public List<CardHTML> filmesToCards(final List<FilmeDTO> filmes) {
        return filmes.stream()
                        .map(this::filmeToCard)
                        .toList();
    }
    public CardHTML filmeToCard(final FilmeDTO filme) {
        return new CardHTML(filme);
    }
}
