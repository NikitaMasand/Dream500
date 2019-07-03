/*
In conversion from infix to postfix. The order of operands from left to right will not change. The order of operators may change. 
With parentheses, any part of expression within itself will be treated as completely new expression in itself. ().
Any outer operator will not influence it’s execution. 

If it’s an opening parenthesis push it onto the stack
An operand will simply be appended to the result as the order of operands remain same in postfix expression
While the top of stack has operator of higher precedence and not a opening parenthesis, pop and append it to result
Push the char on the stack
After the for loop completes, go on popping from the stack until it is complete.

I have assumed on ( ) this type. Can add { and [.
*/



package Stacks;

import java.util.Stack;

public class InfixToPostfixConversion {
    public static String infixToPostfix(String exp){
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder("");
        int n = exp.length();
         for(int i=0;i<n;i++){
             char c = exp.charAt(i);
             if(Character.isLetter(c)){
                 res.append(c);
             }
             else if(isOperator(c)){
                 while (!stack.isEmpty() && !isOpeningParentheses(stack.peek()) && hasHigherPrecedence(stack.peek(),c)){
                     res.append(stack.pop());
                 }
                 stack.push(c);
             }
             else if(isOpeningParentheses(c)){
                 stack.push(c);
             }
             else if(isClosingParentheses(c)){
                 while (!stack.isEmpty() && !isOpeningParentheses(stack.peek())){
                     res.append(stack.pop());
                 }
                 stack.pop();
             }
         }
         while (!stack.isEmpty()){
             res.append(stack.pop());
         }
         return res.toString();
    }

    public static boolean isOpeningParentheses(char c){
        return c=='(';
    }
    public static boolean isClosingParentheses(char c){
        return c==')';
    }

    public static boolean isOperator(char c){
        return (c=='+' || c=='-' || c=='*' || c=='/' || c=='^');
    }

    public static boolean hasHigherPrecedence(char stacktop, char expchar){
        if(stacktop=='^'){
            if(expchar=='^')
                return false;
            else
                return true;
        }
        else if(stacktop=='*' || stacktop=='/'){
            if(expchar=='^')
                return false;
            else
                return true;
        }
        else{
            if(expchar=='+' || expchar=='-'){
                return true;
            }
            else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
}
