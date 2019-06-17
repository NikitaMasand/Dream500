package Trees;

import static Trees.BinarySearchTree.insertNode;

public class NumOfNodes {
    public static int getNumNodes(Node node){
        if(node==null)
            return 0;
        return 1+getNumNodes(node.left)+getNumNodes(node.right);
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,15);
        root = insertNode(root,10);
        root = insertNode(root,20);
        root = insertNode(root,8);
        System.out.println(getNumNodes(root));
    }
}
