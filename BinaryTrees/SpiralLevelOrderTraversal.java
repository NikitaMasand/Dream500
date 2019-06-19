/*
Two stacks were used because one time traversal is from left to right and the other time traversal is from right to left.
So in one stack we have added children left and right order and in the first stackwhere root node was added,
there children are added right left order
Time complexity: O(n)
Space: O(n)

*/



package Trees;

import java.util.Stack;

public class SpiralLevelOrderTraversal {
    public static void spiralTraversal(Node root){
        if(root==null)
            return;
        Stack<Node> stack_1 = new Stack<>();
        Stack<Node> stack_2 = new Stack<>();
        stack_1.push(root);
        while (!stack_1.isEmpty() || stack_2.isEmpty()) {
            while (!stack_1.isEmpty()) {
                Node temp = stack_1.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    stack_2.push(temp.left);
                if (temp.right != null)
                    stack_2.push(temp.right);
            }
            while (!stack_2.isEmpty()) {
                Node temp = stack_2.pop();
                System.out.print(temp.data + " ");
                if (temp.right != null)
                    stack_1.push(temp.right);
                if (temp.left != null)
                    stack_1.push(temp.left);
            }
        }

    }
    public static void main(String[] args) {
        Node root = null;
        //level order traversal of inserted nodes:
        //15 10 20 8 12 17 25 6 11 16 27
        root = InsertNodes.insertUtil(root);
        spiralTraversal(root);
    }
}

