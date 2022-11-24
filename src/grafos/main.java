package grafos;

public class main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        NoVertice vertice1 = new NoVertice("v0", 1);
        NoVertice vertice2 = new NoVertice("v1",2);
        NoVertice vertice3 = new NoVertice("v2",3);
        NoVertice vertice4 = new NoVertice("v3",4);
        NoVertice vertice5 = new NoVertice("v4",5);
        NoVertice vertice6 = new NoVertice("v5",6);
        NoVertice vertice7 = new NoVertice("v6",7);


        grafo.addVertice(vertice1);
        grafo.addVertice(vertice2);
        grafo.addVertice(vertice3);
        grafo.addVertice(vertice4);
        grafo.addVertice(vertice5);
        grafo.addVertice(vertice6);
        grafo.addVertice(vertice7);

        vertice1.addAresta(vertice1, vertice2, 10);
        vertice1.addAresta(vertice1, vertice3, 5);
        vertice3.addAresta(vertice3, vertice2, 3);
        vertice3.addAresta(vertice3, vertice4, 8);
        vertice3.addAresta(vertice3, vertice5, 2);
        vertice4.addAresta(vertice4, vertice5, 4);
        vertice4.addAresta(vertice4, vertice6, 4);
        vertice5.addAresta(vertice5, vertice6, 6);

        grafo.inicializarDijkstra(vertice1);
        System.out.println(grafo.toString());

        System.out.println(grafo.menorCaminho(vertice1, vertice5));







    }
}
