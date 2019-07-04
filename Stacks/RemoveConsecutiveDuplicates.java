package Stacks;
//You are given a string str. You need to remove the consecutive duplicates.


import java.util.Stack;

public class RemoveConsecutiveDuplicates {
    public static String  removeConsecutiveDuplicates(String str){
        Stack<Character>stack =  new Stack<>();
        stack.push(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(stack.peek()!=str.charAt(i)){
                stack.push(str.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        Stack<Character>stack1=new Stack<>();

        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        while (!stack1.isEmpty()){
            res.append(stack1.pop());
        }
     return res.toString();
    }
    public static void main(String[] args) {
      System.out.println(removeConsecutiveDuplicates("aaaaaabaabccccccc"));
    }
}
//output:ababc
