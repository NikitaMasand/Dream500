package Stacks;

public class twoStacksOneArray {
    int size;
    int top1,top2;
    int[] arr;

    twoStacksOneArray(int n){
        size=n;
        top1=-1;
        top2=size;
        arr=new int[n];
    }

    public void push1(int x){
        if(top1<top2-1){
            arr[++top1]=x;
        }
        else{
            System.out.println("stack1 overflow error");
        }
    }
    public void push2(int x){
        if(top1<top2-1)
            arr[--top2]=x;
        else
            System.out.println("stack2 overflow error");
    }
    public int pop1(){
        if(top1>=0)
            return arr[top1--];
        else {
            System.out.println("stack1 underflow error");
            System.exit(1);
        }
        return 0;
    }

    public int pop2(){
            if(top2<size)
                return arr[top2++];
            else{
                System.out.println("stack2 underflow error");
                System.exit(1);
            }
            return 0;
    }

    public static void main(String[] args) {
        twoStacksOneArray ts = new twoStacksOneArray(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        ts.push2(4);
        System.out.println("Popped element from" +
                " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" +
                " stack2 is " + ts.pop2());
    }
}

/*
output:
stack2 overflow error
Popped element from stack1 is 11
Popped element from stack2 is 40

*/
