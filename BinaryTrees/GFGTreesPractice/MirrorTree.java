package Trees;
/*
Given a Binary Tree, convert it into its mirror.
*/
import static Trees.BinarySearchTree.*;

public class MirrorTree {
    static void mirror(Node node){
        if(node==null)
            return;
        if(node.left==null && node.right==null)
            return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
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
        root = insertNode(root,2);
        mirror(root);
        levelOrder(root);
    }
}
