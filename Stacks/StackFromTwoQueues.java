package Stacks;
//Implement a Stack using two queues q1 and q2.

import java.util.LinkedList;
import java.util.Queue;

public class StackFromTwoQueues {
    Queue<Integer>q1 = new LinkedList<>();
    Queue<Integer>q2 = new LinkedList<>();
    void push(int a){
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        q1.add(a);
        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }
    int pop(){
        if(q1.isEmpty())
            return -1;
        else{
            return q1.poll();
        }
    }
    public static void main(String[] args) {
        StackFromTwoQueues q = new StackFromTwoQueues();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        while (!q.q1.isEmpty()){
            System.out.println(q.pop());
        }
    }
}

//output 6 5 4 3 2 1
