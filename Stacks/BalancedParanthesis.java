package Stacks;

import java.util.Stack;

public class BalancedParenthesis {
    public static boolean isBalanced(String exp){
        int n = exp.length();
        Stack<Character>stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(openingCheck(exp.charAt(i))){
                stack.push(exp.charAt(i));
            }
            else if(closingCheck(exp.charAt(i))){
                if(stack.isEmpty() || !checkPeekAndExp(stack.peek(),exp.charAt(i))){
                    return false;
                }
                else{
                    stack.pop();
                }
            }

        }
        return stack.isEmpty() ? true:false;
    }

    public static boolean openingCheck(char c){
        if(c=='(' || c=='{' || c=='[')
            return true;
        return false;
    }

    public static boolean closingCheck(char c){
        if(c==')' || c=='}' || c==']'){
            return true;
        }
        return false;
    }

    public static boolean checkPeekAndExp(char a, char b){
        return ((a=='{' && b=='}') || (a=='(' && b==')') || a=='[' && b==']');
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("{([])}"));
    }
}
