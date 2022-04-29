package listasDuplamenteEncadeadas;

public class NoDuplo<T> {
    private T conteudo;
    private NoDuplo<T> nextNo;
    private NoDuplo<T> previousNo;

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
        this.nextNo = null;
        this.previousNo = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(NoDuplo<T> nextNo) {
        this.nextNo = nextNo;
    }

    public NoDuplo<T> getPreviousNo() {
        return previousNo;
    }

    public void setPreviousNo(NoDuplo<T> previousNo) {
        this.previousNo = previousNo;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
