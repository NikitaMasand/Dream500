package Trees;

public class ParentAndSiblingOfNode {
    static Node prev = null;
    public static Node findParent(Node root, int value){
        if(root==null)
            return null;

        Node temp = root;
        if(temp.data==value)
            return prev;
        else if(temp.data<value) {
            prev = temp;
            return findParent(root.right, value);
        }
        else {
            prev = temp;
            return findParent(root.left, value);
        }
    }

    public static Node findSibling(Node root, int value){
        Node parent = findParent(root,value);
        if(parent==null){
            return null;
        }
        if(parent.left!=null && parent.right!=null) {
            if (parent.left.data == value)
                return parent.right;
            else
                return parent.left;
        }
        return null;
    }
    public static void main(String[] args) {
        Node root = null;
        //level order traversal of inserted nodes:
        //15 10 20 8 12 17 25 6 11 16 27
        root = InsertNodes.insertUtil(root);
        Node parent = findParent(root,17);
        if(parent==null){
            System.out.println("Given value is either root node or does not exist in tree");
        }
        else {
            System.out.println("Parent's data is: "+parent.data);
        }
        Node sibling = findSibling(root,27);
        if(sibling==null){
            System.out.println("Given value does not have sibling");
        }
        else{
            System.out.println("Sibling's data is: "+ sibling.data);
        }
    }
}
