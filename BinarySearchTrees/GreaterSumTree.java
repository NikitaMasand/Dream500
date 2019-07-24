/*
Given a BST, transform it into greater sum tree where each node contains sum of all nodes greater than that node.
Did reverse inorder traversal as it gave the numbers in descending order and modified the data of node by adding sum to it.
Sum is a static variable which gets updated at every step.
*/
package Trees;

import static Trees.BinarySearchTree.insertNode;
import static Trees.BinarySearchTree.levelOrder;

public class GreaterSumTree {
    static int sum= 0;
    public static void greaterSumTree(Node node){
        if(node==null)
            return;
        greaterSumTree(node.right);
        sum = sum + node.data;
        node.data = sum - node.data;
        System.out.print(node.data+" ");
        greaterSumTree(node.left);
    }
    public static void main(String[] args) {
        Node root = null;
        //level order traversal of inserted nodes:
        //15 10 20 8 12 17 25 6 11 16 27
        root = InsertNodes.insertUtil(root);
        levelOrder(root);
        greaterSumTree(root);
        System.out.println();
    }
}
