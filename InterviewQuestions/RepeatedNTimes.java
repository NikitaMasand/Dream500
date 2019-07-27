/*
In a array A of size 2N, there are N+1 unique elements,
and exactly one of these elements is repeated N times.
Return the element repeated N times.
*/

/*
since the number is repeated n times and rest are unique, even if we find the element repeated 2 times
that is the answer. 
there are two cases possible:
the element is atleast once adjacent to it's repetitive element
eg: 1,2,3,2,2,4
else, the element repeated is alternate
for alternates we check arr[0] with last and second last
and arr[1] with last and second last
eg: 1,2,3,2,4,2
or 2,1,2,3,2,4
*/
class Solution {
    public int repeatedNTimes(int[] arr) {
        
        for(int i=1; i<arr.length; i++){
            if(arr[i]==arr[i-1]){
                return arr[i];
            }
        }
        if(arr.length>=3){
        if(arr[0]==arr[arr.length-1] || arr[0]==arr[arr.length-2]){
            return arr[0];
        }
        if(arr[1]==arr[arr.length-1] || arr[1] == arr[arr.length-2]){
            return arr[1];
        }
        
    }
        return -1;
}
}
