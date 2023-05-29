package br.com.artius.modelo;

import br.com.artius.dto.FilmeDTO;

public class Filme {
    private int rank;
    private String titulo;
    private int year;
    private float rating;
    private String url;

    public Filme() {
    }
    public Filme(final FilmeDTO filmeDTO) {
        this.rank = Integer.parseInt(filmeDTO.rank());
        this.titulo = filmeDTO.title();
        this.rating = Float.parseFloat(filmeDTO.rating());
        this.year = Integer.parseInt(filmeDTO.year());
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

    public int year() {
        return year;
    }

    public void year(final int year) {
        this.year = year;
    }

    public float rating() {
        return rating;
    }

    public void rating(final float rating) {
        this.rating = rating;
    }

    public String urlImagem() {
        return url;
    }

    public void urlImagem(final String url) {
        this.url = url;
    }
}
