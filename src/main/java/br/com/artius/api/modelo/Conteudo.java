package br.com.artius.api.modelo;

import br.com.artius.html.TemplateHTML;

public record Conteudo (String image, String titulo, String ano, String nota) {

    @Override
    public String toString() {
        return TemplateHTML.CARD_HTML
                        .replace("${image}", image)
                        .replace("${titulo}", titulo)
                        .replace("${ano}", ano)
                        .replace("${nota}", nota);
    }

}
