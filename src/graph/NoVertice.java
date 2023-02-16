package graph;


import java.util.ArrayList;

public class NoVertice {
    private NoVertice anterior;
    private Integer estimativaDePeso;
    private String nome;
    private Integer id;
    public ArrayList<NoAresta> arestas;
    private boolean fechado;

    public boolean isFechado() {
        return fechado;
    }
    public void fechar(){
        fechado = true;
    }


    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public NoVertice(String nome, Integer id) {
        this.arestas = new ArrayList<>();
        this.nome = nome;
        this.id = id;
        this.anterior = null;
        this.estimativaDePeso = 0;
        this.fechado = false;
    }

    public NoVertice getAnterior() {
        return anterior;
    }

    public void setAnterior(NoVertice anterior) {
        this.anterior = anterior;
    }

    public Integer getEstimativaDePeso() {
        return estimativaDePeso;
    }

    public void setEstimativaDePeso(Integer estimativaDePeso) {
        this.estimativaDePeso = estimativaDePeso;
    }

    public void addAresta(NoVertice inicio, NoVertice fim, int peso){
        NoAresta aresta = new NoAresta(inicio,fim, peso);

        arestas.add(aresta);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "(" +
                nome +", "+ id +
                ") --->     ";
    }


}
