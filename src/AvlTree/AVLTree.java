package AvlTree;

public class AVLTree<T> {
    private NoAVL<T> raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public NoAVL<T> getRaiz() {
        return raiz;
    }

    private int heightNo(NoAVL<T> subTree){
        return (isEmpty(subTree)) ? -1 : subTree.getHeight();

    }

    private boolean isEmpty(NoAVL<T> no){
        return no == null;
    }


    public int fatorB(NoAVL<T> subTree){
        if(!isEmpty(subTree)){
            return heightNo(subTree.getNoLeft())
                    - heightNo(subTree.getNoRight());
        }
        return -1;
    }

    // ------------------------------------------------------

    private NoAVL<T> leftRotation(NoAVL<T> subTree){
        NoAVL<T> temp = subTree.getNoRight();
        subTree.setNoRight(temp.getNoLeft());

        temp.setNoLeft(subTree);

        subTree.setHeight(Math.max(
                heightNo(subTree.getNoLeft()),
                heightNo(subTree.getNoRight())
        ) + 1);

        temp.setHeight(Math.max(
                heightNo(temp.getNoLeft()),
                heightNo(temp.getNoRight())
        ) + 1);

        return temp;

    }

    private NoAVL<T> rightRotation(NoAVL<T> subTree){
        NoAVL<T> temp = subTree.getNoLeft();
        subTree.setNoLeft(temp.getNoRight());

        temp.setNoRight(subTree);

        subTree.setHeight(Math.max(
                heightNo(subTree.getNoLeft()),
                heightNo(subTree.getNoRight())
        ) + 1);

        temp.setHeight(Math.max(
                heightNo(temp.getNoLeft()),
                heightNo(temp.getNoRight())
        ) + 1);

        return temp;

    }

    private NoAVL<T> doubleRotationLR(NoAVL<T> subTree){
        subTree.setNoLeft(leftRotation(subTree.getNoLeft()));
        return rightRotation(subTree);

    }

    private NoAVL<T> doubleRotationRL(NoAVL<T> subTree){
        subTree.setNoRight(rightRotation(subTree.getNoRight()));
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
            subTree.setNoLeft(insert(subTree.getNoLeft(), no));


            if(fatorB(subTree)>=2){
                if(no.getId() < subTree.getNoLeft().getId()){
                    return rightRotation(subTree);
                }else{
                    return doubleRotationLR(subTree);
                }
            }

        }else{

            subTree.setNoRight(insert(subTree.getNoRight(), no));


            if(fatorB(subTree) <= -2){
                if(no.getId() > subTree.getNoRight().getId()){
                    return leftRotation(subTree);

                }else{
                    return doubleRotationRL(subTree);
                }
            }

        }

        subTree.setHeight(Math.max(
                heightNo(subTree.getNoLeft()),
                heightNo(subTree.getNoRight())) +1);

        return subTree;

    }




    //  ----------------------------------------------------------------

    public void inOrdem(){
        inOrdem(raiz);

    }

    private void inOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            inOrdem(noRaiz.getNoLeft());
            System.out.print(noRaiz.getId() + " ");
            inOrdem(noRaiz.getNoRight());

        }
    }

    public void posOrdem(){
        posOrdem(raiz);

    }

    private void posOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            posOrdem(noRaiz.getNoLeft());
            posOrdem(noRaiz.getNoRight());
            System.out.print(noRaiz.getId() + " ");

        }
    }

    public void preOrdem(){
        preOrdem(raiz);

    }

    private void preOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            System.out.print(noRaiz.getId() + " ");
            preOrdem(noRaiz.getNoLeft());
            preOrdem(noRaiz.getNoRight());
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
            subTree = subTree.getNoLeft();

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
            subTree = subTree.getNoRight();

        }
        return maior;
    }

    // ---------------------------------------------------------------------

    public T removerID(int conteudo){

        NoAVL<T> noRetorno = searchRemove(conteudo, raiz);

        if(!isEmpty(searchRemove(conteudo, raiz))){
            raiz = removerID(conteudo, raiz);
            return noRetorno.getObject();
        }
        return null;
    }

    public NoAVL<T> searchRemove(int conteudo, NoAVL<T> subTree){
        if(isEmpty(subTree)){
            return null;
        }
        if(conteudo == subTree.getId()){
            return subTree;

        }else{
            if(conteudo< subTree.getId()){
                return searchRemove(conteudo, subTree.getNoLeft());
            }else{
                return searchRemove(conteudo, subTree.getNoRight());
            }

        }

    }

    private NoAVL<T> removerID(int conteudo, NoAVL<T> subTree) {


        if (isEmpty(subTree)) {
            return null;

        } else if (conteudo < subTree.getId()) {
            subTree.setNoLeft(removerID(conteudo, subTree.getNoLeft()));

            if (fatorB(subTree) >= 2) {
                int heightLeft = isEmpty(subTree.getNoRight()) ?
                        -1 : heightNo(subTree.getNoRight().getNoLeft());

                int heightRight = isEmpty(subTree.getNoRight()) ?
                        -1 : heightNo(subTree.getNoRight().getNoRight());

                if (heightLeft <= heightRight) {
                    leftRotation(subTree);
                } else {
                    rightRotation(subTree);
                }

            }

        } else if (conteudo > subTree.getId()) {
            subTree.setNoRight(removerID(conteudo, subTree.getNoRight()));

            if (fatorB(subTree) <= -2) {

                int heightRight = isEmpty(subTree.getNoRight()) ?
                        -1 : heightNo(subTree.getNoLeft().getNoRight());

                int heightLeft = isEmpty(subTree.getNoRight()) ?
                        -1 : heightNo(subTree.getNoLeft().getNoLeft());

                if (heightRight <= heightLeft) {
                    doubleRotationRL(subTree);
                } else {
                    doubleRotationLR(subTree);
                }

            }
        } else {
            if (subTree.getNoLeft() == null) {
                return subTree.getNoRight();

            } else if (subTree.getNoRight() == null) {
                return subTree.getNoLeft();

            } else {
                NoAVL<T> noTemporario = noMenor(subTree.getNoRight());

                subTree.setId(noTemporario.getId());
                subTree.setObject(noTemporario.getObject());

                subTree.setNoRight(removerID(noTemporario.getId(), subTree.getNoRight()));

                if (fatorB(subTree) <= -2) {

                    int heightRight = isEmpty(subTree.getNoRight()) ?
                            -1 : heightNo(subTree.getNoLeft().getNoRight());

                    int heightLeft = isEmpty(subTree.getNoRight()) ?
                            -1 : heightNo(subTree.getNoLeft().getNoLeft());

                    if (heightRight <= heightLeft) {
                        doubleRotationRL(subTree);
                    } else {
                        doubleRotationLR(subTree);
                    }

                }
            }

        }
        return subTree;
    }
}
