package Trees;

import java.util.Stack;

import static Trees.BinarySearchTree.insertNode;

public class IterativePreorder {
    public static void preorderTraveral(Node root){
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node!=null || !stack.isEmpty()){
            if(node!=null){
                System.out.print(node.data+" ");
                stack.push(node);
                node = node.left;
            }
            else{
                node=stack.pop();
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
        preorderTraveral(root);
        System.out.println();
        Trees.BinarySearchTree.preOrder(root);
    }
}
