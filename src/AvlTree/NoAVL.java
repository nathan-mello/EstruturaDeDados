package AvlTree;

public class NoAVL<T> {
    private int id;
    private T conteudo;
    private NoAVL<T> noDireito;
    private NoAVL<T> noEsquerdo;
    private int height;

    public NoAVL(int id, T conteudo) {
        this.id = id;
        this.conteudo = conteudo;
        this.noDireito = null;
        this.noEsquerdo = null;
        this.height = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoAVL<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(NoAVL<T> noDireito) {
        this.noDireito = noDireito;
    }

    public NoAVL<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NoAVL<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "no{ "+ id + ", "+ conteudo +" }";
    }
}
