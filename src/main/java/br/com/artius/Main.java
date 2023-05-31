package br.com.artius;

import br.com.artius.imdb.controller.FilmeIMDBController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilmeIMDBController controller = new FilmeIMDBController();

        System.out.println("API Key: ");
        final String apiKey = sc.nextLine();

        controller.pesquisaTop250Filmes(apiKey);

    }
}
