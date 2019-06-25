package LinkedLists;

public class DetectLoopFindLength {
    public static void main(String[] args) {
        operationsOnList list = new operationsOnList();
        Node head = null;
        head = list.insertAtEnd(head,5);
        head = list.insertAtEnd(head,6);
        head = list.insertAtEnd(head,3);
        head = list.insertAtEnd(head,9);
        head = list.insertAtEnd(head,10);
        head = list.insertAtEnd(head,1);
        detectLoop(head);
        System.out.println(findLoopLength(head));
    }
    public static boolean detectLoop(Node head){
        Node rabbitPtr = head;
        Node turtoisePtr = head;
        while(rabbitPtr!=null&&rabbitPtr.next!=null){
            turtoisePtr = turtoisePtr.next;
            rabbitPtr = rabbitPtr.next.next;
            if(rabbitPtr==null)
                return false;
            if(rabbitPtr==turtoisePtr)
                return true;
        }
        return false;
    }
    public static int findLoopLength(Node head){
        Node rabbitPtr = head;
        Node turtoisePtr = head;
        while (rabbitPtr!=null && rabbitPtr.next!=null){
            rabbitPtr=rabbitPtr.next.next;
            turtoisePtr=turtoisePtr.next;
            if(rabbitPtr==null)
                return 0;
            if(rabbitPtr==turtoisePtr){
                int count = 2;
                if(turtoisePtr.next!=null){
                    turtoisePtr=turtoisePtr.next;
                    while (turtoisePtr!=rabbitPtr){
                        turtoisePtr=turtoisePtr.next;
                        count++;
                    }
                }
                else{
                    count=1;
                }
                return count;
            }
        }
        return 0;
    }
}
