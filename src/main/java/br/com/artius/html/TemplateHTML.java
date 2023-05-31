package br.com.artius.html;

public class TemplateHTML {
    public static final String HTML = """
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
    public static final String CARD =
            """
                    <div class="card">
                        <img src="${cartaz}" alt="${titulo}">
                        <div class="container">
                            <h2>${rank} ${titulo}</h2>
                            <p>Ano: ${ano}</p>
                            <p>Nota: ${nota}</p>
                        </div>
                    </div>
            """;

}
