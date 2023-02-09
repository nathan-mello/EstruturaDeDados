package biTree;

public class BiTree<T extends Comparable<T>> {

    private NoTree<T> raiz;

    public BiTree() {
        this.raiz = null;
    }

    public void inserir(T conteudo){
        NoTree<T> novoNo = new NoTree<>(conteudo);
        raiz = inserir(raiz, novoNo);

    }

    private NoTree<T> inserir(NoTree<T> noAtual, NoTree<T> noProximo){
        if(noAtual == null){
            return noProximo;
        }else if(noProximo.getObject().compareTo(noAtual.getObject())<0){
            noAtual.setNoLeft(inserir(noAtual.getNoLeft(), noProximo));
        }else {
            noAtual.setNoRight(inserir(noAtual.getNoRight(), noProximo));
        }
        return noAtual;
    }


    public void inOrdem(){
        System.out.println("\nmostrar em ordem");
        inOrdem(raiz);

    }

    private void inOrdem(NoTree<T> noAtual){
        if(noAtual != null){
            inOrdem(noAtual.getNoLeft());
            System.out.print(noAtual.getObject() + ", ");
            inOrdem(noAtual.getNoRight());
        }
    }

    public void posOrdem(){
        System.out.println("\nmostrar  posOrdem");
        posOrdem(this.raiz);

    }

    private void posOrdem(NoTree<T> noAtual){
        if(noAtual != null){
            posOrdem(noAtual.getNoLeft());
            posOrdem(noAtual.getNoRight());
            System.out.print(noAtual.getObject() + ", ");

        }
    }

    public void preOrdem(){
        System.out.println("\nmostrar em preOrdem");
        preOrdem(this.raiz);

    }

    private void preOrdem(NoTree<T> noAtual){
        if(noAtual != null){
            System.out.print(noAtual.getObject() + ", ");
            preOrdem(noAtual.getNoLeft());
            preOrdem(noAtual.getNoRight());

        }
    }


    public void remove(T comteudo) {
        try{
            NoTree<T> noAtual = raiz;
            NoTree<T> noPai   = null;
            NoTree<T> noFilho;
            NoTree<T> noTemp;

            while(noAtual != null && !noAtual.getObject().equals(comteudo)){
                noPai = noAtual;

                if(comteudo.compareTo(noAtual.getObject())<0){
                    noAtual = noAtual.getNoLeft();
                }else{
                    noAtual = noAtual.getNoRight();
                }
            }

            if(noAtual == null){
                System.out.println("valor não encontrado");
            }else{
                if(noPai == null){
                    if(noAtual.getNoRight()==null){
                        this.raiz = noAtual.getNoLeft();
                    }else if(noAtual.getNoLeft()==null){
                        this.raiz = noAtual.getNoRight();
                    }else{
                        for(noTemp = noAtual, noFilho = noAtual.getNoLeft();
                            noFilho.getNoRight() != null;
                            noTemp = noFilho, noFilho = noFilho.getNoLeft()){

                            if(noFilho != noAtual.getNoLeft()){
                                noTemp.setNoRight(noFilho.getNoLeft());
                                noFilho.setNoLeft(raiz.getNoLeft());
                            }

                        }
                        noFilho.setNoRight(raiz.getNoRight());
                        raiz = noFilho;
                    }

                }else if(noAtual.getNoRight()==null){
                    if(noPai.getNoLeft() == noAtual){
                        noPai.setNoLeft(noAtual.getNoLeft());
                    }else{
                        noPai.setNoRight(noAtual.getNoLeft());
                    }

                }else if(noAtual.getNoLeft()==null){
                    if(noPai.getNoLeft() == noAtual){
                        noPai.setNoLeft(noAtual.getNoRight());
                    }else{
                        noPai.setNoRight(noAtual.getNoRight());
                    }

                }else{
                    for(
                            noTemp =  noAtual,  noFilho= noAtual.getNoLeft();
                            noFilho.getNoRight() != null;
                            noTemp = noFilho, noFilho = noFilho.getNoRight()
                    ){


                        if(noFilho != noAtual.getNoLeft()){
                            noTemp.setNoRight(noFilho.getNoLeft());
                            noFilho.setNoLeft(noAtual.getNoLeft());
                        }

                        noFilho.setNoRight(noAtual.getNoRight());

                        if(noPai.getNoLeft() == noAtual){
                            noPai.setNoLeft(noFilho);
                        }else{
                            noPai.setNoRight(noFilho);
                        }
                    }

                }
            }
        } catch (NullPointerException e) {
            System.out.println("valor não encontrado.");
        }


    }

    public T paiNo(T conteudo){
        try{
            NoTree<T> noAtual = raiz;
            NoTree<T> noPai   = null;


            while(noAtual != null && !noAtual.getObject().equals(conteudo)){
                noPai = noAtual;

                if(noAtual.getObject().compareTo(conteudo)>0){
                    noAtual = noAtual.getNoLeft();
                }else{
                    noAtual = noAtual.getNoRight();
                }
            }

            if(noAtual == null){
                System.out.println("valor não encontrado");
                return null;
            }else{
                return noPai != null ? noPai.getObject() : null;
            }

        } catch (NullPointerException e) {
            System.out.println("valor não encontrado.");
            return null;
        }
    }

}
