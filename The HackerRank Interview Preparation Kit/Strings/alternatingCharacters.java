package HackerRankInterviewPreparation.StringManipulation;

public class alternatingCharacters {
    static int alternatingCharacters(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i)==sb.charAt(i-1)){
                sb.deleteCharAt(i);
                count++;
                i--;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAAAA"));
    }

}
