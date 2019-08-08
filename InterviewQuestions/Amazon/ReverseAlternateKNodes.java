package LinkedLists;

public class ReverseAlternateKNodes {
    public static void main(String[] args) {
        operationsOnList list = new operationsOnList();
        Node head = null;
        for(int i=1; i<=14; i++){
            head = list.insertAtEnd(head,i);
        }
        int k = 3;
        head = kAltReverse(head,3);
        list.print(head);
    }

    public static Node kAltReverse(Node head, int k){
        return kAltReverseUtil(head,k,true);
    }

    public static Node kAltReverseUtil(Node node, int k, boolean b){
        if(node == null){
            return null;
        }

        Node current = node;
        Node prev = null;
        Node next = null;
        int count = 1;
        while (current!=null && count<=k){
            next = current.next;
            if(b==true){
                current.next = prev;
            }
            prev = current;
            current = next;
            count++;
        }

        if(b==true){
            node.next = kAltReverseUtil(current,k,!b);
            return prev;
        }
        else{
            prev.next = kAltReverseUtil(current,k,!b);
            return node;
        }
    }
}
