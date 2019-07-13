/*
countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to a value X.
*/

package Trees;

import static Trees.BinarySearchTree.insertNode;

public class CountSubtreesWithSum {
    static int count = 0;
    static int countSubtreesWithSumX(Node root, int x)
    {
        count = 0;
        countSubtreesUtil(root,x);
        return count;
    }
    static int countSubtreesUtil(Node node, int x){
        if(node==null)
            return 0;
        int a = countSubtreesUtil(node.left,x);
        int b = countSubtreesUtil(node.right,x);
        int c = a+b+node.data;

        if(c==x)
            count++;
        return c;


    }
    public static void main(String[] args) {
        Node root =  new Node(4);
        root. left = new Node(5);
        root. right = new Node(-2);
        root. left. left = new Node(-1);
        root. left. right = new Node(2);
        root. right. right = new Node(5);
        root. right. left = new Node(8);
        root. right. left. left = new Node(7);
        root. right. left. right = new Node(-9);

        System.out.println(countSubtreesWithSumX(root,6));
    }
}
