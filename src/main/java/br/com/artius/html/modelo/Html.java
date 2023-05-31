package br.com.artius.html.modelo;

import br.com.artius.html.TemplateHTML;

public class Html {
    private final String titulo;
    private final String body;

    public Html(final String titulo, final String body) {
        this.titulo = titulo;
        this.body = body;
    }

    @Override
    public String toString() {
        return TemplateHTML.HTML
                    .replace("${title}", titulo)
                    .replace("${body}", body);
    }
}
