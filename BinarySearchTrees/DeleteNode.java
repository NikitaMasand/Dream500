package Trees;

public class DeleteNode {

    public Node delete(Node node, int data){
            if(node==null)
                return node;
            if(data<node.data){
                node.left = delete(node.left,data);
            }
            else if(data>node.data){
                node.right = delete(node.right,data);
            }
            else {
                if(node.left == null && node.right == null){
                    return null;
                }
                else if(node.left==null || node.right == null){
                    Node temp = node.left;
                    return temp==null ? node.right : node.left;
                }
                else{
                    Node toReplaceWithNode = findMinInRightSubtree(node);
                    node.data = toReplaceWithNode.data;
                    node.right = delete(node.right,toReplaceWithNode.data);
                    return node;
                }
            }
        return node;
    }

    public Node findMinInRightSubtree(Node node){
        if(node==null)
            return node;

        node = node.right;
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
    public static void main(String[] args) {

    }
}
