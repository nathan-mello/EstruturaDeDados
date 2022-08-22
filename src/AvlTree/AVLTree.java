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


    public int fatorB(NoAVL<T> subTree){
        if(!isEmpty(subTree)){
            NoAVL<T> left = subTree.getNoEsquerdo();
            NoAVL<T> right = subTree.getNoEsquerdo();

            int heightLeft = (isEmpty(left)) ? 0 : left.getHeight();
            int heightRight = (isEmpty(right)) ? 0 : right.getHeight();

            return heightLeft - heightRight;
        }
        return 0;
    }

    // ------------------------------------------------------

    private NoAVL<T> leftRotation(NoAVL<T> subTree){
        NoAVL<T> temp = subTree.getNoDireito();
        subTree.setNoDireito(temp.getNoEsquerdo());

        temp.setNoEsquerdo(subTree);

        subTree.setHeight(Math.max(
                subTree.getNoEsquerdo().getHeight(),
                subTree.getNoDireito().getHeight()
        ) + 1);

        temp.setHeight(Math.max(
                temp.getNoDireito().getHeight(),
                temp.getNoEsquerdo().getHeight()
        ) + 1);

        return temp;

    }

    private NoAVL<T> rightRotation(NoAVL<T> subTree){
        NoAVL<T> temp = subTree.getNoEsquerdo();
        subTree.setNoEsquerdo(temp.getNoDireito());

        temp.setNoDireito(subTree);

        subTree.setHeight(Math.max(
                subTree.getNoEsquerdo().getHeight(),
                subTree.getNoDireito().getHeight()
        ) + 1);

        temp.setHeight(Math.max(
                temp.getNoDireito().getHeight(),
                temp.getNoEsquerdo().getHeight()
        ) + 1);

        return temp;

    }

    private NoAVL<T> doubleRotationLR(NoAVL<T> subTree){
        subTree.setNoEsquerdo(leftRotation(subTree.getNoEsquerdo()));
        return rightRotation(subTree);

    }

    private NoAVL<T> doubleRotationRL(NoAVL<T> subTree){
        subTree.setNoDireito(rightRotation(subTree.getNoDireito()));
        return leftRotation(subTree);
    }


    // ---------------------------------------------------------

    public void insert(T conteudo, int id) {
        NoAVL<T> no = new NoAVL<>(id, conteudo);

        raiz = insert(raiz, no);

    }

    private NoAVL<T> insert(NoAVL<T> subTree, NoAVL<T> no){

        if(isEmpty(subTree)){
            return no;
        }
        else if(no.getId() < subTree.getId()){
            subTree.setNoEsquerdo(insert(subTree.getNoEsquerdo(), no));
            if(subTree.getHeight()<= subTree.getNoEsquerdo().getHeight()){
                subTree.heightMore();
            }
        }else{

            subTree.setNoDireito(insert(subTree.getNoDireito(), no));
            if(subTree.getHeight()<= subTree.getNoDireito().getHeight()){
                subTree.heightMore();
            }
        }
        return subTree;

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
