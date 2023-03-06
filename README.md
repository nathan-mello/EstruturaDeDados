# Estrutura De Dados

#### Implementação das principais estruturas de dados 🎲 



## Tabela de conteúdos

   * [Estruturas de dados](#estruturas-de-dados)

      * [Fila(Queue)](##fila(queue))
      * [Pilha(Stack)](##pilha(Stack))
      * [Lista Encadeada(LinkedList)](##lista-encadeada(LinkedList))
      * [Lista Duplamente Encadeada(DoublyLinkedList)](##lista-duplamente-encadeada(doublyLinkedList))
      * [Lista Circular(doublyLinkedList)](##lista-circular(RingBuffer))
      * [Grafo(Graph)](##Grafo(Graph))
      * [Árvore Binária(BiTree)](##árvore-binária(BiTree))
      * [Árvore AVL(AvlTree)](##árvore-AVL(AvlTree))

   * [Status do Projeto](#status-do-projeto)

* [Autor](#autor)

* [Licença](#licença)

* [Referencias](#referencias)

     


## Estruturas de dados

Uma estrutura de dados é um modo de armazenar e organizar dados com o objetivo de facilitar acesso e modificações. Nenhuma estrutura de dados única funciona bem para todas as finalidades e, por isso, é importante conhecer os pontos fortes e as limitações de várias delas (Cormen, 2012). E podem ser classificadas como lineares e não lineares; homogêneas e heterogêneas; estáticas e dinâmicas.

**Lineares** são organizadas de forma sequencial/linear e tem apenas um nível, ou seja, cada nó tem a referência para o próximo até null. E a ordem depende da inserção ou deleção. Exemplos: Filas, Pilhas e listas.



<img src="C:\Users\natha\Downloads\Diagrama sem nome.drawio (1).png" alt="70" style="zoom:80%;" />



**Não lineares** são formadas por vários níveis, onde os nós ou vértices podem tem várias referencias. Exemplos: Árvores e Grafos.

<img src="C:\Users\natha\Downloads\Diagrama sem nome.drawio.png" alt="8" style="zoom:50%;" />

**homogêneas**: só aceita um tipo de dados.

**Heterogêneas**: aceita vários tipos de dados.

**Estáticas**: tem capacidade e tamanho fixo.

**Dinâmicas**: não tem capacidade e tamanho fixo.



### Estrutura de dados Lineares

### Fila(Queue)

**Filas** são estruturas de dados dinâmicas e lineares que segue a política de primeiro a entrar é o primeiro a sair **FiFo (first-in first-out)**, tendo um início ou "cabeça" e por um fim ou "calda". Quando adiciona-se um novo objeto a fila ele assume a posição final "calda" e sempre remove o objeto do início da final.

#### métodos e pseudocódigo 

- first() - retorna o conteúdo do  primeiro Nó da fila;

```pseudocode
PrimeiroNo(){
Se(FilaNaoVazia()){
    No noAtual = noReferencia;
    boolean verdade = true;

    Enquanto(verdade){
        Se(noAtual.proximoNo() != null){
            noAtual = noAtual.proximoNo();
        }SeNao{
            verdade = false;
        }
    }
    retorno noAtual;

}
retorno null;
}
```



- enQueue(T obj) -cria e adiciona um novo Nó na fila;

```pseudocode
inserindo(obj){
    novoNo = new NoFila(obj);
    novoNo.setNovoNo(referenciaNo);
    referenciaNo = novoNo;

}
```



- dequeue() - remove o primeiro Nó da fila  e retorna o seu conteúdo;

    excluindo(){
        Se(FilaNaoVazia()){
            No SegundoNo = noReferencia;
            No PrimeiroNo = noReferencia;
    
            boolean verdade = true;
            Se(verdade){
                if(PrimeiroNo.proximoNo()!=null){
                    SegundoNo = PrimeiroNo;
                    PrimeiroNo = PrimeiroNo.proximoNo();
                }SeNao{
                    verdade = false;
    
                    Se(noReferencia.proximoNo() == null){
                        noReferencia = null;
                        retorno null;
                    }
    
                    Segundo.setProximoNo(null);
                }
            }
            retorno PrimeiroNo;
    
        }
        retorno null;
    }


### Pilha(Stack)

**Pilhas** são estruturas de dados dinâmicas e lineares; Diferentemente da fila, a pilha segue a política de último a entra é o primeiro a sair **LiFo (last-in frist-out)**.

#### métodos e pseudocódigo 

- pop() - remove um Nó da pinha

```pseudocode
remover(){
    Se(pilhaNaoVazia){
        No noRetorno = topoPilha;
        topoPilha = topoRetorno.proximoNo();
        returno noRetorno;

    }
    returno null;
}
```



- push(T obj) -  cria e adiciona um novo Nó na pilha

```pseudocode
adicionar(obj){
    No novoNo = new NoPilha(object);
    No reference = top;
    top = novoNo;
    novoNO.setProximoNo(reference);
}
```



### Lista Encadeada(LinkedList)

**lista encadeadas** são Estrutura de dados lineares e dinâmicas, que são composta por várias células que estão interligadas através de referências, ou seja, cada célula possui um ponteiro que aponta para a próxima célula. Isso faz com que a estrutura se torne dinâmica, pois há qualquer momento, é possível alocar uma nova célula e mudar as referências das células já existentes.

#### métodos e pseudocódigo 

- size() - retorna o tamanho da lista

```pseudocode
 tamanhoLista(){
    int tamanho = 0;

    No noAtual = primeiroNo;

    boolean verdade = true;
    Enquanto(verdade){
        Se(noAtual != null){
            tamanho++;
            noAtual = noAtual.getProximoNo();
        }Senao{
            verdade = false;
        }

    }
    returno  tamanho;
}
```



- add(T dado) - cria e adiciona um novo Nó no final da lista

```pseudocode
adicionar(obj){
    novoNo = new NoLista(obj);
    Se(listaVazia()){
        primeiroNo = novoNo;
        return;
    }
    No no = primeiroNo;

    for(int i=0; i<tamanhoLista()-1; i++){
        no = primeiroNo.getproximoNo();

    }
    no.setProximoNO(novoNo);

}
```



- get(int index) - retorna um Nó da lista

```pseudocode
getNo(index){
    validarIndice(index);

    No noAxiliar = primeirotNo;
    No noRetorno = null;

    for(int i=0; i<=index; i++){
        noRetorno = noAxiliar;
        noAxiliar = noAxiliar.getProximoNo();
    }
    return noRetorno;


}
```



- remove(int index) -  remove e retorna um Nó da lista

```pseudocode
remove(index){

    Se(listaVazia()){return null;}
    
    No noPivo = getNo(index);

    if(index == 0){
        noPivo = primeiroNo;
        primeiroNo = noPivo.getProximoNO();
        return noPivo;
    }

    No noAnterior = getNo(index -1);

    noAnterior.setProximoNo(noPivo.getProximoNo());
    return noPivo;

}
```



### Lista Duplamente Encadeada(RingBuffer)

**Lista duplamente encadeada** é uma variação da lista encadeada, a diferença entre as duas e que a lista duplamente encadeada os Nós são formados por duas referências: uma para o próximo Nó e uma para o Nó Anterior.  

#### métodos

- size() - retorna o tamanho da lista

```pseudocode
 tamanhoLista(){
    int tamanho = 0;

    No noAtual = primeiroNo;

    boolean verdade = true;
    Enquanto(verdade){
        Se(noAtual != null){
            tamanho++;
            noAtual = noAtual.getProximoNo();
        }Senao{
            verdade = false;
        }

    }
    returno  tamanho;
}
```



- get(int index) - retorna o conteúdo de um Nó a partir de um index

```pseudocode
getNo(int index){
    No noAuxiliar = primeiroNo;

    for(int i = 0; (i < index && (noAuxiliar != null)); i ++){
        noAuxiliar = noAuxiliar.getProximoNo();
    }

    returno noAuxiliar;
}

get(int index){
    returno getNo(index);

}
```



- add(T conteudo) - cria um novo No é adiciona no final da lista duplamente Encadeada 

```pseudocode
add(conteudo){
    No no = new NoDouble(conteudo);

    no.setNextNo(null);
    no.setNextNo(anterior);

    Se(proximo == null){
        proximo = no;
    }
    Se(anterior != null){
        anterior.setProximoNo(no);
    }
    anterior = no;
    TamanhoLista++;

}
```



- add(T conteudo, int index) - cria um novo Nó é adiciona na lista duplamente Encadeada em um index específico

```pseudocode
add(conteudo, int index){
    No no = new NoDouble(conteudo);
    No noAuxiliar = getNo(index);

    Se(no.getProximoNo() != null){
        no.setProximoNo(noAuxiliar.getProximoNo());
        no.getProximoNo().setProximoNo(no);
    }Senao{
        no.setProximoNo(anterior);
        anterior = no;
    }

    Se(index == 0){
        proximo = no;
    }Senao{
        no.getProximoNo().setProximoNO(no);
    }

    TamanhoLista++;
}
```



- remove(int index) - remove um Nó a partir de um index

```pseudocode
remove(int index){

    Se(index == 0){
        proximo = proximo.getProximoNo();
        Se(proximo != null){
            proximo.setProximoNo(null);
        }

    }Senao{
        No noAxiliar = getNo(index);
        noAxiliar.getProximoNo().setProximoNo(noAxiliar.getProximoNo());

        Se(noAxiliar != anterior){
            noAxiliar.getProximoNo().setProximoNo(noAxiliar.getProximoNo());
        } Senao{
            anterior.setProximoNo(noAxiliar);
        }
    }

    this.TamanhoLista--;
}
```



### Lista Circular(doublyLinkedList)

Outra Variação da lista encadeada é a **Lista Circular**, onde o último Nó tem uma referência para o primeiro formando loop infinito.

#### métodos e pseudocódigo 


  - get(int index) - retorna o conteúdo de um Nó a partir de um index

```pseudocode
getNo(int index){
    Se(ListaVazia()){
        retorno null;

    }

    Se(index == 0){
        returno caldacalda;
    }

    No noAuxiliar = calda;

    for(int i=0; i<index && noAuxiliar != null; i++){
        noAuxiliar = noAuxiliar.getProximoNo();
    }
    returno noAuxiliar;


}

get(int index){
    returno getNo(index);

}
```




  - remove(int index) - remove um Nó a partir de um index

```pseudocode
remove(int index){

    Se(index>=tamanhoList){
        retorno null;
    }

    No noAulixiar = calda;
    Se(index==0){

       calda = calda.getProximoNo();

    }Se(index==1){

        calda.setProximoNo(calda.getProximoNo().getProximoNo());
    }Senao{
        for(int i=0; i<=index-1; i++){
            noAulixiar = noAulixiar.getProximoNo();
        }

        noAulixiar.setProximoNo(noAulixiar.getProximoNo().getProximoNo());
    }
    tamanhoLista--;
}
```




  - add(T conteudo) - cria um novo Nó é adiciona na lista

```pseudocode
add(conteudo){
    No novoNo = new NoCircular(conteudo);
    Se(tamanhoList==0){
        cabeca = novoNo;
        calda = cabeca;
        cabeca.setProximoNo(calda);
    }Senao{
        novoNo.setProximoNo(calda);
        cabeca.setProximoNo(novoNo);
        calda = novoNo;
    }

    tamanhoList++;
}
```



### Grafo(Graph)


  - 


### Árvore Binária(BiTree)


  - 

### Árvore AVL(AvlTree)



### Status do Projeto

🚧 Em construção... 🚧

### Autor

Feito por Nathan Mello!

[![Linkedin Badge](https://img.shields.io/badge/Linkedin-Nathan%20Mello-blue)](https://www.linkedin.com/in/nathanll/) [![Gmail Badge](https://img.shields.io/badge/Gmail-Nathan%20Mello-red)](mailto:nathansalesmello@gmail.com)

### Licença

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

### Referencias

- Cormen, Thomas; Algoritmos: teoria e prática. 3 ed. Rio de Janeiro: Elsevier, 2012.





