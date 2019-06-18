package Trees;

import static Trees.BinarySearchTree.insertNode;

public class InsertNodes {
    public static void main(String[] args) {
    }
    public static Node insertUtil(Node root){
        root = insertNode(root,15);
        root = insertNode(root,10);
        root = insertNode(root,20);
        root = insertNode(root,8);
        root = insertNode(root,12);
        root = insertNode(root,17);
        root = insertNode(root,25);
        root = insertNode(root,6);
        root = insertNode(root,11);
        root = insertNode(root,16);
        root = insertNode(root,27);
        return root;
    }
}
