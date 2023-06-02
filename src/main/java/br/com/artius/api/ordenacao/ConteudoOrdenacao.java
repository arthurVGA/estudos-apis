package br.com.artius.api.ordenacao;

import br.com.artius.api.modelo.Conteudo;

import java.util.Comparator;

public class ConteudoOrdenacao implements Comparator<Conteudo> {
    @Override
    public int compare(Conteudo c1, Conteudo c2) {
        if (!c1.nota().equals(c2.nota()))
            return c2.nota().compareTo(c1.nota());
        if (!c1.titulo().equals(c2.titulo()))
            return c2.titulo().compareTo(c1.titulo());
        return c2.ano().compareTo(c1.ano());
    }
}
