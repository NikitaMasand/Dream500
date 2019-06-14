/*

time complexity: O(logn)
find inorder successor for given node
left root right
case 1:
Node has right subtree:
go deep to leftmost node in right subtree

case 2:
No right subtree
go to nearest ancestor for which given node will be left subtree

to walk the tree up:
a. walk down from the root to that node. this way you are visiting the ancestors
of that node
b. inorder successor will be the deepest node/ancestor for which the node
is in the left subtree
 */



package Trees;
import Trees.BinarySearchTree;

import static Trees.BinarySearchTree.insertNode;

public class InorderSuccessor {
    public static Node getInorderSuccessor(Node root, int data){
        //searching the node with given data
        Node current = findNode(root,data);
        if(current==null)
            return null;
        //if node has right subtree
        if(current.right!=null){
            return findMin(current.right);
        }

        //if node does not have right subtree
        //we can walk from root to the node
        //this way we have visited all the ancestors of the node
        //return deepest node for which current node is left subtree
        else{
            Node successor = null;
            Node ancestor = root;
            while(ancestor!=current){
                if(current.data<ancestor. data){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }
                else
                    ancestor = ancestor.right;
            }
            return successor;
        }
    }


    public static Node findNode(Node root, int data){
        if(root==null)
            return root;
        else if(data==root.data)
            return root;
        else if(data<=root.data)
            return findNode(root.left,data);
        else
            return findNode(root.right,data);
    }


    public static Node findMin(Node root){
        if(root==null)
            return null;
        while (root.left!=null){
            root = root.left;
        }
        return root;
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
        Node successor = getInorderSuccessor(root,12);
        if(successor!=null)
             System.out.println(successor.data);
        else
            System.out.println("no successor as given element is last element");
    }
}
