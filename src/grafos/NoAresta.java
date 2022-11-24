package grafos;

public class NoAresta {
    NoVertice inicio;
    NoVertice fim;
    Integer peso;

    public NoAresta(NoVertice inicio, NoVertice fim, Integer peso) {
        this.inicio = inicio;
        this.fim = fim;
        this.peso = peso;
    }

    public NoVertice getInicio() {
        return inicio;
    }

    public void setInicio(NoVertice inicio) {
        this.inicio = inicio;
    }

    public NoVertice getFim() {
        return fim;
    }

    public void setFim(NoVertice fim) {
        this.fim = fim;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "(" + fim.getNome() +
                ", peso=" + peso +
                ")   ";
    }
}
