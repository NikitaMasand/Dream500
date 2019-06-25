package LinkedLists;

public class ReverseLinkedList {
    public static void main(String[] args) {
        operationsOnList list = new operationsOnList();
        Node head = null;
        head = list.insertAtEnd(head,5);
        head = list.insertAtEnd(head,6);
        head = list.insertAtEnd(head,3);
        head = list.insertAtEnd(head,9);
        head = list.insertAtEnd(head,10);
        head = list.insertAtEnd(head,1);
        list.print(head);
        head = iterativeReverse(head);
        System.out.println();
        System.out.println("After reversing the list, iteratively");
        list.print(head);
        System.out.println();
        System.out.println("After reversing the list again, recursively");
        Node curr=head;
        Node prev=null;
        head = recReverse(head,curr,prev);
        list.print(head);
    }
    public static Node iterativeReverse(Node head){
        Node prev = null;
        Node current = head;
        Node newnext = head.next;
        while (current!=null){
            current.next=prev;
            prev=current;
            current=newnext;
            if(newnext!=null)
                newnext=newnext.next;
        }

        head=prev;
        return head;

    }

    public static Node recReverse(Node head, Node curr, Node prev){
        if(curr==null)
            return curr;
        if(curr.next == null){
            head=curr;
            curr.next=prev;
            return head;
        }
        Node nexxt = curr.next;
        curr.next=prev;
        return recReverse(head,nexxt,curr);
    }
}
