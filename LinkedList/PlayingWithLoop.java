package LinkedLists;
/*
1. detect loop
2. find length of loop
3. find meeting point of fast and slow pointers
4. find start point/node of loop
5. remove the loop
 */
public class PlayingWithLoop {
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
   //just a utility function returning meeting point of
   //fast and slow pointers to be used for finding start of loop
   //similar to detecting a loop function..just changed the return type
    public static Node findMeetingPointOfPtrsLoop(Node head){
        Node rabbitPtr = head;
        Node turtoisePtr = head;
        while(rabbitPtr!=null&&rabbitPtr.next!=null){
            turtoisePtr = turtoisePtr.next;
            rabbitPtr = rabbitPtr.next.next;
            if(rabbitPtr==null)
                return null;
            if(rabbitPtr==turtoisePtr)
                return rabbitPtr;
        }
        return null;
    }
    public static void removeLoop(Node head){
        //assuming fast pointer stayed here
        //assuming the linkedlist has a loop..thus finding starting point and meeting pt
        Node meetingPoint = findMeetingPointOfPtrsLoop(head);
        if(meetingPoint==null)
            return;
        //assuming slow pointer went to the start
        Node start = head;
        //finding the start node of loop in the linked list
        while (start.next!=meetingPoint.next){
            start=start.next;
            meetingPoint=meetingPoint.next;
        }
        //removing loop
        meetingPoint.next=null;

    }
}
