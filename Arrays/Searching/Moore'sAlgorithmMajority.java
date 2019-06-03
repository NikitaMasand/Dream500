/*
Majority: appears more than n/2+1 times in the array
Hashmap works..O(n)extra space
Sorting and then checking mid and last element..if they are equal, that is the majority element 
otherwise it does not exist..but O(nlogn) time

Moore’s voting Algorithm
Works only if majority element exists
O(n) time
O(1) space


Step 1: Find a candidate. 
Assume the first element as majority one and count = 1,
if next element is also same, count+=1, otherwise count-=1, the element is majority until, count=0
once count is 0
the  majority element is reset 
and  assumed to be the element who made the count 0. 
This goes on till end

Step 2. Lastly we get one element and we need to verify whether its truly majority,
thus check its count in array in 0(n) time

*/



public class MooresMajorityElement {
    public static void main(String[] args) {
        int a[] = new int[]{3, 3, 4, 2, 4, 4, 2, 4};
        int size = a.length;
        printMajority(a, size);
        int arr[] = new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4};
        int size1 = arr.length;
        printMajority(arr, size1);

    }
    public static void printMajority(int arr[], int size){
        int candidate = findCandidate(arr, size);
        if(isMajority(arr, candidate,size)){
            System.out.println("Majority element is: " + candidate);
        }
        else
        System.out.println("Majority element does not exist");
    }
    //step 1
    public static int findCandidate(int arr[], int size){
        int count = 1;
        int cand = arr[0];
        for(int i=1;i<size;i++){
            if(arr[i]==arr[i-1]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                cand = arr[i];
            }
        }
        return cand;
    }
    //step 2
    public static boolean isMajority(int arr[],int candidate, int size){
        int count =0;
            for(int i=0;i<size;i++){
                if(arr[i]==candidate){
                    count++;
                }
            }
            return count>size/2;
    }
}

