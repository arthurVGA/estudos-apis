package br.com.artius;

import br.com.artius.controller.FilmeController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmeController controller = new FilmeController();

        System.out.println("API Key: ");
        final String apiKey = sc.nextLine();

        controller.pesquisaTop250Filmes(apiKey);

    }
}
