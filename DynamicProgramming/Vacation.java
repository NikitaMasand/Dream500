package DynamicProgramming.Atcoder_DPPractice;

import java.util.Scanner;

/*
Taro's summer vacation starts tomorrow, and he has decided to make plans for it now.
The vacation consists of N days. For each i..1 to N,
Taro will choose one of the following activities and do it on the ith day
A: Swim in the sea. Gain ai points of happiness.
B: Catch bugs in the mountains. Gain bi points of happiness.
C: Do homework at home. Gain ci points of happiness.
As Taro gets bored easily,
he cannot do the same activities for two or more consecutive days.
Find the maximum possible total points of happiness that Taro gains.
 */
public class Vacation {
    public static int findMaxHappiness(int days, int[] a, int[] b, int[] c){
        //dp1 for any i represents activity a is performed on ith day
        //dp2 for any i represents activity b is performed on ith day
        //dp3 for any i represents activity c is performed on ith day
        int[] dp1 = new int[days];
        int[] dp2 = new int[days];
        int[] dp3 = new int[days];
        dp1[0] = a[0];
        dp2[0] = b[0];
        dp3[0] = c[0];
        for(int i=1;i<days;i++){
            dp1[i] = Math.max(dp2[i-1]+a[i],dp3[i-1]+a[i]);
            dp2[i] = Math.max(dp1[i-1]+b[i],dp3[i-1]+b[i]);
            dp3[i] = Math.max(dp1[i-1]+c[i],dp2[i-1]+c[i]);
        }
        return Math.max(dp1[days-1],Math.max(dp2[days-1],dp3[days-1]));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int a[] = new int[days];
        int b[] = new int[days];
        int c[] = new int[days];
        for(int i=0;i<days;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
            c[i]=sc.nextInt();
        }
        System.out.println(findMaxHappiness(days,a,b,c));
    }
}

