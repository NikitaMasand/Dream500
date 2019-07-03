package Stacks;

import java.util.Stack;

public class PostfixEvaluation {
    public static int evaluatePostfix(String exp){
        int n = exp.length();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(Character.isDigit(exp.charAt(i))){
                stack.push(exp.charAt(i)-'0');
            }
            else if(isOperator(exp.charAt(i))){
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res=0;
                if(exp.charAt(i)=='+'){
                    res = op1+op2;
                }
                else if(exp.charAt(i)=='-'){
                    res = op1-op2;
                }
                else if(exp.charAt(i)=='*'){
                    res = op1*op2;
                }
                else if(exp.charAt(i)=='/'){
                    res = op1/op2;
                }
                else if(exp.charAt(i)=='^')
                    res = (int) Math.pow(op1,op2);


                stack.push(res);
            }
        }
        return stack.peek();
    }

    public static boolean isOperator(char a){
        return a=='+' || a=='-' || a=='*' || a=='/' || a=='^';
    }
    public static void main(String[] args) {
        System.out.println(evaluatePostfix("231*+9-"));
    }
}
