public class GCDEuclidAlgorithm {
    public static int findGCD(int a, int b){

        //time complexity: O(digits in the smaller number, say b)
        // O(log b)

        int dividend = a>b ? a:b;
        int divisor = a>b ? b:a;
        while (divisor!=0){
            int remainder = dividend%divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }
    //a: divisor
    //b: dividend
    public static int recursiveGCD(int a, int b){
        return a==0 ? b:recursiveGCD(b%a,a);
    }
    public static void main(String[] args) {
        System.out.println(findGCD(9,3));
        System.out.println(recursiveGCD(9,3));
    }
}
