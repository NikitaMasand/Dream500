
import java.util.*;
import java.io.*;
import java.lang.*;
public class SumOfDigits
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt(); 
            System.out.println(new Digitsum().sumOfDigits(n)); 
    }
}

class Digitsum
{
    int sum = 0;
    public int sumOfDigits(int n)
    {
        if(n<10){
            return sum+n;
        }
        sum+=(n%10);
        return sumOfDigits(n/10);
    }
}
