package AvlTree;

public class NoAVL<T> {
    private int id;
    private T object;
    private NoAVL<T> noRight;
    private NoAVL<T> noLeft;
    private int height;

    public NoAVL(int id, T object) {
        this.id = id;
        this.object = object;
        this.noRight = null;
        this.noLeft = null;
        this.height = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public NoAVL<T> getNoRight() {
        return noRight;
    }

    public void setNoRight(NoAVL<T> noRight) {
        this.noRight = noRight;
    }

    public NoAVL<T> getNoLeft() {
        return noLeft;
    }

    public void setNoLeft(NoAVL<T> noLeft) {
        this.noLeft = noLeft;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "no{ "+ id + ", "+ object +" }";
    }
}
