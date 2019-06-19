/*
The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}.
The first node will definitely be in range, so create root node. To construct the left subtree, set the range as {INT_MIN …root->data}.
If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree. To construct the right subtree,
set the range as {root->data..max .. INT_MAX}.
Above text from gfg.

//there was a need to make index class and not directly pass index as int
//because in reucrsion stack if you want to add 7 to tree and thus to call from 1 where index passed was 3,
// but the conditions were not satisfied so you went back to 5, 5's right. but when you went back to 5,
//the index is again 2. but 7's index was 3. how do you keep track of the correct index because
//in the recursion the index goes on going up and down. thus class was made for making index as stable and correct.

Try making a recursion stack if that’s unclear.

*/
package Trees;
class Index{
    int index = 0;
}

public class BinaryTreeFromPreorderTraversal {
    Index index = new Index();
    public Node constructTree(int pre[], int size){

        return constructTreeUtil(pre,index,pre[0],Integer.MIN_VALUE,Integer.MAX_VALUE,size);
    }
    public static Node constructTreeUtil(int[] pre, Index preIndex, int key, int min, int max, int size){
        if(preIndex.index>=size)
            return null;
        Node root = null;
        if(key>min && key<max){
            root = new Node(key);
             preIndex.index=preIndex.index+1;

            if(preIndex.index<size){
                root.left = constructTreeUtil(pre,preIndex,pre[preIndex.index],min,key,size);

                root.right = constructTreeUtil(pre,preIndex,pre[preIndex.index],key,max,size);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        BinaryTreeFromPreorderTraversal construct = new BinaryTreeFromPreorderTraversal();
        Node root = construct.constructTree(pre,size);
        System.out.println("Inorder traversal of the constructed tree is ");
        BinarySearchTree.inOrder(root);
    }
}
