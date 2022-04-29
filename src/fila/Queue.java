package fila;

public class Queue<T> {
    private NoFila<T> refNoInput;

    public Queue(){
        this.refNoInput = null;
    }

    public boolean isEmpty(){
        return refNoInput == null;
    }

    public void enqueue(T obj){
        NoFila<T> novoNo = new NoFila<T>(obj);
        novoNo.setRefNo(refNoInput);
        refNoInput = novoNo;

    }

    public T first(){
        if(!this.isEmpty()){
            NoFila<T> firstNo = refNoInput;

            boolean con = true;
            while(con){
                if(firstNo.getRefNo()!=null){
                    firstNo = firstNo.getRefNo();
                }else{
                    con = false;
                }
            }
            return firstNo.getObject();

        }
        return null;
    }

    public T dequeue(){

        if(!this.isEmpty()){
            NoFila<T> secondNo = refNoInput;
            NoFila<T> firstNo = refNoInput;

            boolean con = true;
            while(con){
                if(firstNo.getRefNo()!=null){
                    secondNo = firstNo;
                    firstNo = firstNo.getRefNo();
                }else{
                    con = false;

                    if(refNoInput.getRefNo() == null){
                        refNoInput = null;
                        return null;
                    }

                    secondNo.setRefNo(null);


                }
            }
            return firstNo.getObject();

        }
        return null;
    }

    @Override
    public String toString() {
        String str = "--------------\n";

        if(refNoInput != null){

            boolean boo = true;
            NoFila<T> no = refNoInput;

            while(boo){
                str += "[ " +  no.getObject() + "] -----> ";
                if(no.getRefNo() != null){
                    no = no.getRefNo();
                } else {
                    str += "null\n";
                    boo = false;
                }
            }

            return str;
        }else{
            str += "null";
            return str;
        }
    }
}
