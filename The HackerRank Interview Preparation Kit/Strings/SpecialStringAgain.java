package HackerRankInterviewPreparation.StringManipulation;

public class SpecialStringAgain {
    static long substrCount(int n, String s) {
        long result = 0;
        int i = 0;
        long[] sameChar = new long[n];
        while (i < n) {
            int sameCharCount = 1;
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
                sameCharCount++;
            }
            result += ((sameCharCount) * (sameCharCount + 1)) / 2;
            sameChar[i] = sameCharCount;
            i = j;
        }
        for(int j=1;j<n;j++){
            if(s.charAt(j)==s.charAt(j-1)){
                sameChar[j]=sameChar[j-1];
            }
            if(j<n-1 && s.charAt(j-1)==s.charAt(j+1) && s.charAt(j)!=s.charAt(j-1)){
                result+=Math.min(sameChar[j-1],sameChar[j+1]);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(substrCount(7,"aabbcac"));
    }

}
