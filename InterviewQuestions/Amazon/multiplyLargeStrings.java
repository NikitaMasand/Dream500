

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class GfG{
    public String multiply(String a,String b){
        BigInteger an = new BigInteger(a);
        BigInteger bn = new BigInteger(b);
        
        BigInteger res = an.multiply(bn);
        
        return res.toString();
        
    }
}
