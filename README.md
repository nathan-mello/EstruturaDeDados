# Estrutura De Dados

#### Implementação das principais estruturas de dados 🎲 



## Tabela de conteúdos

   * [Estruturas de dados](#estruturas-de-dados)

      * [Fila(Queue)](##fila(queue))
      * [Pilha(Stack)](##pilha(Stack))
      * [Lista Encadeada(LinkedList)](##lista-encadeada(LinkedList))
      * [Lista Duplamente Encadeada(DoublyLinkedList)](##Lista-Duplamente-Encadeada(DoublyLinkedList))
      * [Lista Circular(RingBuffer)](##lista-circular(RingBuffer))
      * [Grafo(Graph)](##Grafo(Graph))
      * [Árvore Binária(BiTree)](##árvore-binária(BiTree))
      * [Árvore AVL(AvlTree)](##árvore-AVL(AvlTree))

   * [Status do Projeto](#status-do-projeto)

* [Autor](#autor)

* [Licença](#licença)

* [Referencias](#referencias)

     


## Estruturas de dados

Estrutura de dados é um modo de armazenar e organizar dados de forma eficiente e com um objetivo específico. É um conceito fundamental na ciência da computação, pois fornece uma maneira de manipular, armazenar e buscar informações de forma mais eficiente. As estruturas de dados podem ser classificadas em várias categorias, como lineares, não lineares, homogêneas, heterogêneas, estáticas e dinâmicas, e cada uma possui suas próprias características e usos específicos. As principais estruturas de dados incluem filas, pilhas, listas encadeadas, árvores e grafos.

**Lineares** são organizadas de forma sequencial/linear onde os elementos tem uma relação de um-a-um, ou seja, cada nó tem a referência para o próximo até null. E a ordem depende da inserção ou deleção. As principais estruturas de dados lineares são  Filas, Pilhas e listas.

<img src=".\Diagrama sem nome.drawio (1).png" style="zoom:80%;" />



**Estruturas de dados não lineares** não têm uma relação um-a-um entre os elementos. Em vez disso, elas são organizadas hierarquicamente ou de forma ramificada. Alguns exemplos de estruturas de dados não lineares incluem árvores, grafos, tabelas hash e conjuntos. Essas estruturas de dados são usadas para armazenar e organizar dados complexos e relacionamentos entre dados.

<img src=".\Diagrama sem nome.drawio.png" style="zoom:70%;" />



**homogêneas**: só aceita um tipo de dados.

**Heterogêneas**: aceita vários tipos de dados.

**Estáticas**: tem capacidade e tamanho fixo.

**Dinâmicas**: não tem capacidade e tamanho fixo.



### Estrutura de dados Lineares

### Fila(Queue)

**Filas** são estruturas de dados dinâmicas e lineares que seguem a política de "primeiro a entrar é o primeiro a sair" (FiFo - First-In-First-Out). Essa estrutura de dados é composta por um conjunto de elementos, onde cada elemento é adicionado no final da fila e removido do início da fila. O primeiro elemento que entra na fila é também o primeiro a sair, e o último elemento que entra na fila é também o último a sair. As filas são usadas em situações onde é necessário manter a ordem de chegada dos elementos.

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

    ```pseudocode
    excluindo(){
        Se(FilaNaoVazia()){
            No SegundoNo = noReferencia;
            No PrimeiroNo = noReferencia;
            boolean verdade = true;
            Se(verdade){
                Se(PrimeiroNo.proximoNo()!=null){
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
    ```
    


### Pilha(Stack)

**pilha** é uma estrutura de dados linear que segue o princípio LIFO (Last In, First Out), o que significa que o último elemento adicionado à pilha é o primeiro a ser removido. A pilha é um tipo de coleção que suporta duas operações principais: empilhar (push), que adiciona um elemento ao topo da pilha, e desempilhar (pop), que remove e retorna o elemento no topo da pilha. Além disso, a pilha também pode suportar outras operações, como verificar o elemento no topo da pilha (top) e verificar se a pilha está vazia (empty). As pilhas são frequentemente utilizadas em algoritmos que exigem rastreamento da ordem em que as operações foram realizadas, como por exemplo, ao desfazer ações em um editor de texto.

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

**Listas encadeadas** são estruturas de dados dinâmicas, onde cada elemento da lista é representado por um nó que contém dois campos: o primeiro armazena o dado e o segundo é uma referência que aponta para o próximo nó da lista. A principal vantagem de usar uma lista encadeada é que ela permite a remoção e a inserção de elementos em qualquer posição da lista de maneira eficiente. Assim o tamanho das listas pode ser facilmente alterado durante a execução do programa sem a necessidade de realocação de memória.

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



### Lista Duplamente Encadeada(doublyLinkedList)

A lista duplamente Encadeada é uma variação da lista encadeada, onde cada Nó tem a referência para o próximo no da lista e  para o Nó anterior, o que permite percorre a lista do primeiro elemento ao último, e em sentido contrário, do último elemento para o primeiro. 

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



### Lista Circular(RingBuffer)

Outra Variação da lista encadeada é a **Lista Circular**, onde cada elemento possui um referência para o próximo elemento, e o último elemento da lista aponta para o primeiro elemento, formando assim um circuito fechado. Uma das principais vantagens da lista circular é que ela permite a implementação eficiente de estruturas circulares, como filas circulares e buffers circulares, sem a necessidade de copiar elementos entre as extremidades da lista. Além disso, como a lista circular não possui um fim definido, ela pode ser percorrida indefinidamente sem nunca chegar a um ponto final.

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

## Implementação das principais estrutura de dados



### Status do Projeto

🚧 Em construção... 🚧

### Autor

Feito por Nathan Mello!

[![Linkedin Badge](https://img.shields.io/badge/Linkedin-Nathan%20Mello-blue)](https://www.linkedin.com/in/nathanll/) [![Gmail Badge](https://img.shields.io/badge/Gmail-Nathan%20Mello-red)](mailto:nathansalesmello@gmail.com)

### Licença

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

### Referencias

- Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein. *Algoritmos: Teoria e Prática.* 3a edição. Elsevier, 2012. 
- Aguilar, Luis Joyanes.  Fundamentos de programação:  algoritmos, estruturas de dados e objetos. 3a edição. AMGH, 2011.





