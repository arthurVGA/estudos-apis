package br.com.artius.html;

import br.com.artius.html.io.HTMLWriter;

public class GeradorHTML {
    private final String tituloHTML;
    private final HTMLWriter writer;

    public GeradorHTML(final String tituloHTML) {
        final String fileName = tituloHTML + ".html";
        this.writer = new HTMLWriter(fileName.replaceAll(" ", ""));
        this.tituloHTML = tituloHTML;
    }

    public void getConteudo(final String conteudo) {
        String html = TemplateHTML.HTML
                .replaceAll("[$]title", tituloHTML)
                .replace("$content", conteudo);

        this.writer.escreveArquivoHTML(html);
    }

}
