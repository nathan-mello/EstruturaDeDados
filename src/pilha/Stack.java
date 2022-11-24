package pilha;

public class Stack {
    NoPilha topo;

    public Stack(){
        this.topo = null;

    }

    public boolean isEmpty(){
        return topo == null;
    }

    public NoPilha top(){
        return topo;
    }

    public void push(NoPilha novoNo){
        NoPilha referencia = topo;
        topo = novoNo;
        novoNo.setNo(referencia);
    }

    public NoPilha pop(){
        if(!this.isEmpty()){
            NoPilha referencia = topo;
            topo = referencia.getNo();
            return referencia;

        }
        return null;
    }

    @Override
    public String toString(){
        String str = "------------\n" +
                      "Pilha\n"        +
                      "------------\n";

        boolean boo = true;
        NoPilha ref = topo;

        while(boo){
            if(ref == null){
                boo = false;
            } else{
                str += "[NoVertice{dado=" + ref.getDado() + "}]\n";
                ref = ref.getNo();

            }

        }
        str += "-------------\n";
        return str;

    }
}
