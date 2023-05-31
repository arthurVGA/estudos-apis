package br.com.artius.protocolo.http;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;

public class HttpRequisicao {
    private Builder builder;

    public HttpRequisicao() {
        this.builder = HttpRequest.newBuilder();
    }

    public HttpRequisicao get() {
        this.builder = this.builder.GET();
        return this;
    }

    public HttpRequisicao uri(final URI uri) {
        this.builder = this.builder.uri(uri);
        return this;
    }

    public HttpRequisicao uri(final String uri) {
        return this.uri(URI.create(uri));
    }

    public HttpRequest request() {
        return builder.build();
    }
}
