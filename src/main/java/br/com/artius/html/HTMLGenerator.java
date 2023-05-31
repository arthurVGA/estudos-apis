package br.com.artius.html;

import br.com.artius.html.modelo.Html;
import br.com.artius.imdb.conversao.FilmeIMDBConversor;
import br.com.artius.imdb.dto.FilmeDTO;
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

    private String geraCards(final List<FilmeDTO> filmesDTO) {
        final StringBuilder cards = new StringBuilder();

        for (FilmeDTO filmeDTO : filmesDTO)
            cards.append(geraCard(filmeDTO));

        return cards.toString();
    }
    private String geraCard(FilmeDTO filmesDTO) {
        return new FilmeIMDBConversor()
                    .filmeToCard(filmesDTO)
                    .toString();
    }

    public void geraHTML(final List<FilmeDTO> filmesDTO) {
        final Html html = new Html(tituloHTML, geraCards(filmesDTO));
        this.writer.escreveArquivoHTML(html.toString());
    }

}
