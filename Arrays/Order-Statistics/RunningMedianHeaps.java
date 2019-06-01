import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    //returning double because the median is not necessarily integer
    static double[] runningMedian(int[] array) {
        //lowers is a maxheap whose root element will be one of the participants in             //deciding the median
        PriorityQueue<Integer>lowers = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return -1*a.compareTo(b);
            } 
        });    
        //highers is a minheap whose root element will be one of the participants in
        //deciding the median
        PriorityQueue<Integer>highers = new PriorityQueue<>();

        //creating median array which will return the value of median at each point
        double medians[] = new double[array.length];

        for(int i =0; i<array.length;i++){
            int number = array[i];
            //depending on it's position no. is added to lowers or highers
            addNumber(number,lowers,highers);
            //rebalancing is needed as the max difference in the size of lowers and 
            //highers can be 1.
            rebalance(lowers,highers);

            medians[i] = getMedian(lowers,highers);
        }   
        return medians;    
        }

        public static void addNumber
        (int number,
        PriorityQueue<Integer>lowers,
        PriorityQueue<Integer>highers)
        {
            if(lowers.size()==0 || number<lowers.peek()){
                lowers.add(number);
            }
            else{
                highers.add(number);
            }
        }

        public static void rebalance(
            PriorityQueue<Integer>lowers,
            PriorityQueue<Integer>highers)
            {
                PriorityQueue<Integer>biggerHeap = 
                lowers.size() > highers.size() ? 
                lowers:highers;
                PriorityQueue<Integer>smallerHeap = 
                lowers.size() > highers.size() ?
                highers:lowers;

                if(biggerHeap.size()-smallerHeap.size()>=2){
                    smallerHeap.add(biggerHeap.poll());
                }
            }

            public static double getMedian(
            PriorityQueue<Integer>lowers,
            PriorityQueue<Integer>highers)
            {
                PriorityQueue<Integer>biggerHeap =
                lowers.size() > highers.size() ?
                lowers:highers;
                PriorityQueue<Integer>smallerHeap = 
                lowers.size() > highers.size() ?
                highers:lowers;

                if(smallerHeap.size()==biggerHeap.size()){
                    return((double)(smallerHeap.peek()+biggerHeap.peek())/2);
                }
                else
                    return biggerHeap.peek();
            }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
