/*
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

This is a function problem.You only need to complete the function given below*/
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/
class GfG
{
    public static Node reverse(Node start, int k)
    {
        Node p, q, new_start, temp;
        p = start;
        int count = 1;
        while(count!=k){
            if(p.next==null){
                return start;
            }
            p = p.next;
            count++;
        }
        
        new_start = p;
        q = new_start;
        
        while(true){
            p = start;
            temp = q.next;
            if(temp==null){
                reverse(p);
                return new_start;
            }
            
            q.next=null;
            q = temp; 
            start = temp;
            
          count = 1;
            while(count!=k){
                if(temp.next==null){
                    reverse(p);
                    reverse(q);
                    p.next = temp;
                    return new_start;
                }
                temp = temp.next;
                count++;
            }
            
            reverse(p);
            p.next = temp;
            q = temp;
            
        }
    
    }
    
    static void reverse(Node node){
        if(node.next==null){
            return;
        }
        
        reverse(node.next);
        Node q = node.next;
        q.next = node;
        node.next = null;
        
        
    }
    
    
}
