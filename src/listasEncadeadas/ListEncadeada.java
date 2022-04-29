package listasEncadeadas;

public class ListEncadeada<T>{
    private No<T> referencia;

    public ListEncadeada() {
        this.referencia = null;
    }

    public No<T> getReferencia() {
        return referencia;
    }

    public Integer size(){
        Integer number = 0;

        No<T> referenciaSize = referencia;

        boolean cont = true;
        while(cont){
            if(referenciaSize != null){
                number++;
                referenciaSize = referenciaSize.getNextNo();
            }else{
                cont = false;
            }

        }
        return  number;
    }

    public boolean IsEmpty(){ return referencia == null; }


    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(IsEmpty()){
            referencia = novoNo;
            return;
        }
        No<T> nReferencia = referencia;

        for(int i=0; i<this.size()-1; i++){
            nReferencia = nReferencia.getNextNo();

        }
        nReferencia.setNextNo(novoNo);

    }

    private No<T> getNo(int index){
        validaIndice(index);

        No<T> noAxiliar = referencia;
        No<T> noRetorno = null;

        for(int i=0; i<=index; i++){
            noRetorno = noAxiliar;
            noAxiliar = noAxiliar.getNextNo();
        }
        return noRetorno;


    }

    public T get(int index){
        return getNo(index).getConteudo();
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
        No<T> noPivo = this.getNo(index);

        if(index == 0){
            noPivo = referencia;
            referencia = noPivo.getNextNo();
            return noPivo.getConteudo();
        }

        No<T> noAnterior = getNo(index -1);

        noAnterior.setNextNo(noPivo.getNextNo());
        return noPivo.getConteudo();

    }

    @Override
    public String toString() {

        String str = "";
        No<T> no = referencia;

        for(int i=0; i<size(); i++){
            str += "(" + no.getConteudo() + ") --> ";
            no = no.getNextNo();
        }
        return str += "null;";
    }

    public boolean isEmpty(){return referencia == null;}
}
