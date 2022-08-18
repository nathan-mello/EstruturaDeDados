package AvlTree;

public class AVLTree<T> {
    private NoAVL<T> raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public NoAVL<T> getRaiz() {
        return raiz;
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


    //  ----------------------------------------------------------------

    public void inOrdem(){
        inOrdem(raiz);

    }

    private void inOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            inOrdem(noRaiz.getNoEsquerdo());
            System.out.print(noRaiz.getId() + " ");
            inOrdem(noRaiz.getNoDireito());

        }
    }

    public void posOrdem(){
        posOrdem(raiz);

    }

    private void posOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            posOrdem(noRaiz.getNoEsquerdo());
            posOrdem(noRaiz.getNoDireito());
            System.out.print(noRaiz.getId() + " ");

        }
    }

    public void preOrdem(){
        preOrdem(raiz);

    }

    private void preOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            System.out.print(noRaiz.getId() + " ");
            preOrdem(noRaiz.getNoEsquerdo());
            preOrdem(noRaiz.getNoDireito());
        }
    }


    // ------------------------------------------------------------------

    public NoAVL<T> noMenor(){
        return noMenor(raiz);
    }

    private NoAVL<T> noMenor(NoAVL<T> subTree){
        NoAVL<T> menor = subTree;

        while(!isEmpty(subTree)){
            menor = subTree;
            subTree = subTree.getNoEsquerdo();

        }
        return menor;
    }

    public NoAVL<T> noMaior(){
        return noMaior(raiz);
    }

    private NoAVL<T> noMaior(NoAVL<T> subTree){
        NoAVL<T> maior = subTree;

        while(!isEmpty(subTree)){
            maior = subTree;
            subTree = subTree.getNoDireito();

        }
        return maior;
    }

    // ---------------------------------------------------------------------

    public void removerID(int conteudo){
        removerID(conteudo, raiz);
    }

    private NoAVL<T> removerID(int conteudo, NoAVL<T> subTree){

        if(isEmpty(subTree)){
            return null;

        }else if(conteudo>subTree.getId()){
            subTree.setNoDireito(removerID(conteudo, subTree.getNoDireito()));

        }else if(conteudo<subTree.getId()){
            subTree.setNoEsquerdo(removerID(conteudo, subTree.getNoEsquerdo()));
        }
        else{
            if(subTree.getNoEsquerdo() == null){
                return subTree.getNoDireito();

            }else if(subTree.getNoDireito() == null){
                return  subTree.getNoEsquerdo();

            }else{
                NoAVL<T> noTemporario = noMenor(subTree.getNoDireito());

                subTree.setId(noTemporario.getId());
                subTree.setConteudo(noTemporario.getConteudo());

                removerID(noTemporario.getId(), subTree.getNoDireito());
            }
        }
        return subTree;

    }

}
