package LinkedLists;

public class pairWiseSwapping {
    public static Node swap(Node head){
        if(head==null)
            return head;
        if(head.next==null)
            return head;
        Node p = head;
        Node newHead = p.next;
        while (true){
            Node q = p.next;
            Node temp = q.next;
            q.next=p;
            if(temp==null||temp.next==null){
                p.next=temp;
                break;
            }
            p.next=temp.next;
            p=temp;
        }
        return newHead;
    }
    public static void main(String[] args) {
        operationsOnList list = new operationsOnList();
        Node head = null;
        head = list.insertAtEnd(head,5);
        head = list.insertAtEnd(head,6);
        head = list.insertAtEnd(head,3);
        head = list.insertAtEnd(head,9);
        head = list.insertAtEnd(head,10);
      //  head = list.insertAtEnd(head,1);
        list.print(head);
        System.out.println();
        head = swap(head);
        list.print(head);
    }
}
