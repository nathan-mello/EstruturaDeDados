package listasEncadeadas;

public class No<T> {
    private T conteudo;
    private No<T> nextNo;

    public No(T conteudo){
        this.nextNo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getNextNo() {
        return nextNo;
    }

    public void setNextNo(No<T> nextNo) {
        this.nextNo = nextNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    public String toStringNo(){
        String str = "No{" +
                "conteudo=" + conteudo +
                '}';

        if(nextNo != null){
            str += "-->" + nextNo;

        }else{
            str += "--> null;";

        }
        return str;
    }
}
