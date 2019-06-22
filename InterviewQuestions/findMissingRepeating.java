/*
given n, a array consist nos from 1 to N, in which one number is repeated 2 times and one number is missing
find the repeated and missing number
time: O(n)
space: O(1)
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetShadow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String [] array=br.readLine().split(" ");
            int sumgiven=0;
            int sumActual=n;
            for(int i=0;i<n;i++) {
                arr[i]= Integer.parseInt(array[i].trim());
                sumgiven=sumgiven+arr[i];
                sumActual = sumActual+i;
            }

            int diff = sumActual-sumgiven;
            int repeat=-1;
            for(int i=0;i<n;i++) {
                if(arr[Math.abs(arr[i])-1]<0) {
                    repeat=Math.abs(arr[i]);
                    break;
                }
                arr[arr[i]-1]=(-1)*arr[arr[i]-1];
            }
            int missing=diff+repeat;

            System.out.println(repeat+" "+missing);
        }
    }
}
