package LinkedLists;

import java.util.Stack;

public class ReverseLinkedListExplicitStack {
    public static void main(String[] args) {
        operationsOnList list = new operationsOnList();
        Node head = null;
        head = list.insertAtEnd(head,5);
        head = list.insertAtEnd(head,6);
        head = list.insertAtEnd(head,3);
        head = list.insertAtEnd(head,9);
        head = list.insertAtEnd(head,10);
        head = list.insertAtEnd(head,1);

        head = reverseList(head);
        list.print(head);
    }
    public static Node reverseList(Node node){
        Stack<Node> stack = new Stack<>();
        Node temp = node;
        while (temp.next!=null){
            stack.push(temp);
            temp=temp.next;
        }
        stack.push(temp);
        node = stack.pop();
        while (!stack.isEmpty()){
            temp.next=stack.peek();
            stack.pop();
            temp=temp.next;
        }
        temp.next=null;
        return node;
    }

}
