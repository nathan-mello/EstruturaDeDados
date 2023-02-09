package pilha;

public class NoStack<T> {
    private T dado;
    private NoStack<T> noStack;

    public NoStack(T dado) {
        this.dado = dado;
        this.noStack = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoStack<T> getNo() {
        return noStack;
    }

    public void setNo(NoStack<T> noStack) {
        this.noStack = noStack;
    }

    @Override
    public String toString() {
        return "NoLinkedList(" +
                 dado.toString() +
                ") ";
    }
}