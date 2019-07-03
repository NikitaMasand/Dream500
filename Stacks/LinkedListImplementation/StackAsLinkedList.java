package Stacks;

public class StackAsLinkedList {
    StackNode root = null;
    static class StackNode{
        int data;
        StackNode next;

        StackNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean isEmpty(){
        return root==null;
    }

    public void push(int x){
        StackNode newNode = new StackNode(x);
        if(root==null){
            root = newNode;
        }
        else{
            newNode.next=root;
            root=newNode;
        }
        System.out.println(x+" pushed to stack");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("stack is empty, cannot pop the element");
            return Integer.MIN_VALUE;
        }
        else{
            int data = root.data;
            root = root.next;
            return data;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return root.data;
        }
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("stack is empty");
        }
        else{
            System.out.println("Stack: ");
            printRev(root);
            System.out.println();
        }
    }

    public void printRev(StackNode node){
        if(node==null)
            return;
        printRev(node.next);
        System.out.print(node.data+" ");
    }
}
