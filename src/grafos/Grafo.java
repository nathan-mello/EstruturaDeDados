package grafos;

import java.util.*;

public class Grafo {

    private final ArrayList<No> vertice;

    public  Grafo(){
        this.vertice = new ArrayList<No>(){};
    }

    public String getVertice(){
        StringBuilder retorno = null;

        for (No no : vertice) {

            retorno.append(no);
        }
        return retorno.toString();
    }

    public void add(No no){
        vertice.add(no);
    }
}
