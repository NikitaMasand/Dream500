
package HackerRankInterviewPreparation.StringManipulation;

import java.util.Arrays;

public class ValidStringGaurav {
    static String isValid(String s){
       if(s.length()<3){
           return "YES";
       }
       int[] arr = new int[26];
       for(int i=0;i<s.length();i++){
           arr[s.charAt(i)-97]++;
       }
        Arrays.sort(arr);
       int i = 0;
       while (arr[i]==0){
           i++;
       }
       int min = arr[i];
       int max = arr[25];
       if(min==max)
           return "YES";
       else if(min==1 && arr[i+1]==max)
           return "YES";
       else if(Math.abs(max-min)>1){
           return "NO";
       }
       int diff = 0;
       if(Math.abs(max-min)==1){
           for(int j=i;j<arr.length-2;j++) {
               for (int k = j + 1; k < arr.length - 1; k++) {
                   diff += arr[k] - arr[j];
                   if (diff > 1)
                       return "NO";
               }
           }
           return "YES";
       }
       return "NO";
    }
    public static void main(String[] args) {
        System.out.println(isValid("abcdefghhgfedecba"));
    }

}
