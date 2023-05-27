package br.com.artius.protocolo.http;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    private final HttpRequest requisicao;
    private final HttpClient client;

    public ClienteHttp(final HttpRequisicao requisicao) {
        this.requisicao = requisicao.GET();
        this.client = HttpClient.newBuilder().proxy(ProxySelector.getDefault()).build();
    }

    public HttpResponse<String> enviaRequisicao() {
        try {
            return client.send(requisicao, BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problema ao executar a requisição.", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Requisição foi interrompida antes de terminar.", e);
        }
    }
}
