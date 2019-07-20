package DynamicProgramming.GFGDP;

public class SumOfSubstringsOfNumber {
    public static long findSumSubstrings(String s){
        int n = s.length();
        long sum = s.charAt(0)-48;
        long[] sumDigit = new long[n];
        sumDigit[0] = sum;
        for(int i=1;i<n;i++){
            sumDigit[i] = (s.charAt(i)-48)*(i+1) + 10*(sumDigit[i-1]);
            sum+=sumDigit[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(findSumSubstrings("1234"));
    }
}
