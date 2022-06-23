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
        }else if(noProximo.getConteudo().compareTo(noAtual.getConteudo())<0){
            noAtual.setNoEsquerdo(inserir(noAtual.getNoEsquerdo(), noProximo));
        }else {
            noAtual.setNoDireito(inserir(noAtual.getNoDireito(), noProximo));
        }
        return noAtual;
    }


    public void inOrdem(){
        System.out.println("\nmostrar em ordem");
        inOrdem(raiz);

    }

    private void inOrdem(NoTree<T> noAtual){
        if(noAtual != null){
            inOrdem(noAtual.getNoEsquerdo());
            System.out.print(noAtual.getConteudo() + ", ");
            inOrdem(noAtual.getNoDireito());
        }
    }

    public void posOrdem(){
        System.out.println("\nmostrar  posOrdem");
        posOrdem(this.raiz);

    }

    private void posOrdem(NoTree<T> noAtual){
        if(noAtual != null){
            posOrdem(noAtual.getNoEsquerdo());
            posOrdem(noAtual.getNoDireito());
            System.out.print(noAtual.getConteudo() + ", ");

        }
    }

    public void preOrdem(){
        System.out.println("\nmostrar em preOrdem");
        preOrdem(this.raiz);

    }

    private void preOrdem(NoTree<T> noAtual){
        if(noAtual != null){
            System.out.print(noAtual.getConteudo() + ", ");
            preOrdem(noAtual.getNoEsquerdo());
            preOrdem(noAtual.getNoDireito());

        }
    }


    public void remove(T comteudo){
        try{
            NoTree<T> noAtual = raiz;
            NoTree<T> noPai   = null;
            NoTree<T> noFilho;
            NoTree<T> noTemp;

            while(noAtual != null && !noAtual.getConteudo().equals(comteudo)){
                noPai = noAtual;

                if(comteudo.compareTo(noAtual.getConteudo())<0){
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
                    for(noTemp = noAtual, noFilho = noAtual.getNoEsquerdo();
                    noFilho.getNoDireito() != null;
                    noTemp = noFilho, noFilho = noFilho.getNoEsquerdo()){

                        if(noFilho != noAtual.getNoEsquerdo()){
                            noTemp.setNoDireito(noFilho.getNoEsquerdo());
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
                for(noTemp =  noAtual,  noFilho= noAtual.getNoEsquerdo();
                    noFilho.getNoDireito() != null;
                    noTemp = noFilho, noFilho = noFilho.getNoDireito()){

                    if(noFilho != noAtual.getNoEsquerdo()){
                        noTemp.setNoDireito(noFilho.getNoEsquerdo());
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

    public T paiNo(T conteudo){
        try{
            NoTree noAtual = raiz;
            NoTree noPai   = null;


            while(noAtual != null && !noAtual.getConteudo().equals(conteudo)){
                noPai = noAtual;

                if(noAtual.getConteudo().compareTo(conteudo)>0){
                    noAtual = noAtual.getNoEsquerdo();
                }else{
                    noAtual = noAtual.getNoDireito();
                }
            }

            if(noAtual == null){
                System.out.println("valor não encontrado");
                return null;
            }

            return (T) noPai.getConteudo();

        } catch (NullPointerException e) {
            System.out.println("valor não encontrado.");
            return null;
        }
    }

}
