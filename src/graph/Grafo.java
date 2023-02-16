package graph;

import java.util.*;

public class Grafo {

    private int qntVertice;
    private int qntAresta;
    private ArrayList<NoVertice> vertices;


    public Grafo() {
        this.vertices = new ArrayList<>();
        this.qntAresta = 0;
        this.qntVertice = 0;
    }

    public int getQntVertice() {
        return qntVertice;
    }

    public void maisVertice() {
        this.qntVertice = qntVertice++;
    }

    public void menosVertice() {
        this.qntVertice = qntVertice--;
    }

    public int getQntAresta(){
        return qntAresta;
    }

    public void menosAresta(){
        this.qntAresta = qntAresta--;
    }

    public void maisAresta(){
        this.qntAresta = qntAresta++;
    }

    public boolean isEmpity(NoVertice no){
        return no == null;
    }

    public void addVertice(NoVertice no){
        vertices.add(no);
    }

    private void populandoDados(NoVertice no){
        for (NoVertice noVertice: vertices) {
            if(noVertice.equals(no)){
                noVertice.setAnterior(null);
                noVertice.setEstimativaDePeso(0);
            }else{
                noVertice.setAnterior(null);
                noVertice.setEstimativaDePeso(9999999);
            }
            
        }
    }
    public void inicializarDijkstra(NoVertice no){
        populandoDados(no);
        dijkstra1(no);

    }

    private void dijkstra1(NoVertice no){
        no.fechar();

        for (NoAresta aresta: no.arestas) {
            if(no.getEstimativaDePeso() + aresta.peso<aresta.getFim().getEstimativaDePeso()){
                aresta.getFim().setEstimativaDePeso(no.getEstimativaDePeso()+ aresta.peso);
                aresta.getFim().setAnterior(no);
            }
        }

        if(haNoAberto()) {
            NoVertice menorEstimativa = null;

            for (NoVertice vertice : vertices) {
                if (!vertice.isFechado()) {
                    if (menorEstimativa == null) {
                        menorEstimativa = vertice;
                    } else if (vertice.getEstimativaDePeso() < menorEstimativa.getEstimativaDePeso()) {
                        menorEstimativa = vertice;

                    }

                }
            }
            dijkstra1(menorEstimativa);
        }

    }

    private boolean haNoAberto() {

        for(NoVertice no: vertices){
            if(!no.isFechado()){
                return true;
            }
        }
        return false;
    }

    public String menorCaminho(NoVertice inicio, NoVertice fim){
        StringBuilder returno = new StringBuilder();
        boolean controle = true;
        while(!isEmpity(fim) && controle ){
            returno.append("[ ").append(fim.getNome()).append(" : ").append(fim.getEstimativaDePeso()).append(" ]");
            fim = fim.getAnterior();

            if(inicio.equals(fim)){
                controle = false;
            }


        }
        returno.append("[ ").append(fim.getNome()).append(" : ").append(fim.getEstimativaDePeso()).append(" ]");
        return returno.toString();
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        String cont;
        for (NoVertice no: vertices) {
            if(no.getAnterior() == null){
                cont = "null";
            }else{
                cont = no.getAnterior().getNome();
            }
            retorno.append(no.getNome()).append(" | ").append(cont).append(" | ").append(no.getEstimativaDePeso()).append("\n");

        }
        return retorno.toString();
    }
}
