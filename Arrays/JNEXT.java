/*
Given a number n, find the smallest number that has same set of digits as n and is greater than n.
If n is the greatest possible number with its set of digits, then print “not possible”.




PS: I'll optimize this approach by applying binary search on the just greater digit and optimizing sort in future.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class jnext {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int number[] = new int[n];
            String s[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                number[i] = Integer.parseInt(s[i]);
            }
            number = findNext(number,n);
            if(number==null)
                System.out.println(-1);
            else {
                for (int i = 0; i < n; i++) {
                    System.out.print(number[i]);
                }
            }
            System.out.println("");
        }
    }
        public static int[] findNext(int[]number,int n){
            int i,j;
            for(i=n-1;i>0;i--){
                if(number[i-1]<number[i])
                    break;
            }
            if(i==0){
                return null;
            }

            i = i-1;
            int max = Integer.MAX_VALUE;
            int num = number[i];
            int index=0;
            for(j=i+1;j<n;j++){
                if(number[j]>num && number[j]<max) {
                    max = number[j];
                    index = j;
                }
            }
            swap(i,index,number);
            Arrays.sort(number,i+1,n);
            return number;

        }
        public static void swap(int indexOne,int indexTwo,int[]number){
            int temp = number[indexOne];
            number[indexOne] = number[indexTwo];
            number[indexTwo]=temp;
        }
}
