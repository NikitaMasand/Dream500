package Trees;

import java.util.Stack;

import static Trees.BinarySearchTree.insertNode;

public class IterativeInorder {
    public static void inorderTraversal(Node root){
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node!=null || !stack.isEmpty()){
            if (node != null) {
                stack.push(node);
                node=node.left;
            }
            else{
                node = stack.pop();
                System.out.print(node.data+" ");
                node=node.right;
            }
        }
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,15);
        root = insertNode(root,6);
        root = insertNode(root,11);
        root = insertNode(root,16);
        root = insertNode(root,27);
        Trees.BinarySearchTree.inOrder(root);
        System.out.println();
        inorderTraversal(root);
    }
}
