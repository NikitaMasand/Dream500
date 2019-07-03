package Stacks;

import java.util.Arrays;

public class Stack {
    private int top = -1;
    int capacity = 10;
    int[] stack = new int[capacity];

    public void push(int x){
        checkEnoughCapacity();
        stack[++top]=x;
    }

    public int top(){
        if(!isEmpty())
         return stack[top];
        return -1;
    }

    public int pop(){
        if(!isEmpty()){
            return stack[top--];
        }
        else{
            System.out.println("stack is empty! cannot pop an element");
            return -1;
        }
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top==-1 ? true:false;
    }
    public void checkEnoughCapacity(){
        if(top==capacity-1){
            int[] newArray = new int[2*capacity];
            System.arraycopy(stack,0,newArray,0,capacity);
            stack = newArray;
        }
    }

    public void printStack(){
        if(!isEmpty()){
            System.out.print("Stack: ");
            for(int i=0;i<size();i++){
                System.out.print(stack[i]+" ");
            }
            System.out.println();
        }
        else{
            System.out.println("Stack is empty");
        }
    }
}
