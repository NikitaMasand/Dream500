package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];

            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();

            System.out.println(findLongestConseqSubseq(a, n));

            t--;

    }

    }

    private static int findLongestConseqSubseq(int[] arr, int n) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        int length=0;
        Arrays.stream(arr).forEach(i -> integerHashSet.add(i));

        for(int i=0;i<n;i++) {
            if(!integerHashSet.contains(arr[i]-1)) {
                int j = arr[i];
                while(integerHashSet.contains(j)) {
                    j++;
                }
                length = Math.max(length,j-arr[i]);
            }

        }
        return length;

    }
}

