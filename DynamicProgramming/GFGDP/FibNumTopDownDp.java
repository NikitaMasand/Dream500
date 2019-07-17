class Geeks
{
    static long dp[] = new long[100];
    
    //Complete this function
    public long findNthFibonacci(int number)
    {
      if(dp[number]>0)
        return dp[number];
      
      if(number==0 || number==1){
          dp[number] = number;
      }
      else{
          dp[number] = findNthFibonacci(number-1)+findNthFibonacci(number-2);
      }
    
      return dp[number];
    }
}
