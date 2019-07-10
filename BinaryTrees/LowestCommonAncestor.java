package Trees;

import static Trees.BinarySearchTree.insertNode;

public class LowestCommonAncestorBinaryTree {
    public static Node findLCA(Node root, Node a, Node b){
        if(root==null)
            return null;
        if(root==a || root==b)
            return root;
        Node left = findLCA(root.left,a,b);
        Node right = findLCA(root.right,a,b);

        if(left!=null && right!=null)
            return root;

        return left!=null ? left:right;
    }

    public static Node search(Node root, int data){
        if(root==null)
            return null;
        if(root.data==data)
            return root;

        Node k = search(root.left,data);
        if(k==null){
            return search(root.right,data);
        }
        else{
            return k;
        }

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
        Node a = search(root,27);
        Node b = search(root,2);
        System.out.println(findLCA(root,a,b).data);
    }
}
