package br.com.artius.html;

public class TemplateHTML {
    public static final String HTML = """
                <!DOCTYPE html>
                <html>
                    <head>
                        <link rel="stylesheet" href="style.css">
                        <title>$title</title>
                    </head>
                    <body>
                        <h1>$title</h1>
                $content
                    </body>
                </html>
                """;
    public static final String FILME_CARD =
            """
                    <div class="card">
                        <img src="${cartaz}" alt="${titulo}">
                        <div class="container">
                            <h2>${rank}° - ${titulo}</h2>
                            <p>Ano: ${ano}</p>
                            <p>Nota: ${nota}</p>
                        </div>
                    </div>
            """;

    public static final String COMIC_CARD =
            """
                    <div class="card">
                        <div class="container">
                            <h2>${titulo}</h2>
                            <p>Ano de Estreia: ${inicio}</p>
                            <p>Ano de Encerramento: ${fim}</p>
                            <p>Tipo: ${tipo}</p>
                        </div>
                    </div>
            """;
}
