package circularList;

public class CircularList<T> {

    private NoCircular<T> head;
    private NoCircular<T> trail;
    private Integer tamanhoList;

    public CircularList() {
        this.head = null;
        this.trail = null;
        this.tamanhoList = 0;
    }

    public int size(){
        return this.tamanhoList;
    }

    public boolean isEmpty(){
        return this.tamanhoList == 0;
    }

    private NoCircular<T> getNo(int index){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("A lista está vazia");

        }

        if(index == 0){
            return this.trail;
        }

        NoCircular<T> noAuxiliar = this.trail;

        for(int i=0; i<index && noAuxiliar != null; i++){
            noAuxiliar = noAuxiliar.getNextNo();
        }
        return noAuxiliar;


    }

    public T get(int index){
        return getNo(index).getConteudo();

    }

    public void remove(int index){

        if(index>=tamanhoList){
            throw new IndexOutOfBoundsException("indice invalido.");
        }

        NoCircular<T> noAulixiar = this.trail;
        if(index==0){

            this.trail = this.trail.getNextNo();

        }else if(index==1){

            this.trail.setNextNo(this.trail.getNextNo().getNextNo());
        }else{
            for(int i=0; i<=index-1; i++){
                noAulixiar = noAulixiar.getNextNo();
            }

            noAulixiar.setNextNo(noAulixiar.getNextNo().getNextNo());
        }
        this.tamanhoList--;
    }

    public void add(T conteudo){
        NoCircular<T> novoNo = new NoCircular<>(conteudo);
        if(tamanhoList==0){
            this.head = novoNo;
            this.trail = head;
            this.head.setNextNo(trail);
        }else{
            novoNo.setNextNo(this.trail);
            this.head.setNextNo(novoNo);
            this.trail = novoNo;
        }

        tamanhoList++;
    }

    @Override
    public String toString() {

        String str = "CircularList{ ";

        NoCircular<T> noAuxiliar = this.trail;
        for(int i=0; i<tamanhoList; i++){
            str += noAuxiliar.getConteudo().toString() + " --> ";
            noAuxiliar = noAuxiliar.getNextNo();
        }

        str += this.isEmpty() ? "(retorno ao inicio)" : "()";

        return str;
    }
}
