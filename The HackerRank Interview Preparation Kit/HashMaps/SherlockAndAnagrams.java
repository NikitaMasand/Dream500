import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        

            //finding substrings of length 1 then 2 and so on......
            int length_substring = 1;
            //we use i to loop through all the substrings of length from 1 to n-1;
            //we use j for:
            //looping from 0 to length of string-1
            //as substring can start from index 0 or 1 or 2 etc.
            //and k is used to generate substring num 2
            //which are all similar to j in length but come after j
            //isanagram function then checks for strings represented by j and k 
            int numOfAnagrams=0;
            int n =s.length();
            for(int i=0;i<n-1;i++){
                for(int j=0;j<=n-length_substring;j++){
                    String s1 = s.substring(j,j+length_substring);
                    for(int k=j+1;k<=n-length_substring;k++){
                        String s2 = s.substring(k,k+length_substring);
                        if(checkAnagrams(s1,s2)){
                            numOfAnagrams++;
                            
                        }

                    }
                }
                length_substring++;
                
            }
            return numOfAnagrams;
    }

    public static boolean checkAnagrams(String s1,String s2){
        HashMap<Character,Integer> s1map = new HashMap<>();
        HashMap<Character,Integer> s2map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(!s1map.containsKey(s1.charAt(i))){
                s1map.put(s1.charAt(i),1);
            }
            else{
                s1map.replace(s1.charAt(i),s1map.get(s1.charAt(i))+1);
            }
        } 
          for(int i=0;i<s2.length();i++){
            if(!s2map.containsKey(s2.charAt(i))){
                s2map.put(s2.charAt(i),1);
            }
            else{
                s2map.replace(s2.charAt(i),s2map.get(s2.charAt(i))+1);
            }
        }
        if(s1map.equals(s2map)){
                return true;
        }       
        return false;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
