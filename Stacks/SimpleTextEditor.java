/*
In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, S.
You must perform Q operations of the following 4 types:
1.append W- Append string W to the end of S.
2.delete k - Delete the last  characters of S.
3.print k- Print the kth character of S.
4.undo - Undo the last (not previously undone) operation of type 1 or 2 , reverting  to the state it was in prior to that operation.
*/

package Stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder("");
        Stack<String> stack = new Stack<>();

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0){
            String input[] = br.readLine().split(" ");
          //had to use temp strings because if directly s stringbuilde was pushed to the stack, then s still pointed to the top of stack
          //this gave unwanted results. thus made strings which made the logic independent
          
                switch (input[0]){
                    case "1":
                        String temp = s.toString();
                        stack.push(temp);
                        s.append(input[1]);
                        break;
                    case "2":
                        String temp1 = s.toString();
                        stack.push(temp1);
                        s.delete(s.length()-Integer.parseInt(input[1]),s.length());
                        break;
                    case "3":
                        System.out.println(s.charAt(Integer.parseInt(input[1])-1));
                        break;

                    case "4":
                        s=new StringBuilder(stack.pop());
                        break;
                }


        }
    }
}
/*
Input:
8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1
output
c
y
a
*/
