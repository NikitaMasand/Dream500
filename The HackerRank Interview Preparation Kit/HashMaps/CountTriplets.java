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

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
 //mp2 stores potential doublet if encountered. i.e if 1 is encountered
//mp2 will store 5..so that when 5 actually encounters, map2 will know
//a doublet is formed. also, since 5 can also form a doublet, it adds 25 to
//itself, so that when 25 actually encoutered, it forms a doublet of 5,25
        HashMap<Long,Long> mp2 = new HashMap<>();
/* mp3 stores potential triplet if found. i.e if 25 is found in mp3..that means
5 is already in map2 who has formed a doublet with 1,5 and waiting for 23.
when 23 is found in array, it means the triplet is finally found and result is incremeneted by the count of how many 25 were needed. i.e how many 1 and 5 were waiting for 25.
    */
        HashMap<Long,Long>mp3 = new HashMap<>();
        long result = 0;
        for(Long a: arr){
            /*
            this checks that if mp3 is waiting for arr[i] i.e the doublet is already
            formed, and since the third element of triplet is also found
            the result can thus be added by how many doublets needed 25. if not then 0
             */
            result+= mp3.getOrDefault(a,0L);
            /*
            if mp2 contains the element in array that means the doublet is now
            formed..we need to find the triplet thus we add the curr element*r in map3 to
            find it. and we set the count along with it as the count of
            the same element in map2 i.e these many doublets are waiting to form this                element
             */
            if(mp2.containsKey(a)){
                mp3.put(a*r,mp3.getOrDefault(a*r,0L)+mp2.get(a));
            }

            /*
            for all cases put currelement*r in map2
            to know that this can be the potential doublet
            if already present..simply increment it's count by 1.
             */
            mp2.put(a*r,mp2.getOrDefault(a*r,0L)+1);
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
