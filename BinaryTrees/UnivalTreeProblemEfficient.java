//time complexity: O(n^2)
/*
Given a binary tree, write a program to count the number of Single Valued Subtrees.
A Single Valued Subtree is one in which all the nodes have same value.
*/
package Trees;
//O(n) time
//postorder traversal

class boolIntPair{
    boolean isUnival;
    int count_univals;
}
public class UnivalTreeProblemEfficient {
    public static boolIntPair evaluate_univals(Node node){
        if(node==null){
            boolIntPair output = new boolIntPair();
            output.isUnival = true;
            output.count_univals = 0;
            return output;
        }
        boolIntPair leftEvaluate = evaluate_univals(node.left);
        boolIntPair rightEvaluate = evaluate_univals(node.right);
        boolean isUnival = true;
        if(!leftEvaluate.isUnival || !rightEvaluate.isUnival)
            isUnival = false;
        if(node.left!=null && node.data!=node.left.data)
            isUnival = false;
        if(node.right!=null && node.data!=node.right.data)
            isUnival = false;
        if (isUnival==true){
            boolIntPair output = new boolIntPair();
            output.isUnival = true;
            output.count_univals = 1+leftEvaluate.count_univals+rightEvaluate.count_univals;
            return output;
        }
        else{
            boolIntPair output = new boolIntPair();
            output.isUnival = false;
            output.count_univals = leftEvaluate.count_univals+rightEvaluate.count_univals;
            return output;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        System.out.println(evaluate_univals(root).count_univals);
    }
}
