/*
Here we will delete all the nodes of binary tree.
But for that, we will have to traverse the node in order to delete.
Out of all the traversals we choose postorder traversal. Why?
Left Right Root node
So before deleting node, it’s left and right subtrees are visited for each node.
In this way the first nodes to be visited will be leaf nodes,
and it’s very easy to delete leaf nodes as there is no dependency unlike node with children.
Once leaf node is made null, their parents now become leaf nodes which are traversed
and thus can be deleted.
Thus returning null and deleting the binary tree
Time complexity : O(n)

 */


package Trees;

import static Trees.BinarySearchTree.insertNode;

public class DeleteBinaryTree {
    public static Node deleteTree(Node node){
        if(node==null)
            return null;
        deleteTree(node.left);
        deleteTree(node.right);
        System.out.println("deleting node "+ node.data);
        node = null;

        return node;
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
        Trees.BinarySearchTree.postOrder(root);
        System.out.println();
        root = deleteTree(root);

    }
}
