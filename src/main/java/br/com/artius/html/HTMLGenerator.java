package br.com.artius.html;

import br.com.artius.conversao.FilmeConversor;
import br.com.artius.dto.FilmeDTO;
import br.com.artius.html.io.HTMLWriter;

import java.util.List;

public class HTMLGenerator {
    private final String tituloHTML;
    private final HTMLWriter writer;

    public HTMLGenerator(final String tituloHTML) {
        final String fileName = tituloHTML + ".html";
        this.writer = new HTMLWriter(fileName.replaceAll(" ", ""));
        this.tituloHTML = tituloHTML;
    }

    private String geraBody(final List<FilmeDTO> filmesDTO) {
        final StringBuilder body = new StringBuilder();
        final FilmeConversor filmeConversor = new FilmeConversor();
        final List<CardHTML> cards = filmeConversor.filmesToCards(filmesDTO);

        for(CardHTML card : cards)
            body.append(card.toString());

        return body.toString();
    }

    public void geraHTML(final List<FilmeDTO> filmesDTO) {
        final DocumentoHTML html = new DocumentoHTML(tituloHTML, geraBody(filmesDTO));
        this.writer.escreveArquivoHTML(html.toString());
    }

}
