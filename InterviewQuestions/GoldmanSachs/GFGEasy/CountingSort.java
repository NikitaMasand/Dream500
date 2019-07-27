/*
Given a string S consisting of lowercase latin letters, arrange all its letters in lexographical order using Counting Sort.
*/

class GfG
{
    // Function to do count sort
    // seq[]: input array
    public static void countSort(char seq[])
    {
        int[] arr = new int[26];
        int n = seq.length;
        for(int i=0; i<n; i++){
            arr[seq[i]-'a']++;
        }
        
        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i]+arr[i-1];
        }
        
        char[] res = new char[n];
        for(int i=0; i<n; i++){
            res[arr[seq[i]-'a']-1]=seq[i];
            arr[seq[i]-'a']--;
        }
        System.arraycopy(res,0,seq,0,n);
    }
}
