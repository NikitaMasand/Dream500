 For each node a range is decided.
 For the root node, it’s -infinity to infinity.
 As we move to the left, we update the upper bound value and as we go to the right we update the lower bound value. 

Time complexity: O(n).

package Trees;
import Trees.BinarySearchTree;
import Trees.Node;

import static Trees.BinarySearchTree.insertNode;

public class CheckIfBinarySearchTree {

    public static boolean isBinarySearchTreeUtil(Node root, int minValue, int maxValue){
        if(root==null)
            return true;
        if(root.data > minValue && root.data <= maxValue &&
           isBinarySearchTreeUtil(root.left,minValue,root.data) &&
           isBinarySearchTreeUtil(root.right,root.data,maxValue))
                return true;
        return false;
    }

    public static boolean isBinarySearchTree(Node root){
        return isBinarySearchTreeUtil(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    


    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,20);
        root = insertNode(root,15);
        root = insertNode(root,25);
        root = insertNode(root,30);
        root = insertNode(root,2);
        root = insertNode(root,18);
        root = insertNode(root,22);
        System.out.println(isBinarySearchTree(root));
    }


}
