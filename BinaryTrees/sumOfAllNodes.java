package Trees;

import static Trees.BinarySearchTree.insertNode;

public class SumOfNodes {
    public static void main(String[] args) {
        Node root = null;
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
        System.out.println(getSumOfNodes(root));

    }
    public static int getSumOfNodes(Node node){
        if(node==null)
            return 0;
        return node.data+getSumOfNodes(node.left)+getSumOfNodes(node.right);
    }
}
