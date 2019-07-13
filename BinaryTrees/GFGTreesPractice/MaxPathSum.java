package Trees;
/*
Given a binary tree of N edges, where every node contains distinct data.
The task is to find the maximum path sum. The path may start and end at any node in the tree.
*/
import static Trees.BinarySearchTree.insertNode;

public class MaxPathSum {
    static int sum = Integer.MIN_VALUE;
    static int findMaxSum(Node node){
        sum = Integer.MIN_VALUE;
        findMaxSumUtil(node);
        return sum;
    }

    static int findMaxSumUtil(Node node){
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            sum=Math.max(node.data,sum);
            return node.data;
        }
        int x = findMaxSumUtil(node.left);
        int y = findMaxSumUtil(node.right);


        sum = Math.max(sum,Math.max(x+node.data,Math.max(y+node.data,Math.max(node.data,x+y+node.data))));
        return Math.max(node.data,Math.max(x+node.data,y+node.data));
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
        System.out.println(findMaxSum(root));
    }
}
//output: 120
