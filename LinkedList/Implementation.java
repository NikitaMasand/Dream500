public class Implementation {
    public static void main(String[] args) {
        Node head = null;
        operationsOnList object = new operationsOnList();
        head = object.insertAtEnd(head,3);
        head = object.insertAtEnd(head,5);
        head = object.insertAtEnd(head,7);
        head = object.insertAtEnd(head,9);
        head = object.insertAtEnd(head,11);
        head = object.insertAtBeginning(head,1);
        head = object.insertAtPosition(head,2,2);
        head = object.insertAtPosition(head,4,4);
        head = object.insertAtPosition(head,0,1);
        head = object.insertAtPosition(head,20,10);
        head = object.delete(head,1);
        head = object.delete(head,9);
        head = object.delete(head,5);

        object.print(head);
        // output : list:1 2 3 4 7 9 11
    }
}
class Node
{
    int data;
    Node next;
}
class operationsOnList
{
    public Node createNewNode(int data)
    {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    public Node insertAtEnd(Node head, int data)
    {
        Node temp = createNewNode(data);
        if (head==null)
        {
            head = temp;
        }
        else
        {
            Node temp1 = head;
            while (temp1.next!=null)
                temp1 = temp1.next;
            temp1.next = temp;
        }

        return head;

    }

    public Node insertAtBeginning(Node head, int data)
    {
        Node temp = createNewNode(data);
        if(head==null)
            head = temp;
        else
        {
            temp.next = head;
            head = temp;
        }
     return head;
    }

    public Node insertAtPosition(Node head, int data, int pos)
    {
        if(pos==1)
        {
            return insertAtBeginning(head,data);
        }
        else if(pos==size(head)+1)
        {
            return insertAtEnd(head,data);
        }

        Node temp = head;
        for(int i=1; i<=pos-2; i++)
            temp = temp.next;
        Node createNew = createNewNode(data);
        createNew.next = temp.next;
        temp.next = createNew;
        return head;
    }

    public Node delete(Node head, int pos)
    {
        if(pos==1)
        {
            Node temp = head;
            head = temp.next;
            temp.next = null;
        }
        else
        {
            Node temp = head;
            for(int i=1;i<=pos-2;i++)
                temp = temp.next;
            Node temp1 = temp.next;
            temp.next = temp1.next;
            temp1.next = null;
        }
        return head;
    }


    public int size(Node head)
    {
        int count = 0;
        Node temp = head;
        while(temp!=null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }


    public void print(Node head)
    {
        if(head!=null) {
            System.out.print("list:");
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data);
        }
    }


}
