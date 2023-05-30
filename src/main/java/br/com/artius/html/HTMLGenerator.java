package br.com.artius.html;

import br.com.artius.conversao.FilmeConversor;
import br.com.artius.html.io.HTMLWriter;
import br.com.artius.modelo.Filme;

import java.util.List;

public class HTMLGenerator {
    private final List<Filme> filmes;
    private final String tituloHTML;
    private final HTMLWriter writer;

    public HTMLGenerator(final String tituloHTML, final List<Filme> filmes) {
        final String fileName = tituloHTML + ".html";
        this.writer = new HTMLWriter(fileName.replaceAll(" ", ""));
        this.tituloHTML = tituloHTML;
        this.filmes = filmes;
    }

    private String body() {
        final StringBuilder body = new StringBuilder();
        final List<CardHTML> cards = new FilmeConversor().filmesToCards(filmes);

        for(CardHTML card : cards)
            body.append(card.toString());

        return body.toString();
    }

    public void gerarHTML() {
        final DocumentoHTML html = new DocumentoHTML(tituloHTML, body());
        this.writer.writeHTML(html.toString());
    }

}
