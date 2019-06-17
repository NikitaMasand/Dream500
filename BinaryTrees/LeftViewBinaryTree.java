package Trees;

import java.util.LinkedList;
import java.util.Queue;

import static Trees.BinarySearchTree.insertNode;

public class LeftViewBinaryTree {
    public static void leftViewBinaryTree(Node root){
        boolean flag = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node pointer = queue.peek();
        while (!queue.isEmpty()){
            Node temp = queue.peek();
            if(temp==pointer)
                System.out.print(pointer.data+" ");
            if(temp.left!=null){
                queue.add(temp.left);
                if(flag==true){
                    pointer=temp.left;
                    flag=false;
                }
                if(temp==pointer){
                    pointer=temp.left;
                }
            }
            if(temp.right!=null){
                queue.add(temp.right);
                if(flag==true){
                    pointer=temp.right;
                    flag=false;
                }
                if(temp.left==null && temp==pointer){
                    pointer = temp.right;
                }
            }
            if(temp==pointer&&temp.left==null&&temp.right==null){
                flag=true;
            }
            queue.poll();
        }
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
        root = insertNode(root,29);
        root = insertNode(root,18);
        root = insertNode(root,19);
        root = insertNode(root,30);

        leftViewBinaryTree(root);
    }
}
