/*
time complexity: O(nlogn)
space complexity: O(n)
*/

package Trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBinaryTree {
    public static void bottomView(Node root){
        if(root==null)
            return;
        Queue<nodeAndDistance> queue = new LinkedList<>();
        Map<Integer,Node> map = new TreeMap<>();
        queue.add(new nodeAndDistance(root,0));
        while (!queue.isEmpty()){
            nodeAndDistance temp = queue.poll();
            if(map.containsKey(temp.distance))
                map.replace(temp.distance,temp.node);
            else{
                map.put(temp.distance,temp.node);
            }
            if(temp.node.left!=null)
                queue.add(new nodeAndDistance(temp.node.left,temp.distance-1));
            if(temp.node.right!=null)
                queue.add(new nodeAndDistance(temp.node.right,temp.distance+1));
        }
        for(int distance: map.keySet()){
            System.out.print(map.get(distance).data+" ");
        }

    }
    public static void main(String[] args) {
        Node root = null;
        //level order traversal of inserted nodes:
        //15 10 20 8 12 17 25 6 11 16 27
        root = InsertNodes.insertUtil(root);
        bottomView(root);
    }
}
