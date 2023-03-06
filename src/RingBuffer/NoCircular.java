package RingBuffer;

public class NoCircular<T> {
    private T conteudo;
    private NoCircular<T> nextNo;

    public NoCircular(T conteudo) {
        this.conteudo = conteudo;
        this.nextNo = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoCircular<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(NoCircular<T> nextNo) {
        this.nextNo = nextNo;
    }

    @Override
    public String toString() {
        return "NoCircular{" +
                "conteudo=" + conteudo +
                '}';
    }
}
