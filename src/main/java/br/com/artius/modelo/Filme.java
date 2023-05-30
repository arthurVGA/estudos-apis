package br.com.artius.modelo;

import br.com.artius.dto.FilmeDTO;

public class Filme {
    private int rank;
    private String titulo;
    private int ano;
    private float nota;
    private String url;

    public Filme() {
    }
    public Filme(final FilmeDTO filmeDTO) {
        this.rank = Integer.parseInt(filmeDTO.rank());
        this.titulo = filmeDTO.title();
        this.nota = Float.parseFloat(filmeDTO.rating());
        this.ano = Integer.parseInt(filmeDTO.year());
        this.url = filmeDTO.url();
    }

    public int rank() {
        return rank;
    }

    public void rank(final int rank) {
        this.rank = rank;
    }

    public String titulo() {
        return titulo;
    }

    public void titulo(final String titulo) {
        this.titulo = titulo;
    }

    public int ano() {
        return ano;
    }

    public void ano(final int year) {
        this.ano = year;
    }

    public float nota() {
        return nota;
    }

    public void nota(final float rating) {
        this.nota = rating;
    }

    public String cartaz() {
        return url;
    }

    public void cartaz(final String url) {
        this.url = url;
    }
}
