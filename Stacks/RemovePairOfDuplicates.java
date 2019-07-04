package Stacks;

import java.util.Stack;

//You are given a string str. You need to remove the pair of duplicates.
public class RemovePairOfDuplicates {
    public static String removePair(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        stack.push(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(!stack.isEmpty()&&str.charAt(i)==stack.peek()){
                stack.pop();
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        if(stack.isEmpty())
            return "Empty String";
        else {
            Stack<Character>stack1 = new Stack<>();

            while (!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
            while (!stack1.isEmpty()){
                res.append(stack1.pop());
            }
            return res.toString();
        }

    }
    public static void main(String[] args) {
        System.out.println(removePair("aaabbaaccd"));
    }
}
//output: ad
