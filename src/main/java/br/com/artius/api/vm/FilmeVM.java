package br.com.artius.api.vm;

import br.com.artius.api.modelo.Filme;
import br.com.artius.html.TemplateHTML;

public class FilmeVM {

    private final String cartaz;
    private final String rank;
    private final String titulo;
    private final String ano;
    private final String nota;

    public FilmeVM(final Filme filme) {
        this.cartaz = filme.url();
        this.rank = filme.rank();
        this.titulo = filme.title();
        this.ano = filme.year();
        this.nota = filme.rating();
    }

    @Override
    public String toString() {
        return TemplateHTML.FILME_CARD
                        .replace("${cartaz}", cartaz)
                        .replace("${rank}", rank)
                        .replace("${titulo}", titulo)
                        .replace("${ano}", ano)
                        .replace("${nota}", nota);
    }
}
