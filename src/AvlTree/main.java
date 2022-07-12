package AvlTree;

public class main {
    public static void main(String[] args) {
        AVLTree<String> tree = new AVLTree<>();

        tree.insert("amor", 6);
        tree.insert("amor", 5);
        tree.insert("amor", 7);
        tree.insert("amor", 3);
        tree.insert("amor", 4);
        tree.insert("amor", 8);
        tree.insert("amor", 9);
        tree.insert("amor", 1);

        tree.inOrdem();

    }
}
