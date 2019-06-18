package Trees;

public class DiameterBasicApproach {
    public static int findDiameter(Node node){
        if(node==null)
            return 0;
        //if including this node, the diameter is maximum
        int includingThisNode = findHeight(node.left) + findHeight(node.right);
        //excluding the node...diameter can be maximum in leftor right subtrees
        int ld = findDiameter(node.left);
        int rd = findDiameter(node.right);

        return Math.max(includingThisNode,Math.max(ld,rd));
    }
    //time complexity:
    /*
    For a perfect binary tree.. T(n) = 2T(n/2) + O(n)...O(n) because n work is done
    in finding the height of nodes. thus complexity becomes O(nlogn)
    For a skewed binary tree..T(n) = T(n-1) + n...thus complexity is O(n^2)

    thus, complexity is O(n*h)
    This can be improved, because height for a node is calculated multiple times
    height of children is called for finding the diameter when current node is included
    as that asks for height of children, and when current node is not included
    we ask for it's diameter again..which in case for diameter
    the height is to be calculated again. Thus, algorithm can be improved by not
    recalculating height again and again.
     */


    public static int findHeight(Node node){
        if(node==null)
            return 0;
        int lh = findHeight(node.left);
        int rh = findHeight(node.right);
        return 1+Math.max(lh,rh);
    }

    //time complexity: O(n)
    // T(n) = 2T(n/2)+1


    public static void main(String[] args) {

    }
}
