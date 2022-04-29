package listasDuplamenteEncadeadas;

public class listaDuplamenteEncadeada<T>{

    private NoDuplo<T> entrada;
    private NoDuplo<T> saida;
    private int tamanhoList;

    public listaDuplamenteEncadeada(){
        this.entrada = null;
        this.saida = null;
        tamanhoList = 0;
    }

    public int size(){
        return tamanhoList;
    }

    public NoDuplo<T> getEntrada() {
        return entrada;
    }

    public void setEntrada(NoDuplo<T> entrada) {
        this.entrada = entrada;
    }

    public NoDuplo<T> getSaida() {
        return saida;
    }

    public void setSaida(NoDuplo<T> saida) {
        this.saida = saida;
    }

    public NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = entrada;

        for(int i = 0; (i < index && (noAuxiliar != null)); i ++){
            noAuxiliar = noAuxiliar.getNextNo();
        }

        return noAuxiliar;
    }

    public T get(int index){
        return  this.getNo(index).getConteudo();

    }

    public void add(T conteudo){
        NoDuplo<T> no = new NoDuplo<>(conteudo);

        no.setNextNo(null);
        no.setPreviousNo(saida);

        if(entrada == null){
            entrada = no;
        }
        if(saida != null){
            saida.setNextNo(no);
        }
        saida = no;
        tamanhoList++;

    }

    public void add(T conteudo, int index){
        NoDuplo<T> no = new NoDuplo<>(conteudo);
        NoDuplo<T> noAuxiliar = getNo(index);

        if(no.getNextNo() != null){
            no.setPreviousNo(noAuxiliar.getPreviousNo());
            no.getNextNo().setPreviousNo(no);
        }else{
            no.setPreviousNo(saida);
            saida = no;
        }

        if(index == 0){
            entrada = no;
        }else{
            no.getPreviousNo().setNextNo(no);
        }

        tamanhoList++;
    }

    public void remove(int index){

        if(index == 0){
            entrada = entrada.getNextNo();
            if(entrada != null){
                entrada.setPreviousNo(null);
            }

        }else{
            NoDuplo<T> noAxiliar = getNo(index);
            noAxiliar.getPreviousNo().setNextNo(noAxiliar.getNextNo());

            if(noAxiliar != saida){
                noAxiliar.getNextNo().setPreviousNo(noAxiliar.getPreviousNo());
            } else{
                saida = noAxiliar;
            }
        }

        this.tamanhoList--;
    }

    @Override
    public String toString() {

        String  strRetorno = "";

        NoDuplo<T> noAxiliar = entrada;

        for(int i = 0; i < size(); i++){

            strRetorno+= "No{" + noAxiliar.getConteudo() + "}  >>  ";
            noAxiliar = noAxiliar.getNextNo();
        }

        strRetorno += " null";

        return strRetorno;
    }
}
