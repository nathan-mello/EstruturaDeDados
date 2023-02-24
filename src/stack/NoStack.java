package stack;

public class NoStack<T> {
    private final T dado;
    private NoStack<T> noStack;

    public NoStack(T dado) {
        this.dado = dado;
        this.noStack = null;
    }

    public T getDado() {
        return dado;
    }


    public NoStack<T> getNo() {
        return noStack;
    }

    public void setNo(NoStack<T> noStack) {
        this.noStack = noStack;
    }

    @Override
    public String toString() {
        return "NoStack(" +
                 dado.toString() +
                ") ";
    }
}