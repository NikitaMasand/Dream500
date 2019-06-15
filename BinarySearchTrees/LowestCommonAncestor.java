/*
If both the nodes are on the same side of the currnode, 
we can go to left or right accordingly, but if both the nodes are on opposite side of the curr node,
we are sure that curr node is the lowest common ancestor because otherwise they both are now separated. 
Also if the currnode is one of the nodes, we cannot go down as we will lose that node, thus currnode becomes lca this time also. 
*/
package Trees;

import static Trees.BinarySearchTree.insertNode;

public class LowestCommonAncestor {
    public static Node LCABST(Node root, int v1, int v2){
        if(root.data==v1 || root.data==v2)
            return root;
        else if(v1<root.data && v2<root.data)
            return LCABST(root.left,v1,v2);
        else if(v1>root.data && v2>root.data)
            return LCABST(root.right,v1,v2);
        else
            return root;
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,15);
        root = insertNode(root,10);
        root = insertNode(root,20);
        root = insertNode(root,8);
        root = insertNode(root,12);
        root = insertNode(root,17);
        root = insertNode(root,25);
        root = insertNode(root,6);
        root = insertNode(root,11);
        root = insertNode(root,16);
        root = insertNode(root,27);
        System.out.println(LCABST(root,11,16).data);
    }
}
