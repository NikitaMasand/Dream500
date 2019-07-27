/*
sum of first n natural numbers: n(n+1)/2
sum of squares of first n natural numbers: n(n+1)(2n+1)/6
sum of cubes of first n natural numbers: (n(n+1)/2)^2
*/

/*count number of squares in a n*n chessboard

number of squares in a 2*2 :
num of 1*1 squares = 4 +
num of 2*2 squares = 1;

number of squares in a 3*3 :
num of 1*1 squares = 9 +
num of 2*2 squares = 4 +
num of 3*3 squares = 1;
=1+2^2+3^2+4^2+......+n^2
=n(n+1)(2n+1)/6

*/

class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    System.out.println((n*(n+1)*(2*n+1))/6);
		}
	}
}

/*
number of rectangles in a m*n grid:

rectangle is nothing but two horizontal lines intersecting with two vertical lines
m rows = m+1 horizontal lines
n cols = n+1 vertical lines
x = number of ways to choose 2 horizontal lines of m+1 = m+1
                                                        C
                                                          2
y = number of ways to choose 2 vertical lines of n+1 = n+1
                                                       C
                                                         2
number of rectangles = x*y   = (m(m+1)/2)*(n(n+1)/2)                                    
*/

/*
Number of squares in a m*n grid:
Let m be the smaller dimension and n the greater dimension
no. of squares in m*m = m(m+1)(2m+1)/6

if we add one more column the number of squares is increased by 1+2+...+(m-1)+m
i.e m squares of 1*1 dimension, m-1 of 2*2 dimension and so on
= m(m+1)/2
since after m*m we have increased the dimensions as n-m
thus number of squares in a m*n is given by:

m(m+1)(2m+1)/6 + (n-m)(m)(m+1)/2
where m is the smaller dimension
*/
