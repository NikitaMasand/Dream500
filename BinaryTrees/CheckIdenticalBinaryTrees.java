package Trees;

import static Trees.BinarySearchTree.insertNode;

public class CheckIfIdenticalBinaryTrees {
    public static boolean isIdentical(Node node_1, Node node_2){
        if(node_1==null && node_2==null)
            return true;
        if(node_1==null || node_2==null)
            return false;
        return node_1.data==node_2.data &&
                isIdentical(node_1.left,node_2.left)&&
                isIdentical(node_1.right,node_2.right);
    }

    public static void main(String[] args) {
        Node root1 = null;
        root1 = insertNode(root1,15);
        root1 = insertNode(root1,10);
        root1 = insertNode(root1,20);
        root1 = insertNode(root1,8);
        root1 = insertNode(root1,12);
        root1 = insertNode(root1,17);
        Node root = null;
        root = insertNode(root,15);
        root = insertNode(root,10);
        root = insertNode(root,8);
        root = insertNode(root,12);
        root = insertNode(root,17);
        if(isIdentical(root1,root))
            System.out.println("two binary trees are identical");
        else
            System.out.println("two binary trees are not identical");
    }
}
