package Trees;

import static Trees.BinarySearchTree.insertNode;

public class ConvertBinaryTreeToMirror {
    public static Node mirrorTree(Node node){
        if(node==null)
            return null;
        Node temp = node.left;
        node.left=node.right;
        node.right=temp;
        mirrorTree(node.left);
        mirrorTree(node.right);
        return node;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,15);
        root = insertNode(root,10);
        root = insertNode(root,20);
        root = insertNode(root,16);
        root = insertNode(root,27);
        root = mirrorTree(root);
        Trees.BinarySearchTree.levelOrder(root);

    }
}
