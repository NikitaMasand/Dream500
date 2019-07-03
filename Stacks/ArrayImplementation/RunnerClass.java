package Stacks;

public class ImplementationArray {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printStack();
        stack.pop();
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("top element: "+stack.top());
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
oupput:
Stack is empty
stack is empty! cannot pop an element
top element: 4
removing top element: 8
Stack: 5 1 2 3 4 5 6 7 9 
Stack: 5 1 2 3 4 5 6 7 9 10 11 12 13 14 15 

*/
