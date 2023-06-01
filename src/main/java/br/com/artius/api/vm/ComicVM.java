package br.com.artius.api.vm;

import br.com.artius.api.modelo.Comic;
import br.com.artius.html.TemplateHTML;

public class ComicVM {
    private final String titulo;
    private final String inicio;
    private final String fim;
    private final String tipo;

    public ComicVM(final Comic comic) {
        this.titulo = comic.titulo();
        this.inicio = Integer.toString(comic.inicio());
        this.fim = Integer.toString(comic.fim());
        this.tipo = comic.tipo();
    }

    @Override
    public String toString() {
        return TemplateHTML.COMIC_CARD
                .replace("${titulo}", titulo)
                .replace("${inicio}", inicio)
                .replace("${fim}", fim)
                .replace("${tipo}", tipo);
    }
}
