public class TowerOfHanoiRecursion {
    private static int moves = 0;
    public static void main(String[] args) {
        TOH(4,'A','B','C');
        System.out.println("Minimum no of moves required: " + moves);
    }
    public static void TOH(int n, char from_rod, char aux_rod, char to_rod){
        if(n==1){
            System.out.println("Move "+ from_rod + " to "+ to_rod);
            moves++;
        }
        else{
            TOH(n-1,from_rod,to_rod,aux_rod);
            TOH(1,from_rod,aux_rod,to_rod);
            TOH(n-1,aux_rod,from_rod,to_rod);
        }
    }
}
