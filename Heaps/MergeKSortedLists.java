package LinkedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static Node mergeKLists(Node[] arr, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data - o2.data;
            }
        });

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        Node head = null;
        Node ptr = head;
        while (!minHeap.isEmpty()) {
            Node temp = minHeap.poll();
            if (head == null) {
                head = temp;
                ptr = head;
            } else {
                ptr.next = temp;
                ptr = ptr.next;
            }
            if (temp.next != null) {
                minHeap.add(temp.next);
            }
        }
        return head;
    }


    public static void main(String[] args) {
        operationsOnList list = new operationsOnList();
        Node head = null;
        head = list.insertAtEnd(head,5);
        head = list.insertAtEnd(head,6);
        head = list.insertAtEnd(head,3);
        Node head1=null;
        head1 = list.insertAtEnd(head1,9);
        head1 = list.insertAtEnd(head1,10);

        Node[] arr = {head,head1};
        Node head2 = mergeKLists(arr,2);
        list.print(head2);
    }
}
