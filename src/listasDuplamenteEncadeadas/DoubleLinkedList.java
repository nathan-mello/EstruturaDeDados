package listasDuplamenteEncadeadas;

public class DoubleLinkedList<T>{

    private NoDouble<T> next;
    private NoDouble<T> previous;
    private int sizeList;

    public DoubleLinkedList(){
        this.next = null;
        this.previous = null;
        sizeList = 0;
    }

    public int size(){
        return sizeList;
    }

    public NoDouble<T> getNext() {
        return next;
    }

    public void setNext(NoDouble<T> next) {
        this.next = next;
    }

    public NoDouble<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NoDouble<T> previous) {
        this.previous = previous;
    }

    public NoDouble<T> getNo(int index){
        NoDouble<T> noAuxiliar = next;

        for(int i = 0; (i < index && (noAuxiliar != null)); i ++){
            noAuxiliar = noAuxiliar.getNextNo();
        }

        return noAuxiliar;
    }

    public T get(int index){
        return  this.getNo(index).getDado();

    }

    public void add(T conteudo){
        NoDouble<T> no = new NoDouble<>(conteudo);

        no.setNextNo(null);
        no.setNextNo(previous);

        if(next == null){
            next = no;
        }
        if(previous != null){
            previous.setNextNo(no);
        }
        previous = no;
        sizeList++;

    }

    public void add(T conteudo, int index){
        NoDouble<T> no = new NoDouble<>(conteudo);
        NoDouble<T> noAuxiliar = getNo(index);

        if(no.getNextNo() != null){
            no.setNextNo(noAuxiliar.getNextNo());
            no.getNextNo().setNextNo(no);
        }else{
            no.setNextNo(previous);
            previous = no;
        }

        if(index == 0){
            next = no;
        }else{
            no.getNextNo().setNextNo(no);
        }

        sizeList++;
    }

    public void remove(int index){

        if(index == 0){
            next = next.getNextNo();
            if(next != null){
                next.setNextNo(null);
            }

        }else{
            NoDouble<T> noAxiliar = getNo(index);
            noAxiliar.getNextNo().setNextNo(noAxiliar.getNextNo());

            if(noAxiliar != previous){
                noAxiliar.getNextNo().setNextNo(noAxiliar.getNextNo());
            } else{
                previous.setNextNo(noAxiliar);
            }
        }

        this.sizeList--;
    }

    @Override
    public String toString() {

        StringBuilder strRetorno = new StringBuilder();

        NoDouble<T> noAxiliar = next;

        for(int i = 0; i < size(); i++){

            strRetorno.append("NoVertice{").append(noAxiliar.getDado()).append("}  >>  ");
            noAxiliar = noAxiliar.getNextNo();
        }

        strRetorno.append(" null");

        return strRetorno.toString();
    }
}
