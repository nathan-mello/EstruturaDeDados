package biTree;


public class NoTree<T extends Comparable<T>> {

    private T conteudo;
    private NoTree<T> noEsquedo;
    private NoTree<T> noDireito;

    public NoTree(T conteudo) {
        this.conteudo = conteudo;
        this.noEsquedo = null;
        this.noDireito = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoTree<T> getNoEsquedo() {
        return noEsquedo;
    }

    public void setNoEsquedo(NoTree<T> noEsquedo) {
        this.noEsquedo = noEsquedo;
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
