//to be optimized more
 import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
       HashMap<Integer,Integer> map = new HashMap<>();
       HashMap<Integer,Integer>frequency = new HashMap<>();
        List<Integer>output = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int operation = queries[i][0];
            int data = queries[i][1];
            if(operation==1){
                map.put(data,map.getOrDefault(data,0)+1);
            }
            else if(operation==2){
                if(map.containsKey(data)&&map.get(data)>0){
                    map.replace(data,map.get(data)-1);
                }
            }
            else{
                if(map.containsValue(data)){
                    output.add(1);
                    continue;
                }
                output.add(0);
            }

        }
        return output;     

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in))) {
            
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
           
            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }
          
            List<Integer> ans = freqQuery(queries);
          
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH")))) {
            
                bufferedWriter.write(ans.stream().map(Object::toString)
                            .collect(joining("\n")) + "\n");
            }
        }
    }
}
