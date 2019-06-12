public class FastModuloExponentiation {
    public static void main(String[] args) {
        System.out.println(fastModuloExponentiation(2,4,7));
    }
    public static long fastExponentiation(int number, int power){
        if(power==0)
            return 1;
        if(power==1)
            return number;
        long sub_number = fastExponentiation(number,power/2);
        if(power%2==0)
            return sub_number*sub_number;
        else
            return sub_number*sub_number*number;
    }

    public static long fastModuloExponentiation(int number, int power, int modulus){
        if(power==0)
            return 1;
        if(power==1)
            return number;
        long sub_number = fastModuloExponentiation(number,power/2,modulus)%modulus;
        if(power%2==0)
            return (sub_number*sub_number)%modulus;
        else
            return ((sub_number*sub_number)%modulus * number%modulus)%modulus;
    }


}
