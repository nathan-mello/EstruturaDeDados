package pilha;

public class Stack<T> {
    NoStack<T> topo;

    public Stack(){
        this.topo = null;

    }

    public boolean isEmpty(){
        return topo == null;
    }

    public NoStack<T> top(){
        return topo;
    }

    public void push(NoStack<T> novoNo){
        NoStack<T> referencia = topo;
        topo = novoNo;
        novoNo.setNo(referencia);
    }

    public NoStack<T> pop(){
        if(!this.isEmpty()){
            NoStack<T> referencia = topo;
            topo = referencia.getNo();
            return referencia;

        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("------------\n" +
                "Pilha\n" +
                "------------\n");

        boolean boo = true;
        NoStack<T> ref = topo;

        while(boo){
            if(ref == null){
                boo = false;
            } else{
                str.append("[NoVertice{dado=").append(ref.getDado()).append("}]\n");
                ref = ref.getNo();

            }

        }
        str.append("-------------\n");
        return str.toString();

    }
}
