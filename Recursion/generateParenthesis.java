/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        generateValid(n,1,0,"(",output);
        returna output;
    }
    
    public void generateValid(int n, int openCount, int closeCount,String currentString,List output) {

        if(currentString.length()==2*n) {
            output.add(currentString);
            return;
        }

        if(openCount< n  ) {
            String newCurrentString = currentString.concat("(");
            generateValid(n,openCount+1,closeCount,newCurrentString,output);
        }
        if(closeCount<openCount) {
            String newCloseString = currentString.concat(")");
            generateValid(n,openCount,closeCount+1,newCloseString,output);
        }
    }
}
