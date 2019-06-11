public class ExponentiationRecursion {
    public static void main(String[] args) {
        System.out.println(power(7,12));
    }
    
    
    //using divide and conquer
    /*
    this method reduces the time complexity from O(n) to O(logn)
    a*a*a*a*...n times = w
    let r = a*a*a..n/2 times
    if n is even
    w = r*r
    if n is odd
    w = r*r*a
    
    base case will be if n is 0 return 1 and if n is 1 return a
    
     */
    public static long power(int number, int power){
        if(power==0)
            return 1;
        if(power==1)
            return number;
        long sub_number = power(number,power/2);
        if(power%2==0)
            return sub_number*sub_number;
        return sub_number*sub_number*number;
    }
}
