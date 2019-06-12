/*
print permutations of a string
1. the string can contain duplicates
2. the output should be in lexicographical order
time complexity : 0(n!)
space complexity : O(n)
where n is length of the input
Also no. of permutations is given by : n!/ a!b!...
where a is no. of any character repeating..eg. in our case A is repeating twice, thus a = 2
b is for some other character and so on.
So, this was a really nice recursion implementation to understand.
For AABC
ABC
211 ..level  0..result[0] = A
so it starts with A and decreasing its count to 1
it goes to next level,with
ABC
111 ..level 1..result[1] = A
then again from left since A is non zero, it decreases its count by 1
ABC
011 ..level 2..result[2] = B
from left since B is non zero..it decreases count by 1
001...level 3..result[3] = C
000...level=4..print AABC and return to upper level but increment the count of C that you had previously decremented
001..i is already rightmost
011...i was at 1..now goes to 2
thus previous all remains same but the order becomes
010...so I hope this is clear..I have attached pictures in the doc notes
 */

import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {
    public static void main(String[] args) {
            permute("AABC".toCharArray());

    }
    //AABC
    public static void permute(char input[]){
        Map<Character, Integer> countMap = new TreeMap<>();
        //using tree map to store the character and frequency in sorted order of the characters
        // i.e to store A-2,B-1,C-1
        //compute function to store these frequencies, it takes in input as a character and a bifunction
        // It represents a function which takes in two arguments and produces a result.
        for(char ch: input){
            countMap.compute(ch, (key,val)->{
                if(val==null)
                    return 1;
                else
                    return val+1;
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for(Map.Entry<Character,Integer> entry : countMap.entrySet()){
            str[index] = entry.getKey();
            count[index]=entry.getValue();
            index++;
        }
        char result[] = new char[input.length];
        permuteUtil(str,count,result,0);

    }
    /*

     */
    public static void permuteUtil(char[] str, int[] count, char[] result, int level){
        if(level==result.length){
            printArray(result);
            return;
        }
        for(int i=0;i<str.length;i++){
            if(count[i]==0)
                continue;
            result[level] = str[i];
            count[i]--;
            permuteUtil(str,count,result,level+1);
            count[i]++;
        }
    }

    public static void printArray(char[] result){
        for(char ch: result){
            System.out.print(ch);
        }
        System.out.println();
    }
}
