package AvlTree;

public class AVLTree<T> {
    private NoAVL<T> raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public NoAVL<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoAVL<T> raiz) {
        this.raiz = raiz;
    }

    private boolean isEmpty(NoAVL<T> no){
        return no == null;
    }

    public void insert(T conteudo, int id) {
        NoAVL<T> no = new NoAVL<>(id, conteudo);

        if(isEmpty(raiz)){
            raiz = no;
        }else{
            insert(raiz, no);
        }
    }

    private void insert(NoAVL<T> noRaiz, NoAVL<T> noAtual){
        if(noAtual.getId()<noRaiz.getId()){
            if(!isEmpty(noRaiz.getNoEsquerdo())){
                insert(noRaiz.getNoEsquerdo(), noAtual);
            }
            else{
                noRaiz.setNoEsquerdo(noAtual);
            }
        }else{
            if(!isEmpty(noRaiz.getNoDireito())){
                insert(noRaiz.getNoDireito(), noAtual);
            }
            else{
                noRaiz.setNoDireito(noAtual);
            }
        }

    }

    public void inOrdem(){
        inOrdem(raiz);

    }

    private void inOrdem(NoAVL<T> noRaiz){
        if(!isEmpty(noRaiz)){
            inOrdem(noRaiz.getNoEsquerdo());
            System.out.println(noRaiz.toString());
            inOrdem(noRaiz.getNoDireito());

        }
    }

    public void posOrdem(){
        posOrdem(raiz);

    }

    private void posOrdem(NoAVL<T> noRaiz){
        if(!isEmpty(noRaiz)){
            inOrdem(noRaiz.getNoEsquerdo());
            inOrdem(noRaiz.getNoDireito());
            System.out.println(noRaiz.toString());

        }
    }

    public void preOrdem(){
        posOrdem(raiz);

    }

    private void preOrdem(NoAVL<T> noRaiz){
        if(!isEmpty(noRaiz)){
            System.out.println(noRaiz.toString());
            inOrdem(noRaiz.getNoEsquerdo());
            inOrdem(noRaiz.getNoDireito());
        }
    }

}
