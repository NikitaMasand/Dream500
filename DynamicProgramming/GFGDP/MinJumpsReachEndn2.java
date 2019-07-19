

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.
*/
class x{
    int val;
    int index;

    x(int val, int index){
        this.val = val;
        this.index = index;
    }

}
class MinJumpsReachEnd {
    public int jump(int[] arr) {
           int n = arr.length;
        if(n==1)
            return 0;
        int jumps[] = new int[n];
        
        jumps[n-1] = Integer.MAX_VALUE;
        for(int i = n-2; i>=0; i--){
            x object = new x(Integer.MIN_VALUE,-1);

            for(int j = i+1; j-i<=arr[i] && j<n; j++){
               if(jumps[j]>object.val){
                   object.val = jumps[j];
                   object.index = j;
               }
            }
            jumps[i] = object.index;
        }
        int j = 0;
        int counts = 0;
        boolean flag = false;
        while (j<n){
            j = jumps[j];
            counts++;

            if(j==n-1){
                flag = true;
                break;
            }
        }

        if(flag==true)
            return counts;
        return -1;
    }
    }
