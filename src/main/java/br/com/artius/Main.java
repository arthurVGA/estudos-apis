package br.com.artius;

import br.com.artius.api.controller.ComicController;
import br.com.artius.api.controller.FilmeController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        filmeAPI(sc);
//        comicAPI(sc);
    }

    private static void comicAPI(Scanner sc) {
        System.out.println("API Key Marvel: ");
        final String apiKeyMarvel = sc.nextLine();
        System.out.println("Hash: ");
        final String hashMarvel = sc.nextLine();

        new ComicController().pesquisaSeries(apiKeyMarvel, hashMarvel);
    }

    private static void filmeAPI(Scanner sc) {
        System.out.println("API Key IMDB: ");
        final String apiKeyIMDB = sc.nextLine();
        new FilmeController().pesquisaTop250Filmes(apiKeyIMDB);
    }
}
