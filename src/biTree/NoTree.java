package biTree;


public class NoTree<T extends Comparable<T>> {

    private T object;
    private NoTree<T> noLeft;
    private NoTree<T> noRight;

    public NoTree(T object) {
        this.object = object;
        this.noLeft = null;
        this.noRight = null;
    }


    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public NoTree<T> getNoLeft() {
        return noLeft;
    }

    public void setNoLeft(NoTree<T> noLeft) {
        this.noLeft = noLeft;
    }

    public NoTree<T> getNoRight() {
        return noRight;
    }

    public void setNoRight(NoTree<T> noRight) {
        this.noRight = noRight;
    }

    @Override
    public String toString() {
        return "" + object;
    }
}
