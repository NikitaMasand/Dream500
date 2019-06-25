package LinkedLists;

import java.util.LinkedList;

// requires less than two complete traversals of list
/*
initially mark a pointer to go to nth node from start. then make a pointer point to head.
 */
public class findNthNodeFromEnd {
    public static Node findNode(Node head, int n){
        Node right = head;
        n = n-1;
        //first right traverses the n nodes
        while (n-- > 0){
            right = right.next;
        }
        //assigning left to head implies the distance between left and right nodes, 
        //including both of them is n
        Node left = head;
        //so by moving right till null, left also moves long with right
        //by maintaining a distance of n nodes. thus left represents the nth node frm end
        while (right.next!=null){
            left = left.next;
            right = right.next;
        }

        return left;
    }
    public static void main(String[] args) {

        operationsOnList list = new operationsOnList();
        Node head = null;
        head = list.insertAtEnd(head,5);
        head = list.insertAtEnd(head,6);
        head = list.insertAtEnd(head,3);
        head = list.insertAtEnd(head,9);
        head = list.insertAtEnd(head,10);
        head = list.insertAtEnd(head,1);
        int n = 4;
        System.out.println(findNode(head, n).data);

    }
}
