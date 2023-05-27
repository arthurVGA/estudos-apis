package br.com.artius.protocolo.http;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;

public class HttpRequisicao {
    private final String key;
    private final String formatoURI;

    public HttpRequisicao(final String key) {
        this.key = key;
        this.formatoURI = "https://imdb-api.com/en/API/Top250Movies/%s";
    }

    public HttpRequest GET() {
        return HttpRequest.newBuilder()
                            .GET()
                            .uri(URI.create(String.format(formatoURI, key)))
                            .build();
    }

}
