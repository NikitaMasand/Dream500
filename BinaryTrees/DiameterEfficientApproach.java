package Trees;
class Pair{
    int height;
    int diameter;
}
public class DiameterEfficientApproach {
    public static Pair findDiameter(Node node){
        if(node==null){
            Pair output = new Pair();
            output.height = 0;
            output.diameter = 0;

            return output;
        }
        Pair leftOutput = findDiameter(node.left);
        Pair rightOutput = findDiameter(node.right);

        int height = 1+Math.max(leftOutput.height,rightOutput.height);
        int option1 = leftOutput.height + rightOutput.height;
        int option2 = leftOutput.diameter;
        int option3 = rightOutput.diameter;

        int diameter = Math.max(option1,Math.max(option2,option3));
        Pair output = new Pair();
        output.height = height;
        output.diameter = diameter;

        return output;
    }


    public static int findHeight(Node node){
        if(node==null)
            return 0;
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return 1+Math.max(leftHeight,rightHeight);
    }
    public static void main(String[] args) {
        Node root = null;
        //level order traversal of inserted nodes:
        //15 10 20 8 12 17 25 6 11 16 27
        root = InsertNodes.insertUtil(root);
        System.out.println(findDiameter(root).diameter);
    }
}
