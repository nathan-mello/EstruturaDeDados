package listasEncadeadas;

public class LinkedList<T>{
    private NoLinkedList<T> firstNo;

    public LinkedList() {
        this.firstNo = null;
    }

    public NoLinkedList<T> getfirstNo() {
        return firstNo;
    }

    public Integer size(){
        Integer number = 0;

        NoLinkedList<T> firstNoSize = firstNo;

        boolean cont = true;
        while(cont){
            if(firstNoSize != null){
                number++;
                firstNoSize = firstNoSize.getNextNo();
            }else{
                cont = false;
            }

        }
        return  number;
    }

    public boolean IsEmpty(){ return firstNo == null; }


    public void add(T dado){
        NoLinkedList<T> novoNo = new NoLinkedList<>(dado);
        if(IsEmpty()){
            firstNo = novoNo;
            return;
        }
        NoLinkedList<T> no = firstNo;

        for(int i=0; i<this.size()-1; i++){
            no = firstNo.getNextNo();

        }
        no.setNextNo(novoNo);

    }

    private NoLinkedList<T> getNo(int index){
        validaIndice(index);

        NoLinkedList<T> noAxiliar = firstNo;
        NoLinkedList<T> noRetorno = null;

        for(int i=0; i<=index; i++){
            noRetorno = noAxiliar;
            noAxiliar = noAxiliar.getNextNo();
        }
        return noRetorno;


    }

    public T get(int index){
        return getNo(index).getDado();
    }

    private void validaIndice(int index){
        int ultimoIndex = size()-1;

        if(index>= size()){
            throw new IndexOutOfBoundsException("Não existem conteudo no indice "+
                    index + "desta lista. Tamanho da lista é: "+ ultimoIndex);
        }

    }

    public T remove(int index){

        if(IsEmpty()){return null;}
        NoLinkedList<T> noPivo = this.getNo(index);

        if(index == 0){
            noPivo = firstNo;
            firstNo = noPivo.getNextNo();
            return noPivo.getDado();
        }

        NoLinkedList<T> noAnterior = getNo(index -1);

        noAnterior.setNextNo(noPivo.getNextNo());
        return noPivo.getDado();

    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        NoLinkedList<T> no = firstNo;

        for(int i=0; i<size(); i++){
            str.append("(").append(no.getDado()).append(") --> ");
            no = no.getNextNo();
        }
        str.append("null;");
        return str.toString();
    }

}
