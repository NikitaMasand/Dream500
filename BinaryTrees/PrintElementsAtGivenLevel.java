package Trees;

import static Trees.BinarySearchTree.findHeight;
import static Trees.BinarySearchTree.insertNode;

public class ElementsAtGivenLevel {
    public static void printElementsAtGivenLevel(Node node,int level){
        if(node==null)
            return;
        if(level==1){
            System.out.print(node.data+" ");
            return;
        }
        printElementsAtGivenLevel(node.left,level-1);
        printElementsAtGivenLevel(node.right,level-1);
    }
    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root,17);
        root = insertNode(root,25);
        root = insertNode(root,6);
        root = insertNode(root,11);
        root = insertNode(root,16);
        root = insertNode(root,27);
        printElementsAtGivenLevel(root,2);
        //printing elements at all levels
        //level order traversal without recursion
        System.out.println();
        System.out.println("Height: "+ findHeight(root));
        System.out.println("Level order traversal without recursion: ");
        for(int i=1;i<=findHeight(root)+1;i++) {
            printElementsAtGivenLevel(root, i);
        }
        System.out.println("Reverse Level order traversal recursion: ");
        for(int i=findHeight(root)+1;i>=1;i--) {
            printElementsAtGivenLevel(root, i);
        }
    }
}
