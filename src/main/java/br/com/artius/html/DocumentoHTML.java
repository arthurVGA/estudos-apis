package br.com.artius.html;

public class DocumentoHTML {
    private static final String TEMPLATE = """
                <!DOCTYPE html>
                <html>
                    <head>
                        <link rel="stylesheet" href="style.css">
                        <title>${title}</title>
                    </head>
                    <body>
                        <h1>${title}</h1>
                        ${body}
                    </body>
                </html>
                """;
    private final String titulo;
    private final String body;

    public DocumentoHTML(final String titulo, final String body) {
        this.titulo = titulo;
        this.body = body;
    }

    @Override
    public String toString() {
        return TEMPLATE
                    .replace("${title}", titulo)
                    .replace("${body}", body);
    }
}
