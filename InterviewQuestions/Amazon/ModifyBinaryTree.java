package Trees;
/*
ref: https://stackoverflow.com/questions/24849548/modify-binary-tree

Given a binary tree. Modify it in such a way that after modification
you can have a preorder traversal of it using only the right pointers.
During modification, you can use right as well as left pointers.

This comes down to linearizing the tree. Pre-order traversal visits the nodes in the order parent, left subtree, right subtree.
If we want to do this using only right pointers, the left subtrees have to be empty. The idea for this is to re-arrange the subtrees.
Let the right pointer point to the original left subtree.
Then let this subtree's last node's right pointer point to the original right subtree.
*/
import static Trees.BinarySearchTree.*;

public class ModifyBinaryTree {
    public static Node linearize(Node node){
        if(node.left == null && node.right== null){
            return node;
        }
        if(node.right == null){
            node.right = node.left;
            node.left = null;
            return linearize(node.right);
        }

        if(node.left == null){
            return linearize(node.right);
        }

        Node left = node.left;
        Node right = node.right;

        Node lastOfLeft = linearize(left);
        node.right = left;
        node.left=null;
        lastOfLeft.right = right;

        return linearize(right);
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

        linearize(root);
        while (root!=null){
            System.out.println(root.data);
            root=root.right;
        }
    }
}

/*
output:
15
10
8
6
12
11
20
17
16
25
27
*/
