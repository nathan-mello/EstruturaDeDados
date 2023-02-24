package stack;

public class Stack<T> {
    private  NoStack<T> top;

    public Stack(){
        this.top = null;

    }

    public boolean isEmpty(){
        return top == null;
    }

    public T topStack(){
        return top.getDado();
    }

    public void push(T object){
        NoStack<T> newNo = new NoStack<>(object);
        NoStack<T> reference = top;
        top = newNo;
        newNo.setNo(reference);
    }

    public T pop(){
        if(!this.isEmpty()){
            NoStack<T> reference = top;
            top = reference.getNo();
            return reference.getDado();

        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("------------\n" +
                "Stack\n" +
                "------------\n");

        boolean boo = true;
        NoStack<T> ref = top;

        while(boo){
            if(ref == null){
                boo = false;
            } else{
                str.append(ref).append("\n");
                ref = ref.getNo();

            }

        }
        str.append("-------------\n");
        return str.toString();

    }
}
