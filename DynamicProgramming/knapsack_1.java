/*
assuming weight array is given in sorted order
 */
package DynamicProgramming.Atcoder_DPPractice;
import java.util.Arrays;
import java.util.Scanner;

public class knapsack_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfItems = sc.nextInt();
        int knapSackWeight = sc.nextInt();
        int[] itemValue = new int[numOfItems+1];
        int[] itemWeight = new int[numOfItems+1];
        for(int i =1;i<=numOfItems;i++){
            itemWeight[i] = sc.nextInt();
            itemValue[i] = sc.nextInt();
        }
//        Arrays.sort(itemWeight);
        System.out.println(findMaxValue(numOfItems,knapSackWeight,itemWeight,itemValue));
    }
    public static long findMaxValue(int items, int knapSackWeight, int[] itemWeight, int[] itemValue){
        long[][] T = new long[items+1][knapSackWeight+1];
        for(int i=1;i<=items;i++){
            for(int j=1;j<=knapSackWeight;j++){
                if(itemWeight[i]>j){
                    T[i][j] = T[i-1][j];
                }
                else{
                    T[i][j] = Math.max(T[i-1][j],itemValue[i]+T[i-1][j- itemWeight[i]]);
                }
            }
        }
        return T[items][knapSackWeight];
    }
}
