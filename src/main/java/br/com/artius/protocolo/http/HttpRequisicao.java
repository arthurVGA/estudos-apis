package br.com.artius.protocolo.http;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;

public class HttpRequisicao {
    private final String api;
    private final String key;
    private final String formatoURI;

    public HttpRequisicao(final String api, final String key) {
        this.api = api;
        this.key = key;
        this.formatoURI = "https://imdb-api.com/en/API/%1$s/%2$s";
    }

    public HttpRequest GET() {
        return HttpRequest.newBuilder()
                            .GET()
                            .uri(URI.create(String.format(formatoURI, api, key)))
                            .build();
    }

}
