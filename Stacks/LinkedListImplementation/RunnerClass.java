package Stacks;

public class LinkedListImplementation {
    public static void main(String[] args) {
        StackAsLinkedList stack = new StackAsLinkedList();
        stack.printStack();
        stack.pop();
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("top element: "+stack.peek());
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println("removing top element: "+ stack.pop());
        stack.push(9);
        stack.printStack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.printStack();


    }
}
/*
output:

stack is empty
stack is empty, cannot pop the element
5 pushed to stack
1 pushed to stack
2 pushed to stack
3 pushed to stack
4 pushed to stack
top element: 4
5 pushed to stack
6 pushed to stack
7 pushed to stack
8 pushed to stack
removing top element: 8
9 pushed to stack
Stack: 
5 1 2 3 4 5 6 7 9 
10 pushed to stack
11 pushed to stack
12 pushed to stack
13 pushed to stack
14 pushed to stack
15 pushed to stack
Stack: 
5 1 2 3 4 5 6 7 9 10 11 12 13 14 15 

*/
