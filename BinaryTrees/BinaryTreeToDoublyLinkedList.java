package Trees;

public class BinaryTreeToDoublyLinkedList {
    static Node prev = null;
    static Node head = null;
    public static Node convertToDLL(Node node){
        if(node==null)
            return node;
        //this is inplace
        //time complexity: O(n)
        //traversing nodes inorder way.
        //while processing the node, we set it's link and prev nodes link
        //prev node is a static variable, whose value is always previous
        //to the current node in the inorder traversal.
        convertToDLL(node.left);
        if(prev==null) {
            head = node;
        }
        else{
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        convertToDLL(node.right);
        return head;
    }
    public static void main(String[] args) {
        Node root = null;
        //level order traversal of inserted nodes:
        //15 10 20 8 12 17 25 6 11 16 27
        root = InsertNodes.insertUtil(root);
        Node head = convertToDLL(root);
        //traversing the linked list
        Node temp = head;
        while(temp.right!=null){
            System.out.print(temp.data+" ");
            temp=temp.right;
        }
        System.out.println(temp.data);
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.left;
        }
    }


}
