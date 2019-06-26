package LinkedLists;

public class SwapTwoNodes {
    public static Node swap(Node head, int x, int y){
        //Searching nodes with data x and y
        Node P = head;
        Node prev = null;
        while (P!=null && P.data!=x){
            prev=P;
            P=P.next;
        }
        Node pX = P;
        Node prevX = prev;
        P = head;
        prev = null;
        while (P!=null && P.data!=y){
            prev=P;
            P=P.next;
        }
        Node pY = P;
        Node prevY = prev;
        //for adjacent nodes
        if(pX.next==pY){
            pX.next= pY.next;
            pY.next=pX;
            prevX.next=pY;
            return head;
        }
        if(pY.next==pX){
            pY.next=pX.next;
            pX.next=pY;
            prevY.next=pX;
            return head;
        }

        //swapping data
        Node temp = pY.next;
        pY.next=pX.next;
        pX.next=temp;
        //px is head node
        if(prevX==null){
            head=pY;
            prevY.next=pX;
        }
        //py is head node
        else if(prevY==null){
            head = pX;
            prevX.next=pY;
        }
        //px and py both are internal nodes or one of them is a end node
        else if(prevY!=null&&prevX!=null){
            prevX.next=pY;
            prevY.next=pX;
        }
        return head;
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
        list.print(head);
        System.out.println();
        head = swap(head,3,6);
        list.print(head);
    }
}
