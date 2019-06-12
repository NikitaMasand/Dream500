/*
1. getNewNode function
2. InsertNode function
3. searchNode given data function
*/


class Node{
    int data;
    Node left;
    Node right;
}
public class BinarySearchTree {
    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,20);
        root = insertNode(root,15);
        root = insertNode(root,25);
        root = insertNode(root,30);
        root = insertNode(root,2);
        System.out.println(searchNode(root,30));

    }
    public static Node getNewNode(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public static Node insertNode(Node root, int data){
        if(root==null){
            root = getNewNode(data);
        }
        else if(data<=root.data){
            root.left = insertNode(root.left,data);
        }
        else{
            root.right = insertNode(root.right,data);
        }
        return root;
    }

    public static boolean searchNode(Node root, int data){
        if(root==null)
            return false;
        else if(data==root.data)
            return true;
        else if(data<=root.data)
            return searchNode(root.left,data);
        else
            return searchNode(root.right,data);
    }
}
