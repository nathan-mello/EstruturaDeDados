package listasEncadeadas;

public class NoLinkedList<T> {
    private T dado;
    private NoLinkedList<T> nextNo;

    public NoLinkedList(T dado){
        this.nextNo = null;
        this.dado = dado;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public NoLinkedList<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(NoLinkedList<T> nextNo) {
        this.nextNo = nextNo;
    }

    @Override
    public String toString(){
        String str = "NoVertice{" +
                "dado=" + dado +
                '}';

        if(nextNo != null){
            str += "-->" + nextNo;

        }else{
            str += "--> null;";

        }
        return str;
    }
}
