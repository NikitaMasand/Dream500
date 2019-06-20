//n<=1000000

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class countDigits1ton {
    public static int countDigits(int n){
        int arr[] = {0,9,189,2889,38889,488889,488895};
        int length = Integer.toString(n).length();
        if(length==6){
            return arr[6];
        }
        if(length==1)
            return n;
        StringBuilder number = new StringBuilder();
        for(int i=0;i<length-1;i++){
            number.append(9);
        }
        int num = Integer.parseInt(number.toString());
        int res = arr[length-1]+(n-num)*length;
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(countDigits(n));
        }
    }
}
