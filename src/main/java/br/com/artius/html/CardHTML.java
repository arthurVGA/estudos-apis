package br.com.artius.html;

import br.com.artius.dto.FilmeDTO;

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

    private final String cartaz;
    private final String rank;
    private final String titulo;
    private final String ano;
    private final String nota;

    public CardHTML(final FilmeDTO filmeDTO) {
        this.cartaz = filmeDTO.url();
        this.rank = filmeDTO.rank();
        this.titulo = filmeDTO.title();
        this.ano = filmeDTO.year();
        this.nota = filmeDTO.rating();
    }

    @Override
    public String toString() {
        return template.replace("${cartaz}", cartaz)
                        .replace("${rank}", rank)
                        .replace("${titulo}", titulo)
                        .replace("${ano}", ano)
                        .replace("${nota}", nota);
    }
}
