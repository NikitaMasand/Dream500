/*
I have always used mid = left+right/2
And I never gave a thought of why tutorials use 
mid = left + (right-left)/2
But recently I read this answer https://stackoverflow.com/questions/27167943/why-leftright-left-2-will-not-overflow
and understood.

by definition left <= MAX_INT
by definition right <= MAX_INT
left+(right-left) is equal to right, which already is <= MAX_INT per #2
and so left+(right-left)/2 must also be <= MAX_INT since x/2 is always smaller than x


by definition left <= MAX_INT
by definition right <= MAX_INT
therefore left+right <= MAX_INT
and so (left+right)/2 <= MAX_INT
where statement 3 is clearly false, since left can be MAX_INT (statement 1) and so can right (statement 2).

I tried a java code:
*/
public class testOverflow {
    public static void main(String[] args) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        int mid = (low+high)/2;
        int mid1 = low + (high-low)/2;

        System.out.println(mid);
        System.out.println(mid1);
        System.out.println(Integer.MAX_VALUE);
    }

}
/*
output:
-1
2147483647
2147483647

*/
