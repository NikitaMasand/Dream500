public class FactorialTailRecursion {
    public static void main(String[] args) {
        int k = 20;
        System.out.println(fact(k));
        System.out.println(factTailRecursion(k,1));
    }
    public static long fact(int n){
        if(n==1 || n==0)
            return 1;
        return n*fact(n-1);
    }

    //tail recursion
    //as the function call is the last statement
    //explained it in google doc.
    public static long factTailRecursion(int n, long result){
        if(n==1 || n==0){
            return result;
        }
        return factTailRecursion(n-1,n*result);
    }
}

//here both work the same in results, however tail rec. one uses constant space
