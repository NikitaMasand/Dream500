package Stacks;

import java.util.Stack;

public class PostfixEvaluationMultipleDigits {
    public static int evaluatePostfix(String exp){
        int n = exp.length();
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<n;i++){
            char c = exp.charAt(i);
            if(c==' ')
                continue;

            else if(Character.isDigit(c)){
                int x = 0;
                while (Character.isDigit(c)){
                    x = x*10 + (c-'0');
                    i++;
                    c=exp.charAt(i);
                }
                i--;
                stack.push(x);
            }
            else if(isOperator(c)){
                int val2 = stack.pop();
                int val1 = stack.pop();
                switch (c){
                    case '+':
                        stack.push(val1+val2);
                        break;
                    case '-':
                        stack.push(val1-val2);
                        break;
                    case '*':
                        stack.push(val1*val2);
                        break;
                    case '/':
                        stack.push(val1/val2);
                        break;
                    case '^':
                        stack.push((int)Math.pow(val1,val2));
                        break;

                }
            }
        }
        return stack.pop();
    }

    public static boolean isOperator(char a){
        return a=='+' || a=='-' || a=='*' || a=='/' || a=='^';
    }
    public static void main(String[] args) {
        System.out.println(evaluatePostfix("100 200 + 2 / 5 * 7 +"));
    }
}
