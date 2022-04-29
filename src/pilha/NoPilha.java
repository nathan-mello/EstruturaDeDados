package pilha;

public class NoPilha {
    private Character dado;
    private NoPilha noPilha;

    public NoPilha(Character dado) {
        this.dado = dado;
        this.noPilha = null;
    }


    public Character getDado() {
        return dado;
    }

    public void setDado(Character dado) {
        this.dado = dado;
    }

    public NoPilha getNo() {
        return noPilha;
    }

    public void setNo(NoPilha noPilha) {
        this.noPilha = noPilha;
    }

    @Override
    public String toString() {
        return "NoPilha{" +
                "dado=" + dado +
                '}';
    }
}