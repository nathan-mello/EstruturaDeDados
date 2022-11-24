package AvlTree;

public class main {
    public static void main(String[] args) {

        AVLTree<String> tree = new AVLTree<>();

//        tree.insert("texto", 61);
//        tree.insert("texto", 89);
//        tree.insert("texto", 66);
//        tree.insert("texto", 43);
//        tree.insert("texto", 51);
//        tree.insert("texto", 16);
//        tree.insert("texto", 55);
//        tree.insert("texto", 11);
//        tree.insert("texto", 79);
//        tree.insert("texto", 77);
//        tree.insert("texto", 82);
//        tree.insert("texto", 32);
//        tree.insert("nathan", 100);

        tree.insert("texto" , 1);
        tree.insert("texto" , 2);
        tree.insert("texto" , 3);
        tree.insert("texto" , 4);
        tree.insert("texto" , 5);
        tree.insert("texto" , 6);
        tree.insert("texto" , 7);


        System.out.println("max = " + tree.noMaior().toString());
        System.out.println("min = " + tree.noMenor().toString());

        tree.inOrdem();
        System.out.println();

        System.out.println(tree.removerID(89));

        tree.inOrdem();


    }
}
