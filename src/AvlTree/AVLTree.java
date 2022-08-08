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


    //  ----------------------------------------------------------------

    public void inOrdem(){
        inOrdem(raiz);

    }

    private void inOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            inOrdem(noRaiz.getNoEsquerdo());
            System.out.print(noRaiz.toString());
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
            System.out.print(noRaiz.toString());

        }
    }

    public void preOrdem(){
        preOrdem(raiz);

    }

    private void preOrdem(NoAVL<T> noRaiz){
        if(noRaiz != null){
            System.out.print(noRaiz.toString());
            preOrdem(noRaiz.getNoEsquerdo());
            preOrdem(noRaiz.getNoDireito());
        }
    }


    // ------------------------------------------------------------------

    public NoAVL<T> noMenor(NoAVL<T> subTree){
        NoAVL<T> menor = subTree;

        while(!isEmpty(subTree)){
            menor = subTree;
            subTree = subTree.getNoEsquerdo();

        }
        return menor;
    }


    public NoAVL<T> noMaior(NoAVL<T> subTree){
        NoAVL<T> maior = subTree;

        while(!isEmpty(subTree)){
            maior = subTree;
            subTree = subTree.getNoDireito();

        }
        return maior;
    }

    public void removeID(int conteudo){

        try{
            NoAVL<T> noAtual = raiz;
            NoAVL<T> noPai = null;
            NoAVL<T> noFilho;
            NoAVL<T> notemporario;


            while(noAtual != null && noAtual.getId() != conteudo){
                noPai = noAtual;

                if(conteudo<noAtual.getId()){
                    noAtual = noAtual.getNoEsquerdo();
                }else{
                    noAtual = noAtual.getNoDireito();
                }
            }

            if(noAtual == null){
                System.out.println("valor não encontrado");
            }

            if(noPai == null){
                if(noAtual.getNoDireito()==null){
                    this.raiz = noAtual.getNoEsquerdo();

                }else if(noAtual.getNoEsquerdo()==null){
                    this.raiz = noAtual.getNoDireito();

                }else{
                    for(notemporario = noAtual, noFilho = noAtual.getNoEsquerdo();
                        noFilho.getNoDireito() != null;
                        notemporario = noFilho, noFilho = noFilho.getNoEsquerdo()){

                        if(noFilho != noAtual.getNoEsquerdo()){
                            notemporario.setNoDireito(noFilho.getNoEsquerdo());
                            noFilho.setNoEsquerdo(raiz.getNoEsquerdo());
                        }

                    }
                    noFilho.setNoDireito(raiz.getNoDireito());
                    raiz = noFilho;
                }

            }else if(noAtual.getNoDireito()==null){
                if(noPai.getNoEsquerdo() == noAtual){
                    noPai.setNoEsquerdo(noAtual.getNoEsquerdo());

                }else{
                    noPai.setNoDireito(noAtual.getNoEsquerdo());

                }

            }else if(noAtual.getNoEsquerdo()==null){
                if(noPai.getNoEsquerdo() == noAtual){
                    noPai.setNoEsquerdo(noAtual.getNoDireito());

                }else{
                    noPai.setNoDireito(noAtual.getNoDireito());

                }

            }else{
                for(notemporario =  noAtual,  noFilho= noAtual.getNoEsquerdo();
                    noFilho.getNoDireito() != null;
                    notemporario = noFilho, noFilho = noFilho.getNoDireito()){


                    if(noFilho != noAtual.getNoEsquerdo()){
                        notemporario.setNoDireito(noFilho.getNoEsquerdo());
                        noFilho.setNoEsquerdo(noAtual.getNoEsquerdo());
                    }

                    noFilho.setNoDireito(noAtual.getNoDireito());

                    if(noPai.getNoEsquerdo() == noAtual){
                        noPai.setNoEsquerdo(noFilho);
                    }else{
                        noPai.setNoDireito(noFilho);
                    }
                }

            }

        } catch (NullPointerException e) {
            System.out.println("valor não encontrado.");
        }


    }

}
