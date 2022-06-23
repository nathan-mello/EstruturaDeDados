package biTree;


public class NoTree<T extends Comparable<T>> {

    private T conteudo;
    private NoTree<T> noEsquerdo;
    private NoTree<T> noDireito;

    public NoTree(T conteudo) {
        this.conteudo = conteudo;
        this.noEsquerdo = null;
        this.noDireito = null;
    }


    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoTree<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NoTree<T> noEsquedo) {
        this.noEsquerdo = noEsquedo;
    }

    public NoTree<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(NoTree<T> noDireito) {
        this.noDireito = noDireito;
    }

    @Override
    public String toString() {
        return "" + conteudo;
    }
}
