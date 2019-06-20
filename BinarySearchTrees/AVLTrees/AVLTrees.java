package Trees.AVLTreeImplementation;

public class AVLTrees {
    private class Node{
        int data;
        Node left;
        Node right;
        int height;
    }
    private Node root;
    private Node getNewNode(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        newNode.height = 1;
        return newNode;
    }
    public void insert(int data){
        this.root = insertNode(this.root,data);
    }
    private Node insertNode(Node node, int data){
        if(node==null){
            node = getNewNode(data);
        }
        else if(data<=node.data){
            node.left = insertNode(node.left,data);
        }
        else{
            node.right= insertNode(node.right,data);
        }
        node.height = Math.max(height(node.left),height(node.right))+1;
        int balancingFactor = balancingFactor(node);
        //LL Case
        if(balancingFactor>1 && data<node.left.data){
            return rightRotate(node);
        }

        //RR Case
        if(balancingFactor<-1 && data>node.right.data){
            return leftRotate(node);
        }

        //LR case
        if(balancingFactor>1 && data > node.left.data){
           node.left =  leftRotate(node.left);
            return rightRotate(node);
        }

        //RL case
        if(balancingFactor<-1 && data < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private int height(Node node){
        if(node==null)
            return 0;
        return node.height;
    }

    private int balancingFactor(Node node){
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }
    //c is the node that was found first as unbalanced.
    //b is the left child of c
    // t3 is the right child of b
    /*
    why did we find b and t3?
    Because for LL problem when we rotate right.
    c becomes the right child of b and t3 becomes the left child of c.
    I have attached the image of tree in the google doc for imagining this.

     */
    //returns new root node of subtree which is b
    private Node rightRotate(Node unbalanced){
        Node b = unbalanced.left;
        Node T3 = b.right;

        //rotating right
        b.right = unbalanced;
        unbalanced.left = T3;

        //update height
        unbalanced.height = Math.max(height(unbalanced.left),height(unbalanced.right))+1;
        b.height = Math.max(height(b.left),height(b.right))+1;

        return b;
    }

    private Node leftRotate(Node unbalanced){
        Node b = unbalanced.right;
        Node T2 = b.left;

        //rotating left
        b.left = unbalanced;
        unbalanced.right = T2;

        //updating heights
        unbalanced.height = Math.max(height(unbalanced.left),height(unbalanced.right))+1;
        b.height = Math.max(height(b.left),height(b.right))+1;

        return b;
    }


    public void display(){
        displayNodes(this.root);
    }
    private void displayNodes(Node node){
        if(node==null)
            return;
        String nodes = "";
        if(node.left==null){
            nodes+=".";
        }
        else {
            nodes+=node.left.data;
        }
        nodes+=" => " + node.data + " <= ";
        if(node.right==null)
            nodes+=".";
        else
            nodes+=node.right.data;
        System.out.println(nodes);
        displayNodes(node.left);
        displayNodes(node.right);

    }
}
