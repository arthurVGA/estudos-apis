package br.com.artius.html;

import br.com.artius.modelo.Filme;

public class CardHTML {
    private final String template = """
            <div class="card">
                <img src="${cartaz}" alt="${titulo}">
                <div class="container">
                    <h2>${rank} ${titulo}</h2>
                    <p>Ano: ${ano}</p>
                    <p>Nota: ${nota}</p>
                </div>
            </div>
            """;

    private final Filme filme;

    public CardHTML(final Filme filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return template.replace("${cartaz}", filme.cartaz())
                        .replace("${rank}", Integer.toString(filme.rank()))
                        .replace("${titulo}", filme.titulo())
                        .replace("${ano}", Integer.toString(filme.ano()))
                        .replace("${nota}", Float.toString(filme.nota()));
    }
}
