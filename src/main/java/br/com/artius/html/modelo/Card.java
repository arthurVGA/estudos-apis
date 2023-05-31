package br.com.artius.html.modelo;

import br.com.artius.html.TemplateHTML;
import br.com.artius.imdb.dto.FilmeDTO;

public class Card {

    private final String cartaz;
    private final String rank;
    private final String titulo;
    private final String ano;
    private final String nota;

    public Card(final FilmeDTO filmeDTO) {
        this.cartaz = filmeDTO.url();
        this.rank = filmeDTO.rank();
        this.titulo = filmeDTO.title();
        this.ano = filmeDTO.year();
        this.nota = filmeDTO.rating();
    }

    @Override
    public String toString() {
        return TemplateHTML.CARD
                        .replace("${cartaz}", cartaz)
                        .replace("${rank}", rank)
                        .replace("${titulo}", titulo)
                        .replace("${ano}", ano)
                        .replace("${nota}", nota);
    }
}
