package LinkedLists;

import java.util.HashMap;

class RandomListNode{
    int value;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int value, RandomListNode next, RandomListNode random){
        this.value=value;
        this.next=next;
        this.random=random;
    }
    RandomListNode(int value){
        this.value=value;
        this.next=null;
        this.random=null;
    }
}
public class CloneRandomPointerList {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(5);
        head.next=new RandomListNode(6);
        head.random=head;
        LinearSpaceApproach obj = new LinearSpaceApproach();
        System.out.println(obj.copyRandomList(head));

        ConstantSpaceApproach obj1 = new ConstantSpaceApproach();
        System.out.println(obj1.copyRandomList(head));
    }
}
class LinearSpaceApproach{
    public RandomListNode copyRandomList(RandomListNode head){
        if(head==null)
            return null;

        HashMap<RandomListNode,RandomListNode> cloneMap = new HashMap<>();
        RandomListNode curr = head;
        while (curr!=null){
            cloneMap.put(curr,new RandomListNode(curr.value));
            curr=curr.next;
        }

        curr = head;
        while (curr!=null){
            cloneMap.get(curr).next = cloneMap.get(curr.next);
            cloneMap.get(curr).random = cloneMap.get(curr.random);

            curr=curr.next;
        }
        return cloneMap.get(head);

    }
}

class ConstantSpaceApproach{
    public RandomListNode copyRandomList(RandomListNode head){
        if(head==null)
            return null;

        RandomListNode curr = head;
        RandomListNode next = null;
        //1->2->3
        //1->1->2->2->3->3
        while (curr!=null) {
            next=curr.next;
            RandomListNode copy = new RandomListNode(curr.value);
            curr.next=copy;
            copy.next=next;

            curr=next;
        }

        curr=head;
        while (curr!=null){
            if(curr.random!=null)
                 curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        curr=head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode cloneListTail = dummyHead;
        RandomListNode copy=null;
        while (curr!=null){
            next=curr.next.next;
            copy=curr.next;
            cloneListTail.next=copy;
            cloneListTail=copy;

            curr.next=next;

            curr=next;
        }
        return dummyHead.next;
    }
}
