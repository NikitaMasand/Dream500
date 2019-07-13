package Trees;

/*
Given a binary tree, check if the tree can be folded or not.
A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
*/

public class FoldableBinaryTree {
    public static void main(String[] args) {

    }
}

class FoldableByModifying{
    public static boolean isFoldable(Node node)
    {
        //for being foldable left and right subtrees children
        // need to be of opposite direction
        //thus if we make left subtree as it's own mirror
        //that means now check if both the subtrees have same
        //structure i.e their children are in the same directions
        boolean res;

        if(node==null)
            return true;

        mirror(node.left);

        res = isStructureSame(node.left,node.right);
        //bringing left subtree back as before
        mirror(node.left);
        return res;



    }
    public static boolean isStructureSame(Node n1, Node n2){
        if(n1==null && n2==null)
            return true;
        if(n1!=null && n2!=null &&
        isStructureSame(n1.left,n2.left) &&
        isStructureSame(n1.right, n2.right))
            return true;

        return false;
    }

    public static void mirror(Node node){
        if(node==null)
            return;
        if(node.left==null && node.right==null)
            return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}

class FoldableWithoutModifying{
        public static boolean isFoldable(Node node){
            if(node==null)
                return true;
            return isFoldableUtil(node.left,node.right);
        }

        public static boolean isFoldableUtil(Node n1, Node n2){
            if(n1==null && n2==null)
                return true;
            if(n1==null || n2== null)
                return false;

            return isFoldableUtil(n1.left,n2.right) &&
                    isFoldableUtil(n1.right,n2.left);
        }
}
