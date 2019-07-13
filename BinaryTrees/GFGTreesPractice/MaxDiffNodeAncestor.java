package Trees;
/*
Given a Binary Tree you need to find maximum value which you can get by subtracting value of node B from value of node A,
where A and B are two nodes of the binary tree and A is an ancestor of B. 
*/
import static Trees.BinarySearchTree.insertNode;

public class MaxDiffNodeAncestor {


    static int diff = Integer.MIN_VALUE;
    static int maxDiff(Node node){
           diff = Integer.MIN_VALUE;
           maxDiffUtil(node);
           return diff;
    }
    static int maxDiffUtil(Node node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        if(node.left==null && node.right==null){
            return node.data;
        }
        int x = maxDiffUtil(node.left);
        int y = maxDiffUtil(node.right);
        diff = Math.max(diff,Math.max(node.data-x,node.data-y));

        return Math.min(node.data,Math.min(x,y));
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
        System.out.println(maxDiff(root));
    }


}
