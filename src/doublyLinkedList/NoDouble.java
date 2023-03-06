package doublyLinkedList;

public class NoDouble<T> {
    private T dado;
    private NoDouble<T> nextNo;
    private NoDouble<T> previousNo;

    public NoDouble(T dado) {
        this.dado = dado;
        this.nextNo = null;
        this.previousNo = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoDouble<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(NoDouble<T> nextNo) {
        this.nextNo = nextNo;
    }

    public NoDouble<T> getPreviousNo() {
        return previousNo;
    }

    public void setPreviousNo(NoDouble<T> previousNo) {
        this.previousNo = previousNo;
    }

    @Override
    public String toString() {
        return "NoDouble{" +
                "dado=" + dado +
                '}';
    }
}
