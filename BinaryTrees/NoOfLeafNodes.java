package Trees;

import static Trees.BinarySearchTree.insertNode;

public class NumLeafNodes {
    public static int getLeafNodes(Node node){
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return 1;
        return getLeafNodes(node.left)+getLeafNodes(node.right);
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,17);
        root = insertNode(root,25);
        root = insertNode(root,6);
        root = insertNode(root,11);
        root = insertNode(root,16);
        root = insertNode(root,27);
        System.out.println(getLeafNodes(root));
    }
}
