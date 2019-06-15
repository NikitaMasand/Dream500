/*

Top view of a binary tree is the set of nodes visible
when the tree is viewed from the top. Given a binary tree, print the top view of it.
The logic is pretty obvious if you know vertical order traversal.
So we print the first nodes entered in the map for the top view. Because for eg. 
1, 5, 6 are at dist 0 from root.
But since 1 is above 5, 6, we can only see 1.
Thus out of all nodes at the same distance from root node, only the ones at the higher level are seen from the top view. 
In this case, in map, we only store dist, and node instead of dist, list of nodes. Because we can only see first one node.


Alternative:
People have also taken a alternative simple approach, towards left they went on going left
and towards right they went on going right until null has occurred. This was quite intuitive but this one coded is quite logical.

*/


package Trees;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import static Trees.BinarySearchTree.insertNode;

class NodeAndDistance{
    int distance;
    Node node;

    public NodeAndDistance(Node nodeinput, int distanceinput){
        node = nodeinput;
        distance = distanceinput;
    }
}
public class TopViewBinaryTree {
        public static void topView(Node root){
            if(root==null)
                return;
            Queue<NodeAndDistance> queue = new LinkedList<>();
            Map<Integer,Node> map = new TreeMap<>();
            NodeAndDistance rootNode = new NodeAndDistance(root,0);
            queue.add(rootNode);
            while (!queue.isEmpty()){
                NodeAndDistance Currentnode = queue.peek();
                if(!map.containsKey(Currentnode.distance)){
                    map.put(Currentnode.distance,Currentnode.node);
                }
                if(Currentnode.node.left!=null){
                    queue.add(new NodeAndDistance(Currentnode.node.left,Currentnode.distance-1));
                }
                if(Currentnode.node.right!=null){
                    queue.add(new NodeAndDistance(Currentnode.node.right,Currentnode.distance+1));
                }
                queue.poll();
            }
            for(int distance: map.keySet()){
                System.out.print(map.get(distance).data+" ");
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
            topView(root);
        }

    }
