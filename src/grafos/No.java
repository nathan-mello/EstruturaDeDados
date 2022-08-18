package grafos;

import java.util.ArrayList;

public class No {
    private String nome;
    private Integer id;

    private ArrayList<No> relacoes;

    public No(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
        this.relacoes = new ArrayList<No>();
    }
}
