package queue;

public class NoQueue<T> {
    private T object;
    private NoQueue<T> nextNo;

    public NoQueue(T object) {
        this.object = object;
        this.nextNo = null;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public NoQueue<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(NoQueue<T> nextNo) {
        this.nextNo = nextNo;
    }

    @Override
    public String toString() {
        return "NoQueue{" +
                "object= " + object +
                '}';
    }
}
