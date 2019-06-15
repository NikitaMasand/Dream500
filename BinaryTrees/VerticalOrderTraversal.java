/*
So vertical order traversal is basically traversing the nodes vertical line wise. 
And if they are on same horizontal level, print the nodes from left to right, like in level order traversal. 

So we consider root is at 0 distance and we find distance of all the nodes from the root node 
i.e a node just to the left of root is -1 and just to the right is +1 dist. Let the dist of parent node from root be d
Then the dist of left child from the root is d-1 and for right child is d+1. 
We keep a map for storing d and the node. Nodes having same d from the root are in same line. 
Since we need output in sorted order of distances i.e from left to right, we use tree map.
Also, for d = 0.. 1,5,6 three are there..1 is at top so no competition, but for 5 and 6,
we print from left to right as they are at same level. We use queue to store left and right children of each node to ensure this.
Finally we print tree map.

Space complexity: O(n)
Time complexity: O(nlogn)
log n for tree map retrieval and insertion and for n elements
*/

package Trees;
import java.util.*;

import static Trees.BinarySearchTree.insertNode;

class Object{
    int distance;
    Node node;

    public Object(Node node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
public class VerticalOrderTraversal {

    public static void verticalTraversal(Node root){
        if(root==null)
            return;
        Queue<Object> queue = new LinkedList<>();
        Map<Integer, List<Node>> map = new TreeMap<>();
        Object ele = new Object(root,0);
        queue.add(ele);
        while (!queue.isEmpty()){
            Object obj = queue.peek();
            if(map.containsKey(obj.distance)){
                map.get(obj.distance).add(obj.node);
            }
            else{
                List<Node> list = new LinkedList<>();
                list.add(obj.node);
                map.put(obj.distance,list);
            }
            if(obj.node.left!=null){
                queue.add(new Object(obj.node.left,obj.distance-1));
            }
            if(obj.node.right!=null){
                queue.add(new Object(obj.node.right,obj.distance+1));
            }
            queue.poll();
        }
        for(int distance: map.keySet()){
            List<Node> nodeList = map.get(distance);
            for(Node node : nodeList){
                System.out.print(node.data+" ");
            }
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
        verticalTraversal(root);
    }

}
