//time complexity: O(n^2)
/*
Given a binary tree, write a program to count the number of Single Valued Subtrees.
A Single Valued Subtree is one in which all the nodes have same value.
*/
package Trees;
//no of non empty universal subtrees
public class UnivalTreeProblem {
    public static boolean isUnival(Node root){
        if(root==null)
            return true;
        if(root.left!=null && root.data!=root.left.data)
            return false;
        if(root.right!=null && root.data!=root.right.data)
            return false;
        if(isUnival(root.left) && isUnival(root.right))
            return true;
        return false;
    }

    public static int count_univals(Node node){
        if(node==null)
            return 0;
        int total_count = count_univals(node.left)+count_univals(node.right);
        if(isUnival(node))
            total_count+=1;
        return total_count;
    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        isUnival(root);
        System.out.println(count_univals(root));
    }
}
