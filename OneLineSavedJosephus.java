/*
for n people in a circle, starting from first person, every second person is killed
find the one person's position who survived.
https://www.youtube.com/watch?v=uCsD3ZGzMgE
check the video, it is clear.
at the first move, all sitting in the even positions are killed.
claim: if n = 2^a;
w(n) = 1; ..winning position

if n = 2^a + l...where 2^a is the highest possible power of 2 that can be expressed
w(n) = 2l+1..
with the little observation it can be noted that..
if n is expressed in binary just take the leading digit and put it at the end
 */
 
public class JosephusProblemForAdjKilling {
    public static void main(String[] args) {
        System.out.println(survivalPosition(41));
    }
    public static int survivalPosition(int n){
        int x = Integer.parseInt(Integer.toBinaryString(n).concat("1").replaceFirst("1","0"),2);
        return x;
    }
}
