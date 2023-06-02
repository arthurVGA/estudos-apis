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
                "{$content}"
                    </body>
                </html>
                """;
    public static final String CARD_HTML =
            """
                    <div class="card">
                        <img src="${image}" alt="${titulo}">
                        <div class="container">
                            <h2>${titulo}</h2>
                            <p>Ano: ${ano}</p>
                            <p>Nota: ${nota}</p>
                        </div>
                    </div>
            """;
}
