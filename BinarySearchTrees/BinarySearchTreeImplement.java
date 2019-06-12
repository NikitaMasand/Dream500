/*
1. getNewNode function
2. InsertNode function
3. searchNode given data function
4. findMinimum element
5. findMaximum element
6. findHeight
7. LevelOrderTraversal
8. Depth Order Traversal
        preorder
        inorder
        postorder
*/

import java.util.LinkedList;
import java.util.Queue;

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
        root = insertNode(root,18);
        root = insertNode(root,22);
        if (searchNode(root, 30)) {
            System.out.println("node is present in tree");
        }
        System.out.println("min element "+ findMin(root));
        System.out.println("max element "+findMax(root));
        System.out.println("Height: "+ findHeight(root));
        System.out.println("Level order traversal of tree is: ");
        levelOrder(root);
        System.out.println("preorder traversal of tree is: ");
        preOrder(root);
        System.out.println();
        System.out.println("inorder traversal of tree is: ");
        inOrder(root);
        System.out.println();
        System.out.println("postOrder traversal of tree is: ");
        postOrder(root);
        System.out.println();



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

    public static int findMin(Node root){
        if(root==null){
            System.out.println("Error: Tree is empty");
            return -1;
        }
        //not using current because root here is a local variable
        //to function, modifying root here
        //does not modify the root in main function
        while (root.left!=null)
            root = root.left;
        return root.data;
    }

    public static int findMax(Node root){
        if(root==null){
            System.out.println("Error: Tree is empty");
            return -1;
        }
        while (root.right!=null)
            root = root.right;
        return root.data;
    }
/*
Height of tree = max depth
Height of leaf node = 0

Height of tree =
Height of root =
No of edges in the longest path from root to leaf node
 */

    public static int findHeight(Node root){
        if(root==null)
            return -1;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return 1+Math.max(leftHeight,rightHeight);
    }

    //level order traversal..using queue
    /*
    Time comp: O(n)
    Space comp:
    Best: O(1)..when skewed tree
    Worst: Perfect bt..O(n)..actually n/2. As their are n/2 nodes at the deepest level
    Avg: O(n)

     */
    public static void levelOrder(Node root){
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.peek();
            System.out.print(current.data + " ");
            if(current.left!=null)
                queue.add(current.left);
            if(current.right!=null)
                queue.add(current.right);
            queue.poll();
        }
        System.out.println();
    }
    /*
    Space complexity
    Call stack will grow only till we reach a leaf node..with no children
    And then it starts shrinking again.
    O(h)..h is height of tree

    Time comp: O(n)

     */
    public static void preOrder(Node root){
        if (root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
}

