/*
For Iterative approach, simply traverse the tree level by level (level order traversal),
store sum of node values in even no. level in evenSum and rest in variable oddSum
and finally return the difference.

simple recursive traversal.
We can recursively calculate the required difference as,
value of root’s data subtracted by the difference for subtree under left child
and the difference for subtree under right child.

Return node.data - getDiff(node.left)-getDiff(node.right)
This works because as can be seen in picture also,
the node at root is initially positive at level 1 and the left and right child are subtracted.
Again their children are subtracted giving final result as positive for the level 3.
Again level 3 children are subtracted giving level 4 children negative sign and so on.
Thus for levels 3, 5...minus of minus does the magic.
 */

package Trees;

import static Trees.BinarySearchTree.insertNode;

public class getDiffOddEvenLevels {
    public static int oddEvenDiff(Node node){
        if(node==null)
            return 0;
        return node.data-oddEvenDiff(node.left)-oddEvenDiff(node.right);
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
        System.out.println(oddEvenDiff(root));
    }
}
