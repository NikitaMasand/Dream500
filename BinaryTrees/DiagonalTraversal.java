/*
time complexity: O(nlogn)
space complexity: O(n)
The approach is similar to vertical order traversal. 
We use queue for traversal and a tree map to store distance/height
and list of nodes at that height. 
if you observe
the left children of current node have height = parent's height+1;
and the right children of current node have height = parent's height
 */

package Trees;

import java.util.*;

class nodeAndDistance{
    Node node;
    int distance;

    public nodeAndDistance(Node node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
public class DiagonalTraversal {
    public static void diagonalTraversal(Node node){
        if(node==null){
            return;
        }
        Queue<nodeAndDistance> queue = new LinkedList<>();
        Map<Integer, List<Node>> map = new TreeMap<>();
        queue.add(new nodeAndDistance(node,0));
        while (!queue.isEmpty()){
            nodeAndDistance temp = queue.peek();
            if(map.containsKey(temp.distance)){
                map.get(temp.distance).add(temp.node);
            }
            else{
                List<Node>list = new LinkedList<>();
                list.add(temp.node);
                map.put(temp.distance,list);
            }
            if(temp.node.left!=null)
                queue.add(new nodeAndDistance(temp.node.left,temp.distance+1));
            if(temp.node.right!=null)
                queue.add(new nodeAndDistance(temp.node.right,temp.distance));
            queue.poll();
        }
        for(int distance: map.keySet()){
            for(Node node1: map.get(distance)){
                System.out.print(node1.data+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Node root = null;
        //level order traversal of inserted nodes:
        //15 10 20 8 12 17 25 6 11 16 27
        root = InsertNodes.insertUtil(root);
        diagonalTraversal(root);
    }
}
