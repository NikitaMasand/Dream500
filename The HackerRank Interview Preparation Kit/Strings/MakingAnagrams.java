package HackerRankInterviewPreparation.StringManipulation;

public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        int count = 0;
        int arr[] = new int[26];
        for(int i=0;i<a.length();i++){
            arr[a.charAt(i)-97]++;
        }
        for(int i=0;i<b.length();i++){
            arr[b.charAt(i)-97]--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                count+=Math.abs(arr[i]);
            }
        }
        return count;

    }
    public static void main(String[] args) {
        System.out.println(makeAnagram("cde","dcf"));
    }
}
