package queue;

public class Queue<T> {
    private NoQueue<T> refNoInput;

    public Queue(){
        this.refNoInput = null;
    }

    public boolean isNotEmpty(){
        return refNoInput != null;
    }

    public void enqueue(T obj){
        NoQueue<T> newNo = new NoQueue<>(obj);
        newNo.setNextNo(refNoInput);
        refNoInput = newNo;

    }

    public T first(){
        if(this.isNotEmpty()){
            NoQueue<T> firstNo = refNoInput;

            boolean con = true;
            while(con){
                if(firstNo.getNextNo()!=null){
                    firstNo = firstNo.getNextNo();
                }else{
                    con = false;
                }
            }
            return firstNo.getObject();

        }
        return null;
    }

    public T dequeue(){

        if(this.isNotEmpty()){
            NoQueue<T> secondNo = refNoInput;
            NoQueue<T> firstNo = refNoInput;

            boolean con = true;
            while(con){
                if(firstNo.getNextNo()!=null){
                    secondNo = firstNo;
                    firstNo = firstNo.getNextNo();
                }else{
                    con = false;

                    if(refNoInput.getNextNo() == null){
                        refNoInput = null;
                        return null;
                    }

                    secondNo.setNextNo(null);


                }
            }
            return firstNo.getObject();

        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("--------------\n");

        if(refNoInput != null){

            boolean boo = true;
            NoQueue<T> no = refNoInput;

            while(boo){
                str.append(no).append("] -----> ");
                if(no.getNextNo() != null){
                    no = no.getNextNo();
                } else {
                    str.append("null\n");
                    boo = false;
                }
            }

        }else{
            str.append("null");
        }
        return str.toString();
    }
}
