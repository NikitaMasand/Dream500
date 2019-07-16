package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {86,177,115,193,135,186,92,49,21,162,27,90,59,163,126,140,26,172,136,11,168,167,29,182,130,62,123,67,135,129,2,22,58,69,167,193,56,11,42,29,173,21,119,184,137,198,124,115,170,13,126,91,180,156,73,62,170,196,81,105,125,84,127,136,105,46,129,113,57,124,95,182,145,14,167,34,164,43,150,87,8,76,178};
        System.out.println(findIncSubsequence(arr));
    }
    public static int findIncSubsequence(int[] arr){
        /*
        for every element we find the increasing subsequence ending with it
        and we take longest of all

        lis(i) = max(lis(j)+1)
         0<=j<i && arr[j]<arr[i]

         res = max in lis
         */
        int n = arr.length;
        int[] lis = new int[n];
       for(int i=0;i<n;i++){
           lis[i]=1;
       }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
           max = Math.max(max,lis[i]);
        }
        return max;
    }
}
