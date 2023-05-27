package br.com.artius;

import br.com.artius.protocolo.http.ClienteHttp;
import br.com.artius.protocolo.http.HttpRequisicao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HttpRequisicao requisicao;
        ClienteHttp clienteHttp;
        System.out.println("Linguagem: ");
        final String lang = sc.nextLine();

        System.out.println("API: ");
        final String api = sc.nextLine();

        System.out.println("API Key: ");
        final String key = sc.nextLine();

        requisicao = new HttpRequisicao(api, key);
        clienteHttp = new ClienteHttp(requisicao);

        System.out.println("Response: " + clienteHttp.enviaRequisicao().body());
        sc.close();
    }
}
